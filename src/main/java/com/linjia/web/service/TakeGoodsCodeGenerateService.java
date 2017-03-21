package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.TakeGoodsCodeGenerate;

public interface TakeGoodsCodeGenerateService extends BaseService<TakeGoodsCodeGenerate, Long>{
	
	/**
	 * 查询是否存在
	 * lixinling 
	 * 2016年8月17日 下午1:20:53
	 * @param model
	 * @return
	 */
	int selectCount(TakeGoodsCodeGenerate model);
	
	/**
	 * 生成提货码
	 * lixinling 
	 * 2016年8月17日 下午1:20:53
	 * @param model
	 * @return
	 */
	TakeGoodsCodeGenerate generateCode(String mallCode);
}
