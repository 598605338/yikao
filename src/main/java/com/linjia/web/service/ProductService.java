package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.Product;
import com.linjia.web.query.ProductQuery;

public interface ProductService extends BaseService<Product, Long>{
	
	/**
	 * 根据分类id查询相关分类商品
	 * 
	 * lixinling
	 * 2016年7月13日 下午5:44:53
	 * @param query
	 * @return
	 */
	List<Product> selectCatagoryProductList(ProductQuery query);

	/**
	 * 根据分类id查询相关分类商品的个数
	 * 
	 * lixinling
	 * 2016年10月31日 下午5:44:53
	 * @param query
	 * @return
	 */
	int countByExample(ProductQuery query);
	
	/**
	 * 根据商品id,商品code,门店id,取得商品的当前库存
	 * 
	 * @param request
	 * @return
	 */
	int getCurrentQty(long product_id, String p_code, String mallCode);
	
	/**
	 * 根据商品id查询预约购买商品的库存量
	 * lixinling 
	 * 2016年8月15日 下午5:10:19
	 * @param id
	 * @return
	 */
	int selectQuantityByPrimaryKey(Long id);
	
	/**
	 * 根据商品id查询预约购买商品的库存量
	 * lixinling 
	 * 2016年8月15日 下午5:10:19
	 * @param id
	 * @return
	 */
	int insertProduct(Product product);

	/**
	 * 批量插入商品的数据
	 * lixinling 
	 * 2016年8月15日 下午5:10:19
	 * @param id
	 * @return
	 */
	int insertBatch(List<Product> list, String userId);

	/**
	 * 查询商品code是否存在
	 * 
	 * lixinling
	 * 2016年10月31日 下午5:44:53
	 * @param query
	 * @return
	 */
	int checkPCode(String pCode);

	/**
	 * 批量更新商品品类
	 * 
	 * lixinling
	 * 2017年2月9日 下午5:44:53
	 * @param query
	 * @return
	 */
	boolean updateCatagoryBatchByPCode(List<Product> list);
}
