package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.TagsMapper;
import com.linjia.web.model.Tags;
import com.linjia.web.query.TagsQuery;
import com.linjia.web.service.TagsService;

@Service
@Transactional
public class TagsServiceImpl extends BaseServiceImpl<Tags, Long> implements TagsService {

	@Resource
	private TagsMapper mapper;

	@Override
	public BaseDao<Tags, Long> getDao() {
		return mapper;
	}

	@Override
	public List<Tags> selectAllTagsByType(int type) {
		return mapper.selectAllTagsByType(type);
	}

	@Override
	public List<Tags> selectAllTagsByPage(TagsQuery query) {
		return mapper.selectAllTagsByPage(query);
	}

	@Override
	public Long countByExample(TagsQuery query) {
		return mapper.countByExample(query);
	}

}
