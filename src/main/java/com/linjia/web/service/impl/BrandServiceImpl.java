package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.BrandMapper;
import com.linjia.web.model.Brand;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.service.BrandService;

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand, Long> implements BrandService {
	
	@Resource
	private BrandMapper mapper;

	@Override
	public BaseDao<Brand, Long> getDao() {
		return mapper;
	}

	@Override
	public List<Brand> selectBySerach(BrandQuery query) {
		return mapper.selectBySerach(query);
	}

	@Override
	public int updateUseStatusByPrimaryKey(Brand model) {
		return mapper.updateUseStatusByPrimaryKey(model);
	}

	@Override
	public List<Brand> selectAllBrandList() {
		return mapper.selectAllBrandList();
	}

	@Override
	public Long selectIdByName(String name) {
		return mapper.selectIdByName(name);
	}

	@Override
	public int countByExample(BrandQuery query) {
		return mapper.countByExample(query);
	}
	

}
