package com.linjia.web.thirdService.baidu.service;


import org.json.JSONObject;

import com.linjia.web.thirdService.baidu.model.Goods;

public interface BaiduGoodsService{
	
	/**
	 * 商品上传
	 * @param goods
	 * @return
	 */
	public JSONObject skuCreate(Goods goods,String Authorization);
	
	/**
	 * 商品修改
	 * @param goods
	 * @return
	 */
	public JSONObject skuUpdate(Goods goods,String Authorization);
	
	/**
	 * 商品列表
	 * @return
	 */
	public JSONObject skuList(String Authorization);
	
	/**
	 * 商品上线
	 * @param shop_id
	 * @param sku_id
	 * @return
	 */
	public JSONObject skuOnline(String shop_id,String sku_id,String Authorization);
	
	/**
	 * 商品下线
	 * @param shop_id
	 * @param sku_id
	 * @return
	 */
	public JSONObject skuOffline(String shop_id,String sku_id,String Authorization);
		
	/**
	 * 批量修改商品库存
	 * @param shop_id
	 * @param skuid_stocks
	 * @return
	 */
	public JSONObject skuStockUpdateMatch(String shop_id,String skuid_stocks,String Authorization);
		
	/**
	 * 批量修改商品价格
	 * @param shop_id
	 * @param skuid_price
	 * @return
	 */
	public JSONObject skuPriceUpdateBatch(String shop_id,String skuid_price,String Authorization);
	
	
}
