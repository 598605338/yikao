package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.SecUser;
import com.linjia.web.model.SecUserRole;
import com.linjia.web.query.SecUserQuery;

public interface SecUserMapper extends BaseDao<SecUser, Long> {
	
	/**
	 * 分页查询用户列表
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	List<SecUser> selectByPageList(SecUserQuery query);
	
	/**
	 * 查询分页数据总数量
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	int countByExample(SecUserQuery query);
	
	/**
	 * 根据userId删除用户和角色关联关系
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	int deleteUserRoleByUserId(int id);
	
	/**
	 * 根据userId查询用户和所属角色
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	List<Integer> selectUserRoleByUserId(Long id);
	
	/**
	 * 插入用户和角色关联关系
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	int insertUserRoleBatch(Map<String,Object> map);

	/**
	 * 根据登陆用户名查询用户信息
	 * lixinling 
	 * 2016年8月30日 下午7:15:17
	 * @param query
	 * @return
	 */
	SecUser selectByLogin(String login);
}