package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ReceiveCardCoupon;
import com.linjia.web.query.ReceiveCardCouponQuery;

public interface ReceiveCardCouponMapper extends BaseDao<ReceiveCardCoupon, Long> {
	
	/**
	 * 分页查询数据
	 * lixinling 
	 * 2016年9月4日 下午4:18:41
	 * @param query
	 * @return
	 */
	List<ReceiveCardCoupon> selectByPageList(ReceiveCardCouponQuery query);
	
	/**
	 * 分页查询数据总数量
	 * lixinling 
	 * 2016年9月4日 下午4:18:41
	 * @param query
	 * @return
	 */
	int countByExample(ReceiveCardCouponQuery query);
	
	/**
	 * 更新使用状态
	 * lixinling 
	 * 2016年9月8日 下午1:34:54
	 * @param param
	 * @return
	 */
	boolean updateUseStatusByPrimaryKey(Map<String,Object> param);
}