package com.linjia.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.model.OrderProductModel;
import com.linjia.web.model.ShoppingCar;
import com.linjia.web.query.OrderGroupQuery;

public interface OrderGroupService extends BaseService<OrderGroup, Long> {

	/**
	 * 确认订单操作
	 * lixinling
	 * 2016年7月25日 上午11:10:12
	 * @param orderGroup
	 * @param shoppingCarList
	 * @return
	 */
	public boolean insertConfirmOrder(OrderGroup orderGroup, List<ShoppingCar> shoppingCarList);

	/**
	 * 更改订单状态
	 * lixinling 
	 * 2016年7月28日 下午3:32:16
	 * @param map
	 * @return
	 */
	boolean updateStatusById(Map<String, Object> map);

	/**
	 * 查询我的全部订单
	 * lixinling 
	 * 2016年7月28日 下午3:32:16
	 * @param map
	 * @return
	 */
	List<OrderGroup> selectMyAllOrderList(OrderGroupQuery query);

	/**
	 * 判断商品的状态（0库存不足；1正常；），并计算每种商品的总金额
	 * 
	 * @param totalPrice
	 *            购物车总商品数量
	 * @param totalQty
	 *            购物车总价格 lixinling 2016年7月18日 下午1:36:34
	 */
	public Map<String, Object> handleOrderProduct(HttpServletRequest request, List<ShoppingCar> shoppingCarList,
			Map<String, Object> totalMap, String mallCode);
}
