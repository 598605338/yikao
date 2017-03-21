package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.OrderGroupProduct;

public interface OrderGroupProductMapper extends BaseDao<OrderGroupProduct, Long> {

	/**
	 * 批量插入确认下单中购买的商品数据
	 * lixinling
	 * 2016年7月25日 下午1:37:41
	 * @param shoppingCarList
	 * @return
	 */
	int insertBatchProductList(Map<String, Object> map);
	
	/**
	 * 根据订单id查询购买的商品数据
	 * lixinling
	 * 2016年7月25日 下午1:37:41
	 * @param shoppingCarList
	 * @return
	 */
	List<OrderGroupProduct> selectProductListByGroupId(long groupId);
}