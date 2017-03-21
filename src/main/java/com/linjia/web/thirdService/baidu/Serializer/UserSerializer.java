package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.User;

public class UserSerializer implements JsonSerializer<User>{
	
	@Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("address", context.serialize(user.getReceive_address()));
        object.add("coord", context.serialize(user.getCoord()));
        object.add("gender", context.serialize(user.getGender()));
        object.add("id", context.serialize(user.getUser_id()));
        object.add("name", context.serialize(user.getReceive_name()));
        object.add("phone", context.serialize(user.getReceive_phone()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("address",  "");
//        prePayParams.put("coord",  "");
//        prePayParams.put("gender",  "");
//        prePayParams.put("id",  "");
//        prePayParams.put("name",  "");
//        prePayParams.put("phone",  "");
//	   for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//		}
}
