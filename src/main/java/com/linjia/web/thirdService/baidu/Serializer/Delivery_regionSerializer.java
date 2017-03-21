package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.BusinessTime;
import com.linjia.web.thirdService.baidu.model.Category;
import com.linjia.web.thirdService.baidu.model.Delivery_region;

public class Delivery_regionSerializer implements JsonSerializer<Delivery_region>{
	
	@Override
    public JsonElement serialize(Delivery_region delivery_region, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("delivery_fee", context.serialize(delivery_region.getDelivery_fee()));
        object.add("delivery_time", context.serialize(delivery_region.getDelivery_time()));
        object.add("name", context.serialize(delivery_region.getName()));
        object.add("region", context.serialize(delivery_region.getRegion()));
        return object;
    }
	
//	public static void main(String[] args) {
//	SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//	prePayParams.put("delivery_fee", "");
//    prePayParams.put("delivery_time","");
//    prePayParams.put("name","");
//    prePayParams.put("region","");
//    
//        for(Entry<String, String> p : prePayParams.entrySet()){
//           System.out.println(p.getKey());
//        }
//	}
}
