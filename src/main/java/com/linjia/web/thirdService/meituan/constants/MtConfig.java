package com.linjia.web.thirdService.meituan.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linjia.web.thirdService.meituan.vo.SystemParam;

public class MtConfig {
	
    private final static SystemParam sysPram = new SystemParam("", "");
    
    private final static String appPoiCode = "";
    //店铺取消原因
	private static List<Map<String,Object>> mtCancelList;
	//美团返回取消原因 
	private static Map<String, String> appCancelMap;

	public static SystemParam getSyspram() {
		return sysPram;
	}

	public static String getApppoicode() {
		return appPoiCode;
	}
    
	static {
		mtCancelList = new ArrayList<Map<String,Object>>();
		appCancelMap = new HashMap<String, String>();
		
		//美团发送的取消原因列表
		appCancelMap.put("1001","系统取消，超时未确认");
		appCancelMap.put("1002","系统取消，在线支付订单30分钟未支付");
		appCancelMap.put("1101","用户取消，在线支付中取消");
		appCancelMap.put("1102","用户取消，商家确认前取消");
		appCancelMap.put("1103","用户取消，用户退款取消");
		appCancelMap.put("1201","客服取消，用户下错单");
		appCancelMap.put("1202","客服取消，用户测试");
		appCancelMap.put("1203","客服取消，重复订单");
		appCancelMap.put("1204","客服取消，其他原因");
		appCancelMap.put("1301","其他");

		//APP方发出、美团接收的取消原因列表
		Map<String,Object> map2001=new HashMap<String, Object>();
		map2001.put("id", 2001);
		map2001.put("info","商家超时接单");
		
		Map<String,Object> map2002=new HashMap<String, Object>();
		map2002.put("id", 2002);
		map2002.put("info","非顾客原因修改订单");
		
		Map<String,Object> map2003=new HashMap<String, Object>();
		map2003.put("id", 2003);
		map2003.put("info","非顾客原因取消订单");
		
		Map<String,Object> map2004=new HashMap<String, Object>();
		map2004.put("id", 2004);
		map2004.put("info","配送延迟");
		
		Map<String,Object> map2005=new HashMap<String, Object>();
		map2005.put("id", 2005);
		map2005.put("info","售后投诉");
		
		Map<String,Object> map2006=new HashMap<String, Object>();
		map2006.put("id", 2006);
		map2006.put("info","用户要求取消");
		
		Map<String,Object> map2007=new HashMap<String, Object>();
		map2007.put("id", 2007);
		map2007.put("info","其他原因取消");
		mtCancelList.add(map2001);
		mtCancelList.add(map2002);
		mtCancelList.add(map2003);
		mtCancelList.add(map2004);
		mtCancelList.add(map2005);
		mtCancelList.add(map2006);
		mtCancelList.add(map2007);
	}
	
	 /**
     * 美团返回取消原因map
     */
    public static List<Map<String,Object>> getMtCancelReason(){
    	return mtCancelList;
    }
    
    /**
     * 店铺取消原因map
     */
    public static Map<String, String> getShopCancelReason(){
    	return appCancelMap;
    }
}
