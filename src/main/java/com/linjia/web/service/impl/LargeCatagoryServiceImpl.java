package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.LargeCatagoryMapper;
import com.linjia.web.model.LargeCatagory;
import com.linjia.web.query.CatagoryQuery;
import com.linjia.web.service.LargeCatagoryService;

@Service
@Transactional
public class LargeCatagoryServiceImpl extends BaseServiceImpl<LargeCatagory, Long> implements LargeCatagoryService {
	
	@Resource
	private LargeCatagoryMapper mapper;

	@Override
	public BaseDao<LargeCatagory, Long> getDao() {
		return mapper;
	}

	@Override
	public List<LargeCatagory> selectPageList(CatagoryQuery query) {
		return mapper.selectPageList(query);
	}

	@Override
	public int updateUseStatusByPrimaryKey(LargeCatagory largeCatagory) {
		return mapper.updateUseStatusByPrimaryKey(largeCatagory);
	}

	@Override
	public List<LargeCatagory> selectAllLargeCatagoryList() {
		return mapper.selectAllLargeCatagoryList();
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
