package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ActivityMemberPromotionMapper;
import com.linjia.web.dao.BrandMapper;
import com.linjia.web.model.ActivityMemberPromotion;
import com.linjia.web.model.Brand;
import com.linjia.web.query.ActivityMemberPromotionQuery;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.service.ActivityMemberPromotionService;
import com.linjia.web.service.BrandService;

@Service
@Transactional
public class ActivityMemberPromotionServiceImpl extends BaseServiceImpl<ActivityMemberPromotion, Long> implements ActivityMemberPromotionService {
	
	@Resource
	private ActivityMemberPromotionMapper mapper;

	@Override
	public BaseDao<ActivityMemberPromotion, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ActivityMemberPromotion> selectByPageList(ActivityMemberPromotionQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public int updateStatusByPrimaryKey(boolean useStatus, Long id) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("useStatus", useStatus);
		map.put("id", id);
		return mapper.updateStatusByPrimaryKey(map);
	}

	@Override
	public int selectExistsSameTime(Date startTime, Date endTime) {
		Map<String,Object> map = new HashMap<String,Object>();
		return mapper.selectExistsSameTime(map);
	}

	@Override
	public int countByExample(ActivityMemberPromotionQuery query) {
		return mapper.countByExample(query);
	}

	

}
