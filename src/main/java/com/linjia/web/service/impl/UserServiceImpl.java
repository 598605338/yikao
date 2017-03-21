package com.linjia.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.UserMapper;
import com.linjia.web.model.User;
import com.linjia.web.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
	@Resource
	private UserMapper mapper;
	
	@Override
	public BaseDao<User, Long> getDao() {
		return mapper;
	}

}
