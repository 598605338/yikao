package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.FinaceSum;
import com.linjia.web.query.FinaceQuery;

public interface FinaceService extends BaseService<FinaceSum, Long>{
	
	/**
	 * 总销售额统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> sumAllSales(FinaceQuery query);
	
	/**
	 * 店铺销售额统计(分日期)
	 * @param request
	 * @return
	 */
	public List<FinaceSum> shopSalesByDate(FinaceQuery query);
	
	/**
	 * 店铺销售额统计(不分日期)
	 * @param request
	 * @return
	 */
	public List<FinaceSum> shopSales(FinaceQuery query);
	
	/**
	 * 店铺销售时段统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> shopSaleInterval(FinaceQuery query);
	
	/**
	 * 客单价分布统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> custPriceInterval(FinaceQuery query);
	
	/**
	 * 热销商品销售统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> hotSaleProducts(FinaceQuery query);
	
	/**
	 * 商品销售类别统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> productsTypeSale(FinaceQuery query);
	
	/**
	 * 商品配送统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> productsSend(FinaceQuery query);
	
	/**
	 * 商品清场统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> productsClean(FinaceQuery query);
	
	/**
	 * 商品清场统计
	 * @param request
	 * @return
	 */
	public List<FinaceSum> lackProducts(FinaceQuery query);
}
