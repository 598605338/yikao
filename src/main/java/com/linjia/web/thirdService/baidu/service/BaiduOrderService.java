package com.linjia.web.thirdService.baidu.service;

import org.json.JSONObject;

import com.linjia.web.thirdService.baidu.model.BaiduData;
import com.linjia.web.thirdService.baidu.model.BaiduReOrder;

public interface BaiduOrderService {
	
	/**
	 * 确认订单
	 * @param orderId
	 * @return
	 */
	public JSONObject orderConfirm(Long orderId,String Authorization);
	
	/**
	 * 取消订单
	 * @param orderId
	 * @return
	 */
	public JSONObject orderCancel(Long orderId,int type,String reason,String Authorization);
	
	/**
	 * 完成订单
	 * @param orderId
	 * @return
	 */
	public JSONObject orderComplete(Long orderId,String Authorization);
	
	/**
	 * 查看订单状态
	 * @param orderId
	 * @return
	 */
	public JSONObject orderStatusQuery(Long orderId,String Authorization);
	
	/**
	 * 查看订单详情
	 * @param orderId
	 * @return
	 */
	public JSONObject getOrderDetail(Long orderId,String Authorization);
	
	/**
	 * 查看订单列表
	 * @param start_time
	 * @param end_time
	 * @param status
	 * @param page
	 * @return
	 */
	public JSONObject getOrderList(int start_time, int end_time,String status,int page,String Authorization);
	
	/**
	 * 扫码取餐
	 * @param orderId
	 * @return
	 */
	public JSONObject orderGetScan(Long orderId,String Authorization);
	
	/**
	 * 锁定订单（非开放）
	 * @param orderId
	 * @return
	 */
	public JSONObject orderLock(Long orderId,String Authorization);
	
	/**
	 * 订单退款
	 * @param orderId
	 * @return
	 */
	public JSONObject orderRefund(Long orderId,String Authorization);
	
	/**
	 * 订单状态推送
	 * @param orderId
	 * @param status
	 * @return
	 */
	public JSONObject orderStatusPush(Long orderId,int status,String Authorization);
	
	/**
	 * 创建订单
	 * @param orderId
	 * @param status
	 * @return
	 */
	public JSONObject createOrder(BaiduData bdData,String Authorization);
	
	/**
	 * 插入订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject insertBdOrder(BaiduData bd);
	
	/**
	 * 更新订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	 JSONObject updateBdOrder(BaiduData bd);
	
	/**
	 * 删除订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject deleteBdOrder(Long orderId);
	
	/**
	 * 查询订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject selectBdOrder(Long orderId,String shopId);
	
	/**
	 * 查询店铺订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	String selectBdOrderlist(String shopId);
	
	/**
	 * 查询订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	BaiduReOrder selectBdOrderAll(Long orderId,String shopId);

	/**
	 * 查询抛单订单对象
	 * @param order_id
	 * @return
	 */
	BaiduReOrder selectPdOrder(Long order_id);
}
