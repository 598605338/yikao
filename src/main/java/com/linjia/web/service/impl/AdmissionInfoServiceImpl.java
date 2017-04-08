package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.AdmissionBatchMapper;
import com.linjia.web.dao.AdmissionInfoMapper;
import com.linjia.web.dao.AdmissionRuleMapper;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.model.AdmissionInfo;
import com.linjia.web.model.AdmissionRule;
import com.linjia.web.query.AdmissionBatchQuery;
import com.linjia.web.query.AdmissionInfoQuery;
import com.linjia.web.service.AdmissionBatchService;
import com.linjia.web.service.AdmissionInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdmissionInfoServiceImpl extends BaseServiceImpl<AdmissionInfo, Long> implements AdmissionInfoService {

	@Resource
	private AdmissionInfoMapper mapper;

	@Resource
	private AdmissionRuleMapper admissionRuleMapper;

	@Override
	public BaseDao<AdmissionInfo, Long> getDao() {
		return mapper;
	}


	@Override
	public List<AdmissionInfo> selectBySerach(AdmissionInfoQuery query) {
		return mapper.selectBySerach(query);
	}

	@Override
	public int countByExample(AdmissionInfoQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public List<AdmissionRule> selectAdmiRuleDownListByCollegeId(Long collegeId) {
		return admissionRuleMapper.selectDownListByCollegeId(collegeId);
	}
}
