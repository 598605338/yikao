package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.Discount;

public class DiscountSerializer implements JsonSerializer<Discount>{
	@Override
    public JsonElement serialize(Discount discount, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("acticity_id", context.serialize(discount.getActicity_id()));
        object.add("agent_rate", context.serialize(discount.getAgent_rate()));
        object.add("baidu_rate", context.serialize(discount.getBaidu_rate()));
        object.add("desc", context.serialize(discount.getDesc()));
        object.add("fee", context.serialize(discount.getFee()));
        object.add("logistics_rate", context.serialize(discount.getLogistics_rate()));
        object.add("rule_id", context.serialize(discount.getRule_id()));
    	object.add("shop_rate", context.serialize(discount.getShop_rate()));
    	object.add("type", context.serialize(discount.getType()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("acticity_id", "");
//        prePayParams.put("agent_rate","");
//        prePayParams.put("baidu_rate", "");
//        prePayParams.put("desc", "");
//        prePayParams.put("fee", "");
//        prePayParams.put("logistics_rate", "");
//        prePayParams.put("rule_id", "");
//        prePayParams.put("shop_rate","");
//        prePayParams.put("type", "");
//        
//	        for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//	}
}
