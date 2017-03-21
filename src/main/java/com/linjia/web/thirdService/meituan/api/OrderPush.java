package com.linjia.web.thirdService.meituan.api;

import java.util.HashMap;
import java.util.Map;

import com.linjia.web.thirdService.meituan.constants.ParamRequiredEnum;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.vo.OrderDetailParam;
import com.linjia.web.thirdService.meituan.vo.SystemParam;

public class OrderPush extends API{

	/**
     * 推送已支付状态的订单给APP方
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderPayedr(SystemParam systemParam,OrderDetailParam order) throws ApiOpException,ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        beforeMethod(null, systemParam, order.getOrder_id());
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(order.getOrder_id()));
        beforeMethod(systemParam, applicationParamsMap,null);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }
    
    /**
     * 推送已确认状态的订单给APP方
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderConfirmed(SystemParam systemParam,OrderDetailParam order) throws ApiOpException,ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        beforeMethod(null, systemParam, order.getOrder_id());
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(order.getOrder_id()));
        beforeMethod(systemParam, applicationParamsMap,null);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }
    
    /**
     *  APP方url 推送已完成订单
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderFinished(SystemParam systemParam,OrderDetailParam order) throws ApiOpException,ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        beforeMethod(null, systemParam, order.getOrder_id());
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(order.getOrder_id()));
        beforeMethod(systemParam, applicationParamsMap,null);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }
    
    /**
     *  用户或客服取消订单API[必接]
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderMtCance(SystemParam systemParam, long orderId,String reason_code,String reason) throws ApiOpException,ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        beforeMethod(ParamRequiredEnum.OrderLogisticsPush, systemParam, orderId);
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason_code",reason_code);
        applicationParamsMap.put("reason",reason);
        beforeMethod(systemParam, applicationParamsMap,null);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }
}
