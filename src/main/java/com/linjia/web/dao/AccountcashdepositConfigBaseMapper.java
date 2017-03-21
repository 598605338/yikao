package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.AccountcashdepositConfigBase;


public interface AccountcashdepositConfigBaseMapper extends BaseDao<AccountcashdepositConfigBase, Long> {
	
	/**
	 * 查询存在的充值配置记录
	 * lixinling 
	 * 2016年9月20日 上午9:36:45
	 * @return
	 */
	AccountcashdepositConfigBase selectExistRecord(int id);
}