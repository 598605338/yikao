package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ActivityKaiTuanUsersMapper;
import com.linjia.web.model.ActivityKaiTuanUsers;
import com.linjia.web.query.ActivityKaiTuanUsersQuery;
import com.linjia.web.service.ActivityKaiTuanUsersService;

@Service
@Transactional
public class ActivityKaiTuanUsersServiceImpl extends BaseServiceImpl<ActivityKaiTuanUsers, Long> implements ActivityKaiTuanUsersService {
	
	@Resource
	private ActivityKaiTuanUsersMapper mapper;

	@Override
	public int insertOneKaiTuanUser(ActivityKaiTuanUsers query) {
		return mapper.insertOneKaiTuanUser(query);
	}

	@Override
	public int updateOneKaiTuanUser(ActivityKaiTuanUsers query) {
		return mapper.updateOneKaiTuanUser(query);
	}

	@Override
	public List<ActivityKaiTuanUsers> selectKaiTuanUser(
			ActivityKaiTuanUsersQuery query) {
		return mapper.selectKaiTuanUser(query);
	}

	@Override
	public BaseDao<ActivityKaiTuanUsers, Long> getDao() {
		return null;
	}

}
