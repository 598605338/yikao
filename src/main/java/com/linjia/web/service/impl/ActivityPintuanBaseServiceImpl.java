package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ActivityPintuanBaseMapper;
import com.linjia.web.dao.ProductSpecMapper;
import com.linjia.web.model.ActivityPintuanBase;
import com.linjia.web.model.ProductSpec;
import com.linjia.web.query.ActivityPintuanBaseQuery;
import com.linjia.web.service.ActivityPintuanBaseService;

@Service
@Transactional
public class ActivityPintuanBaseServiceImpl extends BaseServiceImpl<ActivityPintuanBase, Long> implements ActivityPintuanBaseService {
	
	@Resource
	private ActivityPintuanBaseMapper mapper;
	
	@Resource
	private ProductSpecMapper psmapper;
	
	@Override
	public BaseDao<ActivityPintuanBase, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ActivityPintuanBase> selectPintuanProductList(ActivityPintuanBaseQuery query) {
		return mapper.selectPintuanProductList(query);
	}

	@Override
	public ActivityPintuanBase selectDetailById(int id) {
		return mapper.selectDetailById(id);
	}

	@Override
	public boolean insertPtBase(ActivityPintuanBase base) {
		boolean flag=mapper.insertPtBase(base);
//		if(flag){
//			int f=psmapper.insertProductSpec(base.getProductSpec());
//			if(f<1){
//				flag=false;
//			}
//		}else{
//			flag=false;
//		}
		return flag;
	}

	@Override
	public List<ActivityPintuanBase> selectPtListManage(
			ActivityPintuanBaseQuery query) {
		return mapper.selectPtListManage(query);
	}
	
	@Override
	public Integer selectPtListManageNum(
			ActivityPintuanBaseQuery query) {
		return mapper.selectPtListManageNum(query);
	}

	@Override
	public boolean delPtProducts(int id) {
		return mapper.delPtProducts(id);
	}

	@Override
	public boolean updateBaseProduct(ActivityPintuanBase base) {
		boolean flag=mapper.updateBaseProduct(base);
//		if(flag){
//			if(base.isIfUpdSpec()){
//				ProductSpec ps=psmapper.selectQuantityInfoByPid(base.getProductId());
//				int f=0;
//				if(ps!=null){
//					f=psmapper.updateProductSpec(base.getProductSpec());
//				}else{
//					f=psmapper.insertProductSpec(base.getProductSpec());
//				}
//				if(f<1){
//					flag=false;
//				}
//			}
//		}else{
//			flag=false;
//		}
		return flag;
	}

	
}
