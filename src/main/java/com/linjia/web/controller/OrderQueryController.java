package com.linjia.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjia.constants.Application;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.HttpRequestUtil;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.dao.OrderGroupMapper;
import com.linjia.web.model.ActivityPintuanBase;
import com.linjia.web.model.CustMaster;
import com.linjia.web.model.JddjDeliveryStatus;
import com.linjia.web.model.Logistics;
import com.linjia.web.model.LogistisDmInfo;
import com.linjia.web.model.OrderRefund;
import com.linjia.web.model.OrderRefundManage;
import com.linjia.web.model.OrderSerch;
import com.linjia.web.model.PinTuanOrder;
import com.linjia.web.model.ScoreOrder;
import com.linjia.web.model.ScoreOrderProduct;
import com.linjia.web.model.SecUser;
import com.linjia.web.model.ThirdOrder;
import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.poi.ExportExcel;
import com.linjia.web.query.LogisticsQuery;
import com.linjia.web.query.OrderRefundManageQuery;
import com.linjia.web.query.OrderSerchQuery;
import com.linjia.web.query.ThirdLogisOrderQuery;
import com.linjia.web.service.ActivityPintuanBaseService;
import com.linjia.web.service.ElemeOrderService;
import com.linjia.web.service.OrderQueryService;
import com.linjia.web.service.OrderRefundService;
import com.linjia.web.service.OrderidGenerateService;
import com.linjia.web.service.ThirdJDdjService;
import com.linjia.web.thirdService.baidu.service.BaiduOrderService;
import com.linjia.web.thirdService.meituan.service.OrderService;
import com.linjia.web.thirdService.meituan.vo.LogisticsParam;

/** 
 * @author  xiangsy: 
 * @date 2016年8月30日 下午4:16:39 
 * @version 1.0 
 */
@Controller
@RequestMapping("/orderQuery")
public class OrderQueryController {
	
	@Autowired
	private OrderQueryService  orderQueryService;
	@Autowired
	private ActivityPintuanBaseService activityPintuanBaseService;
	@Autowired
	private OrderRefundService orderRefundService;
	@Autowired
	private OrderidGenerateService orderidGenerateService;
	@Autowired
	private BaiduOrderService baiduOrderService; // 百度
	@Autowired
	private OrderService mtOrderService; // 美团
	@Autowired
	private ThirdJDdjService thirdJDdjService; // 京东
	@Resource
	private OrderGroupMapper orderGroupMapper;
	@Autowired
	private ElemeOrderService elemeOrderService;
	
	/**
	 * 总销售额统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/sumAllSales")
	public String sumAllSales(HttpServletRequest request,@RequestBody CustMaster model){
		OrderSerchQuery query=new OrderSerchQuery();
		List<OrderSerch> list=orderQueryService.selectSumAllSales(query);
		return "finace/sumAllSales";
	}
	
	/**
	 * 查询订单列表 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getOrderList", produces = "application/json;charset=UTF-8")
	public String getBaseInfo(HttpServletRequest request,ThirdLogisOrderQuery query) {
		try {
			Integer sdtype=query.getSend_type();
			Integer pstatus=query.getPay_status();
			Integer ostatus=query.getStatus();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curdate=sdf.format(new Date());
			String beginDate=query.getBeginDate();
			String endDate=query.getEndDate();  
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				query.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEnd_time(sdf.parse(endDate));
			}
			Integer send_type=null;
			if(query.getSend_type()!=null){
				send_type=query.getSend_type();
				if(send_type==0){
					query.setMtSend_type(0);
					query.setBdSend_type(1);
				}
				if(send_type==1){
					query.setMtSend_type(1);
					query.setBdSend_type(2);
				}
			}
			Integer pay_status=query.getPay_status();
			if(pay_status!=null){
				if(pay_status==1){
					query.setMtPatyStatus(2);
					query.setBdPatyStatus(2);
				}else{
					query.setMtPatyStatus(1);
					query.setBdPatyStatus(1);
				}
			}
			Integer status=query.getStatus();
			if(query.getStatus()!=null){
				switch (status) {
				case 0:
					query.setMtPatyStatus(1);
					query.setBdPatyStatus(1);
					query.setJdOrderStatus(31000);//31000:等待付款
					break;
				case 1:
					query.setMtPatyStatus(2);
					query.setBdPatyStatus(2);
					query.setJdOrderStatus(41000);//41000:待处理，
					break;
				case 2:
					query.setStatus(null);
					int[] orderStatusList1 = new int[] {2,10};
					query.setOrderStatusList(orderStatusList1);
					query.setMtOrderStatus(4);
					query.setBdOrderStatus(5);
					query.setJdOrderStatus(32000); //32000:等待出库
					query.setElemeOrderStatus(2);
					break;
				case 4:
					int[] BdOrderStatusList = new int[] {5,7,8};
					int[] MtOrderStatusList = new int[] {4,6};
					query.setMtOrderStatusList(MtOrderStatusList);
					query.setBdOrderStatusList(BdOrderStatusList);
					query.setJdOrderStatus(33040);//33040:配送中
					query.setElemeExcludeStatus(1);
					break;
				case 5:
					query.setMtOrderStatus(8);
					query.setBdOrderStatus(9);
					query.setJdOrderStatus(33060);//33060:已妥投
					query.setElemeOrderStatus(7);
					break;
				case 6:
					query.setStatus(null);
					int[] orderStatusList = new int[] {3,6,8,9};
					query.setOrderStatusList(orderStatusList);
					query.setMtOrderStatus(9);
					query.setBdOrderStatus(10);
					query.setJdOrderStatus(20020);//20020:订单取消
					query.setElemeOrderStatus(8);
					break;
				default:
					break;
				}
			}
			
			Integer querySource=query.getQuerySource();
			if(querySource!=null && querySource!=0 && querySource!=4){
				if(querySource==1){
					//查询商城订单
					query.setQueryLjSource(1);
				}else if(querySource==2){
					//美团订单
					query.setQueryMtSource(1);
				}else if(querySource==3){
					//查询百度订单
					query.setQueryBdSource(1);
				}else if(querySource==5){
					//查询京东订单
					query.setQueryJdSource(1);
				}else if(querySource==6){
					//查询饿了么订单
					query.setQueryElemeSource(1);
				}
			}else{
				//查询所有订单
				query.setQueryLjSource(1);
				query.setQueryMtSource(1);
				query.setQueryBdSource(1);
				query.setQueryJdSource(1);
				query.setQueryElemeSource(1);
				query.setIfAddUnion(1);
			}
				List<ThirdOrder> list = orderQueryService.selectOrderlist(query);
				if(list!=null){
					//查询商品总数
					int ll = orderQueryService.selectOrderNum(query);
					query.setTotalNums(ll);
				}
				
				query.setSend_type(sdtype);
				query.setPay_status(pstatus);
				query.setStatus(ostatus);
				request.setAttribute("query", query);
				request.setAttribute("orderlist", list);
				request.setAttribute("status", "ok");
		} catch (Exception e) {
			request.setAttribute("status", "fail");
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/order_list";
	}

	/**
	 * 获取订单详情
	 * @param request
	 * @param orderSource 订单来源(1:邻家；2美团；3，百度；4，京东到家)
	 * @param orderId
	 * @param shopId
	 * @return
	 */
	@RequestMapping("/orderDetail")
	public String orderDetail(HttpServletRequest request,@RequestParam String orderSource, @RequestParam Long orderId,@RequestParam String shopId) {
		List<ThirdOrderProduct> list = null;
		ThirdOrder thirdOrder = null;
		LogistisDmInfo logisticsInfo = new LogistisDmInfo();
		try {
			if ("1".equals(orderSource)) {
				thirdOrder = orderQueryService.selectMyOrder(shopId, orderId);
				if (thirdOrder != null) {
					if(thirdOrder.getSend_date()!=null){
						Long sdd=thirdOrder.getSend_date().getTime();
						String sdh=thirdOrder.getSend_hour();
						Long sendTimes = 0l;
						if(!Tools.isEmpty(sdh)){
							String[] sendHour = sdh.split(":");
							if(sendHour.length > 1){
								sendTimes=sdd+Long.valueOf(sendHour[0]) * 3600000 + Long.valueOf(sendHour[1]) * 60000;
							}else{
								sendTimes=sdd+Long.valueOf(sdh)*3600000;
							}
						}
						Date ds=DateComFunc.timestampToDate(sendTimes);
						thirdOrder.setCust_send_date(ds);
					}
					list = orderQueryService.selectMyOrderDetail(orderId);
					thirdOrder.setProducts(list);
					//查询物流信息
					LogisticsQuery query = new LogisticsQuery();
					query.setOrder_id(orderId);
					Logistics logis = orderQueryService.selectLogisticsById(query);
					if (logis != null) {
						logisticsInfo.setOrder_id(orderId + "");
						if (logis.getLogis_type() == 1) {
							logisticsInfo.setLogisticsName("自配送");
						} else if (logis.getLogis_type() == 2) {
							logisticsInfo.setLogisticsName("达达配送");
						} else if (logis.getLogis_type() == 3) {
							logisticsInfo.setLogisticsName("百度配送");
						}else if (logis.getLogis_type() == 4) {
							logisticsInfo.setLogisticsName("饿了么配送");
						}
						Integer orderStatus=logis.getOrder_status();
						if(orderStatus!=null){
							if (orderStatus< 2) {
								logisticsInfo.setStatusName("待接单");
							} else if (orderStatus == 2){
								logisticsInfo.setStatusName("物流已接单");
							} else if (orderStatus == 3) {
								logisticsInfo.setStatusName("物流派送中");
							} else if (orderStatus == 4) {
								logisticsInfo.setStatusName("物流已完成");
							}else if (orderStatus == 10) {
								logisticsInfo.setStatusName("物流取消");
							}
						}else{
							logisticsInfo.setStatusName("待接单");
						}
						logisticsInfo.setStatus(logis.getOrder_status());
						Long rtime=logis.getRecieve_time();
						Long stime=logis.getSend_time();
						Long ftime=logis.getFinish_time();
						if(rtime!=null){
							logisticsInfo.setRecive_date(DateComFunc.timestampToDate(rtime));
						}
						if(stime!=null){
							logisticsInfo.setSend_date(DateComFunc.timestampToDate(stime));
						}
						if(ftime!=null){
							logisticsInfo.setFinished_date(DateComFunc.timestampToDate(ftime));
						}
						logisticsInfo.setDmName(logis.getDm_name());
						logisticsInfo.setDmPhone(logis.getDm_mobile());	
					}
				}
			} else if ("2".equals(orderSource)) {
				thirdOrder = orderQueryService.selectMtOrder(shopId, orderId);
				if (thirdOrder != null) {
					list = orderQueryService.selectMtOrderProduct(orderId);
					thirdOrder.setProducts(list);
					//查询物流信息
					LogisticsParam lsg=mtOrderService.orderLogisticsStatus(orderId);
					if (lsg != null&&lsg.getOrder_id()!=null) {
							logisticsInfo.setOrder_id(orderId + "");
							Integer status = lsg.getLogistics_status();
								if (status != null) {
									if (status < 10) {
										logisticsInfo.setStatusName("待接单");
									} else if (status == 20) {
										logisticsInfo.setStatusName("已取餐");
									}else if (status == 40) {
										logisticsInfo.setStatusName("已完成");
									}else if (status == 100) {
										logisticsInfo.setStatusName("美团已取消配送");
									}
								}
								logisticsInfo.setStatus(6);
								logisticsInfo.setLogisticsName("美团配送");
								logisticsInfo.setRecive_time(lsg.getFetch_time()+"");
								logisticsInfo.setSend_time(lsg.getSend_time()+"");
								logisticsInfo.setDmName(lsg.getDispatcher_name());
								logisticsInfo.setDmPhone(lsg.getDispatcher_mobile());
						}
				}
			} else if ("3".equals(orderSource)) {
				thirdOrder = orderQueryService.selectBdOrder(shopId, orderId);
				if (thirdOrder != null) {
					list = orderQueryService.selectBdOrderProduct(orderId);
					thirdOrder.setProducts(list);
					//查询物流
					JSONObject json = (baiduOrderService.getOrderDetail(orderId, ""));
					JSONObject json1 = (baiduOrderService.orderStatusQuery(orderId, ""));
					JSONObject body = json.getJSONObject("body");
					JSONObject body1 = json1.getJSONObject("body");
					if (body.getInt("errno") == 0) {
						JSONObject orderObj = body.getJSONObject("data").getJSONObject("order");
						logisticsInfo.setOrder_id(orderId + "");
						String status = body1.getString("status");
						int ss = 0;
						if (status != null && status != "") {
							ss = Integer.valueOf(status);
							if (ss < 7) {
								logisticsInfo.setStatusName("待接单");
							} else if (ss == 7) {
								logisticsInfo.setStatusName("已取餐");
							} else if (ss == 8) {
								logisticsInfo.setStatusName("正在配送");
							} else if (ss == 9) {
								logisticsInfo.setStatusName("已完成");
							}
						}
						logisticsInfo.setStatus(ss);
						logisticsInfo.setLogisticsName("百度物流");
						logisticsInfo.setPickup_time(orderObj.getLong("pickup_time")+"");
						logisticsInfo.setAtshop_time(orderObj.getLong("atshop_time")+"");
						logisticsInfo.setSend_time(orderObj.getLong("delivery_time")+"");
						logisticsInfo.setDmPhone(orderObj.getString("delivery_phone"));
						logisticsInfo.setDmName("骑士");
						logisticsInfo.setFinished_time(orderObj.getString("finished_time"));
						logisticsInfo.setRecive_time(orderObj.getString("confirm_time"));
					}
				}
			} else if ("4".equals(orderSource)) {
				thirdOrder = orderQueryService.selectJdOrder(shopId, orderId);
				if (thirdOrder != null) {
					list = orderQueryService.selectJdOrderProduct(orderId);
					thirdOrder.setProducts(list);
					//查询物流信息
					JddjDeliveryStatus lsg=thirdJDdjService.selectLastByOrderId(orderId);
					if (lsg != null&&lsg.getOrderId()!=null) {
							logisticsInfo.setOrder_id(orderId + "");
							Integer status = Integer.valueOf(lsg.getDeliveryStatus());
							//配送状态(10 等待抢单;20 已抢单;25 取货失败;27 取货失败待审核;30 已收单;35 投递失败;40 已完成;50 取消;80撤销抢单)
								if (status != null) {
									if (status == 10) {
										logisticsInfo.setStatusName("待抢单");
									} else if (status == 20) {
										logisticsInfo.setStatusName("已抢单");
									}else if (status == 25) {
										logisticsInfo.setStatusName("取货失败");
									}else if (status == 25) {
										logisticsInfo.setStatusName("取货失败");
									}else if (status == 27) {
										logisticsInfo.setStatusName("取货失败待审核");
									}else if (status == 30) {
										logisticsInfo.setStatusName("已收单");
									}else if (status == 35) {
										logisticsInfo.setStatusName("投递失败");
									}else if (status == 40) {
										logisticsInfo.setStatusName("已完成");
									}else if (status == 50) {
										logisticsInfo.setStatusName("取消");
									}else if (status == 80) {
										logisticsInfo.setStatusName("撤销抢单");
									}
								}
								logisticsInfo.setStatus(status);
								logisticsInfo.setLogisticsName("京东配送");
								logisticsInfo.setRecive_date(lsg.getFetchTime());
								logisticsInfo.setSend_date(lsg.getSendTime());
								logisticsInfo.setFinished_date(lsg.getFinishedTime());
								logisticsInfo.setDmName(lsg.getDeliveryManName());
								logisticsInfo.setDmPhone(lsg.getDeliveryManPhone());
						}
				}
			}else if ("6".equals(orderSource)) {
				ThirdLogisOrderQuery querye=new ThirdLogisOrderQuery();
				querye.setOrder_id(orderId);
				List<ThirdOrder> thirdOrderlist = orderQueryService.selectElemeOrder(querye);
				if (thirdOrderlist != null&&thirdOrderlist.size()>0) {
					thirdOrder=thirdOrderlist.get(0);
					if (thirdOrder != null) {
						list =elemeOrderService.selectElemeOrderGoods(orderId+"");
						thirdOrder.setProducts(list);
					}
					//查询物流信息
					logisticsInfo=elemeOrderService.selectLogisByOrderId(orderId+"");
					if(logisticsInfo!=null){
						logisticsInfo.setOrder_id(orderId+"");
						String statuStr=logisticsInfo.getStatusStr();
						Integer ostatus=null;
						//配送状态(10 等待抢单;20 已抢单;25 取货失败;27 取货失败待审核;30 已收单;35 投递失败;40 已完成;50 取消;80撤销抢单)
						if (statuStr != null) {
							if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("待抢单");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("已抢单");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("取货失败");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("取货失败");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("取货失败待审核");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("已收单");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("投递失败");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("已完成");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("取消");
								ostatus=null;
							}else if ("".equals(statuStr)) {
								logisticsInfo.setStatusName("撤销抢单");
								ostatus=null;
							}
						}
					logisticsInfo.setStatus(ostatus);
					logisticsInfo.setLogisticsName("饿了么配送");
				   }
				}
			}
			request.setAttribute("logisticsInfo", logisticsInfo);
			request.setAttribute("orderInfo", thirdOrder);
			request.setAttribute("status", "ok");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", "fail");
			request.setAttribute("message", "异常");
		}
		return "order/order_detail";
	}
	
	/**
	 * 积分订单查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/scorelist")
	public String scorelist(HttpServletRequest request,ThirdLogisOrderQuery query){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curdate=sdf.format(new Date());
		String beginDate=query.getBeginDate();
		String endDate=query.getEndDate();  
		try{
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				query.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEnd_time(sdf.parse(endDate));
			}
			List<ScoreOrder> list=orderQueryService.selectScoreOrderlist(query);
			if(list!=null){
				//查询商品总数
				int ll=orderQueryService.selectScoreOrderNum(query);
				query.setTotalNums(ll);
			}
			request.setAttribute("orderlist", list);
			request.setAttribute("query", query);
		}catch(Exception e){
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/score_order_list";
	}
	
	/**
	 * 积分订单详情查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/scoreOrderInfo")
	public String scoreOrderInfo(HttpServletRequest request,Long orderId){
	try{
		List<ScoreOrderProduct> products=null;
		ScoreOrder scoreOrder=null;
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setOrder_id(orderId);
		List<ScoreOrder> list=orderQueryService.selectScoreOrderlist(query);
		if(list!=null&&list.size()>0){
			scoreOrder=list.get(0);
			products=orderQueryService.selectScoreOrderInfo(scoreOrder.getCardCouponId());
		}
		request.setAttribute("orderInfo", scoreOrder);
		request.setAttribute("products", products);
	}catch(Exception e){
		request.setAttribute("message", "异常");
		e.printStackTrace();
	}
		return "order/score_order_detail";
	}
	
	/**
	 * 拼团订单查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/pinTuanlist")
	public String pinTuanlist(HttpServletRequest request,ThirdLogisOrderQuery query){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curdate=sdf.format(new Date());
		String beginDate=query.getBeginDate();
		String endDate=query.getEndDate();  
		try{
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				query.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEnd_time(sdf.parse(endDate));
			}
			List<PinTuanOrder> list=orderQueryService.selectPinTuanOrderlist(query);
			if(list!=null){
				//查询商品总数
				int ll=orderQueryService.selectPinTuanOrderNum(query);
				query.setTotalNums(ll);
			}
			request.setAttribute("orderlist", list);
			request.setAttribute("query", query);
		}catch(Exception e){
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/team_order_list";
	}
	
	/**
	 * 拼团订单详情查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/pinTuanDetail")
	public String pinTuanDetail(HttpServletRequest request,Long orderId){
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setOrder_id(orderId);
		PinTuanOrder pt=null;
		ActivityPintuanBase base=null;
		LogistisDmInfo logisticsInfo = new LogistisDmInfo();
		try{
			List<PinTuanOrder> list=orderQueryService.selectPinTuanOrderlist(query);
			if(list!=null){
				pt=list.get(0);
				//查询商品信息
				int pid=pt.getProduct_id().intValue();
				base=activityPintuanBaseService.selectDetailById(pid);
			}
			request.setAttribute("orderInfo", pt);
			request.setAttribute("product", base);
			request.setAttribute("logisticsInfo", logisticsInfo);
		}catch(Exception e){
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/team_order_detail";
	}
	
	/**
	 * 退款订单查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/refundOrderlist")
	public String refundOrderlist(HttpServletRequest request,OrderRefundManageQuery query){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curdate=sdf.format(new Date());
		String beginDate=query.getBeginDate();
		String endDate=query.getEndDate();  
		try{
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				query.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEnd_time(sdf.parse(endDate));
			}
			List<OrderRefundManage> list=orderQueryService.selectRefundOrderlist(query);
			if(list!=null){
				//查询商品总数
				int ll=orderQueryService.selectRefundOrderNum(query);
				query.setTotalNums(ll);
			}
			request.setAttribute("orderlist", list);
			request.setAttribute("query", query);
		}catch(Exception e){
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/refund_order_list";
	}
	
	/**
	 * 退款订单详情查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/refundOrderDetail")
	public String refundOrderDetail(HttpServletRequest request,Long id){
		OrderRefundManageQuery query=new OrderRefundManageQuery();
		query.setId(id);
		OrderRefundManage pt=null;
		LogistisDmInfo logisticsInfo = new LogistisDmInfo();
		ThirdOrder thirdOrder=null;
		List<ThirdOrderProduct> prolist = null;
		try{
			List<OrderRefundManage> list=orderQueryService.selectRefundOrderlist(query);
			if(list!=null){
				pt=list.get(0);
				//查询商品信息
				Long pid=pt.getOrder_group_id();
				Integer order_type=pt.getOrder_type();
				if(order_type==null){
					order_type=1;
				}
				//查询商品信息
				if(order_type==1){
					thirdOrder = orderQueryService.selectMyOrder(null, pid);
					prolist = orderQueryService.selectMyOrderDetail(pid);
					thirdOrder.setProducts(prolist);
				}
				if(order_type==2){
					thirdOrder = orderQueryService.selectPtOrder(pid);
					prolist = orderQueryService.selectPtProOrderList(thirdOrder.getPt_base_id());
					thirdOrder.setProducts(prolist);
				}
				if (thirdOrder != null) {
					//查询物流信息
					LogisticsQuery Loguery = new LogisticsQuery();
					Loguery.setOrder_id(pid);
					Logistics logis = orderQueryService.selectLogisticsById(Loguery);
					if (logis != null) {
						logisticsInfo.setOrder_id(pid + "");
						if (logis.getLogis_type() == 1) {
							logisticsInfo.setLogisticsName("自配送");
						} else if (logis.getLogis_type() == 2) {
							logisticsInfo.setLogisticsName("达达配送");
						} else if (logis.getLogis_type() == 3) {
							logisticsInfo.setLogisticsName("百度配送");
						}else if (logis.getLogis_type() == 4) {
							logisticsInfo.setLogisticsName("饿了么配送");
						}else if (logis.getLogis_type() == 4) {
							logisticsInfo.setLogisticsName("美团配送");
						}
						if (logis.getOrder_status() < 2) {
							logisticsInfo.setStatusName("待接单");
						} else if (logis.getOrder_status() == 2){
							logisticsInfo.setStatusName("已接单");
						} else if (logis.getOrder_status() == 3) {
							logisticsInfo.setStatusName("派送中");
						} else if (logis.getOrder_status() == 4) {
							logisticsInfo.setStatusName("已完成");
						}
						logisticsInfo.setStatus(logis.getOrder_status());
						logisticsInfo.setRecive_time(logis.getRecieve_time() + "");
						logisticsInfo.setSend_time(logis.getSend_time() + "");
						logisticsInfo.setDmName(logis.getDm_name());
						logisticsInfo.setDmPhone(logis.getDm_mobile());	
					}
				}
			
			}
			request.setAttribute("reOrderInfo", pt);
			request.setAttribute("orderInfo", thirdOrder);
			request.setAttribute("logisticsInfo", logisticsInfo);
		}catch(Exception e){
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/refund_order_detail";
	}
	
	/**
	 * 退款单详情查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/refundInfoDetail")
	public String refundInfoDetail(HttpServletRequest request,Long id){
		try{
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("orderGroupId", id);
			OrderRefund order=orderRefundService.selectOneOrder(map);
			request.setAttribute("reOrderInfo", order);
		}catch(Exception e){
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "order/refund_info_detail";
	}
	
	/**
	 * 添加退款单
	 * @param request
	 * @return
	 */
	@RequestMapping("/addRefundOrder")
	public String addRefundOrder(HttpServletRequest request,OrderRefund order){
		try{
//			ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
//			Integer querySource=order.getOrderSource();
//			if(querySource!=null && querySource!=0 && querySource!=4){
//				if(querySource==1){
//					//查询商城订单
//					query.setQueryLjSource(1);
//				}else if(querySource==2){
//					//美团订单
//					query.setQueryMtSource(1);
//				}else if(querySource==3){
//					//查询百度订单
//					query.setQueryBdSource(1);
//				}
//			}else{
//				//查询所有订单
//				query.setQueryLjSource(1);
//				query.setQueryMtSource(1);
//				query.setQueryBdSource(1);
//				query.setIfAddUnion(1);
//			}
//			query.setOrder_id(order.getOrderGroupId());
//			List<ThirdOrder> list = orderQueryService.selectOrderlist(query);
//			if(list==null||list.size()==0){
//				request.setAttribute("message", "对不起查询不到订单!");
//				request.setAttribute("reOrder", order);
//				request.setAttribute("status", "fail");
//			}else{
				Map<String, Object> map = new HashMap<String,Object>();
				map.put("orderGroupId", order.getOrderGroupId());
				OrderRefund re=orderRefundService.selectOneOrder(map);
				if(re!=null){
					request.setAttribute("message", "退款订单已经存在,同一个订单请勿多次添加!");
					request.setAttribute("reOrder", order);
					request.setAttribute("status", "fail");
					return "order/refund_order_add";
				}else{
					long orderRefundId = orderidGenerateService.generateRefundId();
					order.setId(orderRefundId);
					order.setRefundType(1);
					order.setRefundOnlinepayStatus(1);
					order.setConfirmTime(new Date());
					order.setMobile(order.getLoginPhone());
					order.setCreate_time(new Date());
					order.setRefundStatus(2);
					if (order.getPayTypeId() == Constants.PAY_TYPE.WX) {
						order.setPayTypeId(0);
						order.setPayTypeName("微信支付");
					} else {
						order.setReturnBalance(order.getRefundAmount());
						order.setPayTypeId(1);
						order.setPayTypeName("钱包支付");
					}
					int num=orderRefundService.insert(order);
					if(num<=0){
						request.setAttribute("message", "退款记录生成失败！");
						request.setAttribute("reOrder", order);
						request.setAttribute("status", "fail");
						return "order/refund_order_add";
					}else{
//						String httpUrl=Application.SERVER_BASE_PATH+"/linjia_1/pay/payRefund";
						String httpUrl="http://10.171.117.29:9080/linjia_1/pay/payRefund";
//						String httpUrl="http://192.168.0.37:80/linjia_1/pay/payRefund";
						Long orderId=order.getOrderGroupId();
						SecUser user=Util.getUser(request);
						String userId=user.getLogin();
						Integer orderType=order.getOrder_type();
						Integer source=1;
						String sign=Util.getKfSign(orderId,userId,orderType,source,orderRefundId);
						Map<String,String> mallMap=new HashMap<String, String>();
						mallMap.put("groupId", orderId+"");
						mallMap.put("userId", userId+"");
						mallMap.put("orderType", orderType+"");
						mallMap.put("source", source+"");
						mallMap.put("refundId", orderRefundId+"");
						mallMap.put("sign", sign);
						HttpRequestUtil httpRequest=HttpRequestUtil.getHttpsRequestSingleton();
						JSONObject result = httpRequest.sendPost(httpUrl, mallMap);
						if(result!=null&&"ok".equals(result.getString("status"))){
							request.setAttribute("message", "退款成功！");
							request.setAttribute("status", "ok");
						}else{
							request.setAttribute("message", "退款失败！"+result.getString("message"));
							request.setAttribute("status", "fail");
							request.setAttribute("reOrder", order);
							return "order/refund_order_add";
						}
					}
				}
//			}
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "异常");
			e.printStackTrace();
			request.setAttribute("reOrder", order);
			return "order/refund_order_add";
		}
		return "redirect:/orderQuery/refundOrderlist";
	}
	
	/**
	 * 导出退款订单
	 */
	@RequestMapping("/leadOutRefundOrder") 
    public void leadOutRefundOrder(HttpServletRequest request,HttpServletResponse response,OrderRefundManageQuery query){
		//poi导出excel
        response.setContentType("text/html;charset=UTF-8");   
        ServletOutputStream out=null;
        try {  
        	//导出结果查询
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String curdate=sdf.format(new Date());
        	String beginDate=query.getBeginDate();
        	String endDate=query.getEndDate();  
        	if("".equals(beginDate)&&!"".equals(endDate)){
        		beginDate=curdate;
        	}
        	if(!"".equals(beginDate)&&"".equals(endDate)){
        		endDate=curdate;
        	}
        	if(beginDate!=null&&(!beginDate.isEmpty())){
        		query.setStart_time(sdf.parse(beginDate));
        	}
        	if(endDate!=null&&(!endDate.isEmpty())){
        		query.setEnd_time(sdf.parse(endDate));
        	}
        	query.setExportFlag(1);
        	List<OrderRefundManage> list=orderQueryService.selectRefundOrderlist(query);
        	
        	request.setCharacterEncoding("UTF-8");  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            String filename = "退款订单列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename,"UTF-8"));  
            ExportExcel<OrderRefundManage> ex = new ExportExcel<OrderRefundManage>();
			String[] headers = {"退款单号","订单单号", "在线支付退款流水号","订单状态(0,无退款;1,等待退款;2,正在退款;3,已退款;4,退款失败;5,未确定 ;6,转入代发)","创建时间", "审核时间","门店编码","门店名称","退款用户","联系电话","退款方式(1,人工;2,自动;)","退款金额","退积分","订单来源","审核状态(1.未审核 2.已审核 3.取消)"};
			out = response.getOutputStream();
			ex.exportExcel(headers, list, out);
            out.flush();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                try {
                	if (out != null) {  
                		out.close();  
                	}  
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }  
    } 
	
	/**
	 * 导出团购订单
	 */
	@RequestMapping("/leadOutPtOrder") 
    public void leadOutPtOrder(HttpServletRequest request,HttpServletResponse response,ThirdLogisOrderQuery query){
		//poi导出excel
        response.setContentType("text/html;charset=UTF-8");   
        ServletOutputStream out=null;
        try {  
        	//导出结果查询
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String curdate=sdf.format(new Date());
    		String beginDate=query.getBeginDate();
    		String endDate=query.getEndDate();  
    			if("".equals(beginDate)&&!"".equals(endDate)){
    				beginDate=curdate;
    			}
    			if(!"".equals(beginDate)&&"".equals(endDate)){
    				endDate=curdate;
    			}
    			if(beginDate!=null&&(!beginDate.isEmpty())){
    				query.setStart_time(sdf.parse(beginDate));
    			}
    			if(endDate!=null&&(!endDate.isEmpty())){
    				query.setEnd_time(sdf.parse(endDate));
    			}
    			query.setExportFlag(1);
    			List<PinTuanOrder> list=orderQueryService.selectPinTuanOrderlist(query);
        	
        	request.setCharacterEncoding("UTF-8");  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            String filename = "团购订单列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename,"UTF-8"));  
            ExportExcel<PinTuanOrder> ex = new ExportExcel<PinTuanOrder>();
			String[] headers = {"订单号","团编号","下单时间","订单状态(0,待发货;1,派送中;2,已完成;3,已取消)", "拼团状态(0,拼团中;1,已成团;2,拼团失败;)","订单类型(1,团购订单)","参团人数", "收货人","联系方式","收货地址","物流名称","第三方物流订单号","支付方式(0,微信支付;1,钱包支付;)","支付时间","总金额","实付金额","运费","优惠金额","商品数量","积分"};
			out = response.getOutputStream();
			ex.exportExcel(headers, list, out);
            out.flush();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                try {
                	if (out != null) {  
                		out.close();  
                	}  
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }  
    } 
	
	/**
	 * 导出积分订单
	 */
	@RequestMapping("/leadOutScoreOrder") 
    public void leadOutScoreOrder(HttpServletRequest request,HttpServletResponse response,ThirdLogisOrderQuery query){
		//poi导出excel
        response.setContentType("text/html;charset=UTF-8");   
        ServletOutputStream out=null;
        try {  
        	//导出结果查询
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String curdate=sdf.format(new Date());
    		String beginDate=query.getBeginDate();
    		String endDate=query.getEndDate();  
    			if("".equals(beginDate)&&!"".equals(endDate)){
    				beginDate=curdate;
    			}
    			if(!"".equals(beginDate)&&"".equals(endDate)){
    				endDate=curdate;
    			}
    			if(beginDate!=null&&(!beginDate.isEmpty())){
    				query.setStart_time(sdf.parse(beginDate));
    			}
    			if(endDate!=null&&(!endDate.isEmpty())){
    				query.setEnd_time(sdf.parse(endDate));
    			}
    			query.setExportFlag(1);
    			List<ScoreOrder> list=orderQueryService.selectScoreOrderlist(query);
        	
        	request.setCharacterEncoding("UTF-8");  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            String filename = "积分订单列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename,"UTF-8"));  
            ExportExcel<ScoreOrder> ex = new ExportExcel<ScoreOrder>();
			String[] headers = {"订单号","下单时间","订单状态(0,未付款;1,已付款)","订单类型(1,积分订单)","收货人","联系方式","订单名称","支付类型(0,微信支付;1,钱包支付;2,纯积分支付;)","支付价格","数量","类型(1,第三方合作券;2,商品券;)","卡券单号","积分"};
			out = response.getOutputStream();
			ex.exportExcel(headers, list, out);
            out.flush();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                try {
                	if (out != null) {  
                		out.close();  
                	}  
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }  
    } 
	
	/**
	 * 导出订单列表
	 */
	@RequestMapping("/leadOutThreeOrder") 
    public void leadOutThreeOrder(HttpServletRequest request,HttpServletResponse response,ThirdLogisOrderQuery query){
		//poi导出excel
        response.setContentType("text/html;charset=UTF-8");   
        ServletOutputStream out=null;
        try {  
        	//导出结果查询
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curdate=sdf.format(new Date());
			String beginDate=query.getBeginDate();
			String endDate=query.getEndDate();  
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				query.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEnd_time(sdf.parse(endDate));
			}
			Integer send_type=null;
			if(query.getSend_type()!=null){
				send_type=query.getSend_type();
				if(send_type==0){
					query.setMtSend_type(0);
					query.setBdSend_type(1);
				}
			}
			Integer pay_status=query.getPay_status();
			if(pay_status!=null){
				if(pay_status==1){
					query.setMtPatyStatus(2);
					query.setBdPatyStatus(2);
				}else{
					query.setMtPatyStatus(1);
					query.setBdPatyStatus(1);
				}
			}
			Integer status=query.getStatus();
			if(query.getStatus()!=null){
				switch (status) {
				case 0:
					query.setMtPatyStatus(1);
					query.setBdPatyStatus(1);
					query.setJdOrderStatus(31000);//31000:等待付款
					break;
				case 1:
					query.setMtPatyStatus(2);
					query.setBdPatyStatus(2);
					query.setJdOrderStatus(41000);//41000:待处理，
					break;
				case 2:
					query.setMtOrderStatus(4);
					query.setBdOrderStatus(5);
					query.setJdOrderStatus(32000); //32000:等待出库
					break;
				case 4:
					int[] BdOrderStatusList = new int[] {5,7,8};
					int[] MtOrderStatusList = new int[] {4,6};
					query.setMtOrderStatusList(MtOrderStatusList);
					query.setBdOrderStatusList(BdOrderStatusList);
					query.setJdOrderStatus(33040);//33040:配送中
					break;
				case 5:
					query.setMtOrderStatus(8);
					query.setBdOrderStatus(9);
					query.setJdOrderStatus(33060);//33060:已妥投
					break;
				case 6:
					query.setStatus(null);
					int[] orderStatusList = new int[] {3,6};
					query.setOrderStatusList(orderStatusList);
					query.setMtOrderStatus(9);
					query.setBdOrderStatus(10);
					query.setJdOrderStatus(20020);//20020:订单取消
					break;
				default:
					break;
				}
			}
			
			Integer querySource=query.getQuerySource();
			if(querySource!=null && querySource!=0){
				if(querySource==1){
					//查询商城订单
					query.setQueryLjSource(1);
				}else if(querySource==2){
					//美团订单
					query.setQueryMtSource(1);
				}else if(querySource==3){
					//查询百度订单
					query.setQueryBdSource(1);
				}else if(querySource==5){
					//查询京东订单
					query.setQueryJdSource(1);
				}else if(querySource==6){
					//查询饿了么订单
					query.setQueryElemeSource(1);
				}
			}else{
				//查询所有订单
				query.setQueryLjSource(1);
				query.setQueryMtSource(1);
				query.setQueryBdSource(1);
				query.setQueryJdSource(1);
				query.setQueryElemeSource(1);
				query.setIfAddUnion(1);
			}
			query.setExportFlag(1);
			List<ThirdOrder> list = orderQueryService.selectOrderlist(query);
        	
        	request.setCharacterEncoding("UTF-8");  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            String filename = "订单列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename,"UTF-8"));  
            ExportExcel<ThirdOrder> ex = new ExportExcel<ThirdOrder>();
			String[] headers = {"订单号","下单时间","订单状态(0,未付款;1,已付款)","订单类型(1,商城订单;2,美团订单;3,百度订单;4,京东订单)","收货人","联系方式","门店号","门店名称","配送方式(1,上门自提;0,送货上门;)","支付方式(0,微信支付;1,钱包支付;2,纯积分支付;4,非商城订单在线支付)","支付时间","总金额","实付金额","运费","优惠金额","订单渠道","积分"};
			if(querySource==5){
				headers = new String[]{"订单号","下单时间","订单状态(41000:待处理;32000:等待出库;33040:配送中;33060:已妥投;20020:订单取消)","订单类型(1,商城订单;2,美团订单;3,百度订单;4,京东订单)","收货人","联系方式","门店号","门店名称","配送方式(1,上门自提;0,送货上门;)","支付方式(0,微信支付;1,钱包支付;2,纯积分支付;4,非商城订单在线支付)","支付时间","总金额","实付金额","运费","优惠金额","订单渠道","积分"};
			}
			out = response.getOutputStream();
			ex.exportExcel(headers, list, out);
            out.flush();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                try {
                	if (out != null) {  
                		out.close();  
                	}  
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }  
    } 
	
	/**
	 * 退款订单信息查询
	 * @param order_type 1,普通订单；2团购订单
	 * @return
	 */
	@RequestMapping(value = "/getRefundInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getRefundInfo(HttpServletRequest request,String order_type,Long orderId) {
		Map<String,Object> map=new HashMap<String, Object>();
		OrderRefund order=new OrderRefund();
		Integer otype=null;
		if(order_type!=""&&!(order_type.isEmpty())){
			otype=Integer.valueOf(order_type);
		}
		try {
			if("1".equals(order_type)){
				ThirdOrder thirdOrder = orderQueryService.selectMyOrder(null, orderId);
				order.setRefundPayee(thirdOrder.getReceive_name());
				order.setLoginPhone(thirdOrder.getReceive_phone());
				order.setOrder_price(thirdOrder.getTotal_price());
				order.setSend_price(thirdOrder.getSend_price());
				order.setBenefit_price(thirdOrder.getBenefit_price());
				order.setOrder_type(otype);
				order.setRemark(thirdOrder.getRemark());
				order.setUserId(thirdOrder.getUser_id());
				order.setPayTypeId(thirdOrder.getPay_type());
				order.setReal_payPrice(thirdOrder.getReal_price());
				Integer score=thirdOrder.getAdd_score();
				if(score==null){
					score=0;
				}
				order.setReturnPoints(new BigDecimal(score));
				map.put("order", order);
			}
			
			if("2".equals(order_type)){
				ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
				query.setOrder_id(orderId);
				PinTuanOrder ptorder = orderQueryService.selectPinTuanOrder(query);
				order.setRefundPayee(ptorder.getCustname());
				order.setLoginPhone(ptorder.getPhone());
				order.setOrder_price(ptorder.getPrice());
				order.setSend_price(ptorder.getSend_fee());
				order.setBenefit_price(ptorder.getBenefit_price());
				order.setPayTypeId(ptorder.getPay_type());
				order.setOrder_type(otype);
				order.setRemark(ptorder.getRemark());
				order.setUserId(ptorder.getUser_id());
				order.setReal_payPrice(ptorder.getReal_price());
				Integer score=ptorder.getAdd_score();
				if(score==null){
					score=0;
				}
				order.setReturnPoints(new BigDecimal(score));
				map.put("order", order);
			}
			
			if("3".equals(order_type)){
				ThirdOrder thirdOrder = orderQueryService.selectReScoreOrder(orderId);
				order.setRefundPayee(thirdOrder.getReceive_name());
				order.setLoginPhone(thirdOrder.getReceive_phone());
				order.setOrder_price(thirdOrder.getReal_price());
				order.setSend_price(new BigDecimal(0));
				order.setBenefit_price(new BigDecimal(0));
				order.setOrder_type(otype);
				order.setRemark(thirdOrder.getRemark());
				order.setUserId(thirdOrder.getUser_id());
				order.setPayTypeId(thirdOrder.getPay_type());
				order.setReal_payPrice(thirdOrder.getReal_price());
				Integer score=thirdOrder.getAdd_score();
				if(score==null){
					score=0;
				}
				order.setReturnPoints(new BigDecimal(score));
				map.put("order", order);
			}
			map.put("status", "ok");
		} catch (Exception e) {
			map.put("status", "fail");
			map.put("message", "异常");
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 查找微信退款信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryWxRefundInfo")
	public Object queryWxRefundInfo(HttpServletRequest request,@RequestParam Long refundNo){
		String httpUrl=Application.SERVER_BASE_PATH+"/linjia_1/pay/payRefund";
		String keystr="outRefundNo="+refundNo+"&"+Application.getljKey();
		String sign=Util.getMD5(keystr);
		Map<String,Object> mallMap=new HashMap<String, Object>();
		mallMap.put("outRefundNo", refundNo);
		mallMap.put("sign", sign);
		HttpRequestUtil httpRequest=HttpRequestUtil.getHttpsRequestSingleton();
		JSONObject result = httpRequest.sendGet(httpUrl, mallMap);
		mallMap.put("resultData", result);
		return mallMap;
	}
	
	/**
	 * 修改团购订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatePtOrder")
	public String updatePtOrder(HttpServletRequest request,PinTuanOrder pt){
		try{
			boolean flag=orderQueryService.updatePtOrderById(pt);
			if(flag){
				request.setAttribute("status", "ok");
				request.setAttribute("message", "更新成功！");
			}else{
				request.setAttribute("status", "fail");
				request.setAttribute("message", "更新失败！");
			}
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "更新异常");
			e.printStackTrace();
		}
		return "redirect:/orderQuery/pinTuanlist";
	}
	
}
