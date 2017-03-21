package com.linjia.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ProductSpecMapper;
import com.linjia.web.model.ProductSpec;
import com.linjia.web.service.ProductSpecService;

@Service
@Transactional
public class ProductSpecServiceImpl extends BaseServiceImpl<ProductSpec, Long> implements ProductSpecService {
	
	@Resource
	private ProductSpecMapper mapper;
	
	@Override
	public BaseDao<ProductSpec, Long> getDao() {
		return mapper;
	}

	@Override
	public int selectSafeQuantityByProductId(Long productId) {
		return mapper.selectSafeQuantityByProductId(productId);
	}

	

}
