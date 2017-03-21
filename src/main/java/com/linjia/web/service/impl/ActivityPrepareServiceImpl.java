package com.linjia.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.DateComFunc;
import com.linjia.web.dao.ActivityPrepareMapper;
import com.linjia.web.model.ActivityPrepare;
import com.linjia.web.query.ActivityPrepareQuery;
import com.linjia.web.service.ActivityPrepareService;

@Service
@Transactional
public class ActivityPrepareServiceImpl extends BaseServiceImpl<ActivityPrepare, Long> implements ActivityPrepareService {

	@Resource
	private ActivityPrepareMapper mapper;

	@Override
	public BaseDao<ActivityPrepare, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ActivityPrepare> selectByPageList(ActivityPrepareQuery query) {
		List<ActivityPrepare> list = mapper.selectByPageList(query);

		if (list != null && list.size() > 0) {
			for (ActivityPrepare item : list) {
				Date activityStartTime = item.getActivityStartTime();
				Date activityEndTime = item.getActivityEndTime();
				Date currentTime = new Date();
				
				// 0、未开始；1、销售中；2、已售罄；3、已结束 
				if(DateComFunc.compareDate(currentTime, activityStartTime) < 0)
					item.setActivityStatus(0);
				if(DateComFunc.compareDate(currentTime, activityStartTime) > 0 && DateComFunc.compareDate(currentTime, activityEndTime) < 0)
					item.setActivityStatus(1);
				if(item.getActivityQuantity() <= 0)
					item.setActivityStatus(2);
				if(DateComFunc.compareDate(currentTime, activityEndTime) > 0)
					item.setActivityStatus(3);
			}
		}
		return list;
	}

	@Override
	public int countByExample(ActivityPrepareQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public Long selectMaxSortIndex() {
		return mapper.selectMaxSortIndex();
	}
}
