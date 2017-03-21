package com.linjia.web.dao;

import java.util.List;
import java.util.Map;
import com.linjia.web.model.ActivityTradeProduct;

public interface ActivityTradeProductMapper{

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
	 * 删除活动兑换商品数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteActTradeProByActId(int activity_id);

	/**
	 * 查询单条活动兑换商品数据
	 * @param activity_id
	 * @return
	 */
	ActivityTradeProduct selectActTradeProById(int id);
	
	/**
	 * 查询单条活动兑换的所有商品数据
	 * @param activity_id
	 * @return
	 */
	List<ActivityTradeProduct> selectActTradeProByActId(int activity_id);
	
	/**
	 * 查询单条活动兑换的所有商品的商品数目
	 * @param activity_id
	 * @return
	 */
	int selectActTraNum(int activity_id);
	
	/**
	 * 查询单条活动兑换的所有商品数据
	 * @param activity_id
	 * @return
	 */
	List<ActivityTradeProduct> selectActTradeProAll(Map<String,Object> map);
	
	/**
	 * 批量插入换购商品
	 * @param list
	 * @return
	 */
	boolean insertBatActTradeProducts(List<ActivityTradeProduct> list);
}
