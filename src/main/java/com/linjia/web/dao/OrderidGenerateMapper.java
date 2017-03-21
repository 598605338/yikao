package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.OrderidGenerate;

public interface OrderidGenerateMapper extends BaseDao<OrderidGenerate, Long> {
	
	/**
	 * 生成退款单号
	 * 
	 * @param model  对象
	 */
	int refundIdGenerate(OrderidGenerate model);
}