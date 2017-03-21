package com.linjia.web.thirdService.baidu.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaiduConfig {
	
	    private static Map<String,String> accountMap;
	    
	    //百度取消订单原因
	    private static List<Map<String,Object>> bdCancelList;

	    static {
	    	accountMap = new HashMap<String, String>();
	    	bdCancelList = new ArrayList<Map<String,Object>>();
	        //合作方唯一标示，由百度外卖分配
	    	accountMap.put("SOURCE","");
	        // * 合作方密钥，由百度外卖分配
	    	accountMap.put("SECRET","");
	    	
			Map<String,Object> map1=new HashMap<String, Object>();
			map1.put("id", 1);
			map1.put("info","不在配送范围内");
			
			Map<String,Object> map2=new HashMap<String, Object>();
			map2.put("id", 2);
			map2.put("info","餐厅已打烊");
			
			Map<String,Object> map3=new HashMap<String, Object>();
			map3.put("id", 3);
			map3.put("info","美食已售完");
			
			Map<String,Object> map4=new HashMap<String, Object>();
			map4.put("id", 4);
			map4.put("info","菜品价格发生变化");
			
			Map<String,Object> map5=new HashMap<String, Object>();
			map5.put("id", 5);
			map5.put("info","用户取消订单");
			
			Map<String,Object> map6=new HashMap<String, Object>();
			map6.put("id", 6);
			map6.put("info","重复订单");
			
			Map<String,Object> map7=new HashMap<String, Object>();
			map7.put("id", 7);
			map7.put("info","餐厅太忙");
			
			Map<String,Object> map8=new HashMap<String, Object>();
			map8.put("id", 8);
			map8.put("info","联系不上用户");
			
			Map<String,Object> map9=new HashMap<String, Object>();
			map9.put("id", 9);
			map9.put("info","假订单");
			
	    	Map<String,Object> map10=new HashMap<String, Object>();
			map10.put("id", -1);
			map10.put("info","其他");
			
			bdCancelList.add(map1);
			bdCancelList.add(map2);
			bdCancelList.add(map3);
			bdCancelList.add(map4);
			bdCancelList.add(map5);
			bdCancelList.add(map6);
			bdCancelList.add(map7);
			bdCancelList.add(map8);
			bdCancelList.add(map9);
			bdCancelList.add(map10);
	    }
	
	    /**
	     * 获取source
	     * @param source
	     * @return
	     */
	    public static String getSource(){
	    	String source = accountMap.get("SOURCE");
	        return source;
	    }
	    
	    /**
	     * 获取secret
	     * @param secret
	     * @return
	     */
	    public static String getSecret(){
	        String secret = accountMap.get("SECRET");
	        return secret;
	    }
	    
	    /**
	     * 获取取消原因map
	     */
	    public static List<Map<String,Object>> getCancelReason(){
	    	return bdCancelList;
	    }
}
