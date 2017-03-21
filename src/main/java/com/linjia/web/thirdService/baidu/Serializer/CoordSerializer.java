package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.Coord;

public class CoordSerializer implements JsonSerializer<Coord>{
	
	@Override
    public JsonElement serialize(Coord coord, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        //注意：此处必须按照字母顺序依次加入元素
        object.add("latitude", context.serialize(coord.getLatitude()));
        object.add("longitude", context.serialize(coord.getLongitude()));
        return object;
    }
	
//	public static void main(String[] args) {
//	SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//	prePayParams.put("latitude", "");
//    prePayParams.put("longitude","");
//    
//        for(Entry<String, String> p : prePayParams.entrySet()){
//           System.out.println(p.getKey());
//        }
//	}
}
