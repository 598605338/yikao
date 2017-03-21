package com.linjia.web.thirdService.eleme.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static boolean sandbox;
    private static String appKey;
    private static String secret;
    private static String serverUrl;
    private static String callbackUrl;

    static {
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream("");
            properties.load(in);
            in.close();

            sandbox = properties.get("sandbox").equals("true") ? true : false;
            appKey = (String) properties.get("appKey");
            secret = (String) properties.get("secret");
            serverUrl = (String) properties.get("serverUrl");
            callbackUrl = (String) properties.get("callbackUrl");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (callbackUrl == null || callbackUrl.equals("")) {
            throw new RuntimeException("required callbackUrl in config.properties.");
        }

        if (appKey == null || secret == null || callbackUrl == null) {
            throw new RuntimeException("fix config.properties first.");
        }
    }

    public static String getAppKey() {
        return appKey.trim();
    }

    public static String getSecret() {
        return secret.trim();
    }

    public static String getCallbackUrl() {
        return callbackUrl.trim();
    }

    public static String getServerUrl() {
        if (serverUrl == null) {
            return sandbox ? "" : "";
        }
        return serverUrl;
    }

    public static String getAccessTokenUrl() {
        return getServerUrl() + "/token";
    }

    public static String getAPIServerUrl() {
        return getServerUrl() + "/api/v1/";
    }

    public static String getAuthorizeUrl() {
        return getServerUrl() + "/authorize";
    }

}
