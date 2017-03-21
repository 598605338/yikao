package com.linjia.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

/** 
 * JSON工具类
 * @author  lixinling: 
 * @date 2016年8月8日 下午2:37:02 
 * @version 1.0 
*/
public class JSONUtil {
	private static Logger logger= LoggerFactory.getLogger(JSONUtil.class);
	private static ObjectMapper mapper = new ObjectMapper();
	static{
		mapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
	}
	/**
	 * 将JSON转化为实体POJO
	 * lixinling 
	 * 2016年8月8日 下午2:45:32
	 * @param jsonStr
	 * @param obj
	 * @return
	 */
	public static <T> Object JSONToObj(String jsonStr, Class<T> obj) {
		T t = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			t = objectMapper.readValue(jsonStr, obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 将实体POJO转化为JSON
	 * lixinling 
	 * 2016年8月8日 下午2:45:32
	 * @param jsonStr
	 * @param obj
	 * @return
	 */
	public static <T> JSONObject ObjToJSON(T obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONObject(jsonStr);
	}
	
	 public static <T> String toJson(T o){
	        if(o==null){
	            return null;
	        }
	        try{
	            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	            return mapper.writeValueAsString(o);
	        }catch(Exception e){
	            logger.error("toJson Error",e);
	            return null;
	        }
	    }

	    public static <T> T fromJson(String jsonstr,Class<T> clazz){
	        if(jsonstr==null){
	            return null;
	        }
	        try{
	            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	            return mapper.readValue(jsonstr, clazz);
	        }catch (Exception e){
	            logger.error("fromJson Error",e);
	            logger.error(jsonstr);
	            return null;
	        }
	    }

	    public static Map<String,String> jsonToMap(InputStream inputStream){
	        try{
	            return mapper.readValue(inputStream, Map.class);
	        }catch(Exception e){
	            logger.error("jsonToMap Error",e);
	            return null;
	        }
	    }

	    public static Map<String,Object> beanToMap(Object object){
	        try{
	            return mapper.readValue(JSONUtil.toJson(object), Map.class);
	        }catch(Exception e){
	            logger.error("beanToMap Error",e);
	            return null;
	        }
	    }
	    
	    public static <T> List<T> json2List(String json, Class<T> clazz) {
			List<Map<String, Object>> list;
			try {
				list = mapper.readValue(json, new TypeReference<List<T>>(){});
			} catch (IOException e) {
				throw new RuntimeException("解析json错误");
			}
			List<T> result = new ArrayList<T>();
			for (Map<String, Object> map : list) {
				result.add(map2pojo(map, clazz));
			}
			return result;
		}
	    
	    public static <T> T map2pojo(Map map, Class<T> clazz) {
			return mapper.convertValue(map, clazz);
		}

//	    public static void main(String[] args) {
//	        List<Integer> list=new ArrayList<Integer>();
//	        list.add(1321);
//	        list.add(312);
//	        list.add(3122);
//	        String listJson=JsonUtils.toJson(list);
//	        System.out.println(listJson);
//	        List<Integer> list1=JsonUtils.fromJson(listJson,List.class);
//	        for(Integer id:list1){
//	            System.out.println(id);
//	        }
//	        System.out.println(list1);
//	        System.out.println(JsonUtils.toJson(new Date()));
//	        Map<Integer,String> map=new HashMap<Integer,String>();
//	        map.put(1,"111");
//	        map.put(2,"222");
//	        System.out.println(JsonUtil.toJson(map));
//	        System.out.println(System.currentTimeMillis() + 1000000000);
//	    }
	    
}
