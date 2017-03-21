package com.linjia.web.thirdService.eleme.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CancelReasonConfig {
	
	private static List<Map<String,Object>> elemeOrderCancelList;
	private static Map<Integer,String> elemeOrderCancelInfo;
	
	 static {
		 elemeOrderCancelList = new ArrayList<Map<String,Object>>();
		 elemeOrderCancelInfo=new HashMap<Integer,String>();

		 Map<String,Object> map1=new HashMap<String, Object>();
		 map1.put("id",1);
		 map1.put("info","用户信息不符");
		 
		 Map<String,Object> map2=new HashMap<String, Object>();
		 map2.put("id",4);
		 map2.put("info","联系不上用户");
		 
		 Map<String,Object> map3=new HashMap<String, Object>();
		 map3.put("id",5);
		 map3.put("info","商品已经售完");
		 
		 Map<String,Object> map4=new HashMap<String, Object>();
		 map4.put("id",6);
		 map4.put("info","商家已经打烊");
		 
		 Map<String,Object> map5=new HashMap<String, Object>();
		 map5.put("id",7);
		 map5.put("info","超出配送范围");
		 
		 Map<String,Object> map6=new HashMap<String, Object>();
		 map6.put("id",8);
		 map6.put("info","商家现在太忙");
		 
		 Map<String,Object> map7=new HashMap<String, Object>();
		 map7.put("id",9);
		 map7.put("info","用户申请取消");
		 
		 Map<String,Object> map8=new HashMap<String, Object>();
		 map8.put("id",11);
		 map8.put("info","配送出现问题");
		 
		 Map<String,Object> map9=new HashMap<String, Object>();
		 map9.put("id",17);
		 map9.put("info","不满足起送要求");
		 
		 Map<String,Object> map10=new HashMap<String, Object>();
		 map10.put("id",99);
		 map10.put("info","其他原因");
		 
		 elemeOrderCancelList.add(map1);
		 elemeOrderCancelList.add(map2);
		 elemeOrderCancelList.add(map3);
		 elemeOrderCancelList.add(map4);
		 elemeOrderCancelList.add(map5);
		 elemeOrderCancelList.add(map6);
		 elemeOrderCancelList.add(map7);
		 elemeOrderCancelList.add(map8);
		 elemeOrderCancelList.add(map9);
		 elemeOrderCancelList.add(map10);
		 
		 elemeOrderCancelInfo.put(1,"others");
		 elemeOrderCancelInfo.put(2,"fakeOrder");
		 elemeOrderCancelInfo.put(3,"contactUserFailed");
		 elemeOrderCancelInfo.put(4,"foodSoldOut");
		 elemeOrderCancelInfo.put(5,"restaurantClosed");
		 elemeOrderCancelInfo.put(6,"distanceTooFar");
		 elemeOrderCancelInfo.put(7,"restaurantTooBusy");
		 elemeOrderCancelInfo.put(8,"forceRejectOrder");
		 elemeOrderCancelInfo.put(9,"deliveryFault");
		 elemeOrderCancelInfo.put(10,"notSatisfiedDeliveryRequirement");
	 }

	 /**
	   * 饿了么取消原因map
	  */
	 public static List<Map<String,Object>> getElemeCancelReason(){
	    return elemeOrderCancelList;
	 }
	 
	 /**
	   * 饿了么取消原因map
	  */
	 public static String getElemeCancelReasonInfo(int reasonId){
	    return elemeOrderCancelInfo.get(reasonId);
	 }
	 
}
