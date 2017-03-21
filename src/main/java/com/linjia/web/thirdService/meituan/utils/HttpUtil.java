package com.linjia.web.thirdService.meituan.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.linjia.web.thirdService.meituan.constants.ErrorEnum;
import com.linjia.web.thirdService.meituan.constants.RequestMethodTypeEnum;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.factory.URLFactory;

/**
 * Created by yangzhiqi on 15/10/15.
 */
public class HttpUtil {

    private static CloseableHttpClient httpClient = HttpClients.custom().build();

    public static String request(String urlPrefix,String urlHasParamsNoSig,String sig,Map<String, String> systemParamsMap,
                                 Map<String,String> applicationParamsMap,String requestMethodType,RequestConfig.Builder requestConfigBuilder )
    throws ApiSysException{
        if(RequestMethodTypeEnum.POST.getCode().equals(requestMethodType)){
            String url = URLFactory.genOnlyHasSysParamsAndSigUrl(urlPrefix, systemParamsMap, sig);
            return requestOfPost(url,applicationParamsMap,requestConfigBuilder);
        }else {
            String url = URLFactory.genUrlForGetRequest(urlHasParamsNoSig, sig);
            return requestOfGet(url,requestConfigBuilder);
        }
    }

    public static String request(String urlPrefix,String urlHasParamsNoSig,String sig,Map<String, String> systemParamsMap,
                                 Map<String,String> applicationParamsMap, byte[] fileData, String imgName, String requestMethodType,
                                 RequestConfig.Builder requestConfigBuilder ) throws ApiSysException{
        if(RequestMethodTypeEnum.POST.getCode().equals(requestMethodType)){
            String url = URLFactory.genOnlyHasSysParamsAndSigUrl(urlPrefix, systemParamsMap, sig);
            return requestOfPost(url,applicationParamsMap, fileData, imgName, requestConfigBuilder);
        }else {
            String url = URLFactory.genUrlForGetRequest(urlHasParamsNoSig, sig);
            return requestOfGet(url,requestConfigBuilder);
        }
    }

    /**
     * 请求以POST方式
     * @param url 美团的接口url
     * @param applicationParamsMap 参数列表
     * @return
     */
    private static String requestOfPost(String url,Map<String,String> applicationParamsMap,RequestConfig.Builder requestConfigBuilder)
        throws ApiSysException{
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            //设置参数
            List<BasicNameValuePair> nameValuePairList = ConvertUtil.convertToEntity(applicationParamsMap);
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nameValuePairList,"UTF-8");
            httpPost.setConfig(requestConfigBuilder.build());
            httpPost.setEntity(uefEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            throw new ApiSysException(e);
        }finally {
            httpPost.releaseConnection();
            try {
                if (response != null) {
                    response.close();
                }else{
                    throw new ApiSysException("请检查environment.properties文件是否配置正确");
                }
            } catch (IOException e) {
                throw new ApiSysException(e);
            }
        }

    }

    /**
     * 请求以POST方式
     * @param url 美团的接口url
     * @param applicationParamsMap 参数列表
     * @return
     */
    private static String requestOfPost(String url,Map<String,String> applicationParamsMap, byte[] fileData,
                                        String imgName, RequestConfig.Builder requestConfigBuilder) throws ApiSysException{
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            //设置参数
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            List<BasicNameValuePair> nameValuePairList = ConvertUtil.convertToEntity(applicationParamsMap);
            nameValuePairs.addAll(nameValuePairList);

            MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            ByteArrayBody byteArray = new ByteArrayBody(fileData, imgName);
            entity.addPart("file", byteArray);

            URLEncodedUtils.format(nameValuePairs, "UTF-8");
            Iterator<NameValuePair> it = nameValuePairs.iterator();
            while(it.hasNext()){
                NameValuePair param = it.next();
                entity.addPart(param.getName(), new StringBody(param.getValue()));
            }

            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, "UTF-8");
        } catch (Exception e) {
            throw new ApiSysException(e);
        }finally {
            httpPost.releaseConnection();
            try {
                if (response != null) {
                    response.close();
                }else{
                    throw new ApiSysException("请检查environment.properties文件是否配置正确");
                }
            } catch (IOException e) {
                throw new ApiSysException(e);
            }
        }

    }

    /**
     * 请求以GET方式
     * @param url
     * @return
     */
    private static String requestOfGet(String url,RequestConfig.Builder requestConfigBuilder) throws ApiSysException{
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfigBuilder.build());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            throw new ApiSysException(e);
        }finally {
            try {
                if (response != null) {
                    response.close();
                }else{
                    throw new ApiSysException("请检查environment.properties文件是否配置正确");
                }
                httpGet.releaseConnection();
                response.close();
            } catch (IOException e) {
                throw new ApiSysException(e);
            }
        }

    }

    public static String httpResultHandler(String httpResult) throws ApiOpException, ApiSysException{
        if(httpResult == null || httpResult.equals("")){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        JSONObject resultObj = null;
        try{
            resultObj = JSONObject.parseObject(httpResult);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        if(resultObj == null || resultObj.get("data") == null){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }

        String dataStr = resultObj.get("data").toString();
        if(dataStr.equals("ng") || dataStr.equalsIgnoreCase("null")) {
            Object errObject = resultObj.get("error");
            if(errObject == null || errObject.toString().equals("")
               || errObject.toString().equalsIgnoreCase("null")){
                throw new ApiSysException(ErrorEnum.SYS_ERR);
            }

            JSONObject errJsonObject = null;
            try{
                errJsonObject = JSONObject.parseObject(errObject.toString());
            }catch (Exception e){
                throw new ApiSysException(ErrorEnum.SYS_ERR);
            }
            if(errJsonObject == null || errJsonObject.get("code") == null || errJsonObject.get("code").equals("")
               || errJsonObject.get("code").toString().equalsIgnoreCase("null")){
                throw new ApiSysException(ErrorEnum.SYS_ERR);
            }

            Integer errorCode = null;
            try{
                errorCode = Integer.parseInt(errJsonObject.get("code").toString());
            }catch (Exception e){
                throw new ApiSysException(ErrorEnum.SYS_ERR);
            }
            if(errorCode == null){
                throw new ApiSysException(ErrorEnum.SYS_ERR);
            }else{
                if(errJsonObject.get("msg") == null || errJsonObject.get("msg").equals("")
                   || errJsonObject.get("msg").toString().equalsIgnoreCase("null")){
                    throw new ApiSysException(ErrorEnum.SYS_ERR);
                }else{
                    String errorMsg = errJsonObject.get("msg").toString();
                    throw new ApiOpException(errorCode.intValue(), errorMsg);
                }

            }
        }
        return dataStr;
    }
}
