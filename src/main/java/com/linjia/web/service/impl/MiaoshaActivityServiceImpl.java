package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants.MIAOSHA_PANIC_STATUS;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.web.dao.MiaoshaActivityMapper;
import com.linjia.web.dao.MiaoshaActivityProductMapper;
import com.linjia.web.model.MiaoshaActivityBase;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.model.User;
import com.linjia.web.query.MiaoshaActivityBaseQuery;
import com.linjia.web.query.MiaoshaActivityProductQuery;
import com.linjia.web.service.MiaoshaActivityService;

@Service
@Transactional
public class MiaoshaActivityServiceImpl extends BaseServiceImpl<MiaoshaActivityBase, Long> implements MiaoshaActivityService {

	@Resource
	private MiaoshaActivityMapper mapper;

	@Resource
	private MiaoshaActivityProductMapper miaoshaActivityProductMapper;

	@Override
	public BaseDao<MiaoshaActivityBase, Long> getDao() {
		return mapper;
	}

	@Override
	public MiaoshaActivityBase selectOne(MiaoshaActivityBaseQuery query) {
		return mapper.selectOne(query);
	}

	@Override
	public MiaoshaActivityBase insertMiaoshaBaseActivity(MiaoshaActivityBase miaoshaActivityBase) {
		String publishData = miaoshaActivityBase.getPublishDateStr();
		miaoshaActivityBase.setPublishDate(DateComFunc.strToDate(publishData,"yyyy-MM-dd"));
		int timeNode = miaoshaActivityBase.getTimeNode();
		String timeSolt = "09:00";
		if (timeNode == 2)
			timeSolt = "12:00";
		if (timeNode == 3)
			timeSolt = "15:00";
		if (timeNode == 4)
			timeSolt = "18:00";

		Date startT = DateComFunc.strToDate(publishData + timeSolt, "yyyy-MM-ddHH:mm");
		Date endT = DateComFunc.addHour(startT, 3);
		miaoshaActivityBase.setStartTime(startT);
		miaoshaActivityBase.setEndTime(endT);
		miaoshaActivityBase.setPanicBuyingStartTime(startT);
		miaoshaActivityBase.setPanicBuyingEndTime(endT);
		miaoshaActivityBase.setCreDate(new Date());
		miaoshaActivityBase.setUpdateDate(new Date());
		mapper.insertSelective(miaoshaActivityBase);
		return miaoshaActivityBase;
		// 插入参加活动的商品
		/*
		 * List<MiaoshaActivityProduct> list =
		 * miaoshaActivityBase.getMiaoshaActivityProductList(); if(list != null
		 * && list.size() > 0){ for(MiaoshaActivityProduct item : list){
		 * item.setShangouBaseId(miaoshaActivityBase.getId());
		 * item.setPanicBuyingStartTime(startT);
		 * item.setPanicBuyingEndTime(endT);
		 * miaoshaActivityProductMapper.insertSelective(item); } }
		 */
	}
	
	@Override
	public MiaoshaActivityBase updateMiaoshaBaseActivity(MiaoshaActivityBase miaoshaActivityBase) {
		String publishData = miaoshaActivityBase.getPublishDateStr();
		miaoshaActivityBase.setPublishDate(DateComFunc.strToDate(publishData,"yyyy-MM-dd"));
		int timeNode = miaoshaActivityBase.getTimeNode();
		String timeSolt = "09:00";
		if (timeNode == 2)
			timeSolt = "12:00";
		if (timeNode == 3)
			timeSolt = "15:00";
		if (timeNode == 4)
			timeSolt = "18:00";

		Date startT = DateComFunc.strToDate(publishData + timeSolt, "yyyy-MM-ddHH:mm");
		Date endT = DateComFunc.addHour(startT, 3);
		miaoshaActivityBase.setStartTime(startT);
		miaoshaActivityBase.setEndTime(endT);
		miaoshaActivityBase.setPanicBuyingStartTime(startT);
		miaoshaActivityBase.setPanicBuyingEndTime(endT);
		miaoshaActivityBase.setUpdateDate(new Date());
		boolean r = mapper.updateByPrimaryKeySelective(miaoshaActivityBase);
		
		//更新其相关活动商品的抢购时间
		if(r){
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("panicBuyingStartTime", startT);
			param.put("panicBuyingEndTime", endT);
			param.put("shangouBaseId", miaoshaActivityBase.getId());
			miaoshaActivityProductMapper.updatePanicBuyingTimeByBaseId(param);
		}
		return miaoshaActivityBase;
		// 插入参加活动的商品
		/*
		 * List<MiaoshaActivityProduct> list =
		 * miaoshaActivityBase.getMiaoshaActivityProductList(); if(list != null
		 * && list.size() > 0){ for(MiaoshaActivityProduct item : list){
		 * item.setShangouBaseId(miaoshaActivityBase.getId());
		 * item.setPanicBuyingStartTime(startT);
		 * item.setPanicBuyingEndTime(endT);
		 * miaoshaActivityProductMapper.insertSelective(item); } }
		 */
	}

	@Override
	public boolean insertMiaoshaProductActivity(MiaoshaActivityProduct miaoshaActivityProduct) {
		if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingStartTimeStr()))
			miaoshaActivityProduct.setPanicBuyingStartTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingEndTimeStr()))
			miaoshaActivityProduct.setPanicBuyingEndTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		
		miaoshaActivityProduct.setCreDate(new Date());
		miaoshaActivityProduct.setUpdateDate(new Date());
		int row = miaoshaActivityProductMapper.insertSelective(miaoshaActivityProduct);
		if (row == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<MiaoshaActivityBase> selectByPageList(MiaoshaActivityBaseQuery query) {
		// 活动状态
		String activityStatus = query.getActivityStatus();
		if (!Tools.isEmpty(activityStatus)) {
			query.setCurrentTime(new Date());
		}
		List<MiaoshaActivityBase> list = mapper.selectByPageList(query);
		if (list != null && list.size() > 0) {
			for (MiaoshaActivityBase item : list) {
				Date panicBuyingStartTime = item.getPanicBuyingStartTime();
				Date panicBuyingEndTime = item.getPanicBuyingEndTime();
				Date currentTime = new Date();
				int r1 = DateComFunc.compareDate(currentTime, panicBuyingStartTime);
				int r2 = DateComFunc.compareDate(currentTime, panicBuyingEndTime);
				if (r1 < 0)
					item.setActivityStatus("即将开始");
				if (r1 > 0 && r2 < 0)
					item.setActivityStatus("抢购中");
				if (r2 > 0)
					item.setActivityStatus("已结束");
			}
		}
		return list;
	}

	@Override
	public List<MiaoshaActivityProduct> selectProductListByBaseId(Long baseId) {
		MiaoshaActivityProductQuery query = new MiaoshaActivityProductQuery();
		query.setShangouBaseId(baseId);
		query.setStartIndex(0);
		query.setPageSize(100);

		return miaoshaActivityProductMapper.selectAllByBaseId(query);
	}

	@Override
	public boolean updateActivityProduct(MiaoshaActivityProduct miaoshaActivityProduct) {
		if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingStartTimeStr()))
			miaoshaActivityProduct.setPanicBuyingStartTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingEndTimeStr()))
			miaoshaActivityProduct.setPanicBuyingEndTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		
		miaoshaActivityProduct.setUpdateDate(new Date());
		return miaoshaActivityProductMapper.updateByPrimaryKeySelective(miaoshaActivityProduct);
	}

	@Override
	public boolean deleteActivityProduct(Long miaoshaProductId) {
		return miaoshaActivityProductMapper.deleteByPrimaryKey(miaoshaProductId);
	}

	@Override
	public int countByExample(MiaoshaActivityBaseQuery query) {
		return mapper.countByExample(query);
	}

}
