package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.NoticeManagerMapper;
import com.linjia.web.model.NoticeManager;
import com.linjia.web.query.NoticeManagerQuery;
import com.linjia.web.service.NoticeManagerService;

@Service
@Transactional
public class NoticeManagerServiceImpl extends BaseServiceImpl<NoticeManager, Long> implements NoticeManagerService {
	
	@Resource
	private NoticeManagerMapper mapper;

	@Override
	public BaseDao<NoticeManager, Long> getDao() {
		return mapper;
	}

	@Override
	public List<NoticeManager> selectByPageList(NoticeManagerQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public int updateUseStatusByPrimaryKey(NoticeManager model) {
		return mapper.updateUseStatusByPrimaryKey(model);
	}


}
