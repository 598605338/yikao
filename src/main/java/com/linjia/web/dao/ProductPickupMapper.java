package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ProductPickup;
import com.linjia.web.query.ProductPickupQuery;


public interface ProductPickupMapper extends BaseDao<ProductPickup, Long> {
	
	/**
	 * 查询我的关注的商品列表
	 * lixinling 
	 * 2016年8月18日 下午8:11:07
	 * @param query
	 * @return
	 */
	List<ProductPickup> selectProductPickupList(ProductPickupQuery query);
}