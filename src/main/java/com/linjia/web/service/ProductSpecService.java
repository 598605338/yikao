package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.ProductSpec;

public interface ProductSpecService extends BaseService<ProductSpec, Long>{
	/**
	 * 根据商品id查询商品的安全库存
	 * 
	 * @return
	 */
	int selectSafeQuantityByProductId(Long productId);
}
