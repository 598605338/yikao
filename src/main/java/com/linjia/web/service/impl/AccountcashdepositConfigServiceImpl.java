package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.AccountcashdepositConfigAmountMapper;
import com.linjia.web.dao.AccountcashdepositConfigBaseMapper;
import com.linjia.web.model.AccountcashdepositConfigAmount;
import com.linjia.web.model.AccountcashdepositConfigBase;
import com.linjia.web.service.AccountcashdepositConfigService;

@Service
@Transactional
public class AccountcashdepositConfigServiceImpl extends BaseServiceImpl<AccountcashdepositConfigBase, Long> implements AccountcashdepositConfigService {
	
	@Resource
	private AccountcashdepositConfigBaseMapper mapper;
	
	@Resource
	private AccountcashdepositConfigAmountMapper accountcashdepositConfigAmountMapper;

	@Override
	public BaseDao<AccountcashdepositConfigBase, Long> getDao() {
		return mapper;
	}

	@Override
	public AccountcashdepositConfigBase selectExistRecord(int id) {
		return mapper.selectExistRecord(id);
	}

	@Override
	public Integer deleteAll(int baseId) {
		return accountcashdepositConfigAmountMapper.deleteAll(baseId);
	}

	@Override
	public int insertSelectiveBatch(List<AccountcashdepositConfigAmount> list) {
		return accountcashdepositConfigAmountMapper.insertSelectiveBatch(list);
	}

	@Override
	public List<AccountcashdepositConfigAmount> selectAllByBaseId(int baseId) {
		return accountcashdepositConfigAmountMapper.selectAllByBaseId(baseId);
	}

	

}
