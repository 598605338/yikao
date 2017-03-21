package com.linjia.web.thirdService.baidu.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.tools.JSONUtil;
import com.linjia.tools.NetRequest;
import com.linjia.web.dao.BaiduLogsticsMapper;
import com.linjia.web.dao.BdOrderProductMapper;
import com.linjia.web.query.ThirdLogisOrderQuery;
import com.linjia.web.thirdService.baidu.factory.BdURLFactory;
import com.linjia.web.thirdService.baidu.model.BaiduData;
import com.linjia.web.thirdService.baidu.model.BaiduReOrder;
import com.linjia.web.thirdService.baidu.model.Order;
import com.linjia.web.thirdService.baidu.model.Page;
import com.linjia.web.thirdService.baidu.model.Product;
import com.linjia.web.thirdService.baidu.model.PushReBody;
import com.linjia.web.thirdService.baidu.model.PushReData;
import com.linjia.web.thirdService.baidu.service.BaiduOrderService;
import com.linjia.web.thirdService.baidu.vo.OrderParamAdapter;

@Service
@Transactional
public class BaiduOrderServiceImpl implements BaiduOrderService{

	@Autowired
	private BaiduLogsticsMapper mapper;
	
	@Autowired
	private BdOrderProductMapper proMapper;
	
	private OrderParamAdapter param=new OrderParamAdapter();
	private String reqUrl=BdURLFactory.genUrlPrefix();
	
	//确认订单  必须接入百度
	@Override
	public JSONObject orderConfirm(Long order_Id,String Authorization) {
		//准备body数据
		String orderId=String.valueOf(order_Id);
		JSONObject respJson=param.orderConfirm(orderId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	//取消订单  必须接入百度
	@Override
	public JSONObject orderCancel(Long order_id, int type, String reason,String Authorization) {
		String orderId=String.valueOf(order_id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.orderCancel(orderId,reason,type);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	//完成订单  必须接入百度
	@Override
	public JSONObject orderComplete(Long order_id,String Authorization) {
		String orderId=String.valueOf(order_id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.orderComplete(orderId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	//创建订单，必须提供给百度
	public JSONObject createOrder(BaiduData bdData,String Authorization) {
		JSONObject respJson=null;
		try{
			//测试使用
			bdData.getOrder().setStatus(1);
			bdData.getOrder().setPay_status(2);
			
			Integer ordernum=mapper.insertBdOrder(bdData);
			Long orderId=Long.parseLong(bdData.getOrder().getOrder_id());
			int innum=0;
			if(ordernum>0){
				List<Product> products=bdData.getProducts();
				if(products!=null){
					for (Product product : products) {
						product.setOrderId(orderId);
						int pronum=proMapper.insertBdOrderProduct(product);
						if(pronum>0){
							innum++;
						}
					}
				}
			}
			PushReData prd=new PushReData();
			prd.setSource_order_id(bdData.getId()+"");
			PushReBody prb=new PushReBody(0,"success",prd);
			respJson=param.createOrder(prb);
		}catch(Exception e){
			e.printStackTrace();
			respJson=new JSONObject();
			respJson.put("status", "fail");
		}
		return respJson;
	}
	
	@Override
	public JSONObject getOrderDetail(Long order_Id,String Authorization) {
		String orderId=String.valueOf(order_Id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.getOrderDetail(orderId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}
	
	@Override
	public JSONObject getOrderList(int start_time, int end_time, String status,
			int page,String Authorization) {
		//准备body数据
		Page pageObj = new Page();
		pageObj.setStart_time(start_time);
		pageObj.setEnd_time(end_time);
		pageObj.setStatus(status);
		pageObj.setPage(page);
		JSONObject respJson=param.getOrderList(start_time, end_time, status, page);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject orderGetScan(Long order_id,String Authorization) {
		String orderId=String.valueOf(order_id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.orderGetScan(orderId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject orderLock(Long order_id,String Authorization) {
		String orderId=String.valueOf(order_id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.orderLock(orderId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject orderRefund(Long order_Id,String Authorization) {
		String orderId=String.valueOf(order_Id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.orderRefund(orderId);
		JSONObject reslut=NetRequest.requestPost(reqUrl, respJson, Authorization);
		return reslut;
	}

	@Override
	public JSONObject orderStatusPush(Long order_Id, int status,String Authorization) {
		String orderId=String.valueOf(order_Id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		order.setStatus(status);
		JSONObject respJson=param.orderStatusPush(orderId, status);
		try{
			Integer sourceOrder=mapper.updateBdOrderStatus(order);
			
			JSONObject json=new JSONObject();
			json.put("errno", 0);
			json.put("error","success");
			respJson.put("body", json);
		}catch(Exception e){
			e.printStackTrace();
			respJson.put("status", "fail");
		}
		return respJson;
	}
	
	@Override
	public JSONObject orderStatusQuery(Long order_Id,String Authorization) {
		String orderId=String.valueOf(order_Id);
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		JSONObject respJson=param.orderStatusQuery(orderId);
		try{
			Order reOrder=mapper.selectBdOrderStatus(orderId);
			JSONObject json=new JSONObject();
			JSONObject data=new JSONObject();
			data.put("source_order_id",reOrder.getOrder_id());
			data.put("status",reOrder.getStatus());
			json.put("errno", 0);
			json.put("error","success");
			json.put("data",data);
			respJson.put("body", json);
		}catch(Exception e){
			e.printStackTrace();
			respJson.put("status", "fail");
		}
		return respJson;
	}
	
	@Override
	public JSONObject insertBdOrder(BaiduData bd) {
		JSONObject respJson=new JSONObject();
		try{
			Integer sourceOrder=mapper.insertBdOrder(bd);
			String source_order_id=sourceOrder+"";
			JSONObject json=new JSONObject();
			JSONObject data=new JSONObject();
			data.put("source_order_id",source_order_id);
			json.put("errno", 0);
			json.put("error","success");
			json.put("data",data);
			respJson.put("body", json);
		}catch(Exception e){
			e.printStackTrace();
			respJson.put("status", "fail");
		}
		return respJson;
	}

	@Override
	public JSONObject updateBdOrder(BaiduData bd) {
		JSONObject json=new JSONObject();
		try{
			boolean flag=mapper.updateBdOrder(bd);
			if(flag){
				json.put("status", "ok");
				json.put("message", "更新成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", "fail");
			json.put("message", "更新失败");
		}
		return json;
	}

	@Override
	public JSONObject deleteBdOrder(Long order_Id) {
		String orderId=String.valueOf(order_Id);
		JSONObject json=new JSONObject();
		try{
			boolean flag=mapper.deleteBdOrder(orderId);
			if(flag){
				json.put("status", "ok");
				json.put("message", "删除成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", "fail");
			json.put("message", "删除失败");
		}
		return json;
	}

	@Override
	public JSONObject selectBdOrder(Long order_Id,String shopId) {
		JSONObject json=null;
		try{
			ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
			query.setShop_id(shopId);
			query.setOrder_id(order_Id);
			BaiduReOrder bd=mapper.selectBdOrder(query);
			if(bd!=null){
				json=JSONUtil.ObjToJSON(bd);
				String products=bd.getProductList();
				String discount=bd.getDiscountList();
				if(!"".equals(products)){
					json.put("products", new JSONArray(products));
				}else{
					json.put("products", new JSONArray());
				}
				if(!"".equals(discount)){
					json.put("discount", new JSONArray(discount));
				}else{
					json.put("discount", new JSONArray());
				}
			}else{
				json=new JSONObject();
			}
		}catch(Exception e){
			e.printStackTrace();
			json=new JSONObject();
			json.put("status", "fail");
		}
		return json;
	}
	
	public String selectBdOrderlist(String shopId) {
		JSONArray jarray=new JSONArray();
		try{
			ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
			query.setShop_id(shopId);
				List<BaiduReOrder> mt=mapper.selectBdOrderlist(query);
			if(mt!=null){
				for (int i = 0; i < mt.size(); i++) {
					BaiduReOrder br=mt.get(i);
					JSONObject json=JSONUtil.ObjToJSON(br);
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

	@Override
	public BaiduReOrder selectBdOrderAll(Long orderId, String shopId) {
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setShop_id(shopId);
		query.setOrder_id(orderId);
		BaiduReOrder bd=mapper.selectBdOrder(query);
		return bd;
	}

	@Override
	public BaiduReOrder selectPdOrder(Long order_id) {
		return mapper.selectPdOrder(order_id);
	}

}
