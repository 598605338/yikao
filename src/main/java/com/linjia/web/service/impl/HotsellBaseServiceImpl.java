package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.Tools;
import com.linjia.web.dao.HotsellBaseMapper;
import com.linjia.web.dao.HotsellProductMapper;
import com.linjia.web.model.ActivityProduct;
import com.linjia.web.model.HotsellBase;
import com.linjia.web.model.HotsellProduct;
import com.linjia.web.model.Product;
import com.linjia.web.query.HotsellBaseQuery;
import com.linjia.web.service.HotsellService;

@Service
@Transactional
public class HotsellBaseServiceImpl extends BaseServiceImpl<HotsellBase, Long> implements HotsellService {

	@Resource
	private HotsellBaseMapper mapper;

	@Resource
	private HotsellProductMapper hotsellProductMapper;

	@Override
	public BaseDao<HotsellBase, Long> getDao() {
		return mapper;
	}

	@Override
	public List<HotsellBase> selectByPageList(HotsellBaseQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public Integer totalCountByPage(HotsellBaseQuery query) {
		return mapper.totalCountByPage(query);
	}

	@Override
	public int insertBatch(List<Product> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return hotsellProductMapper.insertBatch(map);
	}

	@Override
	public int insertActivity(HotsellBase model) {
		int row = mapper.insertSelective(model);

		// 插入活动商品数据
		if (row == 1 && !Tools.isEmpty(model.getActProducts())) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<ActivityProduct> productList = JSONArray.parseArray(model.getActProducts(), ActivityProduct.class);
			map.put("list", productList);
			map.put("baseId", model.getId());
			map.put("createTime", new Date());
			map.put("updateTime", new Date());
			hotsellProductMapper.insertBatch(map);
		}
		return row;
	}

	@Override
	public List<HotsellProduct> selectByBaseId(Integer baseId) {
		return hotsellProductMapper.selectByBaseId(baseId);
	}

	@Override
	public boolean updateHotsell(HotsellBase model) {
		boolean flag = false;
		flag = mapper.updateByPrimaryKeySelective(model);

		// 先删除后插入活动商品数据
		if (flag && !Tools.isEmpty(model.getActProducts())) {
			
			hotsellProductMapper.deleteByBaseId(model.getId());
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ActivityProduct> productList = JSONArray.parseArray(model.getActProducts(), ActivityProduct.class);
			map.put("list", productList);
			map.put("baseId", model.getId());
			map.put("updateTime", new Date());
			hotsellProductMapper.insertBatch(map);
		}
		return false;
	}

	@Override
	public boolean updateStatusByPrimaryKey(Integer id,Integer online) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("online", online);
		return mapper.updateStatusByPrimaryKey(param);
	}

}
