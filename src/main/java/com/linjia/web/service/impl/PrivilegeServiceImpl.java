package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.Util;
import com.linjia.web.dao.PrivilegeMapper;
import com.linjia.web.model.Privilege;
import com.linjia.web.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, Long> implements PrivilegeService {
	
	@Resource
	private PrivilegeMapper mapper;

	@Override
	public BaseDao<Privilege, Long> getDao() {
		return mapper;
	}

	@Override
	public List<Integer> selectPrivilegeIdByRoleId(int roleId) {
		return mapper.selectPrivilegeIdByRoleId(roleId);
	}

	@Override
	public boolean updateRolePrivilege(HttpServletRequest request, int roleId, String privilegeIds) {
		boolean flag =false;
		//删除该角色所有的权限
		mapper.deleteByRoleId(roleId);
		
		//插入该角色新选的权限
		String creator = Util.getUser(request).getLogin();// session中取得
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		params.put("creDate", new Date());
		params.put("creator", creator);
		params.put("updater", creator);
		params.put("updateDate", new Date());
		params.put("list", privilegeIds.split(","));
		mapper.insertBatchRolePrivilegeList(params);
		flag =true;
		
		return flag;
	}

}
