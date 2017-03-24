package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.web.model.Region;
import com.linjia.web.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域模块
 *
 * @author lixinling
 */
@Controller
@RequestMapping("/region")
public class RegionController extends BaseController {

    @Autowired
    private RegionServiceImpl regionServiceImpl;

    /**
     * 取得省级区域列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @return
     */
    @RequestMapping(value = "/getProvinceList")
    @ResponseBody
    public Object getProvinceList() {
        Map<String, Object> resMap = new HashMap<String, Object>();
        //查询一级区域列表
        List<Region> provinceList = regionServiceImpl.selectRegionByParentId(0);
        resMap.put("provinceList", provinceList);
        resMap.put("status", "ok");
        return resMap;
    }

    /**
     * 根据parentId查询区域列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/getRegionByParentId")
    @ResponseBody
    public Object getRegionByParentId(Integer parentId) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        List<Region> regionList = regionServiceImpl.selectRegionByParentId(parentId);
        resMap.put("regionList",regionList);
        resMap.put("status", "ok");
        return resMap;
    }


    
}
