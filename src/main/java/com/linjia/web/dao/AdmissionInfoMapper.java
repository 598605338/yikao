package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.model.AdmissionInfo;
import com.linjia.web.query.AdmissionBatchQuery;
import com.linjia.web.query.AdmissionInfoQuery;

import java.util.List;

public interface AdmissionInfoMapper extends BaseDao<AdmissionInfo, Long> {

    /**
     * 根据query查询录取信息列表
     * lixinling
     * 2016年8月22日 下午2:17:39
     * @param query
     * @return
     */
    List<AdmissionInfo> selectBySerach(AdmissionInfoQuery query);

    /**
     * 根据query查询录取信息列表总数量
     * lixinling
     * 2016年8月22日 下午2:17:39
     * @param query
     * @return
     */
    int countByExample(AdmissionInfoQuery query);
}