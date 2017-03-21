package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.Address;

public interface AddressService extends BaseService<Address, Long>{
	
	/**
	 * 通过userId查询用户最近使用过的收货地址
	 * lixinling
	 * 2016年7月21日 下午5:31:06
	 * @param userId
	 * @return
	 */
	Address selectOneByUserId(String userId);
	
	/**
	 * 通过userId查询用户最近使用过的收货地址
	 * lixinling
	 * 2016年7月21日 下午5:31:06
	 * @param userId
	 * @return
	 */
	List<Address> selectListByUserId(String userId);
}
