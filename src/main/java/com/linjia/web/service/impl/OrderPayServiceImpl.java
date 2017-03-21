package com.linjia.web.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.alibaba.druid.util.StringUtils;
import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Util;
import com.linjia.web.dao.FeedbackMapper;
import com.linjia.web.model.Feedback;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.service.FeedbackService;
import com.linjia.web.service.OrderPayService;

@Service
@Transactional
public class OrderPayServiceImpl extends BaseServiceImpl<Object, Long> implements OrderPayService {

	@Override
	public BaseDao<Object, Long> getDao() {
		return null;
	}

	/**
	 * 调起支付
	 * lixinling 
	 * 2016年8月10日 下午4:17:42
	 * @param payType
	 * @param body
	 * @param totalFee
	 * @param outTradeNo
	 * @param spbill_create_ip
	 * @return
	 */
	public Map<String, Object> payHandle(int payType, String body, String attach, BigDecimal realPrice, long outTradeNo, String spbill_create_ip) {
		Map<String, Object> resMap = new HashMap<String, Object>();

		return resMap;
	}
}
