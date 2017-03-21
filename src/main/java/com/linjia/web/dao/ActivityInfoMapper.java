package com.linjia.web.dao;

import java.util.List;

import com.linjia.web.model.ActivityInfo;
import com.linjia.web.query.ActivityInfoQuery;

public interface ActivityInfoMapper{

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
	
}
