package com.linjia.web.service;


import java.util.Map;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.RegistMember;

public interface RegistMemberService extends BaseService<RegistMember, Long>{

	/**
	 * 根据手机号查询用户注册状态
	 * lixinling 
	 * 2016年8月8日 上午9:59:21
	 * @param phone
	 * @return
	 */
	RegistMember selectByPhone(String phone);
	
	/**
	 * 注册会员
	 * lixinling 
	 * 2016年8月8日 上午9:59:21
	 * @param phone
	 * @return
	 */
	Map<String,Object> insertRegistMember(String phone);
	

}
