package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.SelectCustSendCardCoupon;
import com.linjia.web.model.UserCardCoupon;
import com.linjia.web.query.UserCardCouponQuery;


public interface UserCardCouponMapper extends BaseDao<UserCardCoupon, Long> {
	
	/**
	 * 分页取得列表数据
	 * lixinling 
	 * 2016年9月5日 上午11:14:49
	 * @param query
	 * @return
	 */
	List<UserCardCoupon> selectByPageList(UserCardCouponQuery query);
	
	/**
	 * 发放卡券中：选择会员发放列表 
	 * lixinling 
	 * 2016年9月5日 上午11:14:49
	 * @param query
	 * @return
	 */
	List<SelectCustSendCardCoupon> selectCustSendCardCoupon(UserCardCouponQuery query);
	
	/**
	 * 发放卡券中：批量发放卡券给会员 
	 * lixinling 
	 * 2016年9月5日 上午11:14:49
	 * @param query
	 * @return
	 */
	int insertBatch(List<UserCardCoupon> list);
	
	/**
	 * 更新优惠券状态
	 * lixinling 
	 * 2016年9月5日 上午11:14:49
	 * @param query
	 * @return
	 */
	int updateUseStatusByPrimaryKey(UserCardCoupon model);
	
	/**
	 * 查询总数量
	 * lixinling 
	 * 2016年9月5日 上午11:14:49
	 * @param query
	 * @return
	 */
	Integer countByExample(UserCardCouponQuery query);
}