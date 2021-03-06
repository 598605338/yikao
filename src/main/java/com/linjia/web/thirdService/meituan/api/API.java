package com.linjia.web.thirdService.meituan.api;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import com.linjia.web.thirdService.meituan.constants.ErrorEnum;
import com.linjia.web.thirdService.meituan.constants.ParamRequiredEnum;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.factory.URLFactory;
import com.linjia.web.thirdService.meituan.utils.ConvertUtil;
import com.linjia.web.thirdService.meituan.utils.HttpUtil;
import com.linjia.web.thirdService.meituan.utils.PropertiesUtil;
import com.linjia.web.thirdService.meituan.utils.SignGenerator;
import com.linjia.web.thirdService.meituan.utils.StringUtil;
import com.linjia.web.thirdService.meituan.vo.SystemParam;

/**
 * Created by yangzhiqi on 15/10/19.
 */
public class API {
    protected static String requestApi(String methodName,SystemParam systemParam,
                                       Map<String,String> applicationParamsMap) throws
                                                                                ApiOpException,
                                                                                ApiSysException {
        //组织系统级参数
        Map<String,String> systemParamsMap = ConvertUtil.convertSystemParamsToMap(systemParam);
        String urlForGenSig = URLFactory.genUrlForGenSig(methodName, systemParamsMap,
                                                         applicationParamsMap);
        //生成签名
        String sig = SignGenerator.genSig(urlForGenSig);
        //去掉scret的url
        String urlNoSig = urlForGenSig.replaceAll(systemParam.getAppSecret(), "");
        String urlPrefix = URLFactory.genUrlPrefix(methodName);
        String resultString = HttpUtil.request(urlPrefix,
                                               genUrlForGetRequest(urlPrefix, systemParamsMap, applicationParamsMap),
                                               sig, systemParamsMap, applicationParamsMap,
                                               URLFactory.genUrlType(methodName),
                                               PropertiesUtil.getRequestConfig());

        return HttpUtil.httpResultHandler(resultString);
    }

    protected static String requestApi(String methodName,SystemParam systemParam,
                                       Map<String,String> applicationParamsMap, byte[] fileData, String imgName) throws
                                                                                ApiOpException,
                                                                                ApiSysException {
        //组织应用级参数
        Map<String,String> systemParamsMap = ConvertUtil.convertSystemParamsToMap(systemParam);
        String urlForGenSig = URLFactory.genUrlForGenSig(methodName, systemParamsMap,
                                                         applicationParamsMap);
        //生成签名
        String sig = SignGenerator.genSig(urlForGenSig);
        //去掉scret的url
        String urlNoSig = urlForGenSig.replaceAll(systemParam.getAppSecret(), "");

        String urlPrefix = URLFactory.genUrlPrefix(methodName);
        String resultString = HttpUtil.request(urlPrefix,
                                               genUrlForGetRequest(urlPrefix, systemParamsMap, applicationParamsMap),
                                               sig, systemParamsMap, applicationParamsMap, fileData, imgName,
                                               URLFactory.genUrlType(methodName),
                                               PropertiesUtil.getRequestConfig());

        return HttpUtil.httpResultHandler(resultString);
    }

    protected void beforeMethod(ParamRequiredEnum paramRequiredEnum,Object... targetObjects) throws ApiSysException, ApiOpException {
        List<String> requiredParamList = null;
        if(paramRequiredEnum != null){
            requiredParamList = ParamRequiredEnum.getParams(paramRequiredEnum);
        }
        if(targetObjects != null){
            for(Object targetObject : targetObjects){
                if(Enum.class == targetObject.getClass()){
                    if(targetObject == null){
                        throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                    }
                }else if(String.class == targetObject.getClass()){
                    if(targetObject == null){
                        throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                    }
                }else if(SystemParam.class == targetObject.getClass()){
                    SystemParam systemParam = (SystemParam) targetObject;
                    if(StringUtil.isBlank(systemParam.getAppId()) || StringUtil.isBlank(systemParam.getAppSecret())){
                        throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                    }
                }else {
                    Field[] fields = targetObject.getClass().getDeclaredFields();
                    for (Field field : fields){
                        field.setAccessible(true);
                        String fieldName = field.getName();
                        if(requiredParamList != null && !"null".equals(requiredParamList) &&
                           !"NULL".equals(requiredParamList) && !requiredParamList.isEmpty() &&
                            requiredParamList.contains(fieldName)){
                            try {
                                Object value = field.get(targetObject);
                                if(value == null){
                                    throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                                }
                            } catch (IllegalAccessException e) {
                                throw new ApiSysException("参数校验异常",e);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void beforeMethod(Object targetObject1 , Map<String, String> paramMap, ParamRequiredEnum paramRequiredEnum) throws ApiSysException, ApiOpException {
        List<String> requiredParamList = ParamRequiredEnum.getParams(paramRequiredEnum);
        if(targetObject1 != null){
            Field[] fields = targetObject1.getClass().getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getName();
                if(requiredParamList != null && !"null".equals(requiredParamList) &&
                   !"NULL".equals(requiredParamList) && !requiredParamList.isEmpty() &&
                   requiredParamList.contains(fieldName)){
                    try {
                        Object value = field.get(targetObject1);
                        if(value == null){
                            throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                        }
                    } catch (IllegalAccessException e) {
                        throw new ApiSysException("参数校验异常", e);
                    }
                }
            }
        }
        if(paramMap != null && !paramMap.isEmpty()){
            if(requiredParamList != null && !"null".equals(requiredParamList) &&
                    !"NULL".equals(requiredParamList) && !requiredParamList.isEmpty() && paramMap.size() < requiredParamList.size()){
                throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
            }
            for (String key : paramMap.keySet()){
                if(requiredParamList != null && !"null".equals(requiredParamList) &&
                !"NULL".equals(requiredParamList) && !requiredParamList.isEmpty() &&
                requiredParamList.contains(key)){
                    Object value = paramMap.get(key);
                    if(value == null){
                        throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                    }
                }
            }
        }
        if (requiredParamList != null && !"null".equals(requiredParamList) &&
                !"NULL".equals(requiredParamList) && !requiredParamList.isEmpty()) {
            if(paramMap != null && !paramMap.isEmpty() && paramMap.size() < requiredParamList.size()){
                throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
            }
            for (String requiredParam : requiredParamList) {
                if (!paramMap.containsKey(requiredParam) || paramMap.get(requiredParam) == null) {
                    throw new ApiSysException(ErrorEnum.LACK_OF_PARAM);
                }
            }
        }
    }

    protected static String genUrlForGetRequest(String urlPrefix, Map<String,String> systemParamsMap, Map<String, String> applicationParamsMap) throws ApiOpException{
        String uriParamStr = "";
        uriParamStr += "app_id=" + systemParamsMap.get("app_id") + "&timestamp="
                       + systemParamsMap.get("timestamp");
        if (applicationParamsMap != null && !"null".equals(applicationParamsMap) && !"NULL".equals(applicationParamsMap)) {
            for (String key : applicationParamsMap.keySet()) {
                String val = applicationParamsMap.get(key);
                if (val != null && !"".equals(val) && !"null".equals(val) && !"NULL".equals(val)) {
                    try {
                        key = URLEncoder.encode(key, "UTF-8");
                        val = URLEncoder.encode(val, "UTF-8");
                        uriParamStr += "&" + key + "=" + val;
                    } catch (UnsupportedEncodingException e) {
                        throw new ApiOpException(e);
                    }
                }
            }
        }
        String basedUrl = urlPrefix + "?" + uriParamStr;
        return basedUrl;
    }
}
