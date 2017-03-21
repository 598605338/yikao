package com.linjia.web.dao;

import java.util.List;

import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.query.OGoodsItemQuery;
import com.linjia.web.query.OOrderQuery;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OGoodsItem;

public interface ElemeOrderProductMapper {
	/**
	 * 插入订单商品记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param OOrder
	 * @return
	 */
	 boolean insertElemeOrderProduct(OGoodsItem order);
	
	/**
	 * 更改订单商品记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param OOrder
	 * @return
	 */
	 boolean updateElemeOrderProduct(OGoodsItem order);
	
	/**
	 * 查询订单商品记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 OGoodsItem selectElemeOrderProductById(String orderId);
	
	/**
	 * 查询多个订单商品记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 List<OGoodsItem> selectElemeOrderProducts(OOrderQuery query);
	
	/**
	 * 删除订单商品记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	 boolean deleteElemeOrderProductById(String orderId);
	 
	 /**
	  * 饿了么订单商品查询
	  * xiangsy 
	  * 2017年3月6日 上午10:21:41
	  * @param orderId
	  * @return
	*/
	List<ThirdOrderProduct> selectElemeOrderGoods(String orderId);
}
