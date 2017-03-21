package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.Photo;

public class PhotoSerializer implements JsonSerializer<Photo>{
	
	@Override
    public JsonElement serialize(Photo photo, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("is_master", context.serialize(photo.getIs_master()));
        object.add("url", context.serialize(photo.getUrl()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("url", "");
//        prePayParams.put("is_master", "");
//	   for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//		}
}
