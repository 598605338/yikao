package com.linjia.web.service;

import java.util.List;

import com.linjia.web.model.ShopUser;
import com.linjia.web.query.ShopUserQuery;

public interface ShopUserService {

	/**
	 * 插入店铺数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer insertShop(ShopUser shopUser);
	
	/**
	 * 删除店铺数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer deleteShop(ShopUser query);
	
	/**
	 * 更新店铺数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer updateShop(ShopUser query);
	
	/**
	 * 查询店铺数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	ShopUser selectShop(String account,String password);
	
	/**
	 * 查询店铺列表数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ShopUser> selectShopList(ShopUserQuery query);
	
	/**
	 * 查询店铺总数
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer selectShopNum();
}
