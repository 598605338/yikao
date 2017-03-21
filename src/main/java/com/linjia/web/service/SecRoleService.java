package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.SecRole;
import com.linjia.web.query.SecRoleQuery;

public interface SecRoleService extends BaseService<SecRole, Long>{
	
	/**
	 * 分页查询角色列表
	 * lixinling 
	 * 2016年8月30日 下午4:12:28
	 * @param query
	 * @return
	 */
	List<SecRole> selectByPageList(SecRoleQuery query);

	/**
	 * 查询分页数据总数量
	 * lixinling 
	 * 2016年8月31日 上午10:27:28
	 * @param query
	 * @return
	 */
	int countByExample(SecRoleQuery query);
	

	/**
	 * 查询所有角色列表
	 * lixinling 
	 * 2016年8月31日 上午10:27:28
	 * @param query
	 * @return
	 */
	List<SecRole> selectAllRoleInfo();
}
