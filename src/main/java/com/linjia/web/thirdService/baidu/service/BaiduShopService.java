package com.linjia.web.thirdService.baidu.service;

import java.util.List;

import org.json.JSONObject;

import com.linjia.web.thirdService.baidu.model.Shop;

public interface BaiduShopService {
	
	/**
	 * 创建商户
	 * @param shop
	 * @return
	 */
	public JSONObject shopCreate(Shop shop,String Authorization);
	
	/**
	 * 修改商户
	 * @param shop
	 * @return
	 */
	public JSONObject shopUpdate(Shop shop,String Authorization);
	
	/**
	 * 商户列表
	 * @return
	 */
	public JSONObject shopList(String Authorization);
	
	/**
	 * 下线商户
	 * @param shopId
	 * @return
	 */
	public JSONObject shopOffline(String shopId,String Authorization);
	
	/**
	 * 商户开业
	 * @param shopId
	 * @return
	 */
	public JSONObject shopOpen(String shopId,String Authorization);
	
	/**
	 * 商户歇业
	 * @param shopId
	 * @return
	 */
	public JSONObject shopClose(String shopId,String Authorization);
	
	/**
	 * 查看商户
	 * @param shopId
	 * @return
	 */
	public JSONObject shopGet(String shopId,String Authorization);
	
	/**
	 * 商户订单阈值设置(已下线)	
	 * @param shopId
	 * @param list
	 * @return
	 */
	public JSONObject shopThresholdSet(String shopId,List list,String Authorization);
	
	/**
	 * 商户配送时延设置
	 * @param shopId
	 * @param delivery_delay_time
	 * @return
	 */
	public JSONObject shopDeliveryDelay(String shopId,int delivery_delay_time,String Authorization);
	
	/**
	 * 商户资质图片上传
	 * @param shopId
	 * @param list
	 * @return
	 */
	public JSONObject shopPicUpload(String shopId,List list,String Authorization);
	
	/**
	 * 商户公告
	 * @param shopId
	 * @param content
	 * @return
	 */
	public JSONObject shopAnnouncementSet(String shopId,String content,String Authorization);
	
	/**
	 * 查看商户代码
	 * @param shopId
	 * @return
	 */
	public JSONObject shopCode(String shopId,String Authorization);
}
