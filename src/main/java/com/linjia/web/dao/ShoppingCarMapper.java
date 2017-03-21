package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ShoppingCar;
import com.linjia.web.query.ShoppingCarQuery;


public interface ShoppingCarMapper extends BaseDao<ShoppingCar, Long> {
	
	/**
	 * 更新购物车商品数量
	 * lixinling
	 * 2016年7月14日 下午3:25:27
	 * @param shoppingCar
	 * @return
	 */
	boolean updateQuantityByPrimaryKey(int quantity, long id);
	
	
	/**
	 * 查询用户购物车所有商品
	 * lixinling
	 * 2016年7月15日 上午10:27:58
	 * @param query
	 * @return
	 */
	List<ShoppingCar> selectCarAllProduct(ShoppingCarQuery query);
	
	
	/**
	 * 根据商品code和userId查询购物车中商品
	 * lixinling
	 * 2016年7月18日 上午11:43:58
	 * @param map
	 * @return
	 */
	ShoppingCar selectProductByPCodeAndUserId(Map map);
	
	/**
	 * 根据商品code列表和userId查询购物车中要结算的商品
	 * lixinling
	 * 2016年7月18日 上午11:43:58
	 * @param map
	 * @return
	 */
	List<ShoppingCar> selectCarProductByChecked(Map map);
}