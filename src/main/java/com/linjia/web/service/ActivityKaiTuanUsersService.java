package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.ActivityKaiTuanUsers;
import com.linjia.web.model.ActivityPintuanBase;
import com.linjia.web.query.ActivityKaiTuanUsersQuery;

public interface ActivityKaiTuanUsersService extends BaseService<ActivityKaiTuanUsers, Long>{
	
	/**
	 * 插入单个开团用户信息
	 * xiangsy
	 * 2016年7月20日 下午10:55:33
	 * @param query
	 * @return
	 */
	int insertOneKaiTuanUser(ActivityKaiTuanUsers query);
	
	/**
	 * 更新单个开团用户信息
	 * xiangsy
	 * 2016年7月20日 下午10:55:33
	 * @param query
	 * @return
	 */
	int updateOneKaiTuanUser(ActivityKaiTuanUsers query);
	
	/**
	 * 查询开团用户信息
	 * xiangsy
	 * 2016年7月20日 下午11:15:33
	 * @param query
	 * @return
	 */
	List<ActivityKaiTuanUsers> selectKaiTuanUser(ActivityKaiTuanUsersQuery query);
}
