package com.linjia.web.service;

import java.util.List;
import java.util.Map;
import com.linjia.web.model.ActivityInfo;
import com.linjia.web.model.ActivityProduct;
import com.linjia.web.model.ActivityTradeProduct;
import com.linjia.web.query.ActivityInfoQuery;

public interface ActivityPromotionService{

	/**
	 * 插入活动信息数据
	 * @param info
	 * @return
	 */
	boolean insertActInfo(ActivityInfo info);
	
	/**
	 * 更新活动信息数据
	 * @param info
	 * @return
	 */
	boolean updateActInfoById(ActivityInfo info);
	
	/**
	 * 删除活动信息数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteActInfoById(int activity_id);
	

	/**
	 * 查询单条活动信息数据
	 * @param activity_id
	 * @return
	 */
	ActivityInfo selectActInfoById(int activity_id);
	

	/**
	 * 查询多条活动信息数据
	 * @param activity_id
	 * @return
	 */
	List<ActivityInfo> selectActInfoAll(ActivityInfoQuery query);
	
	
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
	 * 插入活动兑换商品数据
	 * @param info
	 * @return
	 */
	boolean insertActTradePro(ActivityTradeProduct info);
	
	/**
	 * 更新活动兑换商品数据
	 * @param info
	 * @return
	 */
	boolean updateActTradeProById(ActivityTradeProduct info);
	
	/**
	 * 删除活动兑换商品数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteActTradeProById(int id);
	

	/**
	 * 查询单条活动兑换商品数据
	 * @param activity_id
	 * @return
	 */
	ActivityTradeProduct selectActTradeProById(int id);
	

	/**
	 * 查询多条活动兑换商品数据
	 * @param activity_id
	 * @return
	 */
	List<ActivityTradeProduct> selectActTradeProAll(Map<String,Object> map);
}
