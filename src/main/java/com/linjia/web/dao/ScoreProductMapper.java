package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.ScoreProduct;
import com.linjia.web.query.ScoreProductQuery;

public interface ScoreProductMapper extends BaseDao<ScoreProduct, Long> {
	
	/**
	 * 分页取得列表数据
	 * lixinling 
	 * 2016年9月8日 下午7:51:16
	 * @param query
	 * @return
	 */
	List<ScoreProduct> selectByPageList(ScoreProductQuery query);
	
	/**
	 * 分页取得列表数据总数量
	 * lixinling 
	 * 2016年9月8日 下午7:51:16
	 * @param query
	 * @return
	 */
	int countByExample(ScoreProductQuery query);
	
	/**
	 * 更新上下架状态
	 * lixinling 
	 * 2016年9月8日 下午7:51:16
	 * @param query
	 * @return
	 */
	int updateStatusByPrimaryKey(ScoreProduct model);

	/**
	 * 查询最大的SortIndex
	 * 
	 * lixinling 
	 * 2016年11月22日 上午10:45:24
	 * @param query
	 * @return
	 */
	Long selectMaxSortIndex();
}