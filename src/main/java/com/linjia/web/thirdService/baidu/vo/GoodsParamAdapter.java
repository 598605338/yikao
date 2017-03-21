package com.linjia.web.thirdService.baidu.vo;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linjia.web.thirdService.baidu.Serializer.CmdSerializer;
import com.linjia.web.thirdService.baidu.Serializer.GoodsSerializer;
import com.linjia.web.thirdService.baidu.factory.BdURLFactory;
import com.linjia.web.thirdService.baidu.model.Cmd;
import com.linjia.web.thirdService.baidu.model.Goods;
import com.linjia.web.thirdService.baidu.utils.BaiduUtil;

public class GoodsParamAdapter {
	
	public JSONObject skuCreate(Goods goods) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Goods.class, new GoodsSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuCreate"),goods,gson);
		return respJson;
	}

	public JSONObject skuUpdate(Goods goods) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Goods.class, new GoodsSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuUpdate"),goods,gson);
		return respJson;
	}

	public JSONObject skuList() {
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuList"),null,null);
		return respJson;
	}

	public JSONObject skuOnline(String shop_id, String sku_id) {
		//准备body数据
		Goods goods = new Goods();
		goods.setShop_id(shop_id);
		goods.setSku_id(sku_id);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Goods.class, new GoodsSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuOnline"),goods,gson);
		return respJson;
	}

	public JSONObject skuOffline(String shop_id, String sku_id) {
		//准备body数据
		Goods goods = new Goods();
		goods.setShop_id(shop_id);
		goods.setSku_id(sku_id);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Goods.class, new GoodsSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuOffline"),goods,gson);
		return respJson;
	}

	public JSONObject skuStockUpdateMatch(String shop_id, String skuid_stocks) {
		//准备body数据
		Goods goods = new Goods();
		goods.setShop_id(shop_id);
		goods.setSkuid_stocks(skuid_stocks);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Goods.class, new GoodsSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuStockUpdateMatch"),goods,gson);
		return respJson;
	}

	public JSONObject skuPriceUpdateBatch(String shop_id, String skuid_price) {
		//准备body数据
		Goods goods = new Goods();
		goods.setShop_id(shop_id);
		goods.setSkuid_price(skuid_price);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Goods.class, new GoodsSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("skuPriceUpdateBatch"),goods,gson);
		return respJson;
	}
	
}
