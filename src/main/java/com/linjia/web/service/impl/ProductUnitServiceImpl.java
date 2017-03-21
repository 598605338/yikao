package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ProductUnitMapper;
import com.linjia.web.model.ProductUnit;
import com.linjia.web.query.ProductUnitQuery;
import com.linjia.web.service.ProductUnitService;

@Service
@Transactional
public class ProductUnitServiceImpl extends BaseServiceImpl<ProductUnit, Long> implements ProductUnitService {
	
	@Resource
	private ProductUnitMapper mapper;

	@Override
	public BaseDao<ProductUnit, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ProductUnit> selectByPageList(ProductUnitQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public int updateUseStatusById(ProductUnit model) {
		return mapper.updateUseStatusById(model);
	}

	@Override
	public List<ProductUnit> selectAllUnitList() {
		return mapper.selectAllUnitList();
	}

	@Override
	public Long selectIdByName(String name) {
		return mapper.selectIdByName(name);
	}

	@Override
	public int countByExample(ProductUnitQuery query) {
		return mapper.countByExample(query);
	}

}
