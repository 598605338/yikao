package com.linjia.web.thirdService.meituan.constants;

import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.utils.PropertiesUtil;

public class ReqUrl {
	
	public static String APPID="";
	
	public static String CONSUMERSECRET="";
	
	private static String urlPrefix = "";
	
	//设订单为商家已收到
	public static String ORDERPOIRECEIVED="order/poi_received";
	//商家确认订单[必接]
	public static String ORDERCONFIRM="order/confirm";
	//商家取消订单[必接]
	public static String ORDERCANCEL="order/cancel";
	//订单配送中[必接]
	public static String ORDERDELIVERING="order/delivering";
	//订单已送达
	public static String ORDERARRIVED="order/arrived";
    //订单确认退款请求
	public static String ORDERREFUNDAGREE="order/refund/agree";
//    // 驳回订单退款申请
//    order/refund/reject;
//    //获取订单商家补贴款
//    order/subsidy;
//    //查询订单状态
	public static String VIEWSTATUS="order/viewstatus";
//    //查询活动信息
//    order/getActDetailByAcId;
//    //获取订单详细信息
	public static String GETORDERDETAIL="order/getOrderDetail";
//    //下发美团配送订单
	public static String LOGISTICSPUSH="order/logistics/push";
//    //取消美团配送订单
	public static String LOGISTICSCANCEL="order/logistics/cancel";
//    //配送状态变更回调
//	public static String ORDERCALLBACK="";
//    //获取配送订单状态
	public static String LOGISTICSSTATUS="";
//    //获取最新日订单流水号
//    getOrderDaySeq;
//    //通过流水号取订单ID
//    getOrderIdByDaySeq;
//    //批量查询众包配送费
//    order/zhongbao/shippingFee;
//    //众包配送预下单
//    order/zhongbao/dispatch/prepare;
//    //众包配送确认下单
//    order/zhongbao/dispatch/confirm;
//    //众包配送单追加小费
//    order/zhongbao/update/tip;
//    //获取订单评价信息
//    order/comment/order;
//    //根据评价id添加商家回复
//    order/comment/add_reply;

	/**
	 * 通过方法名生成url
	 * 
	 * @param methodName
	 * @return
	 */
	public static String getUrlPrefix(){
		try {
			if (urlPrefix.equals("")) {
				String env = PropertiesUtil.getEnvironmentMode();
				if ("0".equals(env)) {
					urlPrefix = "";
				} else if ("1".equals(env)) {
					urlPrefix = "";
				} else if ("2".equals(env)) {
					urlPrefix = "";
				}
			}
		 }catch (ApiSysException e) {
			e.printStackTrace();
		}
		String url = urlPrefix;
		return url;
	}

}
