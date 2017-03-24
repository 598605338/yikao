package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.College;
import com.linjia.web.query.CollegeQuery;

import java.util.List;


/**
 * The interface College mapper.
 */
public interface CollegeMapper extends BaseDao<College, Long> {

    /**
     * 查询院校列表
     *
     * lixinling
     * 2017/3/24 14:17
     * @param:
     * @return:
     */
    List<College> selectBySearch(CollegeQuery query);

    /**
     * 查询院校总数
     *
     * lixinling
     * 2017/3/24 14:17
     * @param:
     * @return:
     */
    int countByExample(CollegeQuery query);
}