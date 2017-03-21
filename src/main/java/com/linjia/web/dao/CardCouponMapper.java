package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.CardCoupon;
import com.linjia.web.query.CardCouponQuery;

/**
 * 优惠券
 * @author lixinling
 * 2016年8月15日 上午9:55:23
 */
public interface CardCouponMapper extends BaseDao<CardCoupon, Long> {
	
	/**
	 * 取得分页数据列表
	 * lixinling 
	 * 2016年9月5日 上午10:23:43
	 * @param query
	 * @return
	 */
	List<CardCoupon> selectByPageList(CardCouponQuery query);
	
	/**
	 * 取得分页数据总数量
	 * lixinling 
	 * 2016年9月5日 上午10:23:43
	 * @param query
	 * @return
	 */
	int countByExample(CardCouponQuery query);
	
	
	/**
	 * 第三方合作券列表
	 * lixinling 
	 * 2016年9月5日 下午5:17:20
	 * @param query
	 * @return
	 */
	List<CardCoupon> selectThirdByPageList(CardCouponQuery query);
	
	/**
	 * 分页查询第三方合作券总数量
	 * lixinling 
	 * 2016年9月5日 下午5:17:20
	 * @param query
	 * @return
	 */
	int countSelectThird(CardCouponQuery query);
	
	/**
	 * 查询剩余的卡券数量 
	 * lixinling 
	 * 2016年9月5日 下午5:17:20
	 * @param query
	 * @return
	 */
	int countSurplusNum(Long cardId);
	
	/**
	 * 更新卡券数量 
	 * lixinling 
	 * 2016年9月5日 下午5:17:20
	 * @param query
	 * @return
	 */
	int updateTotalNumByCardId(Map<String,Object> param);
}