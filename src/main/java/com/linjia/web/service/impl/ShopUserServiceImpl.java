package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.constants.Constants;
import com.linjia.web.dao.ShopUserMapper;
import com.linjia.web.model.ShopUser;
import com.linjia.web.query.ShopUserQuery;
import com.linjia.web.service.ShopUserService;

@Service
@Transactional
public class ShopUserServiceImpl implements ShopUserService{

	@Resource
	private ShopUserMapper mapper;
	
	@Override
	public Integer insertShop(ShopUser shopUser) {
		int num=mapper.insertShop(shopUser);
		return num;
	}

	@Override
	public Integer deleteShop(ShopUser query) {
		int num=mapper.deleteShop(query);
		return num;
	}

	@Override
	public Integer updateShop(ShopUser query) {
		int num=mapper.updateShop(query);
		return num;
	}

	@Override
	public ShopUser selectShop(String account,String password) {
		ShopUserQuery query=new ShopUserQuery();
		query.setAccount(account);
		query.setPassword(password);
		ShopUser shopUser=mapper.selectShop(query);
		return shopUser;
	}

	@Override
	public List<ShopUser> selectShopList(ShopUserQuery query) {
		query.setPageSize(Constants.PAGE.SIZE);
		List<ShopUser> shopList=mapper.selectShopList(query);
		return shopList;
	}

	@Override
	public Integer selectShopNum() {
		int shopNum=mapper.selectShopNum();
		return shopNum;
	}

}
