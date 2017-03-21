package com.linjia.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.linjia.web.model.CustMaster;
import com.linjia.web.model.FinaceSum;
import com.linjia.web.query.FinaceQuery;
import com.linjia.web.service.FinaceService;

/** 
 * @author  xiangsy: 
 * @date 2016年8月30日 下午4:16:39 
 * @version 1.0 
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {
	
	@Autowired
	private FinaceService  finaceService;
	
	/**
	 * 总销售额统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/sumAllSales")
	public String sumAllSales(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		List<FinaceSum> list=finaceService.sumAllSales(query);
		return "finace/sumAllSales";
	}
	
	/**
	 * 店铺销售额统计(分日期)
	 * @param request
	 * @return
	 */
	@RequestMapping("/shopSalesByDate")
	public String shopSalesByDate(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setMall_code("");
		query.setMall_name("");
		List<FinaceSum> list=finaceService.shopSalesByDate(query);
		return "finace/shopSalesByDate";
	}
	
	/**
	 * 店铺销售额统计(不分日期)
	 * @param request
	 * @return
	 */
	@RequestMapping("/shopSales")
	public String shopSales(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setMall_code("");
		query.setMall_name("");
		List<FinaceSum> list=finaceService.shopSales(query);
		return "finace/shopSales";
	}
	
	/**
	 * 店铺销售时段统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/shopSaleInterval")
	public String shopSaleInterval(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		List<FinaceSum> list=finaceService.shopSaleInterval(query);
		return "finace/shopSaleInterval";
	}
	
	/**
	 * 客单价分布统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/custPriceInterval")
	public String custPriceInterval(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginPrice(0);
		query.setBeginPrice(0);
		query.setStatus(0);
		query.setStatusList("");
		List<FinaceSum> list=finaceService.custPriceInterval(query);
		return "finace/custPriceInterval";
	}
	
	/**
	 * 热销商品销售统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/hotSaleProducts")
	public String hotSaleProducts(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setP_code("");
		query.setP_name("");
		List<FinaceSum> list=finaceService.hotSaleProducts(query);
		return "finace/hotSaleProducts";
	}
	
	/**
	 * 商品销售类别统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/productsTypeSale")
	public String productsTypeSale(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setLarge_catagory_id(0);
		query.setLarge_catagory_name("");
		query.setMiddle_catagory_id(0);
		query.setMiddle_catagory_name("");
		List<FinaceSum> list=finaceService.productsTypeSale(query);
		return "finace/productsTypeSale";
	}
	
	/**
	 * 商品配送统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/productsSend")
	public String productsSend(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setOrder_id(0l);
		query.setMall_code("");
		query.setMall_name("");
		//门店接单时长
		query.setBeigin_recive_time(0);
		query.setEnd_recive_time(1);
		//门店配送时长
		query.setBeigin_send_time(0);;
		query.setEnd_send_time(1);
		//达达接单时长开始时间
		query.setBeigin_dadaRecive_time(0);
		query.setEnd_dadaRecive_time(1);
		//达达配送时长
		query.setBeigin_dadaSend_time(0);
		query.setEnd_dadaSend_time(1);
		
		query.setPayToFinishTime(1);
		query.setPayToCancelTime(2);
		query.setOrderCreateTime("");
		List<FinaceSum> list=finaceService.productsSend(query);
		return "finace/productsSend";
	}
	
	/**
	 * 商品清场统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/productsClean")
	public String productsClean(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setMall_code("");
		query.setMall_name("");
		query.setP_code("");
		query.setP_name("");
		List<FinaceSum> list=finaceService.productsClean(query);
		return "finace/productsClean";
	}
	
	/**
	 * 商品清场统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/lackProducts")
	public String lackProducts(HttpServletRequest request,@RequestBody CustMaster model){
		FinaceQuery query=new FinaceQuery();
		query.setBeginDate("");
		query.setEndDate("");
		query.setStatus(0);
		query.setStatusList("");
		query.setMall_code("");
		query.setMall_name("");
		query.setP_code("");
		query.setP_name("");
		query.setOrder_id(0l);
		List<FinaceSum> list=finaceService.lackProducts(query);
		return "finace/lackProducts";
	}
}
