package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.TakeGoodsCodeGenerate;


public interface TakeGoodsCodeGenerateMapper extends BaseDao<TakeGoodsCodeGenerate, Long> {
	
	/**
	 * 查询是否存在
	 * lixinling 
	 * 2016年8月17日 下午1:20:53
	 * @param model
	 * @return
	 */
	int selectCount(TakeGoodsCodeGenerate model);
}