package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.PushReData;

public class PushReDataSerializer implements JsonSerializer<PushReData>{
	
	@Override
    public JsonElement serialize(PushReData pushReData, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("source_order_id", context.serialize(pushReData.getSource_order_id()));
        return object;
    }
	
//	public static void main(String[] args) {
//	SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//	prePayParams.put("source_order_id", "");
//    
//        for(Entry<String, String> p : prePayParams.entrySet()){
//           System.out.println(p.getKey());
//        }
//	}
}
