package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.Privilege;


public interface PrivilegeMapper extends BaseDao<Privilege, Long> {
	
	/**
	 * 根据角色id查询角色权限
	 * lixinling 
	 * 2016年8月31日 下午6:52:55
	 * @param roleId
	 * @return
	 */
	List<Integer> selectPrivilegeIdByRoleId(int roleId);
	
	/**
	 * 批量插入确认下单中购买的商品数据
	 * lixinling 
	 * 2016年8月31日 下午6:52:55
	 * @param roleId
	 * @return
	 */
	int insertBatchRolePrivilegeList(Map params);
	
	/**
	 * 删除该角色的所有权限
	 * lixinling 
	 * 2016年8月31日 下午6:52:55
	 * @param roleId
	 * @return
	 */
	int deleteByRoleId(int roleId);
}