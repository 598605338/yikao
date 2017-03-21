package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.AccountcashdepositConfigAmount;


public interface AccountcashdepositConfigAmountMapper extends BaseDao<AccountcashdepositConfigAmount, Long> {
	
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