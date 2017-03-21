package com.linjia.web.service;

import java.util.List;
import java.util.Map;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.model.OrderRefund;
import com.linjia.web.query.OrderRefundQuery;

public interface OrderRefundService extends BaseService<OrderRefund, Long> {

	/**
	 * 退款
	 * lixinling 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	Map<String,Object> insertRefund(OrderGroup orderGroup, String userId);
	
	/**
	 * 更新退款单状态
	 * lixinling 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	boolean updateRefundStatusById(Map<String,Object> map);
	
	/**
	 * 查询我的退款单
	 * lixinling 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	List<OrderRefund> selectMyRefundOrderList(OrderRefundQuery query);
	
	/**
	 * 查询单条退款单
	 * xiangsy 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	OrderRefund selectOneOrder(Map<String,Object> map);

}
