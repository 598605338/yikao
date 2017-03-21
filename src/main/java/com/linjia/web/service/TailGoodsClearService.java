package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.TailGoodsClear;
import com.linjia.web.query.TailGoodsClearQuery;

public interface TailGoodsClearService extends BaseService<TailGoodsClear, Long>{
	
	/**
	 * 查询分页列表
	 * 
	 * lixinling 
	 * 2016年9月8日 上午10:45:24
	 * @param query
	 * @return
	 */
	List<TailGoodsClear> selectByPageList(TailGoodsClearQuery query);

	/**
	 * 查询分页列表总数量
	 * 
	 * lixinling 
	 * 2016年9月8日 上午10:45:24
	 * @param query
	 * @return
	 */
	int countByExample(TailGoodsClearQuery query);

	/**
	 * 更新使用状态和活动状态
	 * 
	 * lixinling 
	 * 2016年9月8日 上午10:45:24
	 * @param model
	 * @return
	 */
	int updateStatusByPrimaryKey(TailGoodsClear model);
	
	/**
	 * 查询最大的SortIndex
	 * 
	 * lixinling 
	 * 2016年11月22日 上午10:45:24
	 * @param query
	 * @return
	 */
	Long selectMaxSortIndex();
}
