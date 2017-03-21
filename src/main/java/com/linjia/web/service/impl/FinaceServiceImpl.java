package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.FinaceMapper;
import com.linjia.web.model.FinaceSum;
import com.linjia.web.query.FinaceQuery;
import com.linjia.web.service.FinaceService;

@Service
@Transactional
public class FinaceServiceImpl extends BaseServiceImpl<FinaceSum, Long> implements FinaceService{

	@Resource
	private FinaceMapper mapper;

	@Override
	public List<FinaceSum> sumAllSales(FinaceQuery query) {
		return mapper.selectSumAllSales(query);
	}

	@Override
	public List<FinaceSum> shopSalesByDate(FinaceQuery query) {
		return mapper.selectShopSalesByDate(query);
	}

	@Override
	public List<FinaceSum> shopSales(FinaceQuery query) {
		return mapper.selectShopSales(query);
	}

	@Override
	public List<FinaceSum> shopSaleInterval(FinaceQuery query) {
		return mapper.selectShopSaleInterval(query);
	}

	@Override
	public List<FinaceSum> custPriceInterval(FinaceQuery query) {
		return mapper.selectCustPriceInterval(query);
	}

	@Override
	public List<FinaceSum> hotSaleProducts(FinaceQuery query) {
		return mapper.selectHotSaleProducts(query);
	}

	@Override
	public List<FinaceSum> productsTypeSale(FinaceQuery query) {
		return mapper.selectProductsTypeSale(query);
	}

	@Override
	public List<FinaceSum> productsSend(FinaceQuery query) {
		return mapper.selectProductsSend(query);
	}

	@Override
	public List<FinaceSum> productsClean(FinaceQuery query) {
		return mapper.selectProductsClean(query);
	}

	@Override
	public List<FinaceSum> lackProducts(FinaceQuery query) {
		return mapper.selectLackProducts(query);
	}

	@Override
	public BaseDao<FinaceSum, Long> getDao() {
		return null;
	}
	
}
