package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.AccountcashdepositRecordMapper;
import com.linjia.web.model.AccountcashdepositRecord;
import com.linjia.web.query.AccountcashdepositRecordQuery;
import com.linjia.web.service.AccountcashdepositRecordService;

@Service
@Transactional
public class AccountcashdepositRecordServiceImpl extends BaseServiceImpl<AccountcashdepositRecord, Long> implements AccountcashdepositRecordService {
	
	@Resource
	private AccountcashdepositRecordMapper mapper;

	@Override
	public BaseDao<AccountcashdepositRecord, Long> getDao() {
		return mapper;
	}

	@Override
	public List<AccountcashdepositRecord> selectByPageList(AccountcashdepositRecordQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public Integer selectByPageListNum(AccountcashdepositRecordQuery query) {
		return mapper.selectByPageListNum(query);
	}


}
