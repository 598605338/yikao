package com.linjia.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.JddjDeliveryStatusMapper;
import com.linjia.web.model.JddjDeliveryStatus;
import com.linjia.web.model.OrderInfoDTO;
import com.linjia.web.service.ThirdJDdjService;

@Service
@Transactional
public class ThirdJDdjServiceImpl extends BaseServiceImpl<OrderInfoDTO, Long> implements ThirdJDdjService {

	@Resource
	private JddjDeliveryStatusMapper jddjDeliveryStatusMapper;

	@Override
	public BaseDao<OrderInfoDTO, Long> getDao() {
		return null;
	}

	@Override
	public JddjDeliveryStatus selectLastByOrderId(Long orderId) {
		return jddjDeliveryStatusMapper.selectLastByOrderId(orderId);
	}


	
}
