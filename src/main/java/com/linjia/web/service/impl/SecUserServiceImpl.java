package com.linjia.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.SecUserMapper;
import com.linjia.web.model.SecUser;
import com.linjia.web.model.SecUserRole;
import com.linjia.web.query.SecUserQuery;
import com.linjia.web.service.SecUserService;

@Service
@Transactional
public class SecUserServiceImpl extends BaseServiceImpl<SecUser, Long> implements SecUserService {

	@Resource
	private SecUserMapper mapper;

	@Override
	public BaseDao<SecUser, Long> getDao() {
		return mapper;
	}

	@Override
	public List<SecUser> selectByPageList(SecUserQuery query, Integer level, String login) {
		List<SecUser> list = null;
		if(level == 0){
			list = mapper.selectByPageList(query);
		}else{
			list = new ArrayList<SecUser>();
			SecUser secUser = mapper.selectByLogin(login);
			list.add(secUser);
		}
		return list;
	}

	@Override
	public boolean insertUserAndRole(SecUser model) {
		boolean result = false;
		// 插入新增用户数据
		int row = getDao().insertSelective(model);

		// 插入用户角色相关
		if (row == 1 && model.getPrivilegeIds() != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			
			param.put("list", model.getPrivilegeIds());
			param.put("secUserId", model.getId());
			param.put("creator", model.getCreator());
			param.put("updater", model.getUpdater());
			param.put("creDate", new Date());
			param.put("updateDate", new Date());
			
			mapper.insertUserRoleBatch(param);
			result = true;
		}
		return result;
	}

	@Override
	public boolean updateUserAndRole(SecUser model) {
		boolean result = false;
		// 插入新增用户数据
		boolean res = getDao().updateByPrimaryKeySelective(model);

		// 插入用户角色相关
		if (res && model.getPrivilegeIds() != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			
			param.put("list", model.getPrivilegeIds());
			param.put("secUserId", model.getId());
			param.put("creator", model.getUpdater());
			param.put("updater", model.getUpdater());
			param.put("creDate", new Date());
			param.put("updateDate", new Date());
			
			//删除用户原来的所属角色并设置新更改的角色
			mapper.deleteUserRoleByUserId(model.getId());
			mapper.insertUserRoleBatch(param);
			result = true;
		}
		return result;
	}
	
	@Override
	public List<Integer> selectUserRoleByUserId(Long id) {
		return mapper.selectUserRoleByUserId(id);
	}

	@Override
	public SecUser selectByLogin(String login) {
		return mapper.selectByLogin(login);
	}

	@Override
	public int countByExample(SecUserQuery query) {
		return mapper.countByExample(query);
	}

}
