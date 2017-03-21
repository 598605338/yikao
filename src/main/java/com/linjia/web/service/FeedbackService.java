package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.Feedback;
import com.linjia.web.query.FeedbackQuery;

public interface FeedbackService extends BaseService<Feedback, Long>{
	
	/**
	 * 分页查询反馈信息
	 * lixinling 
	 * 2016年8月30日 下午4:12:28
	 * @param query
	 * @return
	 */
	List<Feedback> selectByPageList(FeedbackQuery query);

	/**
	 * 查询分页数据的总数量
	 * lixinling 
	 * 2016年8月30日 下午4:12:28
	 * @param query
	 * @return
	 */
	int countByExample(FeedbackQuery query);
}
