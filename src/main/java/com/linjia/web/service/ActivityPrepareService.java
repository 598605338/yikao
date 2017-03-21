package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.ActivityPrepare;
import com.linjia.web.query.ActivityPrepareQuery;

public interface ActivityPrepareService extends BaseService<ActivityPrepare, Long>{

	/**
	 * 分页取得列表数据
	 * lixinling 
	 * 2016年9月8日 下午5:14:05
	 * @param query
	 * @return
	 */
	List<ActivityPrepare> selectByPageList(ActivityPrepareQuery query);

	/**
	 * 分页取得列表数据总数量
	 * lixinling 
	 * 2016年9月8日 下午5:14:05
	 * @param query
	 * @return
	 */
	int countByExample(ActivityPrepareQuery query);
	
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
