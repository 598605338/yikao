package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.Region;

import java.util.List;

public interface RegionMapper  extends BaseDao<Region, Long> {

    /**
     * 根据父Id查询子区域列表信息(parentId =0时为顶级区域列表)
     *
     * @author:  lixinling
     * @date:  2017/3/24 16:09
     * @param:  [parentId]
     * @return:  List<Region>
     */
    List<Region> selectRegionByParentId(Integer parentId);
}