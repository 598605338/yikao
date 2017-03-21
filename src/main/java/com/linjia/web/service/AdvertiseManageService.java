package com.linjia.web.service;

import java.util.List;
import java.util.Map;

import com.linjia.web.model.ActivityAdvertise;
import com.linjia.web.model.AdvertisePosition;
import com.linjia.web.model.BannerInfo;

public interface AdvertiseManageService{

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
	 * @param id
	 * @return
	 */
	AdvertisePosition selectAdvInfoById(int id);
	

	/**
	 * 查询多条广告信息数据
	 * @param
	 * @return
	 */
	List<AdvertisePosition> selectAdvInfoAll();
	
	/**
	 * 插入Banner数据
	 * @param info
	 * @return
	 */
	boolean insertBannerInfo(BannerInfo info);
	
	/**
	 * 更新Banner数据
	 * @param info
	 * @return
	 */
	boolean updateBannerInfoById(BannerInfo info);
	
	/**
	 * 删除Banner数据
	 * @param activity_id
	 * @return
	 */
	boolean deleteBannerInfoById(int id);
	

	/**
	 * 查询单条Banner数据
	 * @param activity_id
	 * @return
	 */
	BannerInfo selectBannerInfoById(int id);
	

	/**
	 * 查询多条Banner数据
	 * @param 
	 * @return
	 */
	List<BannerInfo> selectBannerInfoAll(Map<String,Object> map);
	
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
	
	/**
	 * 批量修改Banner数据
	 * @return
	 */
	boolean updBatchBaseInfos(List<BannerInfo> list);
}
