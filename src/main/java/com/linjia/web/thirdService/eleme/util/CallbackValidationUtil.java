package com.linjia.web.thirdService.eleme.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linjia.web.thirdService.eleme.config.Config;
import com.linjia.web.thirdService.eleme.interfaces.entity.other.OMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 回调签名校验工具类
 */
public class CallbackValidationUtil {

    static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 通过哈希一个摘要，校验消息是否合法或者被篡改
     *
     * @param message
     * @return
     */
    public static boolean isValidMessage(OMessage message) {
        if (message == null) {
            return false;
        }
        if (message.getSignature() == null) {
            return false;
        }
        Map<String, Object> map = new HashMap();
        map.put("requestId", message.getRequestId());
        map.put("message", message.getMessage());
        map.put("type", message.getType());
        map.put("shopId", message.getShopId());
        map.put("timestamp", message.getTimestamp());
        map.put("userId", message.getUserId());
        map.put("appId", message.getAppId());

        String signature = null;
        try {
            signature = getSignature(map, Config.getSecret());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return signature.toUpperCase().equals(message.getSignature().toUpperCase());
    }

    public static String getSignature(Map<String, Object> params, String secret) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, Object> sortedParams = new TreeMap<String, Object>(params);
        Set<Map.Entry<String, Object>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, Object> param : entrys) {
            basestring.append(param.getKey()).append("=").append(objectMapper.writeValueAsString(param.getValue()));
        }
        basestring.append(secret);

        return SignatureUtil.md5(basestring.toString());
    }
}
