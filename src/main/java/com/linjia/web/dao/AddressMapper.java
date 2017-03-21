package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.Address;

public interface AddressMapper extends BaseDao<Address, Long> {
	
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