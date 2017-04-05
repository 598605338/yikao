package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.CollegeType;
import com.linjia.web.query.CollegeTypeQuery;

import java.util.List;

public interface CollegeTypeService extends BaseService<CollegeType, Long>{
	
	/**
	 * 根据query查询院校类型列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<CollegeType> selectBySerach(CollegeTypeQuery query);
	
	/**
	 * 根据query查询院校类型列表总数量
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(CollegeTypeQuery query);
}
