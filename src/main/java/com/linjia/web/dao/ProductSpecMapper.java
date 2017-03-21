package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ProductSpec;


public interface ProductSpecMapper extends BaseDao<ProductSpec, Long>{
	/**
	 * 根据商品id查询商品的安全库存
	 * 
	 * @return
	 */
	int selectSafeQuantityByProductId(Long productId);
	
	/**
	 * 根据productId更新库存
	 */
	int updateProductSpec(ProductSpec psec);
	
	/**
	 * 根据productId删除库存
	 */
	int deleteProductSpecByPid(Long productId);
	
	/**
	 * 插入数据
	 * @return
	 */
	int insertProductSpec(ProductSpec psec);
	
	/**
	 * 根据商品id查找库存
	 * @return
	 */
	ProductSpec selectQuantityInfoByPid(Long productId);
}