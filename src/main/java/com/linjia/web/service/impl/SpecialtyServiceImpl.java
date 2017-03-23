package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.SpecialtyMapper;
import com.linjia.web.model.Specialty;
import com.linjia.web.query.SpecialtyQuery;
import com.linjia.web.service.SpecialtyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SpecialtyServiceImpl extends BaseServiceImpl<Specialty, Long> implements SpecialtyService {
	
	@Resource
	private SpecialtyMapper mapper;

	@Override
	public BaseDao<Specialty, Long> getDao() {
		return mapper;
	}


	@Override
	public List<Specialty> selectBySerach(SpecialtyQuery query) {
		return mapper.selectBySerach(query);
	}

	@Override
	public int countByExample(SpecialtyQuery query) {
		return mapper.countByExample(query);
	}
}
