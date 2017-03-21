package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.web.dao.ActivityInfoMapper;
import com.linjia.web.dao.ActivityProductMapper;
import com.linjia.web.dao.ActivityTradeProductMapper;
import com.linjia.web.model.ActivityInfo;
import com.linjia.web.model.ActivityProduct;
import com.linjia.web.model.ActivityTradeProduct;
import com.linjia.web.query.ActivityInfoQuery;
import com.linjia.web.service.ActivityPromotionService;

@Service
@Transactional
public class ActivityPromotionServiceImpl  implements  ActivityPromotionService {
	
	@Resource
	private ActivityInfoMapper activityInfoMapper;
	
	@Resource
	private ActivityProductMapper activityProductMapper;
	
	@Resource
	private ActivityTradeProductMapper activityTradeProductMapper;

	@Override
	public boolean insertActInfo(ActivityInfo info) {
		boolean flag=false;
		info.setCreate_time(new Date());
		String actpro=info.getActProducts();
		if(actpro!=null&&(!actpro.isEmpty())){
			info.setSelector_goods(1);
		}else{
			info.setSelector_goods(0);
		}
		flag=activityInfoMapper.insertActInfo(info);
		if(flag){
			//插入活动商品
			List<ActivityProduct> ll=info.getProducts();
			if(ll!=null&&ll.size()>0){
				for (ActivityProduct activityProduct : ll) {
					activityProduct.setActivity_id(info.getActivity_id());
				}
				boolean b=activityProductMapper.insertBatchActProducts(ll);
				if(!b){
					flag=false;
				}
			}
			//插入换购商品
			List<ActivityTradeProduct> lltrade=info.getTradeProducts();
			if(lltrade!=null&&lltrade.size()>0){
				for (ActivityTradeProduct activityTradeProduct : lltrade) {
					activityTradeProduct.setActivity_id(info.getActivity_id());
				}
				boolean f=activityTradeProductMapper.insertBatActTradeProducts(lltrade);
				if(!f){
					flag=false;
				}
			}
		}else{
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean updateActInfoById(ActivityInfo info) {
		info.setUpdate_time(new Date());
		boolean flag=false;
		info.setUpdate_time(new Date());
		String actpro=info.getActProducts();
		if(actpro!=null){
			if(!actpro.isEmpty()){
				info.setSelector_goods(1);
			}else{
				info.setSelector_goods(0);
			}
		}
		flag=activityInfoMapper.updateActInfoById(info);
		if(flag&&actpro!=null){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("activity_id", info.getActivity_id());
			//插入活动商品
			List<ActivityProduct> ll=info.getProducts();
			if(ll!=null&&ll.size()>0){
				for (ActivityProduct activityProduct : ll) {
					activityProduct.setActivity_id(info.getActivity_id());
				}
				List<ActivityProduct> plist=activityProductMapper.selectActProductAll(map);
				boolean ad=false;
				if(plist!=null&&plist.size()>0){
					ad=activityProductMapper.deleteActProductByActId(info.getActivity_id());
					if(!ad){
						flag=false;
					}
				}else{
					ad=true;
				}
				if(ad){
					boolean b=activityProductMapper.insertBatchActProducts(ll);
					if(!b){
						flag=false;
					}
				}else{
					flag=false;
				}
			}
			//插入换购商品
			List<ActivityTradeProduct> lltrade=info.getTradeProducts();
			if(lltrade!=null&&lltrade.size()>0){
				for (ActivityTradeProduct activityTradeProduct : lltrade) {
					activityTradeProduct.setActivity_id(info.getActivity_id());
				}
				List<ActivityTradeProduct> plist=activityTradeProductMapper.selectActTradeProAll(map);
				boolean am=false;
				if(plist!=null&&plist.size()>0){
					am=activityTradeProductMapper.deleteActTradeProByActId(info.getActivity_id());
					if(!am){
						flag=false;
					}
				}else{
					am=true;
				}
				if(am){
					boolean f=activityTradeProductMapper.insertBatActTradeProducts(lltrade);
					if(!f){
						flag=false;
					}
				}else{
					flag=false;
				}
			}
		}else{
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean deleteActInfoById(int activity_id) {
		boolean f=activityInfoMapper.deleteActInfoById(activity_id);
		 if(f){
			 //查询是否有活动商品
			 int nump=activityProductMapper.selectActProNum(activity_id);
			 boolean am=false;
			 if(nump>0){
				 am=activityProductMapper.deleteActProductByActId(activity_id);
			 }else{
				 am=true;
			 }
			 
			 if(!am){
				 f=false; 
			 }else{
				 //查询是否有兑换商品
				 int num=activityTradeProductMapper.selectActTraNum(activity_id);
				 if(num>0){
					 boolean fpm=activityTradeProductMapper.deleteActTradeProByActId(activity_id);
					 if(!fpm){
						 f=false;  
					 }
				 }
			 }
		 }
		 return f;
	}

	@Override
	public ActivityInfo selectActInfoById(int activity_id) {
		return activityInfoMapper.selectActInfoById(activity_id);
	}

	@Override
	public List<ActivityInfo> selectActInfoAll(ActivityInfoQuery query) {
		return activityInfoMapper.selectActInfoAll(query);
	}

	@Override
	public boolean insertActProduct(ActivityProduct info) {
		info.setCreate_time(new Date());
		return activityProductMapper.insertActProduct(info);
	}

	@Override
	public boolean updateActProductById(ActivityProduct info) {
		info.setUpdate_time(new Date());
		return activityProductMapper.updateActProductById(info);
	}

	@Override
	public boolean deleteActProductById(int id) {
		return activityProductMapper.deleteActProductById(id);
	}

	@Override
	public ActivityProduct selectActProductById(int id) {
		return activityProductMapper.selectActProductById(id);
	}

	@Override
	public List<ActivityProduct> selectActProductAll(Map<String, Object> map) {
		return activityProductMapper.selectActProductAll(map);
	}

	@Override
	public boolean insertActTradePro(ActivityTradeProduct info) {
		info.setCreate_time(new Date());
		return activityTradeProductMapper.insertActTradePro(info);
	}

	@Override
	public boolean updateActTradeProById(ActivityTradeProduct info) {
		info.setUpdate_time(new Date());
		return activityTradeProductMapper.updateActTradeProById(info);
	}

	@Override
	public boolean deleteActTradeProById(int id) {
		return activityTradeProductMapper.deleteActTradeProById(id);
	}

	@Override
	public ActivityTradeProduct selectActTradeProById(int id) {
		return activityTradeProductMapper.selectActTradeProById(id);
	}

	@Override
	public List<ActivityTradeProduct> selectActTradeProAll(
			Map<String, Object> map) {
		return activityTradeProductMapper.selectActTradeProAll(map);
	}

}
