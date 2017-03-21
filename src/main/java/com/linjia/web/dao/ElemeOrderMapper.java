package com.linjia.web.dao;

import java.util.List;

import com.linjia.web.model.LogistisDmInfo;
import com.linjia.web.query.OOrderQuery;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OOrder;

public interface ElemeOrderMapper {
	/**
	 * 插入订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param OOrder
	 * @return
	 */
	 boolean insertElemeOrder(OOrder order);
	
	/**
	 * 更改订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param OOrder
	 * @return
	 */
	 boolean updateElemeOrder(OOrder order);
	
	/**
	 * 查询订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 OOrder selectElemeOrderById(String orderId);
	
	/**
	 * 查询多个订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 List<OOrder> selectElemeOrders(OOrderQuery query);
	
	/**
	 * 删除订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 boolean deleteElemeOrderById(String orderId);
	 
	/**
	 * 饿了么订单物流信息查询
	 * xiangsy 
	 * 2017年3月6日 上午10:21:41
	 * @param order
	 * @return
	 */
	public LogistisDmInfo selectLogisByOrderId(String orderId);
}
