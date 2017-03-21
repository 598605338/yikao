package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.SecRoleMapper;
import com.linjia.web.model.SecRole;
import com.linjia.web.query.SecRoleQuery;
import com.linjia.web.service.SecRoleService;

@Service
@Transactional
public class SecRoleServiceImpl extends BaseServiceImpl<SecRole, Long> implements SecRoleService {

	@Resource
	private SecRoleMapper mapper;

	@Override
	public BaseDao<SecRole, Long> getDao() {
		return mapper;
	}

	@Override
	public List<SecRole> selectByPageList(SecRoleQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public List<SecRole> selectAllRoleInfo() {
		return mapper.selectAllRoleInfo();
	}

	@Override
	public int countByExample(SecRoleQuery query) {
		return mapper.countByExample(query);
	}


}
