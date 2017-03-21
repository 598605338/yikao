package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.User;

public interface TestService extends BaseService<User, Long>{

	/**
	 * 测试数据库连接池
	 * lixinling
	 * 2016年7月1日 下午4:19:17
	 */
	void testPools();
	
	boolean updateAge();
	
	/**
	 * 事务测试
	 * lixinling 
	 * 2016年7月25日 下午3:10:22
	 * @return
	 */
//	boolean testTransaction();
	
	/**
	 * 批量插入测试
	 * lixinling 
	 * 2016年7月25日 下午3:10:22
	 * @return
	 */
//	int testInsertBatch();
}
