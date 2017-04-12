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
	 * 新增录取信息
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param info
	 * @return
	 */
	int insertAdmissionInfo(AdmissionInfo info);

	/**
	 * 更新录取信息
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param info
	 * @return
	 */
	boolean updateAdmissionInfo(AdmissionInfo info);

	/**
	 * 根据规则Id删除规则记录
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param ruleId
	 * @return
	 */
	boolean deleteAdmissionRule(Long ruleId);

	/**
	 * 根据规则Id更新规则记录
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param rule
	 * @return
	 */
	boolean updateAdmissionRule(AdmissionRule rule);

	/**
	 * 根据规则Id查询规则记录
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param ruleId
	 * @return
	 */
    AdmissionRule selectAdmissionRule(Long ruleId);

	/**
	 * 根据院校Id查询录取规则列表
	 * @param collegeId
	 * @return
	 */
	List<AdmissionRule> selectAdmiRuleDownListByCollegeId(Long collegeId);
}
