package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.MiaoshaActivityBase;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.query.MiaoshaActivityBaseQuery;

public interface MiaoshaActivityService extends BaseService<MiaoshaActivityBase, Long>{
	/**
	 * 查询单个对象
	 * 
	 * @return
	 */
	MiaoshaActivityBase selectOne(MiaoshaActivityBaseQuery query);
	
	/**
	 * 分页查询数据
	 * 
	 * @param id
	 * @return
	 */
	List<MiaoshaActivityBase> selectByPageList(MiaoshaActivityBaseQuery query);

	/**
	 * 分页查询数据总数量
	 * 
	 * @param id
	 * @return
	 */
	int countByExample(MiaoshaActivityBaseQuery query);
	
	/**
	 * 新增秒杀活动Base
	 * lixinling 
	 * 2016年9月1日 上午11:07:11
	 * @return
	 */
	MiaoshaActivityBase insertMiaoshaBaseActivity(MiaoshaActivityBase miaoshaActivityBase);
	
	/**
	 * 更新秒杀活动Base
	 * lixinling 
	 * 2016年9月1日 上午11:07:11
	 * @return
	 */
	MiaoshaActivityBase updateMiaoshaBaseActivity(MiaoshaActivityBase miaoshaActivityBase);
	
	/**
	 * 新增秒杀活动Product
	 * lixinling 
	 * 2016年9月1日 上午11:07:11
	 * @return
	 */
	boolean insertMiaoshaProductActivity(MiaoshaActivityProduct miaoshaActivityProduct);
	
	/**
	 * 查询所有参加该活动的商品数据
	 * 
	 * @param id
	 * @return
	 */
	List<MiaoshaActivityProduct> selectProductListByBaseId(Long baseId);
	
	/**
	 * 编辑商品数据
	 * 
	 * @param id
	 * @return
	 */
	boolean updateActivityProduct(MiaoshaActivityProduct miaoshaActivityProduct);
	

	/**
	 * 删除商品数据
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteActivityProduct(Long miaoshaProductId);
}
