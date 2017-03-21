package com.linjia.web.thirdService.meituan.api;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linjia.web.thirdService.meituan.constants.ErrorEnum;
import com.linjia.web.thirdService.meituan.constants.ParamRequiredEnum;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.vo.LogisticsParam;
import com.linjia.web.thirdService.meituan.vo.OrderDetailParam;
import com.linjia.web.thirdService.meituan.vo.OrderSubsidyParam;
import com.linjia.web.thirdService.meituan.vo.PoiPolicyParam;
import com.linjia.web.thirdService.meituan.vo.SystemParam;

/**
 * Created by yangzhiqi on 15/10/15.
 */
public class OrderAPI extends API{

    /**
     * 将订单设为商家已收到
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderReceived(SystemParam systemParam, Long orderId)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderReceived);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 商家确认订单
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderConfirm(SystemParam systemParam, Long orderId)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderConfirm);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 商家取消订单
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param reason  取消原因
     * @param reasonCode  取消原因code, 通过取消订单原因列表接口方法获取
     * @return
     */
    public String orderCancel(SystemParam systemParam, Long orderId, String reason,
                                     String reasonCode)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason", reason);
        applicationParamsMap.put("reason_code", reasonCode);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderCancel);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 订单配送中
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param courierName  配送员姓名
     * @param courierPhone  配送电话
     * @return
     */
    public String orderDelivering(SystemParam systemParam, Long orderId, String courierName,
                                     String courierPhone)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        if (courierName != null && !"".equals(courierName) && !"null".equals(courierName) && !"NULL".equals(courierName)) {
            applicationParamsMap.put("courier_name", courierName);
        }
        if (courierPhone != null && !"".equals(courierPhone) && !"null".equals(courierPhone) && !"NULL".equals(courierPhone)) {
            applicationParamsMap.put("courier_name", courierName);
        }
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderDelivering);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 订单已送达(如接入美团配送则无需接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderArrived(SystemParam systemParam, Long orderId) throws ApiOpException,
                                                                                      ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderArrived);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 订单确认退款请求
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param reason  确认退款详情
     * @return
     */
    public String orderRefundAgree(SystemParam systemParam, Long orderId, String reason)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderRefundAgree, systemParam, orderId, reason);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason", reason);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderRefundAgree);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 驳回订单退款申请
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param reason  驳回退款详情
     * @return
     */
    public String orderRefundReject(SystemParam systemParam, Long orderId, String reason)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderRefundReject, systemParam, orderId, reason);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason", reason);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderRefundReject);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取订单商家补贴款
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public OrderSubsidyParam orderSubsidy(SystemParam systemParam, Long orderId) throws ApiOpException,
                                                                                      ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderSubsidy, systemParam, orderId);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderSubsidy);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        OrderSubsidyParam orderSubsidyParam = null;
        try{
            orderSubsidyParam = JSONObject.parseObject(data, OrderSubsidyParam.class);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderSubsidyParam;
    }

    /**
     * 查询订单状态
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public Integer orderViewStatus(SystemParam systemParam, Long orderId)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderViewStatus, systemParam, orderId);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderViewStatus);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        Integer orderStatus = null;
        try{
            String status = JSONObject.parseObject(data).get("status").toString();
            orderStatus = Integer.parseInt(status);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderStatus;
    }

    /**
     * 查询活动信息
     * @param systemParam  系统参数
     * @param actDetailId  活动ID
     * @return
     */
    public PoiPolicyParam orderGetActDetailByAcId(SystemParam systemParam, int actDetailId)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderGetActDetailByAcId, systemParam, actDetailId);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("act_detail_id", String.valueOf(actDetailId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderGetActDetailByAcId);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        PoiPolicyParam poiPolicyParam = null;
        try{
            poiPolicyParam = JSONObject.parseObject(data, PoiPolicyParam.class);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return poiPolicyParam;
    }

    /**
     * 获取订单详细信息
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param isMtLogistics  是否为美团配送（当需要查询美团配送的详细信息时此字段需要为1）
     * @return
     */
    public OrderDetailParam orderGetOrderDetail(SystemParam systemParam, long orderId,long isMtLogistics)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderGetOrderDetail, systemParam, orderId, isMtLogistics);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderGetOrderDetail);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        OrderDetailParam orderDetailParam = null;
        try{
            orderDetailParam= JSONObject.parseObject(data, OrderDetailParam.class);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderDetailParam;
    }

    /**
     * 下发美团配送订单(接入美团配送选接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderLogisticsPush(SystemParam systemParam, long orderId) throws ApiOpException,
                                                                                                 ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderLogisticsPush, systemParam, orderId);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderLogisticsPush);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 取消美团配送订单(接入美团配送选接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public String orderLogisticsCancel(SystemParam systemParam, long orderId) throws ApiOpException,
                                                                                            ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderLogisticsCancel, systemParam, orderId);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderLogisticsCancel);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取配送订单状态(接入美团配送选接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public LogisticsParam orderLogisticsStatus(SystemParam systemParam, long orderId)
        throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderLogisticsStatus, systemParam, orderId);

        //组织应用级参数
        Map<String,String> applicationParamsMap = new HashMap<String, String>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderLogisticsStatus);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        LogisticsParam logisticsParam = null;
        try{
            logisticsParam= JSONObject.parseObject(data, LogisticsParam.class);
        }catch (Exception e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return logisticsParam;
    }

}
