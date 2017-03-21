package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.ScoreOrder;
import com.linjia.web.model.ScoreProduct;
import com.linjia.web.query.ScoreProductQuery;

public interface ScoreOrderService extends BaseService<ScoreOrder, Long>{
	
	/**
	 * 积分兑换订单生成(纯积分模式)
	 * 
	 * lixinling 
	 * 2016年8月10日 上午10:18:57
	 * @param query
	 * @param userId
	 * @return
	 */
	boolean insertScoreOrder(ScoreProduct scoreProduct, String userId, String loginCod, int cardCouponId);
	
	/**
	 * 积分兑换订单生成+并支付（积分+金钱模式）
	 * 
	 * lixinling 
	 * 2016年8月10日 上午10:18:57
	 * @param query
	 * @param userId
	 * @return
	 */
	boolean insertPayScoreOrder(ScoreProduct scoreProduct, ScoreOrder model, String userId, String loginCode, String spbill_create_ip);
	
	/**
	 * 金钱支付完成后进行积分支付并更改订单状态
	 * 
	 * lixinling 
	 * 2016年8月10日 上午10:18:57
	 * @param query
	 * @param userId
	 * @return
	 */
	public boolean updatePayScoreOrderStatus(Long outTradeNo, int score, String userId, String loginCode, int cardCouponId);
	
	/**
	 * 更新积分订单状态
	 * lixinling 
	 * 2016年8月11日 下午1:21:56
	 * @param id
	 * @param orderStatus
	 * @return
	 */
	boolean updateStatusById(Long id, int orderStatus);
}
