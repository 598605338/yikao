package com.linjia.web.dao;


import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.Specialty;
import com.linjia.web.query.SpecialtyQuery;

import java.util.List;

public interface SpecialtyMapper extends BaseDao<Specialty, Long> {
    /**
     * 根据query查询科目列表
     * lixinling
     * 2016年8月22日 下午2:17:39
     * @param query
     * @return
     */
    List<Specialty> selectBySerach(SpecialtyQuery query);

    /**
     * 根据query查询科目列表总数量
     * lixinling
     * 2016年8月22日 下午2:17:39
     * @param query
     * @return
     */
    int countByExample(SpecialtyQuery query);
}

