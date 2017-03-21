package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.AddressMapper;
import com.linjia.web.model.Address;
import com.linjia.web.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService {
	
	@Resource
	private AddressMapper mapper;

	@Override
	public BaseDao<Address, Long> getDao() {
		return mapper;
	}
	
	@Override
	public Address selectOneByUserId(String userId) {
		return mapper.selectOneByUserId(userId);
	}

	/**
	 * 通过userId查询用户最近使用过的收货地址
	 * lixinling
	 * 2016年7月21日 下午5:31:06
	 * @param userId
	 * @return
	 */
	@Override
	public List<Address> selectListByUserId(String userId){
		return mapper.selectListByUserId(userId);
	}

}
