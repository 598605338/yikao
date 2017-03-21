package com.linjia.web.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.MallMasterMapper;
import com.linjia.web.model.MallMaster;
import com.linjia.web.model.ReMallProduct;
import com.linjia.web.query.MallMasterQuery;
import com.linjia.web.query.ReMallProductQuery;
import com.linjia.web.service.MallMasterService;

@Service
@Transactional
public class MallMasterServiceImpl extends BaseServiceImpl<MallMaster, Long> implements MallMasterService {
	
	@Resource
	private MallMasterMapper mapper;

	@Override
	public BaseDao<MallMaster, Long> getDao() {
		return mapper;
	}

	@Override
	public MallMaster selectByMallCode(String mallCode) {
		return mapper.selectByMallCode(mallCode);
	}

	@Override
	public BigDecimal selectSendPriceByMallCode(String mallCode) {
		return mapper.selectSendPriceByMallCode(mallCode);
	}

	@Override
	public List<MallMaster> selectSendPriceByRegion(MallMasterQuery query) {
		return mapper.selectSendPriceByRegion(query);
	}

	@Override
	public boolean insertMallMaster(MallMaster mallMaster) {
		return mapper.insertMallMaster(mallMaster);
	}
	
	@Override
	public List<ReMallProduct> selectMallProduct(ReMallProductQuery query) {
		List<ReMallProduct> list=mapper.selectMallProduct(query);
		return list;
	}

	@Override
	public Integer selectMallNum() {
		return mapper.selectMallNum();
	}

	@Override
	public Integer selectProductNum(ReMallProductQuery query) {
		return mapper.selectProductNum(query);
	}

	@Override
	public List<String> selectMallCodes() {
		return mapper.selectMallCodes();
	}

	@Override
	public Integer selectSendPriceByRegionNum(MallMasterQuery query) {
		return mapper.selectSendPriceByRegionNum(query);
	}

	@Override
	public boolean updateMallById(MallMaster mallMaster) {
		return mapper.updateMallById(mallMaster);
	}

	@Override
	public boolean updateMallByCode(MallMaster mallMaster) {
		return mapper.updateMallByCode(mallMaster);
	}

	@Override
	public boolean deleteMall(String mallCode) {
		return mapper.deleteMall(mallCode);
	}
}
