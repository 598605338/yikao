package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.Goods;

public class GoodsSerializer implements JsonSerializer<Goods>{
	
	@Override
    public JsonElement serialize(Goods goods, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("brand_id", context.serialize(goods.getBrand_id()));
        object.add("brand_name", context.serialize(goods.getBrand_name()));
        object.add("cat1_id", context.serialize(goods.getCat1_id()));
        object.add("cat2_id", context.serialize(goods.getCat2_id()));
        object.add("cat3_id", context.serialize(goods.getCat3_id()));
        object.add("desc", context.serialize(goods.getDesc()));
        object.add("left_num", context.serialize(goods.getLeft_num()));
        object.add("market_price", context.serialize(goods.getMarket_price()));
        object.add("name", context.serialize(goods.getName()));
        object.add("sale_price", context.serialize(goods.getSale_price()));
        object.add("shop_id", context.serialize(goods.getShop_id()));
        object.add("sku_id", context.serialize(goods.getSku_id()));
        object.add("skuid_price", context.serialize(goods.getSkuid_price()));
        object.add("skuid_stocks", context.serialize(goods.getSkuid_stocks()));
        object.add("status", context.serialize(goods.getStatus()));
        object.add("upc", context.serialize(goods.getUpc()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("brand_id", "");
//        prePayParams.put("brand_name","");
//        prePayParams.put("cat1_id", "");
//        prePayParams.put("cat2_id", "");
//        prePayParams.put("cat3_id", "");
//        prePayParams.put("desc", "");
//        prePayParams.put("left_num", "");
//        prePayParams.put("market_price","");
//        prePayParams.put("name", "");
//        prePayParams.put("sale_price", "");
//        prePayParams.put("shop_id", "");
//        prePayParams.put("skuid_price", "");
//        prePayParams.put("skuid_stocks","");
//        prePayParams.put("sku_id", "");
//        prePayParams.put("status", "");
//        prePayParams.put("upc","");
//		
//	        for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//	}
}
