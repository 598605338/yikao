package com.linjia.web.service;


import java.util.List;
import java.util.Map;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.query.MiaoshaActivityProductQuery;

public interface MiaoshaActivityProductService extends BaseService<MiaoshaActivityProduct, Long>{
	/**
	 * 查询商品列表
	 * 
	 * @return
	 */
	List<MiaoshaActivityProduct> selectAllByBaseId(MiaoshaActivityProductQuery query);
	
	/**
	 * 根据商品id，取得正在进行秒杀的商品
	 * lixinling
	 * 2016年7月18日 上午10:17:11
	 * @param product_id
	 * @return
	 */
	MiaoshaActivityProduct getPanicingProductByProductId(long product_id);
}
