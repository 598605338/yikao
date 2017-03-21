package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.AccountcashdepositRecord;
import com.linjia.web.model.Brand;
import com.linjia.web.query.AccountcashdepositRecordQuery;
import com.linjia.web.query.BrandQuery;

public interface AccountcashdepositRecordService extends BaseService<AccountcashdepositRecord, Long>{
	
	/**
	 * 根据query查询会员充值记录
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
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
