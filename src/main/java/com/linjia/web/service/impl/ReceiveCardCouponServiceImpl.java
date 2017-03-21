package com.linjia.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ReceiveCardCouponMapper;
import com.linjia.web.model.ReceiveCardCoupon;
import com.linjia.web.query.ReceiveCardCouponQuery;
import com.linjia.web.service.ReceiveCardCouponService;

@Service
@Transactional
public class ReceiveCardCouponServiceImpl extends BaseServiceImpl<ReceiveCardCoupon, Long> implements ReceiveCardCouponService {
	
	@Resource
	private ReceiveCardCouponMapper mapper;

	@Override
	public BaseDao<ReceiveCardCoupon, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ReceiveCardCoupon> selectByPageList(ReceiveCardCouponQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public boolean updateUseStatusByPrimaryKey(Map<String, Object> param) {
		return mapper.updateUseStatusByPrimaryKey(param);
	}

	@Override
	public int countByExample(ReceiveCardCouponQuery query) {
		return mapper.countByExample(query);
	}

	

}
