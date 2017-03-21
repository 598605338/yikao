package com.linjia.web.thirdService.meituan.service;

import org.json.JSONObject;

import com.linjia.web.thirdService.meituan.model.MtOrder;
import com.linjia.web.thirdService.meituan.model.MtReOrder;

public interface MtOrderService {
	
	/**
	 * 插入订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject insertMtOrder(MtOrder mt);
	
	
	/**
	 * 删除订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject deleteMtOrder(Long orderId);
	
	/**
	 * 查询订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject selectMtOrder(Long orderId,String App_poi_code);
	
	/**
	 * 查询店铺订单数据列表
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	String selectMtOrderlist(String app_poi_code);
	
	/**
	 * 更新订单数据(已支付)
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject updateOrderPayed(MtOrder mt);
	
	/**
	 * 更新订单数据(已确认)
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject updateOrderConfirmed(MtOrder mt);
	
	/**
	 * 更新订单数据(已完成)
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	JSONObject updateOrderOver(MtOrder mt);
	
	/**
	 * 查询订单所有属性数据
	 * @param order_id
	 * @return
	 */
	MtReOrder selectMtOrderAll(Long order_id);
	
	/**
	 * 更新订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	int updateMtOrder(MtOrder mt);
}
