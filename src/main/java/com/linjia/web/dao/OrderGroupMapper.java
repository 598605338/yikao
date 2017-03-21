package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.query.OrderGroupQuery;

public interface OrderGroupMapper extends BaseDao<OrderGroup, Long> {
	
	/**
	 * 更改订单状态
	 * lixinling 
	 * 2016年7月28日 下午3:32:16
	 * @param map
	 * @return
	 */
	int updateStatusById(Map<String,Object> map);
	
	/**
	 * 查询我的全部订单
	 * lixinling 
	 * 2016年7月28日 下午3:32:16
	 * @param map
	 * @return
	 */
	List<OrderGroup> selectMyAllOrderList(OrderGroupQuery query);
}