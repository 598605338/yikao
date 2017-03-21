package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ProductBannerImages;


public interface ProductBannerImagesMapper extends BaseDao<ProductBannerImages, Long> {
	
	/**
	 * 根据商品id查询轮播图列表
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	List<ProductBannerImages> selectAllByProductId(long productId);
	
	/**
	 * 批量批量插入商品轮播图
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int insertBatchProductBannerImageList(Map<String,Object> map);
	
	/**
	 * 插入商品轮播图
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int insertProductBannerImage(Map<String,Object> map);
	
	/**
	 * 批量批量插入商品轮播图
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int deleteByProductId(Long productId);
	
	/**
	 * 更新商品轮播图
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int updateProductBannerImageById(Map<String,Object> map);
}