package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.Tags;
import com.linjia.web.query.TagsQuery;

public interface TagsService extends BaseService<Tags, Long>{
	
	/**
	 * 根据type类型查询相应的标签列表
	 * lixinling 
	 * 2016年10月14日 上午11:12:06
	 * @param type
	 * @return
	 */
	List<Tags> selectAllTagsByType(int type);

	/**
	 * 查询分页标签列表
	 * lixinling 
	 * 2016年10月14日 上午11:12:06
	 * @param type
	 * @return
	 */
	List<Tags> selectAllTagsByPage(TagsQuery query);

	/**
	 * 查询列表总数量
	 * lixinling 
	 * 2016年10月14日 上午11:12:06
	 * @param type
	 * @return
	 */
	Long countByExample(TagsQuery query);
}
