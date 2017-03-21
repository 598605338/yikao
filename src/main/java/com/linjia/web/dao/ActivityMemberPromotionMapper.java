package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ActivityMemberPromotion;
import com.linjia.web.query.ActivityMemberPromotionQuery;

public interface ActivityMemberPromotionMapper extends BaseDao<ActivityMemberPromotion, Long> {
	
	/**
	 * 分页取得
	 * lixinling 
	 * 2016年9月13日 下午7:49:10
	 * @param query
	 * @return
	 */
	List<ActivityMemberPromotion> selectByPageList(ActivityMemberPromotionQuery query);
	
	/**
	 * 取得分页数据总数量
	 * lixinling 
	 * 2016年9月13日 下午7:49:10
	 * @param query
	 * @return
	 */
	int countByExample(ActivityMemberPromotionQuery query);
	
	/**
	 * 更新启用状态
	 * lixinling 
	 * 2016年9月13日 下午7:49:10
	 * @param query
	 * @return
	 */
	int updateStatusByPrimaryKey(Map<String,Object> map);
	
	/**
	 * 同一时间段内是否存在重复排期 
	 * lixinling 
	 * 2016年9月13日 下午7:49:10
	 * @param query
	 * @return
	 */
	int selectExistsSameTime(Map<String,Object> map);
}