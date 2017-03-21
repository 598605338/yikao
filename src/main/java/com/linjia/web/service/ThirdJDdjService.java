package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.JddjDeliveryStatus;
import com.linjia.web.model.OrderInfoDTO;

public interface ThirdJDdjService extends BaseService<OrderInfoDTO, Long>{
	
	/**
	 * 根据订单号查询最后一条运单数据
	 * lixinling 
	 * 2017年3月14日 下午2:51:59
	 * @param orderId
	 * @return
	 */
	JddjDeliveryStatus selectLastByOrderId(Long orderId);
}
