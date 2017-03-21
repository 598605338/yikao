package com.linjia.web.dao;


import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.HotsellProduct;

public interface HotsellProductMapper extends  BaseDao<HotsellProduct, Long> {
	
	/**
	 * 批量插入活动商品数据
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	int insertBatch(Map<String,Object> map);
	
	/**
	 * 根据baseId查询活动商品数据
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	List<HotsellProduct> selectByBaseId(Integer baseId);
	
	/**
	 * 根据baseId删除所有活动商品数据
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	int deleteByBaseId(Integer baseId);
}