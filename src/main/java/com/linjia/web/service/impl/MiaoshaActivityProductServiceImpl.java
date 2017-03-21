package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.MiaoshaActivityProductMapper;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.query.MiaoshaActivityProductQuery;
import com.linjia.web.service.MiaoshaActivityProductService;

@Service
public class MiaoshaActivityProductServiceImpl extends BaseServiceImpl<MiaoshaActivityProduct, Long> implements MiaoshaActivityProductService {
	
	@Resource
	private MiaoshaActivityProductMapper mapper;
	
	@Override
	public BaseDao<MiaoshaActivityProduct, Long> getDao() {
		return mapper;
	}

	@Override
	public List<MiaoshaActivityProduct> selectAllByBaseId(MiaoshaActivityProductQuery query) {
		return mapper.selectAllByBaseId(query);
	}

	@Override
	public MiaoshaActivityProduct getPanicingProductByProductId(long product_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productId", product_id);
		map.put("currentDate", new Date());
		return mapper.getPanicingProductByProductId(map);
	}

}
