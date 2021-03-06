package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.ProductUnit;
import com.linjia.web.query.ProductUnitQuery;

public interface ProductUnitService extends BaseService<ProductUnit, Long>{
	
	/**
	 * 分页取得单位数据
	 * lixinling 
	 * 2016年8月30日 上午10:05:17
	 * @param query
	 * @return
	 */
	List<ProductUnit> selectByPageList(ProductUnitQuery query);

	/**
	 * 取得分页数据总数量
	 * lixinling 
	 * 2016年8月30日 上午10:05:17
	 * @param query
	 * @return
	 */
	int countByExample(ProductUnitQuery query);
	
	/**
	 * 更新单位的使用状态数据
	 * lixinling 
	 * 2016年8月30日 上午10:05:17
	 * @param query
	 * @return
	 */
	int updateUseStatusById(ProductUnit model);
	
	/**
	 * 取得所有单位数据
	 * lixinling 
	 * 2016年8月30日 上午10:05:17
	 * @param query
	 * @return
	 */
	List<ProductUnit> selectAllUnitList();

	/**
	 * 根据name查询Id
	 * lixinling 
	 * 2016年8月27日 下午3:47:12
	 * @param query
	 */
	Long selectIdByName(String name);
}
