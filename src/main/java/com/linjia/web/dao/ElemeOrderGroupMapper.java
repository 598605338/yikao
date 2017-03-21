package com.linjia.web.dao;

import java.util.List;

import com.linjia.web.query.OGoodsGroupQuery;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OGoodsGroup;

public interface ElemeOrderGroupMapper {
	/**
	 * 插入订单商品组记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param group
	 * @return
	 */
	 boolean insertElemeOrderGroup(OGoodsGroup group);
	
	/**
	 * 更改订单商品组记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param group
	 * @return
	 */
	 boolean updateElemeOrderGroup(OGoodsGroup group);
	
	/**
	 * 查询订单商品组记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 OGoodsGroup selectElemeOrderGroupById(OGoodsGroupQuery query);
	
	/**
	 * 查询多个订单商品组记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 List<OGoodsGroup> selectElemeOrderGroups(OGoodsGroupQuery query);
	
	/**
	 * 删除订单商品组记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 boolean deleteElemeOrderGroupById(String orderId);
}
