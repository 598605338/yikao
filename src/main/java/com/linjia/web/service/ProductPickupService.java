package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.ProductPickup;
import com.linjia.web.query.ProductPickupQuery;

public interface ProductPickupService extends BaseService<ProductPickup, Long>{
	
	/**
	 * 查询我的关注的商品列表
	 * lixinling 
	 * 2016年8月18日 下午8:11:07
	 * @param query
	 * @return
	 */
	List<ProductPickup> selectProductPickupList(ProductPickupQuery query);
	
	/**
	 * 删除关注列表中的商品
	 * lixinling 
	 * 2016年8月18日 下午8:11:07
	 * @param query
	 * @return
	 */
	int delMyProductPickupItem(String itemIds);
}
