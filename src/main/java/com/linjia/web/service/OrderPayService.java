package com.linjia.web.service;


import java.math.BigDecimal;
import java.util.Map;

import com.linjia.base.service.BaseService;

public interface OrderPayService extends BaseService<Object, Long>{
	
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
	public Map<String,Object> payHandle(int payType, String body, String attach,BigDecimal realPrice, long outTradeNo,String spbill_create_ip);
}
