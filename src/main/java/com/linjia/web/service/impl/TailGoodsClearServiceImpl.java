package com.linjia.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.DateComFunc;
import com.linjia.web.dao.TailGoodsClearMapper;
import com.linjia.web.model.TailGoodsClear;
import com.linjia.web.query.TailGoodsClearQuery;
import com.linjia.web.service.TailGoodsClearService;

@Service
@Transactional
public class TailGoodsClearServiceImpl extends BaseServiceImpl<TailGoodsClear, Long> implements TailGoodsClearService {
	
	@Resource
	private TailGoodsClearMapper mapper;

	@Override
	public BaseDao<TailGoodsClear, Long> getDao() {
		return mapper;
	}

	@Override
	public int updateStatusByPrimaryKey(TailGoodsClear model) {
		return mapper.updateStatusByPrimaryKey(model);
	}

	@Override
	public List<TailGoodsClear> selectByPageList(TailGoodsClearQuery query) {
		List<TailGoodsClear> list = mapper.selectByPageList(query);
		if(list != null && !list.isEmpty()){
			Date currentDate = new Date();
			for(TailGoodsClear obj : list){
				if(DateComFunc.compareDate(currentDate , obj.getPublishEndTime()) > 0){
					obj.setActivityStatus(3);
				}
			}
		}
		return list;
	}

	@Override
	public int countByExample(TailGoodsClearQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public Long selectMaxSortIndex() {
		return mapper.selectMaxSortIndex();
	}

	

}
