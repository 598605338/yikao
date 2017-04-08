package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.model.AdmissionInfo;
import com.linjia.web.model.AdmissionRule;
import com.linjia.web.query.AdmissionBatchQuery;
import com.linjia.web.query.AdmissionInfoQuery;

import java.util.List;

public interface AdmissionInfoService extends BaseService<AdmissionInfo, Long>{
	
	/**
	 * 根据query查询录取信息列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<AdmissionInfo> selectBySerach(AdmissionInfoQuery query);
	
	/**
	 * 根据query查询录取信息列表总数量
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(AdmissionInfoQuery query);

	/**
	 * 根据院校Id查询录取规则列表
	 * @param collegeId
	 * @return
	 */
	List<AdmissionRule> selectAdmiRuleDownListByCollegeId(Long collegeId);
}
