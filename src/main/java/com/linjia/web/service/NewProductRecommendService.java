package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.NewProductRecommend;

public interface NewProductRecommendService extends BaseService<NewProductRecommend, Long>{
	
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
