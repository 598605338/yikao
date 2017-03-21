package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.NoticeManager;
import com.linjia.web.query.NoticeManagerQuery;

public interface NoticeManagerMapper extends BaseDao<NoticeManager, Long> {
	
	/**
	 * 分页查询公告信息
	 * lixinling 
	 * 2016年8月30日 下午2:33:34
	 * @param query
	 * @return
	 */
	List<NoticeManager> selectByPageList(NoticeManagerQuery query);
	
	/**
	 * 更新使用状态
	 * lixinling 
	 * 2016年8月30日 下午2:34:37
	 * @param model
	 * @return
	 */
	int updateUseStatusByPrimaryKey(NoticeManager model);
}