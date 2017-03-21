package com.linjia.web.uhd123.service;

import java.util.Date;
import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.model.OrderGroupProduct;
import com.linjia.web.model.Product;

/** 
 * 同步平台商品范围到鼎力云
 * @author  lixinling: 
 * @date 2016年10月11日 上午10:30:41 
 * @version 1.0 
*/
public interface UhdOrderService {

	/**
	 * 同步平台商品范围到鼎力云
	 * lixinling 
	 * 2016年10月17日 下午2:09:52
	 * @param platformId:平台号：1商城；2百度；3美团
	 * @param orderGroup
	 * @param orderGroupProductList
	 * @param userId 抛单者userId
	 * @return
	 */
	boolean ptmskus(List<Product> list, String operator);
	
	/**
	 * 同步平台商品范围到鼎力云
	 * lixinling 
	 * 2016年10月17日 下午2:09:52
	 * @param platformId:平台号：1商城；2百度；3美团
	 * @param orderGroup
	 * @param orderGroupProductList
	 * @param userId 抛单者userId
	 * @return
	 */
	boolean ptmskus(Product product, String operator);
}
