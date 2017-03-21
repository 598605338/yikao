package com.linjia.web.thirdService.meituan.service.impl;

import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.linjia.web.thirdService.meituan.constants.MtConfig;
import com.linjia.web.thirdService.meituan.exception.ApiOpException;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.factory.APIFactory;
import com.linjia.web.thirdService.meituan.service.OrderService;
import com.linjia.web.thirdService.meituan.vo.LogisticsParam;
import com.linjia.web.thirdService.meituan.vo.OrderDetailParam;
import com.linjia.web.thirdService.meituan.vo.OrderSubsidyParam;
import com.linjia.web.thirdService.meituan.vo.PoiPolicyParam;

/**
 * 订单操作服务类
 * @author xiangshouyi
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	
	//商家订单确认 必接
	@Override
	public JSONObject orderConfirm(Long orderId) {
		JSONObject json=new JSONObject();
        try {
        	String result=APIFactory.getOrderAPI().orderConfirm(MtConfig.getSyspram(),orderId);
        	json.put("data", result);
        } catch (ApiOpException e) {
        	json.put("msg", e.getMsg());
        	json.put("data", "fail");
        	return json;
        } catch (ApiSysException e) {
        	json.put("data", "fail");
        	json.put("msg", e.getMessage());
        	return json;
        }
        return json;
	}
	
	//商家订单取消 必接
	@Override
	public JSONObject orderCancel(Long orderId,
			String reason, String reasonCode) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderCancel(MtConfig.getSyspram(),orderId, reason, reasonCode);
            result.put("data", json);
        } catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	
	//商家订单配送中 必接
	@Override
	public JSONObject orderDelivering(Long orderId,String courierName, String courierPhone) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderDelivering(MtConfig.getSyspram(),orderId, courierName,courierPhone);
        	 result.put("data", json);
        } catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	
	//商家订单已送达
	@Override
	public JSONObject orderArrived(Long orderId) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderArrived(MtConfig.getSyspram(),orderId);
        	 result.put("data", json);
        } catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	@Override
	public JSONObject orderReceived(Long orderId) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderArrived(MtConfig.getSyspram(),orderId);
        	 result.put("data", json);
        }catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	
	@Override
	public JSONObject orderRefundAgree(Long orderId,String reason) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderRefundAgree(MtConfig.getSyspram(),orderId,reason);
        	 result.put("data", json);
        } catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	@Override
	public JSONObject orderRefundReject(Long orderId,String reason) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderRefundReject(MtConfig.getSyspram(),orderId,reason);
        	 result.put("data", json);
        } catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	@Override
	public OrderSubsidyParam orderSubsidy(Long orderId) {
		OrderSubsidyParam osp=null;
        try {
        	 osp=APIFactory.getOrderAPI().orderSubsidy(MtConfig.getSyspram(),orderId);
        } catch (ApiOpException e) {
            e.printStackTrace();
            return osp;
        } catch (ApiSysException e) {
            e.printStackTrace();
            return osp;
        }
        return osp;
	}
	@Override
	public Integer orderViewStatus(Long orderId) {
		Integer result=null;
        try {
        	result=APIFactory.getOrderAPI().orderViewStatus(MtConfig.getSyspram(),orderId);
        } catch (ApiOpException e) {
            e.printStackTrace();
            return result;
        } catch (ApiSysException e) {
            e.printStackTrace();
            return result;
        }
        return result;
	}
	@Override
	public PoiPolicyParam orderGetActDetailByAcId(int actDetailId) {
		PoiPolicyParam ppp=null;
        try {
        	ppp=APIFactory.getOrderAPI().orderGetActDetailByAcId(MtConfig.getSyspram(),actDetailId);
        } catch (ApiOpException e) {
            e.printStackTrace();
            return ppp;
        } catch (ApiSysException e) {
            e.printStackTrace();
            return ppp;
        }
        return ppp;
	}
	@Override
	public OrderDetailParam orderGetOrderDetail(long orderId, long isMtLogistics) {
		OrderDetailParam odp=null;
        try {
        	odp=APIFactory.getOrderAPI().orderGetOrderDetail(MtConfig.getSyspram(),orderId,isMtLogistics);
        } catch (ApiOpException e) {
            e.printStackTrace();
            return odp;
        } catch (ApiSysException e) {
            e.printStackTrace();
            return odp;
        }
        return odp;
	}
	@Override
	public JSONObject orderLogisticsPush(long orderId) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderLogisticsPush(MtConfig.getSyspram(),orderId);
        	result.put("data", json);
        } catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	@Override
	public JSONObject orderLogisticsCancel(long orderId) {
		JSONObject result=new JSONObject();
        try {
        	String json=APIFactory.getOrderAPI().orderLogisticsCancel(MtConfig.getSyspram(),orderId);
        	result.put("data", json);
        }catch (ApiOpException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMsg());
        	return result;
        } catch (ApiSysException e) {
        	result.put("data", "fail");
        	result.put("msg", e.getMessage());
        	return result;
        }
        return result;
	}
	@Override
	public LogisticsParam orderLogisticsStatus(long orderId) {
		LogisticsParam ltp=null;
        try {
        	ltp=APIFactory.getOrderAPI().orderLogisticsStatus(MtConfig.getSyspram(),orderId);
        } catch (ApiOpException e) {
        	ltp=new LogisticsParam();
        	ltp.setResult(e.getMsg());
        	e.printStackTrace();
        	return ltp;
        } catch (ApiSysException e) {
        	ltp=new LogisticsParam();
        	ltp.setResult(e.getMessage());
            e.printStackTrace();
            return ltp;
        }
        return ltp;
	}

}

