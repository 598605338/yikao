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

public class CategorySerializer implements JsonSerializer<Category>{
	
	@Override
    public JsonElement serialize(Category category, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("category1", context.serialize(category.getCategory1()));
        object.add("category2", context.serialize(category.getCategory2()));
        object.add("category3", context.serialize(category.getCategory3()));
        return object;
    }
	
//	public static void main(String[] args) {
//	SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//	prePayParams.put("category1", "");
//    prePayParams.put("category2","");
//    prePayParams.put("category3","");
//    
//        for(Entry<String, String> p : prePayParams.entrySet()){
//           System.out.println(p.getKey());
//        }
//	}
}
