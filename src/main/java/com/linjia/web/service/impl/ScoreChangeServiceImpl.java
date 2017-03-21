package com.linjia.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ScoreChangeMapper;
import com.linjia.web.model.ScoreChange;
import com.linjia.web.service.ScoreChangeService;

@Service
@Transactional
public class ScoreChangeServiceImpl extends BaseServiceImpl<ScoreChange, Long> implements ScoreChangeService {
	
	@Resource
	private ScoreChangeMapper mapper;

	@Override
	public BaseDao<ScoreChange, Long> getDao() {
		return mapper;
	}
	
}
