package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.BaiduData;

public class BaiduDataSerializer implements JsonSerializer<BaiduData>{
	
	@Override
    public JsonElement serialize(BaiduData bdData, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("discount", context.serialize(bdData.getDiscount()));
        object.add("order", context.serialize(bdData.getOrder()));
        object.add("products", context.serialize(bdData.getProducts()));
        object.add("shop", context.serialize(bdData.getShop()));
        object.add("user", context.serialize(bdData.getUser()));
        return object;
    }
	
//	public static void main(String[] args) {
//	SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//	prePayParams.put("discount", "");
//    prePayParams.put("order","");
//    prePayParams.put("products","");
//    prePayParams.put("shop","");
//    prePayParams.put("user","");
//    
//        for(Entry<String, String> p : prePayParams.entrySet()){
//           System.out.println(p.getKey());
//        }
//	}
}
