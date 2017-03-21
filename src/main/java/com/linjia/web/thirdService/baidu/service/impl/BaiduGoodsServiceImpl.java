package com.linjia.web.thirdService.baidu.service.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.linjia.tools.NetRequest;
import com.linjia.web.thirdService.baidu.factory.BdURLFactory;
import com.linjia.web.thirdService.baidu.model.Goods;
import com.linjia.web.thirdService.baidu.service.BaiduGoodsService;
import com.linjia.web.thirdService.baidu.vo.GoodsParamAdapter;

@Service
public class BaiduGoodsServiceImpl implements BaiduGoodsService{

	private GoodsParamAdapter param=new GoodsParamAdapter();
	private String reqUrl=BdURLFactory.genUrlPrefix();
	
	@Override
	public JSONObject skuCreate(Goods goods, String Authorization) {
		JSONObject respJson=param.skuCreate(goods);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
		
	@Override
	public JSONObject skuUpdate(Goods goods, String Authorization) {
		JSONObject respJson=param.skuUpdate(goods);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject skuList(String Authorization) {
		JSONObject respJson=param.skuList();
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	@Override
	public JSONObject skuOnline(String shop_id, String sku_id,String Authorization) {
		JSONObject respJson=param.skuOnline(shop_id,sku_id);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject skuOffline(String shop_id, String sku_id,String Authorization) {
		JSONObject respJson=param.skuOffline(shop_id,sku_id);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject skuStockUpdateMatch(String shop_id, String skuid_stocks,
			String Authorization) {
		JSONObject respJson=param.skuStockUpdateMatch(shop_id,skuid_stocks);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject skuPriceUpdateBatch(String shop_id, String skuid_price,
			String Authorization) {
		JSONObject respJson=param.skuPriceUpdateBatch(shop_id,skuid_price);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
}
