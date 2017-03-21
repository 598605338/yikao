package com.linjia.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.web.dao.ActivityAdvertiseMapper;
import com.linjia.web.dao.AdvertisePositionMapper;
import com.linjia.web.dao.BannerInfoMapper;
import com.linjia.web.model.ActivityAdvertise;
import com.linjia.web.model.AdvertisePosition;
import com.linjia.web.model.BannerInfo;
import com.linjia.web.service.AdvertiseManageService;

@Service
@Transactional
public class AdvertiseManageServiceImpl  implements  AdvertiseManageService {
	
	@Resource
	private AdvertisePositionMapper advertisePositionMapper;
	
	@Resource
	private BannerInfoMapper bannerInfoMapper;
	
	@Resource
	private ActivityAdvertiseMapper activityAdvertiseMapper;

	@Override
	public boolean insertAdvInfo(AdvertisePosition info) {
		return advertisePositionMapper.insertAdvInfo(info);
	}

	@Override
	public boolean updateAdvInfoById(AdvertisePosition info) {
		return advertisePositionMapper.updateAdvInfoById(info);
	}

	@Override
	public boolean deleteAdvInfoById(int id) {
		return advertisePositionMapper.deleteAdvInfoById(id);
	}

	@Override
	public AdvertisePosition selectAdvInfoById(int id) {
		return advertisePositionMapper.selectAdvInfoById(id);
	}

	@Override
	public List<AdvertisePosition> selectAdvInfoAll() {
		return advertisePositionMapper.selectAdvInfoAll();
	}

	@Override
	public boolean insertBannerInfo(BannerInfo info) {
		boolean b=bannerInfoMapper.insertBannerInfo(info);
		//更新广告表数据
		if(b){
			AdvertisePosition adinfo=new AdvertisePosition();
			adinfo.setNums(1);
			adinfo.setId(info.getAd_id());
			boolean m=advertisePositionMapper.updateAdvInfoById(adinfo);
			if(!m){
				b=false;
			}
		}else{
			b=false;
		}
		return b;
	}

	@Override
	public boolean updateBannerInfoById(BannerInfo info) {
		return bannerInfoMapper.updateBannerInfoById(info);
	}

	@Override
	public boolean deleteBannerInfoById(int id) {
		return bannerInfoMapper.deleteBannerInfoById(id);
	}

	@Override
	public BannerInfo selectBannerInfoById(int id) {
		return bannerInfoMapper.selectBannerInfoById(id);
	}

	@Override
	public List<BannerInfo> selectBannerInfoAll(Map<String,Object> map) {
		return bannerInfoMapper.selectBannerInfoAll(map);
	}

	@Override
	public boolean insertAyAdvInfo(ActivityAdvertise info) {
		return activityAdvertiseMapper.insertAyAdvInfo(info);
	}

	@Override
	public boolean updateAyAdvInfoById(ActivityAdvertise info) {
		return activityAdvertiseMapper.updateAyAdvInfoById(info);
	}

	@Override
	public boolean deleteAyAdvInfoById(int id) {
		return activityAdvertiseMapper.deleteAyAdvInfoById(id);
	}

	@Override
	public ActivityAdvertise selectAyAdvInfoById(int id) {
		return activityAdvertiseMapper.selectAyAdvInfoById(id);
	}

	@Override
	public List<ActivityAdvertise> selectAyAdvInfoAll() {
		return activityAdvertiseMapper.selectAyAdvInfoAll();
	}

	@Override
	public boolean updBatchBaseInfos(List<BannerInfo> list) {
		return bannerInfoMapper.updBatchBaseInfos(list);
	}
	

}
