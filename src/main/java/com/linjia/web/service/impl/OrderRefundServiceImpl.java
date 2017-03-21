package com.linjia.web.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.web.dao.OrderGroupMapper;
import com.linjia.web.dao.OrderRefundMapper;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.model.OrderRefund;
import com.linjia.web.query.OrderRefundQuery;
import com.linjia.web.service.OrderRefundService;
import com.linjia.web.service.OrderidGenerateService;

@Service
@Transactional
public class OrderRefundServiceImpl extends BaseServiceImpl<OrderRefund, Long> implements OrderRefundService {

	@Resource
	private OrderRefundMapper mapper;

	@Resource
	private OrderGroupMapper orderGroupMapper;

	@Autowired
	private OrderidGenerateService orderidGenerateService;

	@Override
	public BaseDao<OrderRefund, Long> getDao() {
		return mapper;
	}

	/**
	 * 退款
	 * lixinling 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	@Override
	public Map<String, Object> insertRefund(OrderGroup orderGroup, String userId) {
		OrderRefund orderRefund = this.createRefundParams(orderGroup, userId);
		int row = mapper.insertSelective(orderRefund);
		Map<String, Object> resMap = new HashMap<String, Object>();
		return null;
	}

	/**
	 * 构造退款单参数
	 * 
	 * lixinling 
	 * 2016年7月29日 上午11:51:15
	 * @param orderGroup
	 * @param userId
	 * @param loginPhone
	 * @return
	 */
	public OrderRefund createRefundParams(OrderGroup orderGroup, String userId) {
		long orderRefundId = orderidGenerateService.generateRefundId();

		OrderRefund orderRefund = new OrderRefund();
		orderRefund.setId(orderRefundId);
		orderRefund.setOrderGroupId(orderGroup.getId());
		orderRefund.setUserId(orderGroup.getUserId());
		orderRefund.setLoginPhone(userId);
		orderRefund.setRefundType(Constants.REFUND_TYPE.AUTO);
		orderRefund.setRefundAmount(orderGroup.getRealPrice());
		orderRefund.setRefundSource(Constants.REFUND_SOURCE.CANCEL);
		orderRefund.setRefundStatus(Constants.REFUND_STATUS.REVIEWED);
		orderRefund.setConfirmor("system");
		orderRefund.setConfirmTime(new Date());
		orderRefund.setMobile(userId);
		orderRefund.setRefundPayee(orderGroup.getReceiveName());
		orderRefund.setRefundReason("订单取消");
		orderRefund.setMallCode(orderGroup.getMallCode());
		orderRefund.setMallName(orderGroup.getMallName());
		orderRefund.setMallPhone(orderGroup.getMallPhone());
		orderRefund.setRefundOnlinepayStatus(Constants.ORDER_REFUND_STATUS.WAIT_REFUND);
		orderRefund.setPayTypeId(5);
		orderRefund.setPayTypeName("微信支付");
		return orderRefund;
	}

	/**
	 * 更新退款单状态
	 * lixinling 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	@Override
	public boolean updateRefundStatusById(Map<String, Object> map) {

		int row = mapper.updateRefundStatusById(map);
		if (row == 1)
			return true;

		// 申请微信退款的时候更新订单状态为已取消，查询微信退款状态时只更新退款单状态
		/*
		 * if(row ==1 && !StringUtils.isEmpty(map.get("groupId"))){
		 * logger.info("更新退款单状态成功"); //更新订单状态 Map<String,Object> param = new
		 * HashMap<String,Object>(); param.put("groupId", map.get("groupId"));
		 * param.put("orderGroupStatus", Constants.ORDER_GROUP_STATUS.CANCELED);
		 * orderGroupMapper.updateStatusById(param); logger.info("更新订单状态");
		 * return true; }
		 */
		return false;
	}

	/**
	 * 查询我的退款单
	 * lixinling 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	@Override
	public List<OrderRefund> selectMyRefundOrderList(OrderRefundQuery query) {
		return mapper.selectMyRefundOrderList(query);
	}

	@Override
	public OrderRefund selectOneOrder(Map<String, Object> map) {
		return mapper.selectOneOrder(map);
	}


}
