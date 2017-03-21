package com.linjia.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.MallProductStoreMapper;
import com.linjia.web.model.MallProductStore;
import com.linjia.web.model.ReMallProduct;
import com.linjia.web.service.MallProductStoreService;

@Service
@Transactional
public class MallProductStoreServiceImpl extends BaseServiceImpl<MallProductStore, Long> implements MallProductStoreService {
	
	@Resource
	private MallProductStoreMapper mapper;

	@Override
	public BaseDao<MallProductStore, Long> getDao() {
		return mapper;
	}

	@Override
	public int selectSafeQtyByMallAndPCode(String mallCode, String pCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mallCode", mallCode);
		map.put("pCode", pCode);
		Object res = mapper.selectSafeQtyByMallAndPCode(map);
		return res == null?0:(int)res;
	}

	@Override
	public Integer insertMallProduct(ReMallProduct mallProduct) {
		int num=mapper.insertMallProduct(mallProduct);
		return num;
	}

	@Override
	public Integer updateMallProduct(ReMallProduct mallProduct) {
		int num=mapper.updateMallProduct(mallProduct);
		return num;
	}

	@Override
	public Integer deleteMallProduct(ReMallProduct mallProduct) {
		int num=mapper.deleteMallProduct(mallProduct);
		return num;
	}

	@Override
	public int insertLeadInPro(List<MallProductStore> list) {
		return mapper.insertLeadInPro(list);
	}

	@Override
	public int updateBatchProducts(List<MallProductStore> list) {
		return mapper.updateBatchProducts(list);
	}
	

}
