package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.CardCouponThird;
import com.linjia.web.query.CardCouponThirdQuery;
public interface CardCouponThirdMapper extends BaseDao<CardCouponThird, Long> {
	
	/**
	 * 批量插入第三方合作券
	 * lixinling 
	 * 2016年9月5日 下午8:28:50
	 * @param list
	 * @return
	 */
	int insertBatch(Map<String,Object> param);
	
	/**
	 * 第三方合作券详情列表
	 * lixinling 
	 * 2016年9月5日 下午8:28:50
	 * @param list
	 * @return
	 */
	List<CardCouponThird> selectPageListByCardCouponId(CardCouponThirdQuery query);
}