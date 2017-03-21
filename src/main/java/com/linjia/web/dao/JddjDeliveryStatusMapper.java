package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.JddjDeliveryStatus;


public interface JddjDeliveryStatusMapper extends BaseDao<JddjDeliveryStatus, Long> {
	
	/**
	 * 根据订单号查询最后一条运单数据
	 * lixinling 
	 * 2017年3月14日 下午2:51:59
	 * @param orderId
	 * @return
	 */
	JddjDeliveryStatus selectLastByOrderId(Long orderId);
}