package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.OrderidGenerate;

/**
 * 生成订单Id
 * @author lixinling
 * 2016年7月26日 上午10:57:14
 */
public interface OrderidGenerateService extends BaseService<OrderidGenerate, Long>{
	
	/**
	 * 生成订单号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	public long generateOrderId();
	
	/**
	 * 生成订单组号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	public long generateOrderGroupId();
	
	/**
	 * 生成退款单号
	 * 
	 * @param model  对象
	 */
	public long generateRefundId();
	
	/**
	 * 生成积分兑换订单号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	public long generateScoreOrderId();
}
