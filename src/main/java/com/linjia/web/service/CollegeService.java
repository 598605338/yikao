package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.College;
import com.linjia.web.query.CollegeQuery;

import java.util.List;

public interface CollegeService extends BaseService<College, Long>{
	
	/**
	 * 根据query查询院校列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<College> selectBySerach(CollegeQuery query);
	
	/**
	 * 根据query查询院校列表总数量
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(CollegeQuery query);

	/**
	 * 查询院校下拉列表
	 *
	 * lixinling
	 * 2017/3/24 14:17
	 * @param:
	 * @return:
	 */
	List<College> selectCollegeDownList();
}
