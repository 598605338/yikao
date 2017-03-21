package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.OrderGroupProduct;
import com.linjia.web.model.ShoppingCar;

public interface OrderGroupProductService extends BaseService<OrderGroupProduct, Long>{
	
	/**
	 * 批量插入确认下单中购买的商品数据
	 * lixinling
	 * 2016年7月25日 下午1:37:41
	 * @param shoppingCarList
	 * @return
	 */
	int insertBatchProductList(List<ShoppingCar> shoppingCarList, Long groupId);
	

	/**
	 * 根据订单id查询购买的商品数据
	 * lixinling
	 * 2016年7月25日 下午1:37:41
	 * @param groupId
	 * @return
	 */
	List<OrderGroupProduct> selectProductListByGroupId(long groupId);
	
	/**
	 * 根据订单id恢复购买的商品库存数
	 * lixinling
	 * 2016年7月25日 下午1:37:41
	 * @param groupId
	 * @return
	 */
	boolean updateProductQuantity(long groupId);
}
