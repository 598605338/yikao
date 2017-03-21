package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.web.model.BannerInfo;

public interface BannerInfoMapper{

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
	 * @param 广告id 
	 * @param 广告类型
	 * @return
	 */
	List<BannerInfo> selectBannerInfoAll(Map<String,Object> map);
	
	/**
	 * 批量修改Banner数据
	 * @return
	 */
	boolean updBatchBaseInfos(List<BannerInfo> list);
	
}
