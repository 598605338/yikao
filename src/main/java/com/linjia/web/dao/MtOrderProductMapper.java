package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.thirdService.meituan.vo.OrderFoodDetailParam;


public interface MtOrderProductMapper extends BaseDao<ThirdOrderProduct, Long>{
	
	/**
	 * 插入美团订单商品信息
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer insertMtOrderProduct(OrderFoodDetailParam product);
	
	/**
	 * 删除美团订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer deleteMtOrderProduct(Long order_id);
	
	/**
	 * 修改美团订单商品信息
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer updateMtOrderProduct(OrderFoodDetailParam detail);
	
	/**
	 * 查询美团订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ThirdOrderProduct> selectMtOrderProduct(Long order_Id);
	
	/**
	 * 查询美团订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<OrderFoodDetailParam> selectMtOrderProductAll(Long order_Id);
}