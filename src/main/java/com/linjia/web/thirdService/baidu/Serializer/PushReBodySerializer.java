package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.PushReBody;

public class PushReBodySerializer implements JsonSerializer<PushReBody>{
	
	@Override
    public JsonElement serialize(PushReBody pushReBody, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("data", context.serialize(pushReBody.getData()));
        object.add("errno", context.serialize(pushReBody.getErrno()));
        object.add("error", context.serialize(pushReBody.getError()));
        return object;
    }
	
//	public static void main(String[] args) {
//	SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//	prePayParams.put("data", "");
//    prePayParams.put("errno","");
//    prePayParams.put("error",""); 
//        for(Entry<String, String> p : prePayParams.entrySet()){
//           System.out.println(p.getKey());
//        }
//	}
}
