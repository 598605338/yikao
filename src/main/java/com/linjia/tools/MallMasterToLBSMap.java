package com.linjia.tools;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.linjia.constants.Application;
import com.linjia.web.model.LBSBDMap;
import com.linjia.web.model.MallMaster;

public class MallMasterToLBSMap {

	/**
	 * mallmaster转LBS提交数据模型
	 */
	public static LBSBDMap mallMasterToLBS(MallMaster mallMaster) {
		LBSBDMap lbs=new LBSBDMap();
		lbs.setMallName(mallMaster.getMallName());
		lbs.setTitle(mallMaster.getMallName());
		lbs.setMallCode(mallMaster.getMallCode());
		lbs.setPhone(mallMaster.getPhone());
		lbs.setBusiness_start_time(mallMaster.getGetbyselfBegintimeStr());
		lbs.setBusiness_end_time(mallMaster.getGetbyselfEndhourStr());
		Integer IsSupportSelfDeliver=mallMaster.getIsSupportSelfDeliver();
		if(IsSupportSelfDeliver==null){
			IsSupportSelfDeliver=0;
		}
		lbs.setIs_support_self_deliver(IsSupportSelfDeliver+"");
		String Shop_label=mallMaster.getShop_label();
		Integer slabel=0;
		if(Shop_label==null||Shop_label.isEmpty()){
			slabel=0;
		}else{
			slabel=Integer.valueOf(Shop_label);
		}
		lbs.setIs_send(slabel+"");
		Integer IsSupportThirdDeliver=mallMaster.getIsSupportThirdDeliver();
		if(IsSupportThirdDeliver==null){
			IsSupportThirdDeliver=0;
		}
		lbs.setIs_support_third_deliver(IsSupportThirdDeliver+"");
		BigDecimal sdit=mallMaster.getSendDistance();
		String SendDistance=null;
		if(mallMaster.getSendDistance()==null){
			SendDistance=Application.LBS_SENDDISTANCE;
		}else{
			SendDistance=sdit.toString();
		}
		lbs.setSend_distance(SendDistance);
		lbs.setProvinceName(mallMaster.getProvinceName());
		lbs.setCountyName(mallMaster.getCountyName());
		lbs.setLatitude(mallMaster.getLatitude().toString());
		lbs.setLongitude(mallMaster.getLongitude().toString());
		lbs.setCoord_type(Application.LBS_COORD_TYPE);
		lbs.setSend_limit_money(Application.SEND_LIMIT_MONEY);
		lbs.setUseFlg(Application.LBS_MALL_STOP+"");
		lbs.setAk(Application.AK);
		lbs.setGeotable_id(Application.GEOTABLE_ID);
		
		return lbs;
	}
	 
	public static Map<String, String> mallMasterToMap(MallMaster mallMaster) {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("mallName",mallMaster.getMallName());
		 map.put("title",mallMaster.getMallName());
		 map.put("mallCode",mallMaster.getMallCode());
		 map.put("phone",mallMaster.getPhone());
		 map.put("business_start_time",mallMaster.getGetbyselfBegintimeStr());
		 map.put("business_end_time",mallMaster.getGetbyselfEndhourStr());
		 map.put("send_start_time",mallMaster.getSendBegintimeStr());
		 map.put("send_end_time",mallMaster.getSendEndhourStr());
		 Integer IsSupportSelfDeliver=mallMaster.getIsSupportSelfDeliver();
		 if(IsSupportSelfDeliver==null){
			IsSupportSelfDeliver=0;
		 }
		 map.put("is_support_self_deliver",IsSupportSelfDeliver+"");
		 String Shop_label=mallMaster.getShop_label();
		 Integer slabel=0;
		 if(Shop_label==null||Shop_label.isEmpty()){
			slabel=0;
		 }else{
			slabel=Integer.valueOf(Shop_label);
		 }
		 map.put("is_send",slabel+"");
		 Integer IsSupportThirdDeliver=mallMaster.getIsSupportThirdDeliver();
		 if(IsSupportThirdDeliver==null){
			IsSupportThirdDeliver=0;
		 }
		 map.put("is_support_third_deliver",IsSupportThirdDeliver+"");
		 BigDecimal sdit=mallMaster.getSendDistance();
		 String SendDistance=null;
		 if(mallMaster.getSendDistance()==null){
			SendDistance=Application.LBS_SENDDISTANCE;
		 }else{
			SendDistance=sdit.toString();
		 }
		 map.put("send_distance",SendDistance);
		 map.put("provinceName",mallMaster.getProvinceName());
		 map.put("countyName",mallMaster.getCountyName());
		 map.put("latitude",mallMaster.getLatitude().toString());
		 map.put("longitude",mallMaster.getLongitude().toString());
		 map.put("coord_type",Application.LBS_COORD_TYPE);
		 if(mallMaster.getSendLimitMoney()==null){
			 map.put("send_limit_money",Application.SEND_LIMIT_MONEY);
		 }else{
			 map.put("send_limit_money",mallMaster.getSendLimitMoney().setScale(2,BigDecimal.ROUND_HALF_UP).floatValue()+"");
		 }
		 if(mallMaster.getUseflg()==null){
			 map.put("useFlg",Application.LBS_MALL_STOP+"");
		 }else{
			 map.put("useFlg",mallMaster.getUseflg()+"");
		 }
		 map.put("ak",Application.AK);
		 map.put("geotable_id",Application.GEOTABLE_ID);
		 Long bd_map_key=mallMaster.getBd_map_key();
		 if(bd_map_key!=null&&bd_map_key>0){
			 map.put("id",bd_map_key+"");
		 }
		 return map;
	}
}
