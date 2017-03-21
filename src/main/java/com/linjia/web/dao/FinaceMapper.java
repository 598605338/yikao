package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.FinaceSum;
import com.linjia.web.query.FinaceQuery;


public interface FinaceMapper  extends BaseDao<FinaceSum, Long>{
	
	/**
	 * 总销售额统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectSumAllSales(FinaceQuery query);
	
	/**
	 * 店铺销售额统计(分日期)
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectShopSalesByDate(FinaceQuery query);
	
	/**
	 * 店铺销售额统计(不分日期)
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectShopSales(FinaceQuery query);
	
	/**
	 * 店铺销售时段统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectShopSaleInterval(FinaceQuery query);
	
	/**
	 * 客单价分布统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectCustPriceInterval(FinaceQuery query);
	
	/**
	 * 热销商品销售统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectHotSaleProducts(FinaceQuery query);
	
	/**
	 * 商品销售类别统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectProductsTypeSale(FinaceQuery query);
	
	/**
	 * 商品配送统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectProductsSend(FinaceQuery query);
	
	/**
	 * 商品清场统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectProductsClean(FinaceQuery query);
	
	/**
	 * 缺货商品统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> selectLackProducts(FinaceQuery query);
}