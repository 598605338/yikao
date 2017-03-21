package com.linjia.web.dao;

import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ScoreOrder;


public interface ScoreOrderMapper extends BaseDao<ScoreOrder, Long> {
	
	/**
	 * 更新积分订单状态
	 * lixinling 
	 * 2016年8月11日 下午1:21:56
	 * @param id
	 * @param orderStatus
	 * @return
	 */
	boolean updateStatusById(Map<String,Object> params);
}