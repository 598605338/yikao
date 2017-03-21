package com.linjia.web.dao;

import java.util.List;
import com.linjia.web.model.AdvertisePosition;

public interface AdvertisePositionMapper{

	/**
	 * 插入广告信息数据
	 * @param info
	 * @return
	 */
	boolean insertAdvInfo(AdvertisePosition info);
	
	/**
	 * 更新广告信息数据
	 * @param info
	 * @return
	 */
	boolean updateAdvInfoById(AdvertisePosition info);
	
	/**
	 * 删除广告信息数据
	 * @param id
	 * @return
	 */
	boolean deleteAdvInfoById(int id);
	

	/**
	 * 查询单条广告信息数据
	 * @param activity_id
	 * @return
	 */
	AdvertisePosition selectAdvInfoById(int id);
	

	/**
	 * 查询多条广告信息数据
	 * @param activity_id
	 * @return
	 */
	List<AdvertisePosition> selectAdvInfoAll();
	
}
