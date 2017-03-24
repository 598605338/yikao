package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.CollegeMapper;
import com.linjia.web.dao.RegionMapper;
import com.linjia.web.model.College;
import com.linjia.web.model.Region;
import com.linjia.web.query.CollegeQuery;
import com.linjia.web.service.CollegeService;
import com.linjia.web.service.RegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RegionServiceImpl extends BaseServiceImpl<Region, Long> implements RegionService {

	@Resource
	private RegionMapper mapper;

	@Override
	public BaseDao<Region, Long> getDao() {
		return mapper;
	}


	@Override
	public List<Region> selectRegionByParentId(Integer parentId) {
		return mapper.selectRegionByParentId(parentId);
	}
}
