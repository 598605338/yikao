package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.Page;

public class PageSerializer implements JsonSerializer<Page>{
	@Override
    public JsonElement serialize(Page page, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("end_time", context.serialize(page.getEnd_time()));
        object.add("page", context.serialize(page.getPage()));
        object.add("start_time", context.serialize(page.getStart_time()));
        object.add("status", context.serialize(page.getStatus()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("end_time", "");
//        prePayParams.put("page", "");
//        prePayParams.put("start_time", "");
//        prePayParams.put("status","");
//	   for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//		}
}
