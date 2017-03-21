package com.linjia.web.thirdService.eleme.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    private static final int TIMEOUT = 15 * 1000;

    private HttpClient createHttpClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslFactory).build();
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public String post(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(getRequestConfig(TIMEOUT));
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        return doPost(httpPost);
    }

    public String post(String url, String body) throws IOException {
        return post(url, body, TIMEOUT);
    }

    public String post(String url, String body, int timeout) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(getRequestConfig(timeout));

        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

        return doPost(httpPost);
    }

    private String doPost(HttpUriRequest request) throws IOException {
        HttpClient httpClient = null;
        try {
            httpClient = createHttpClient();
            HttpResponse response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new IllegalStateException(String.format("remote server response %d", statusCode));
            }

            return stream2Str(response.getEntity().getContent());
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private RequestConfig getRequestConfig(int timeout) {
        return RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
    }

    private String stream2Str(InputStream inputStream) throws IOException {
        StringBuilder sbu = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                sbu.append(line);
            }
            return sbu.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
