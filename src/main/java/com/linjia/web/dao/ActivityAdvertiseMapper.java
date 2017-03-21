package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.web.model.ActivityAdvertise;

public interface ActivityAdvertiseMapper{

	/**
	 * 插入活动广告信息数据
	 * @param info
	 * @return
	 */
	boolean insertAyAdvInfo(ActivityAdvertise info);
	
	/**
	 * 更新活动广告信息数据
	 * @param info
	 * @return
	 */
	boolean updateAyAdvInfoById(ActivityAdvertise info);
	
	/**
	 * 删除活动广告信息数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteAyAdvInfoById(int id);
	

	/**
	 * 查询单条活动广告信息数据
	 * @param activity_id
	 * @return
	 */
	ActivityAdvertise selectAyAdvInfoById(int id);
	

	/**
	 * 查询多条活动广告信息数据
	 * @param
	 * @return
	 */
	List<ActivityAdvertise> selectAyAdvInfoAll();
	
}
