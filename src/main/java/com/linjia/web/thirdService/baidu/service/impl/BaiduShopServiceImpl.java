package com.linjia.web.thirdService.baidu.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.linjia.tools.JSONUtil;
import com.linjia.tools.NetRequest;
import com.linjia.web.thirdService.baidu.factory.BdURLFactory;
import com.linjia.web.thirdService.baidu.model.Shop;
import com.linjia.web.thirdService.baidu.service.BaiduShopService;
import com.linjia.web.thirdService.baidu.vo.ShopParamAdapter;

@Service
public class BaiduShopServiceImpl implements BaiduShopService{

	private ShopParamAdapter param=new ShopParamAdapter();
	private String reqUrl=BdURLFactory.genUrlPrefix();
	
	public JSONObject shopCreate(Shop shop,String Authorization){
		JSONObject respJson=param.shopCreate(shop);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	};
	
	public JSONObject shopUpdate(Shop shop,String Authorization){
		JSONObject respJson=param.shopUpdate(shop);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	};
	
	public JSONObject shopList(String Authorization){
		JSONObject respJson=param.shopList();
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	public JSONObject shopOffline(String shopId,String Authorization) {
		JSONObject respJson=param.shopOffline(shopId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	public JSONObject shopOpen(String shopId,String Authorization) {
		JSONObject respJson=param.shopOpen(shopId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	public JSONObject shopClose(String shopId,String Authorization) {
		JSONObject respJson=param.shopClose(shopId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	public JSONObject shopGet(String shopId,String Authorization) {
		JSONObject respJson=param.shopGet(shopId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	public JSONObject shopThresholdSet(String shopId, List list,String Authorization) {
		
		JSONObject respJson=param.shopThresholdSet(shopId,null);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	/**
	 * 商户配送时延设置
	 * @param shopId
	 * @param delivery_delay_time
	 * @return
	 */
	public JSONObject shopDeliveryDelay(String shopId,int delivery_delay_time,String Authorization){
		JSONObject respJson=param.shopDeliveryDelay(shopId,delivery_delay_time);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	/**
	 * 商户资质图片上传
	 * @param shopId
	 * @param list
	 * @return
	 */
	public JSONObject shopPicUpload(String shopId,List list,String Authorization){
		JSONObject respJson=param.shopPicUpload(shopId,null);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	/**
	 * 商户公告
	 * @param shopId
	 * @param content
	 * @return
	 */
	public JSONObject shopAnnouncementSet(String shopId,String content,String Authorization){
		JSONObject respJson=param.shopAnnouncementSet(shopId,content);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	/**
	 * 查看商户代码
	 * @param shopId
	 * @return
	 */
	public JSONObject shopCode(String shopId,String Authorization){
		JSONObject respJson=param.shopCode(shopId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

}
