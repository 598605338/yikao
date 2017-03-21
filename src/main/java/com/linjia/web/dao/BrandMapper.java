package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.Brand;
import com.linjia.web.query.BrandQuery;

public interface BrandMapper extends BaseDao<Brand, Long> {
	
	/**
	 * 根据query查询品牌列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<Brand> selectBySerach(BrandQuery query);
	
	/**
	 * 根据query查询品牌列表总数量
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(BrandQuery query);
	
	/**
	 * 查询所有品牌列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<Brand> selectAllBrandList();
	
	/**
	 * 更改使用状态
	 * lixinling 
	 * 2016年10月5日 下午8:00:47
	 * @param model
	 * @return
	 */
	int updateUseStatusByPrimaryKey(Brand model);

	/**
	 * 根据name查询Id
	 * lixinling 
	 * 2016年8月27日 下午3:47:12
	 * @param query
	 */
	Long selectIdByName(String name);
}