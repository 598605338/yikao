package com.linjia.web.thirdService.meituan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.tools.JSONUtil;
import com.linjia.web.dao.MtLogsticsMapper;
import com.linjia.web.dao.MtOrderProductMapper;
import com.linjia.web.query.ThirdLogisOrderQuery;
import com.linjia.web.thirdService.meituan.model.MtOrder;
import com.linjia.web.thirdService.meituan.model.MtReOrder;
import com.linjia.web.thirdService.meituan.service.MtOrderService;
import com.linjia.web.thirdService.meituan.vo.OrderExtraParam;
import com.linjia.web.thirdService.meituan.vo.OrderFoodDetailParam;

@Service
@Transactional
public class MtOrderServiceImpl implements MtOrderService{

	@Resource
	private MtLogsticsMapper mapper;
	@Resource
	private MtOrderProductMapper promapper;
	
	@Override
	public JSONObject insertMtOrder(MtOrder mt) {
		JSONObject json=new JSONObject();
		int pronum=0;
		try{
			boolean flag=mapper.insertMtOrder(mt);
			if(flag){
				List<OrderExtraParam> extras=mt.getExtraList();
				List<OrderFoodDetailParam> products=mt.getDetailList();
				if(products!=null && products.size()>0){
					Long orderId=Long.valueOf(mt.getOrder_id());
					for (OrderFoodDetailParam orderFoodDetailParam : products) {
						orderFoodDetailParam.setOrderId(orderId);
						int num=promapper.insertMtOrderProduct(orderFoodDetailParam);
						if(num>0){
							pronum++;
						}
					}
				}
				if(extras!=null&&extras.size()>0){
					Long orderId=Long.valueOf(mt.getOrder_id());
					for (OrderExtraParam orderExtraParam : extras) {
						System.out.println(orderExtraParam.getAvg_send_time());
//						int num=promapper.insertMtOrderProduct(orderFoodDetailParam);
//						if(num>0){
//							pronum++;
//						}
					}
				}
			}
			if(flag){
				json.put("data", "ok");
				json.put("status", 3);
				json.put("msg", "ok");
			}else{
				json.put("data", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", "fail");
		}
		return json;
	}

	@Override
	public JSONObject updateOrderPayed(MtOrder mt) {
		JSONObject json=new JSONObject();
		try{
			boolean flag=mapper.updateOrderPayed(mt);
			if(flag){
				json.put("status", "ok");
			}else{
				json.put("data", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", "fail");
		}
		return json;
	}
	
	@Override
	public JSONObject updateOrderConfirmed(MtOrder mt) {
		JSONObject json=new JSONObject();
		try{
			boolean flag=mapper.updateOrderConfirmed(mt);
			if(flag){
				json.put("data", "ok");
			}else{
				json.put("data", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", "fail");
		}
		return json;
	}
	
	@Override
	public JSONObject updateOrderOver(MtOrder mt) {
		JSONObject json=new JSONObject();
		try{
			boolean flag=mapper.updateOrderOver(mt);
			if(flag){
				json.put("data", "ok");
			}else{
				json.put("data", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", "fail");
		}
		return json;
	}

	@Override
	public JSONObject deleteMtOrder(Long order_id) {
		JSONObject json=new JSONObject();
		String orderId=String.valueOf(order_id);
		try{
			boolean flag=mapper.deleteMtOrder(orderId);
			if(flag){
				json.put("data", "ok");
			}else{
				json.put("data", "fail");
			}
		}catch(Exception e){
			json.put("status", "fail");
		}
		return json;
	}

	@Override
	public JSONObject selectMtOrder(Long order_id,String App_poi_code) {
		JSONObject json=null;
		try{
			ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
			query.setOrder_id(order_id);
			query.setApp_poi_code(App_poi_code);
			MtReOrder mt=mapper.selectMtOrder(query);
			if(mt!=null){
				json=JSONUtil.ObjToJSON(mt);
				String detail=mt.getDetail();
				String extras=mt.getExtras();
				if(!"".equals(detail)){
					json.put("detail", new JSONArray(detail));
				}else{
					json.put("detail", new JSONArray());
				}
				if(!"".equals(extras)){
					json.put("extras", new JSONArray(extras));
					mt.setExtraList(null);
				}else{
					json.put("extras", new JSONArray());
				}
			}else{
				json=new org.json.JSONObject();
			}
		}catch(Exception e){
			e.printStackTrace();
			json=new org.json.JSONObject();
			json.put("status", "fail");
		}
		return json;
	}
	
	public String selectMtOrderlist(String app_poi_code) {
		JSONArray jarray=new JSONArray();
		try{
				ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
				query.setApp_poi_code(app_poi_code);
				List<MtReOrder> mt=mapper.selectMtOrderlist(query);
			if(mt!=null){
				for (int i = 0; i < mt.size(); i++) {
					MtReOrder mo=mt.get(i);
					JSONObject json=JSONUtil.ObjToJSON(mo);
					jarray.put(json);
				}
			}else{
				jarray=new JSONArray();
			}
		}catch(Exception e){
			e.printStackTrace();
			jarray=new JSONArray();
		}
		return jarray.toString();
	}
	
	public MtReOrder selectMtOrderAll(Long order_id) {
		MtReOrder mt=null;
		try{
			ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
			query.setOrder_id(order_id);
		    mt=mapper.selectMtOrder(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mt;
	}

	@Override
	public int updateMtOrder(MtOrder mt) {
		return mapper.updateMtOrder(mt);
	}
}
