package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.query.AdmissionBatchQuery;

import java.util.List;

public interface AdmissionBatchService extends BaseService<AdmissionBatch, Long>{
	
	/**
	 * 根据query查询批次列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<AdmissionBatch> selectBySerach(AdmissionBatchQuery query);
	
	/**
	 * 根据query查询批次列表总数量
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(AdmissionBatchQuery query);
}
