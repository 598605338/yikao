package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.CollegeMapper;
import com.linjia.web.model.College;
import com.linjia.web.query.CollegeQuery;
import com.linjia.web.service.CollegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<College, Long> implements CollegeService {

	@Resource
	private CollegeMapper mapper;

	@Override
	public BaseDao<College, Long> getDao() {
		return mapper;
	}


	@Override
	public List<College> selectBySerach(CollegeQuery query) {
		return mapper.selectBySearch(query);
	}

	@Override
	public int countByExample(CollegeQuery query) {
		return mapper.countByExample(query);
	}

}
