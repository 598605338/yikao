package com.linjia.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.RandUtils;
import com.linjia.web.dao.TakeGoodsCodeGenerateMapper;
import com.linjia.web.model.TakeGoodsCodeGenerate;
import com.linjia.web.service.TakeGoodsCodeGenerateService;

@Service
@Transactional
public class TakeGoodsCodeGenerateServiceImpl extends BaseServiceImpl<TakeGoodsCodeGenerate, Long> implements TakeGoodsCodeGenerateService {
	
	@Resource
	private TakeGoodsCodeGenerateMapper mapper;

	@Override
	public BaseDao<TakeGoodsCodeGenerate, Long> getDao() {
		return mapper;
	}

	@Override
	public int selectCount(TakeGoodsCodeGenerate model) {
		return mapper.selectCount(model);
	}

	@Override
	public TakeGoodsCodeGenerate generateCode(String mallCode) {
		TakeGoodsCodeGenerate model = new TakeGoodsCodeGenerate();
		int count = 0;
		do{
			String takeGoodsCode = RandUtils.getTakeGoodsCode();
			model.setMallCode(mallCode);
			model.setTakeGoodsCode(takeGoodsCode);
			count = mapper.selectCount(model);
			}while(count == 1);
		
		mapper.insertSelective(model);
		return model;
	}

	
	
}
