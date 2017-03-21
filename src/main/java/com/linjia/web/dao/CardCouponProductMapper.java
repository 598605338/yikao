package com.linjia.web.dao;

import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.CardCouponProduct;

public interface CardCouponProductMapper extends BaseDao<CardCouponProduct, Long> {
	
	/**
	 * 查询优惠券校验商品行数据
	 * lixinling 
	 * 2016年9月22日 下午1:44:30
	 * @param cardCouponId
	 * @return
	 */
	CardCouponProduct selectDetailBycardCouponId(Map<String,Object> param);
	
	/**
	 * 查询用户商品券对应的商品code
	 * lixinling 
	 * 2016年9月22日 下午1:44:30
	 * @param cardCouponId
	 * @return
	 */
	CardCouponProduct selectByuserCardCouponId(Long userCardCouponId);
	
	/**
	 * 查询商品券对应的商品
	 * lixinling 
	 * 2016年11月23日 下午1:44:30
	 * @param cardCouponId
	 * @return
	 */
	CardCouponProduct selectByCardCouponId(Long userCardCouponId);
	
	/**
	 * 查询商品券对应的商品code
	 * lixinling 
	 * 2016年11月22日 下午1:44:30
	 * @param cardCouponId
	 * @return
	 */
	String selectPCodeByuserCardCouponId(Long userCardCouponId);
}