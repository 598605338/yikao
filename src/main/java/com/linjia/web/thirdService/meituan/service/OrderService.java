package com.linjia.web.thirdService.meituan.service;

import com.alibaba.fastjson.JSONObject;
import com.linjia.web.thirdService.meituan.vo.LogisticsParam;
import com.linjia.web.thirdService.meituan.vo.OrderDetailParam;
import com.linjia.web.thirdService.meituan.vo.OrderSubsidyParam;
import com.linjia.web.thirdService.meituan.vo.PoiPolicyParam;

public interface OrderService {

	 /**
     * 将订单设为商家已收到
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public JSONObject orderReceived(Long orderId);

    /**
     * 商家确认订单
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public JSONObject orderConfirm(Long orderId);

    /**
     * 商家取消订单
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param reason  取消原因
     * @param reasonCode  取消原因code, 通过取消订单原因列表接口方法获取
     * @return
     */
    public JSONObject orderCancel(Long orderId, String reason,
                                     String reasonCode);

    /**
     * 订单配送中
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param courierName  配送员姓名
     * @param courierPhone  配送电话
     * @return
     */
    public JSONObject orderDelivering(Long orderId, String courierName,String courierPhone);

    /**
     * 订单已送达(如接入美团配送则无需接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public JSONObject orderArrived(Long orderId);

    /**
     * 订单确认退款请求
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param reason  确认退款详情
     * @return
     */
    public JSONObject orderRefundAgree(Long orderId, String reason);

    /**
     * 驳回订单退款申请
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param reason  驳回退款详情
     * @return
     */
    public JSONObject orderRefundReject(Long orderId, String reason);

    /**
     * 获取订单商家补贴款
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public OrderSubsidyParam orderSubsidy(Long orderId);

    /**
     * 查询订单状态
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public Integer orderViewStatus(Long orderId);

    /**
     * 查询活动信息
     * @param systemParam  系统参数
     * @param actDetailId  活动ID
     * @return
     */
    public PoiPolicyParam orderGetActDetailByAcId(int actDetailId);

    /**
     * 获取订单详细信息
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @param isMtLogistics  是否为美团配送（当需要查询美团配送的详细信息时此字段需要为1）
     * @return
     */
    public OrderDetailParam orderGetOrderDetail(long orderId,long isMtLogistics);

    /**
     * 下发美团配送订单(接入美团配送选接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public JSONObject orderLogisticsPush(long orderId);

    /**
     * 取消美团配送订单(接入美团配送选接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public JSONObject orderLogisticsCancel(long orderId);

    /**
     * 获取配送订单状态(接入美团配送选接)
     * @param systemParam  系统参数
     * @param orderId  订单id
     * @return
     */
    public LogisticsParam orderLogisticsStatus(long orderId);

}
