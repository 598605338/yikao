package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.CardCoupon;
import com.linjia.web.model.CardCouponThird;
import com.linjia.web.query.CardCouponQuery;
import com.linjia.web.query.CardCouponThirdQuery;

/**
 * 优惠券
 * @author lixinling
 * 2016年8月15日 上午9:55:23
 */
public interface CardCouponService extends BaseService<CardCoupon, Long>{
	
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
	 * 第三方合作券详情列表
	 * lixinling 
	 * 2016年9月5日 下午5:17:20
	 * @param query
	 * @return
	 */
	List<CardCouponThird> selectThirdDetailByPageList(CardCouponThirdQuery query);
	
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
	 * 插入第三方合作券
	 * lixinling 
	 * 2016年9月5日 下午5:17:20
	 * @param query
	 * @return
	 */
	boolean insertCardCouponThird(List<CardCouponThird> list, String creator);
	
	/**
	 * 插入优惠券
	 * lixinling 
	 * 2016年11月23日 下午5:17:20
	 * @param query
	 * @return
	 */
	int insertCardCoupon(CardCoupon cardCoupon, String pName);
	
	/**
	 * 更新优惠券
	 * lixinling 
	 * 2016年11月23日 下午5:17:20
	 * @param query
	 * @return
	 */
	boolean updateCardCoupon(CardCoupon cardCoupon, Integer cardCouponProductId, String pName);
	
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
	int updateTotalNumByCardId(Long cardId, Integer sendNum);
}
