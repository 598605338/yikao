package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.RegistMember;


public interface RegistMemberMapper extends BaseDao<RegistMember, Long> {
	
	/**
	 * 根据手机号查询用户注册状态
	 * lixinling 
	 * 2016年8月8日 上午9:59:21
	 * @param phone
	 * @return
	 */
	RegistMember selectByPhone(String phone);
	
	/**
	 * 根据手机号更新用户注册状态
	 * lixinling 
	 * 2016年8月8日 上午9:59:21
	 * @param phone
	 * @return
	 */
	int updateByPhone(RegistMember model);
}