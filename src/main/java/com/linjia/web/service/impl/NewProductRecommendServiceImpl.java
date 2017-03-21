package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ActivityPintuanBaseMapper;
import com.linjia.web.dao.NewProductRecommendMapper;
import com.linjia.web.model.ActivityPintuanBase;
import com.linjia.web.model.NewProductRecommend;
import com.linjia.web.query.ActivityPintuanBaseQuery;
import com.linjia.web.service.ActivityPintuanBaseService;
import com.linjia.web.service.NewProductRecommendService;

@Service
@Transactional
public class NewProductRecommendServiceImpl extends BaseServiceImpl<NewProductRecommend, Long> implements NewProductRecommendService {
	
	@Resource
	private NewProductRecommendMapper mapper;
	
	@Override
	public BaseDao<NewProductRecommend, Long> getDao() {
		return mapper;
	}

	@Override
	public List<NewProductRecommend> selectNewProductList() {
		return mapper.selectNewProductList();
	}

	@Override
	public int updateBatchByPrimaryKey(List<NewProductRecommend> list) {
		return mapper.updateBatchByPrimaryKey(list);
	}



	

}
