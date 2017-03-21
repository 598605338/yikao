package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.NewProductRecommend;

public interface NewProductRecommendMapper extends BaseDao<NewProductRecommend, Long>{
	
	/**
	 * 取得首页新品推荐列表
	 * lixinling
	 * 2016年7月12日 上午10:42:47
	 * @return
	 */
	List<NewProductRecommend> selectNewProductList();
	
	/**
	 * 批量更新首页新品推荐数据列表
	 * lixinling
	 * 2016年11月28日 上午10:42:47
	 * @return
	 */
	int updateBatchByPrimaryKey(List<NewProductRecommend> list);
}