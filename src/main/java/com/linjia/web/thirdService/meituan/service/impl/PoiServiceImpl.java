package com.linjia.web.thirdService.meituan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linjia.web.thirdService.meituan.constants.MtConfig;
import com.linjia.web.thirdService.meituan.constants.PoiQualificationEnum;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.factory.APIFactory;
import com.linjia.web.thirdService.meituan.service.PoiService;
import com.linjia.web.thirdService.meituan.vo.PoiParam;
import com.linjia.web.thirdService.meituan.vo.PoiTagParam;

/**
 * 门店操作类
 * @author xiangshouyi 
 *
 */
@Service
public class PoiServiceImpl implements PoiService {

	@Override
	public JSONObject poiSave(PoiParam poiParam) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiSave(MtConfig.getSyspram(),poiParam);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiGetIds() {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiGetIds(MtConfig.getSyspram());
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public List<PoiParam> poiMget(String appPoiCodes) {
		List<PoiParam> ppList=null;
		 try {
			  ppList=APIFactory.getPoiAPI().poiMget(MtConfig.getSyspram(),appPoiCodes);
	         System.out.println(ppList);
	        } catch (ApiOpException e) {
	            e.printStackTrace();
	        } catch (ApiSysException e) {
	            e.printStackTrace();
	        }
	        return ppList;
	}
	
	@Override
	public JSONObject poiOpen(String appPoiCode) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getPoiAPI().poiOpen(MtConfig.getSyspram(),appPoiCode);
        	result.put("status", json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
            result.put("status", "fail");
        }
        return result;
	}
	@Override
	public JSONObject poiClose(String appPoiCode) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiClose(MtConfig.getSyspram(),appPoiCode);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiOnline(String appPoiCode) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiOnline(MtConfig.getSyspram(),appPoiCode);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiOffline(String appPoiCode,
			String reason) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiOffline(MtConfig.getSyspram(),appPoiCode,reason);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiQualifySave(String appPoiCode, PoiQualificationEnum poiQualificationEnum,
			String qualificationUrl, String validDate, String address,
			String number) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiQualifySave(MtConfig.getSyspram(),appPoiCode,poiQualificationEnum,
        			qualificationUrl,validDate,address,number);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiSendTimeSave(String appPoiCodes, int sendTime) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiSendTimeSave(MtConfig.getSyspram(),appPoiCodes,sendTime);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiAdditionalSave(String appPoiCode, String appPoiEmail, String appBrandCode,
			String appOrgId) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiAdditionalSave(MtConfig.getSyspram(),appPoiCode,appPoiEmail,appBrandCode,
        			appOrgId);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public JSONObject poiUpdatePromotionInfo(String appPoiCode, String promotionInfo) {
		JSONObject result=null;
        try {
        	String json=APIFactory.getPoiAPI().poiUpdatePromotionInfo(MtConfig.getSyspram(),appPoiCode,promotionInfo);
            result=JSON.parseObject(json);
        } catch (ApiOpException e) {
            e.printStackTrace();
        } catch (ApiSysException e) {
            e.printStackTrace();
        }
        return result;
	}
	@Override
	public List<PoiTagParam> poiTagList() {
		List<PoiTagParam> ptpList=null;
		 try {
			 ptpList=APIFactory.getPoiAPI().poiTagList(MtConfig.getSyspram());
	         System.out.println(ptpList);
	        } catch (ApiOpException e) {
	            e.printStackTrace();
	        } catch (ApiSysException e) {
	            e.printStackTrace();
	        }
	        return ptpList;
	}

//	public static void main(String[] args) {
//		PoiServiceImpl impl=new PoiServiceImpl();
//	}
}
