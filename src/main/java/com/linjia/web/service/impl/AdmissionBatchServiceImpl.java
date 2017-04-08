package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.AdmissionBatchMapper;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.query.AdmissionBatchQuery;
import com.linjia.web.service.AdmissionBatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdmissionBatchServiceImpl extends BaseServiceImpl<AdmissionBatch, Long> implements AdmissionBatchService {

	@Resource
	private AdmissionBatchMapper mapper;

	@Override
	public BaseDao<AdmissionBatch, Long> getDao() {
		return mapper;
	}


	@Override
	public List<AdmissionBatch> selectBySerach(AdmissionBatchQuery query) {
		return mapper.selectBySerach(query);
	}

	@Override
	public int countByExample(AdmissionBatchQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public List<AdmissionBatch> selectAdmissionBatchDownList() {
		return mapper.selectAdmissionBatchDownList();
	}
}
