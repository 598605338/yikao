package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.SecUser;
import com.linjia.web.query.SecUserQuery;

public interface SecUserService extends BaseService<SecUser, Long>{
	
	/**
	 * 分页查询用户列表
	 * lixinling 
	 * 2016年8月30日 下午4:12:28
	 * @param query
	 * @return
	 */
	List<SecUser> selectByPageList(SecUserQuery query, Integer level, String login);

	/**
	 * 查询分页数据总数量
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	int countByExample(SecUserQuery query);
	
	/**
	 * 添加用户并设置角色
	 * lixinling 
	 * 2016年8月30日 下午4:12:28
	 * @param query
	 * @return
	 */
	boolean insertUserAndRole(SecUser model);

	/**
	 * 根据userId查询用户所属角色列表
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	List<Integer> selectUserRoleByUserId(Long id);
	
	/**
	 * 更新用户并设置角色
	 * lixinling 
	 * 2016年8月30日 下午4:12:28
	 * @param query
	 * @return
	 */
	boolean updateUserAndRole(SecUser model);

	/**
	 * 根据登陆用户名查询用户信息
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	SecUser selectByLogin(String login);
}
