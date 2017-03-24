package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.Region;

import java.util.List;

public interface RegionService extends BaseService<Region, Long>{
	
	/**
	 * 根据query查询院校列表
	 * lixinling 
	 * 2016年8月22日 下午2:17:39
	 * @param parentId
	 * @return
	 */
	List<Region> selectRegionByParentId(Integer parentId);
	

}
