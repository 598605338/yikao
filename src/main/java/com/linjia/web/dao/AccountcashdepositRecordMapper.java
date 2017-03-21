package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.AccountcashdepositRecord;
import com.linjia.web.query.AccountcashdepositRecordQuery;


public interface AccountcashdepositRecordMapper extends BaseDao<AccountcashdepositRecord, Long> {
	
	/**
	 * 分页查询会员充值记录
	 * lixinling 
	 * 2016年9月19日 下午3:33:54
	 * @param query
	 * @return
	 */
	List<AccountcashdepositRecord> selectByPageList(AccountcashdepositRecordQuery query);
	
	/**
	 * 分页查询会员总数
	 * lixinling 
	 * 2016年9月19日 下午3:33:54
	 * @param query
	 * @return
	 */
	Integer selectByPageListNum(AccountcashdepositRecordQuery query);
}