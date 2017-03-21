package com.linjia.web.service;


import java.util.List;
import java.util.Map;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.ProductBannerImages;
import com.linjia.web.model.ProductTags;

public interface ProductTagsService extends BaseService<ProductTags, Long>{
	
	/**
	 * 根据商品id查询商品标签列表
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	List<String> selectTagsByProductId(long productId);
	
	/**
	 * 根据商品id删除关联的信息
	 * lixinling 
	 * 2016年10月14日 下午5:12:36
	 * @param productId
	 */
	int deleteTagsByProductId(Map<String,Object> map);
	
	/**
	 * 批量插入标签和商品关联情况
	 * lixinling 
	 * 2016年10月14日 下午5:28:10
	 * @param map
	 * @return
	 */
	int insertBatch(Map<String,Object> map);
}
