package com.linjia.web.thirdService.eleme.interfaces.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.linjia.web.thirdService.eleme.annotation.Service;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.oauth.Token;
import com.linjia.web.thirdService.eleme.protocol.RpcClient;

class NopService {

    private RpcClient rpcClient = new RpcClient();

    private Token token;

    private Class service;

    private HashMap<String, Method> methodHashMap = new HashMap<String, Method>();

    NopService(Token token, Class service) {
        this.token = token;
        this.service = service;
        Method[] methods = service.getMethods();
        for (Method method : methods) {
            methodHashMap.put(method.getName(), method);
        }
    }

    public void setToken(Token token) {
        this.token = token;
    }

    <T> T call(Map<String, Object> parameters) throws ServiceException {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Method method = getMethod(methodName);
        Service annotation = (Service) service.getAnnotation(Service.class);
        if (annotation == null)
            throw new RuntimeException("服务未找到Service注解");
        String action = String.format("%s.%s", annotation.value(), methodName);

        return rpcClient.call(action, parameters, token, method.getGenericReturnType());
    }

    protected Method getMethod(String name) {
        return methodHashMap.get(name);
    }

}
