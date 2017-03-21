package com.linjia.web.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.Privilege;

public interface PrivilegeService extends BaseService<Privilege, Long>{
	

	/**
	 * 根据角色id查询角色权限
	 * lixinling 
	 * 2016年8月31日 下午6:52:55
	 * @param roleId
	 * @return
	 */
	List<Integer> selectPrivilegeIdByRoleId(int roleId);
	
	/**
	 * 更新授权信息 
	 * lixinling 
	 * 2016年8月31日 下午6:52:55
	 * @param roleId
	 * @return
	 */
	boolean updateRolePrivilege(HttpServletRequest request, int roleId, String privilegeIds);
}
