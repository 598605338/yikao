package com.linjia.web.thirdService.eleme.oauth;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linjia.web.thirdService.eleme.config.Config;
import com.linjia.web.thirdService.eleme.util.HttpClientUtil;
import org.apache.http.HttpHeaders;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class OAuthClient {

    HttpClientUtil httpClientUtil = new HttpClientUtil();

    Logger logger = Logger.getLogger(this.getClass());

    private static ObjectMapper objectMapper = new ObjectMapper();

    private String authorizeUrl;

    private String appKey;

    private String secret;

    private String callbackUrl;

    private String accessTokenUrl;

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public OAuthClient() {
        authorizeUrl = Config.getAuthorizeUrl();
        appKey = Config.getAppKey();
        secret = Config.getSecret();
        callbackUrl = Config.getCallbackUrl();
        accessTokenUrl = Config.getAccessTokenUrl();
    }

    public OAuthClient(String serverUrl, String appKey, String secret, String callbackUrl) {
        this.accessTokenUrl = serverUrl + "/token";
        this.authorizeUrl = serverUrl + "/authorize";
        this.appKey = appKey;
        this.secret = secret;
        this.callbackUrl = callbackUrl;
    }


    public String getAuthUrl(String state, String scope) {
        String url = authorizeUrl;
        String responseType = "code";
        String clientId = appKey;
        String callback;
        try {
            callback = URLEncoder.encode(callbackUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return String.format("%s?response_type=%s&client_id=%s&state=%s&redirect_uri=%s&scope=%s", url, responseType, clientId, state, callback, scope);
    }

    public Token getTokenInClientCredentials() {
        Map<String, String> body = new HashMap<String, String>();
        body.put("grant_type", "client_credentials");

        logger.info(String.format("getTokenInClientCredentials request: url=%s , headers=%s , body=%s", accessTokenUrl, getHeaders(), body));

        try {
            String response = httpClientUtil.post(accessTokenUrl, getHeaders(), body);
            logger.info("getTokenInClientCredentials response: " + response);
            return objectMapper.readValue(response, Token.class);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    public Token getTokenByCode(final String code) {
        final String callback = callbackUrl;
        Map<String, String> body = new HashMap<String, String>();
        body.put("grant_type", "authorization_code");
        body.put("code", code);
        body.put("redirect_uri", callback);
        body.put("client_id", appKey);

        logger.info(String.format("getTokenByCode request: url=%s , headers=%s , body=%s", accessTokenUrl, getHeaders(), body));

        try {
            String response = httpClientUtil.post(accessTokenUrl, getHeaders(), body);
            logger.info("getTokenByCode response: " + response);
            return objectMapper.readValue(response, Token.class);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    public Token getTokenByRefreshToken(String refreshToken, String scope) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("grant_type", "refresh_token");
        body.put("refresh_token", refreshToken);
        body.put("scope", scope);

        logger.info(String.format("getTokenByRefreshToken request: url=%s , headers=%s , body=%s", accessTokenUrl, getHeaders(), body));

        try {
            String response = httpClientUtil.post(accessTokenUrl, getHeaders(), body);
            logger.info("getTokenByRefreshToken response:" + response);
            return objectMapper.readValue(response, Token.class);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    private String getBasic() {
        return "Basic " + new BASE64Encoder().encode((String.format("%s:%s", appKey, secret).getBytes()));
    }


    private HashMap<String, String> getHeaders() {
        return new HashMap<String, String>() {{
            put(HttpHeaders.CONTENT_TYPE, "Content-Type: application/x-www-form-urlencoded; charset=utf-8");
            put(HttpHeaders.AUTHORIZATION, getBasic());
        }};
    }
}
