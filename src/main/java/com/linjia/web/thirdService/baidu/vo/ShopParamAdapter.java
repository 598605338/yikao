package com.linjia.web.thirdService.baidu.vo;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linjia.web.thirdService.baidu.Serializer.BusinessTimeSerializer;
import com.linjia.web.thirdService.baidu.Serializer.CmdSerializer;
import com.linjia.web.thirdService.baidu.Serializer.CoordSerializer;
import com.linjia.web.thirdService.baidu.Serializer.Delivery_regionSerializer;
import com.linjia.web.thirdService.baidu.Serializer.ShopSerializer;
import com.linjia.web.thirdService.baidu.factory.BdURLFactory;
import com.linjia.web.thirdService.baidu.model.BusinessTime;
import com.linjia.web.thirdService.baidu.model.Cmd;
import com.linjia.web.thirdService.baidu.model.Coord;
import com.linjia.web.thirdService.baidu.model.Delivery_region;
import com.linjia.web.thirdService.baidu.model.Shop;
import com.linjia.web.thirdService.baidu.utils.BaiduUtil;

public class ShopParamAdapter {

	public JSONObject shopCreate(Shop shop){
		//准备body数据
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopCreate"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopUpdate(Shop shop){
		//准备body数据
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopUpdate"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopList(){
		Shop shop=new Shop();
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopList"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopOffline(String shopId){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopOffline"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopOpen(String shopId){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopOpen"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopClose(String shopId){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopClose"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopGet(String shopId){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopGet"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopThresholdSet(String shopId,List list){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopThresholdSet"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopDeliveryDelay(String shopId,int delivery_delay_time){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopDeliveryDelay"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopPicUpload(String shopId,List list){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopPicUpload"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopAnnouncementSet(String shopId,String content){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopAnnouncementSet"),shop,gson);
		return respJson;
	}
	
	public JSONObject shopCode(String shopId){
		//准备body数据
		Shop shop = new Shop();
		shop.setMall_code(shopId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopCode"),shop,gson);
		return respJson;
	}
	
}
