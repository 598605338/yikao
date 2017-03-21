package com.linjia.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.CardCouponProductMapper;
import com.linjia.web.model.CardCouponProduct;
import com.linjia.web.service.CardCouponProductService;

@Service
@Transactional
public class CardCouponProductServiceImpl extends BaseServiceImpl<CardCouponProduct, Long> implements CardCouponProductService {
	
	@Resource
	private CardCouponProductMapper mapper;

	@Override
	public BaseDao<CardCouponProduct, Long> getDao() {
		return mapper;
	}

	@Override
	public CardCouponProduct selectByCardCouponId(Long userCardCouponId) {
		return mapper.selectByCardCouponId(userCardCouponId);
	}

}
