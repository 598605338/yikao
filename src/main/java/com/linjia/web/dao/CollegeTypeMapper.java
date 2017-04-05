package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.CollegeType;
import com.linjia.web.query.CollegeTypeQuery;

import java.util.List;

public interface CollegeTypeMapper extends BaseDao<CollegeType, Long> {


    /**
     * 根据query查询院校类型列表
     * lixinling
     * 2016年8月22日 下午2:17:39
     * @param query
     * @return
     */
    List<CollegeType> selectBySerach(CollegeTypeQuery query);

    /**
     * 根据query查询院校类型列表总数量
     * lixinling
     * 2016年8月22日 下午2:17:39
     * @param query
     * @return
     */
    int countByExample(CollegeTypeQuery query);
}