package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.CollegeMapper;
import com.linjia.web.dao.CollegeTypeMapper;
import com.linjia.web.model.College;
import com.linjia.web.model.CollegeType;
import com.linjia.web.query.CollegeQuery;
import com.linjia.web.query.CollegeTypeQuery;
import com.linjia.web.service.CollegeTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CollegeTypeServiceImpl extends BaseServiceImpl<CollegeType, Long> implements CollegeTypeService {

	@Resource
	private CollegeTypeMapper mapper;

	@Override
	public BaseDao<CollegeType, Long> getDao() {
		return mapper;
	}


	@Override
	public List<CollegeType> selectBySerach(CollegeTypeQuery query) {
		return mapper.selectBySerach(query);
	}

	@Override
	public int countByExample(CollegeTypeQuery query) {
		return mapper.countByExample(query);
	}

}
