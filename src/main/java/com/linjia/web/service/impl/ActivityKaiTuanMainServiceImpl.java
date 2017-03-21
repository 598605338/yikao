package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ActivityKaiTuanMainMapper;
import com.linjia.web.model.ActivityKaiTuanMain;
import com.linjia.web.query.ActivityKaiTuanMainQuery;
import com.linjia.web.service.ActivityKaiTuanMainService;

@Service
@Transactional
public class ActivityKaiTuanMainServiceImpl extends BaseServiceImpl<ActivityKaiTuanMain, Long> implements ActivityKaiTuanMainService {
	
	@Resource
	private ActivityKaiTuanMainMapper mapper;

	@Override
	public int insertOneKaiTuanActivity(ActivityKaiTuanMain model) {
		return mapper.insertOneKaiTuanActivity(model);
	}

	@Override
	public int updateOneKaiTuanActivity(ActivityKaiTuanMain query) {
		return mapper.updateOneKaiTuanActivity(query);
	}

	@Override
	public List<ActivityKaiTuanMain> selectUserAllKaiTuan(
			ActivityKaiTuanMainQuery model) {
		return mapper.selectUserAllKaiTuan(model);
	}
	
	@Override
	public ActivityKaiTuanMain selectKaiTuanActivity(
			ActivityKaiTuanMainQuery query) {
		return mapper.selectKaiTuanActivity(query);
	}

	@Override
	public BaseDao<ActivityKaiTuanMain, Long> getDao() {
		return null;
	}
	
	public int selectSumSalesNum(int baseId){
		return mapper.selectSumSalesNum(baseId);
	}

	@Override
	public List<ActivityKaiTuanMain> selectOrderList() {
		return mapper.selectOrderList();
	}

}
