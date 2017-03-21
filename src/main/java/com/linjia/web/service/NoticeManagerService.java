package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.NoticeManager;
import com.linjia.web.query.NoticeManagerQuery;

public interface NoticeManagerService extends BaseService<NoticeManager, Long>{

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
