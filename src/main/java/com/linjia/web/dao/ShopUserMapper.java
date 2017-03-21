package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ShopUser;
import com.linjia.web.query.ShopUserQuery;

public interface ShopUserMapper extends BaseDao<ShopUser, Long>{
	
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
	ShopUser selectShop(ShopUserQuery query);
	
	/**
	 * 查询店铺列表数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ShopUser> selectShopList(ShopUserQuery query);
	
	/**
	 * 查询店铺列表数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	Integer selectShopNum();
	
}