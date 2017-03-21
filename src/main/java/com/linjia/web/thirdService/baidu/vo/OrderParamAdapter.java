package com.linjia.web.thirdService.baidu.vo;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linjia.constants.Constants;
import com.linjia.web.thirdService.baidu.Serializer.CmdSerializer;
import com.linjia.web.thirdService.baidu.Serializer.OrderSerializer;
import com.linjia.web.thirdService.baidu.Serializer.PushReBodySerializer;
import com.linjia.web.thirdService.baidu.factory.BdURLFactory;
import com.linjia.web.thirdService.baidu.model.BaiduData;
import com.linjia.web.thirdService.baidu.model.Cmd;
import com.linjia.web.thirdService.baidu.model.Order;
import com.linjia.web.thirdService.baidu.model.Page;
import com.linjia.web.thirdService.baidu.model.PushReBody;
import com.linjia.web.thirdService.baidu.utils.BaiduUtil;

public class OrderParamAdapter {

	public JSONObject getOrderDetail(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
		.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderGet"),order,gson);
		return respJson;
	}
	
	public JSONObject orderConfirm(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderConfirm"),order,gson);
		return respJson;
	}

	public JSONObject orderCancel(String orderId,String reason,int type) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		order.setType(type);
		order.setReason(reason);
		order.setStatus(Constants.ORDER_GROUP_STATUS.BUSSINESS_CANCELE);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderCancel"),order,gson);
		return respJson;
	}

	public JSONObject orderComplete(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderComplete"),order,gson);
		return respJson;
	}

	public JSONObject orderStatusQuery(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderStatusGet"),order,gson);
		return respJson;
	}

	public JSONObject getOrderList(int start_time, int end_time, String status,int page) {
		//准备body数据
		Page pageObj = new Page();
		pageObj.setStart_time(start_time);
		pageObj.setEnd_time(end_time);
		pageObj.setStatus(status);
		pageObj.setPage(page);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderList"),pageObj,gson);
		return respJson;
	}

	public JSONObject orderGetScan(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderScancode"),order,gson);
		return respJson;
	}

	public JSONObject orderLock(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderLock"),order,gson);
		return respJson;
	}

	public JSONObject orderRefund(String orderId) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderRefund"),order,gson);
		return respJson;
	}

	public JSONObject orderStatusPush(String orderId, int status) {
		//准备body数据
		Order order = new Order();
		order.setOrder_id(orderId);
		order.setStatus(status);
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(Order.class, new OrderSerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderStatusPush"),order,gson);
		return respJson;
	}

	public JSONObject createOrder(PushReBody prb) {
		//准备body数据
		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
				.registerTypeAdapter(PushReBody.class, new PushReBodySerializer()).disableHtmlEscaping().create();
		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderCreate"),prb,gson);
//		JSONObject json=new JSONObject(respJson);
		return respJson;
	}
}
