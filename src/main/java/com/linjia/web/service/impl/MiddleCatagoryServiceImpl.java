package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.MiddleCatagoryMapper;
import com.linjia.web.model.MiddleCatagory;
import com.linjia.web.query.CatagoryQuery;
import com.linjia.web.service.MiddleCatagoryService;

@Service
@Transactional
public class MiddleCatagoryServiceImpl extends BaseServiceImpl<MiddleCatagory, Long> implements MiddleCatagoryService {
	
	@Resource
	private MiddleCatagoryMapper mapper;

	@Override
	public BaseDao<MiddleCatagory, Long> getDao() {
		return mapper;
	}

	@Override
	public List<MiddleCatagory> selectByLargeCatagoryId(CatagoryQuery query) {
		return mapper.selectByLargeCatagoryId(query);
	}

	@Override
	public int updateUseStatusByPrimaryKey(MiddleCatagory middleCatagory) {
		return mapper.updateUseStatusByPrimaryKey(middleCatagory);
	}

	@Override
	public List<MiddleCatagory> selectAllByLargeCatagoryId(Long largeId) {
		return mapper.selectAllByLargeCatagoryId(largeId);
	}

	@Override
	public Long selectIdByName(String name) {
		return mapper.selectIdByName(name);
	}

	@Override
	public int countByExample(CatagoryQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public Long selectMaxSortIndex() {
		return mapper.selectMaxSortIndex();
	}
	
	

}
