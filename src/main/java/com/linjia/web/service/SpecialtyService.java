package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.Specialty;
import com.linjia.web.query.SpecialtyQuery;

import java.util.List;

public interface SpecialtyService extends BaseService<Specialty, Long>{
	
	/**
	 * 根据query查询科目列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<Specialty> selectBySerach(SpecialtyQuery query);
	
	/**
	 * 根据query查询科目列表总数量
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(SpecialtyQuery query);

	/**
	 * 根据collegeId查询该院校科目列表
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param ids
	 * @return
	 */
	List<Specialty> selectDownListByIds(String[] ids);
}
