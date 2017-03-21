package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.AccountcashdepositConfigAmount;
import com.linjia.web.model.AccountcashdepositConfigBase;

public interface AccountcashdepositConfigService extends BaseService<AccountcashdepositConfigBase, Long>{
	
	/**
	 * 查询存在的充值配置记录
	 * lixinling 
	 * 2016年9月20日 上午9:36:45
	 * @return
	 */
	AccountcashdepositConfigBase selectExistRecord(int id);
	

	/**
	 * 根据baseId删除记录
	 * lixinling 
	 * 2016年9月20日 上午10:16:58
	 * @param baseId
	 * @return
	 */
	Integer deleteAll(int baseId);
	
	/**
	 * 根据baseId查询所有记录
	 * lixinling 
	 * 2016年9月20日 上午10:16:58
	 * @param baseId
	 * @return
	 */
	List<AccountcashdepositConfigAmount> selectAllByBaseId(int baseId);
	
	/**
	 * 批量插入充值金额配置信息
	 * lixinling 
	 * 2016年9月20日 上午10:27:30
	 * @param list
	 * @return
	 */
	int insertSelectiveBatch(List<AccountcashdepositConfigAmount> list);
}
