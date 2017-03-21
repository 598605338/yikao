package com.linjia.web.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.DateComFunc;
import com.linjia.web.dao.OrderidGenerateMapper;
import com.linjia.web.model.OrderidGenerate;
import com.linjia.web.service.OrderidGenerateService;

@Service
@Transactional
public class OrderidGenerateServiceImpl extends BaseServiceImpl<OrderidGenerate, Long> implements OrderidGenerateService {
	
	@Resource
	private OrderidGenerateMapper mapper;

	@Override
	public BaseDao<OrderidGenerate, Long> getDao() {
		return mapper;
	}

	
	/**************************订单号和订单组号生成规则******************************/
	/*
	 * type:1订单号；2订单组号；3退款单号
	 * 对于订单号 orderId的生成规则：yyMMdd+1+b_orderid_generate表自增主键id  (例如：16072611001)
	 * 对于订单号 orderGroupId的生成规则：yyMMdd+2+b_orderid_generate表自增主键id  (例如：16072621002)
	 * 对于订单号 refundId的生成规则：yyMMdd+3+b_refundid_generate表自增主键id  (例如：16072631003)
	 * 对于订单号 scoreOrderId的生成规则：yyMMdd+4+b_orderid_generate表自增主键id  (例如：16072641003)
     */
	
	private final String ORDER_TYPE = "1";
	private final String GROUP_ORDER_TYPE = "2";
	private final String REFUND_TYPE = "3";
	private final String SCORE_ORDER_TYPE = "4";
	private String format="yyMMdd";
	/**************************订单号和订单组号生成规则******************************/
	/**
	 * 生成订单号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	@Override
	public long generateOrderId() {
		StringBuilder sb = new StringBuilder();
		OrderidGenerate model = new OrderidGenerate();
		mapper.insertSelective(model);
		sb.append(DateComFunc.formatDate(new Date(), format)).append(ORDER_TYPE).append(model.getId());
		
		return Long.valueOf(sb.toString());
	}

	/**
	 * 生成订单组号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	@Override
	public long generateOrderGroupId() {
		StringBuilder sb = new StringBuilder();
		OrderidGenerate model = new OrderidGenerate();
		mapper.insertSelective(model);
		sb.append(DateComFunc.formatDate(new Date(), format)).append(GROUP_ORDER_TYPE).append(model.getId());
		
		return Long.valueOf(sb.toString());
	}
	
	/**
	 * 生成退款单号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	@Override
	public long generateRefundId() {
		StringBuilder sb = new StringBuilder();
		OrderidGenerate model = new OrderidGenerate();
		mapper.insertSelective(model);
		sb.append(DateComFunc.formatDate(new Date(), format)).append(REFUND_TYPE).append(model.getId());
		
		return Long.valueOf(sb.toString());
	}

	/**
	 * 生成积分兑换订单号
	 * lixinling 
	 * 2016年7月26日 上午10:58:47
	 * @return
	 */
	@Override
	public long generateScoreOrderId() {
		StringBuilder sb = new StringBuilder();
		OrderidGenerate model = new OrderidGenerate();
		mapper.insertSelective(model);
		sb.append(DateComFunc.formatDate(new Date(), format)).append(SCORE_ORDER_TYPE).append(model.getId());
		
		return Long.valueOf(sb.toString());
	}
	
	


	

}
