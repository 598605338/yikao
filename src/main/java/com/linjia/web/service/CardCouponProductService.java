package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.CardCouponProduct;

public interface CardCouponProductService extends BaseService<CardCouponProduct, Long>{

	/**
	 * 查询商品券对应的商品
	 * lixinling 
	 * 2016年11月23日 下午1:44:30
	 * @param cardCouponId
	 * @return
	 */
	CardCouponProduct selectByCardCouponId(Long userCardCouponId);
}
