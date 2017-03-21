package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.thirdService.baidu.model.Product;


public interface BdOrderProductMapper extends BaseDao<ThirdOrderProduct, Long>{
	
	/**
	 * 插入百度订单商品信息
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer insertBdOrderProduct(Product product);
	
	/**
	 * 删除百度订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer deleteBdOrderProduct(String moblie);
	
	/**
	 * 修改百度订单商品信息
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer updateBdOrderProduct(Product product);
	
	/**
	 * 查询百度订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ThirdOrderProduct> selectBdOrderProduct(Long orderId);
	
	/**
	 * 查询百度订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<Product> selectBdOrderProductAll(Long orderId);
	
}