package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.web.model.ActivityProduct;

public interface ActivityProductMapper{

	/**
	 * 插入活动商品数据
	 * @param info
	 * @return
	 */
	boolean insertActProduct(ActivityProduct info);
	
	/**
	 * 更新活动商品数据
	 * @param info
	 * @return
	 */
	boolean updateActProductById(ActivityProduct info);
	
	/**
	 * 删除活动商品数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteActProductById(int id);
	
	/**
	 * 删除活动商品数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteActProductByActId(int activity_id);

	/**
	 * 查询单条活动商品数据
	 * @param activity_id
	 * @return
	 */
	ActivityProduct selectActProductById(int id);
	

	/**
	 * 查询多条活动商品数据
	 * @param activity_id
	 * @return
	 */
	List<ActivityProduct> selectActProductAll(Map<String,Object> map);
	
	/**
	 * 批量插入活动商品
	 * @param list
	 * @return
	 */
	boolean insertBatchActProducts(List<ActivityProduct> list);
	
	/**
	 * 查询活动商品条数
	 * @param activity_id
	 * @return
	 */
	int selectActProNum(int activity_id);
}
