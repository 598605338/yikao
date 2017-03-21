package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ScoreProductMapper;
import com.linjia.web.model.ScoreProduct;
import com.linjia.web.query.ScoreProductQuery;
import com.linjia.web.service.ScoreProductService;

@Service
@Transactional
public class ScoreProductServiceImpl extends BaseServiceImpl<ScoreProduct, Long> implements ScoreProductService {
	
	@Resource
	private ScoreProductMapper mapper;

	@Override
	public BaseDao<ScoreProduct, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ScoreProduct> selectByPageList(ScoreProductQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public int updateStatusByPrimaryKey(ScoreProduct model) {
		return mapper.updateStatusByPrimaryKey(model);
	}

	@Override
	public int countByExample(ScoreProductQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public Long selectMaxSortIndex() {
		return mapper.selectMaxSortIndex();
	}

	
}
