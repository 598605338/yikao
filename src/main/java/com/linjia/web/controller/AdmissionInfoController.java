package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.*;
import com.linjia.web.query.AdmissionInfoQuery;
import com.linjia.web.query.SpecialtyQuery;
import com.linjia.web.service.AdmissionBatchService;
import com.linjia.web.service.AdmissionInfoService;
import com.linjia.web.service.CollegeService;
import com.linjia.web.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 录取信息模块
 *
 * @author lixinling
 */
@Controller
@RequestMapping("/admissionInfo")
public class AdmissionInfoController extends BaseController {

    @Autowired
    private CollegeService collegeService;
    @Autowired
    private AdmissionInfoService admissionInfoServiceImpl;
    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private AdmissionBatchService admissionBatchService;



    /**
     * 取得录取信息列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param query
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/select")
    public String getAdmissionInfoList(AdmissionInfoQuery query, Model model, String message) throws UnsupportedEncodingException {

        List<AdmissionInfo> admissionInfoList = admissionInfoServiceImpl.selectBySerach(query);

        //查询列表总数量
        int pnums = admissionInfoServiceImpl.countByExample(query);
        model.addAttribute("query", query);
        model.addAttribute("admissionInfoList", admissionInfoList);
        model.addAttribute("pnums", pnums);
        if (!Tools.isEmpty(message))
            model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

        return "admission_info/admission_info_list";
    }

    /**
     * 添加录取信息
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param admissionInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String addAdmissionInfo(AdmissionInfo admissionInfo, Model model) {
        if (admissionInfo == null || admissionInfo.getCollegeId() == null || admissionInfo.getCollegeId().intValue() == 0) {
            model.addAttribute("message", "请选择正确的院校");
            return "admission_info/admission_info_add";
        }
        try {
            admissionInfoServiceImpl.insert(admissionInfo);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "admission_info/admission_info_add";
        }
        return "redirect:/admissionInfo/select";
    }

    /**
     * 跳转到添加录取信息页
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {
        //查询院校和批次列表
        getPrepareData(model);
        //查询科目列表
        /*SpecialtyQuery query = new SpecialtyQuery();
        query.setExportFlag(0);
        List<Specialty> specialtyList = specialtyService.selectBySerach(query);
        model.addAttribute("specialtyList", specialtyList);*/

        return "admission_info/admission_info_add";
    }

    /**
     * 删除录取信息
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param model
     */
    @RequestMapping(value = "/deleteCollege")
    public String deleteCollege(String ids, Model model) {
        if (ids == null) {
            model.addAttribute("message", "请选择要删除的录取信息");
            return "college/college_list";
        }
        try {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                collegeService.delete(Long.valueOf(id));
            }
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "redirect:/admissionInfo/select";
        }
        return "redirect:/admissionInfo/select";
    }

    /**
     * 跳转到编辑录取规则页
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/toEdit")
    public String toEdit(Long id, Model model) {
        if (id == null || id.longValue() == 0) {
            model.addAttribute("message", "请选择要编辑的记录!");
            return "admission_info/admission_info_list";
        }
        AdmissionInfo admissionInfo = admissionInfoServiceImpl.selectById(id);
        model.addAttribute("admissionInfo", admissionInfo);

        //查询院校和批次列表
        getPrepareData(model);

        //查询科目列表
        /*SpecialtyQuery query = new SpecialtyQuery();
        query.setExportFlag(0);
        List<Specialty> specialtyList = specialtyService.selectBySerach(query);
        model.addAttribute("specialtyList", specialtyList);*/
        return "admission_info/admission_info_edit";
    }

    /**
     * 编辑录取信息
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param admissionInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String editAdmissionInfo(AdmissionInfo admissionInfo, Model model) {
        if (admissionInfo == null || admissionInfo.getCollegeId() == null || admissionInfo.getCollegeId().intValue() == 0) {
            model.addAttribute("message", "请填写正确的编辑信息");
            return "admission_info/admission_info_edit";
        }
        try {
            admissionInfoServiceImpl.update(admissionInfo);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "admission_info/admission_info_edit";
        }
        return "redirect:/admissionInfo/select";
    }

    /**
     * 准备数据
     *
     * @author: lixinling
     * @date: 2017/3/24 16:40
     * @param: [model]
     * @return: void
     */
    private void getPrepareData(Model model) {

        //查询院校列表
        List<College> collegeList = collegeService.selectCollegeDownList();
        model.addAttribute("collegeList", collegeList);

        //查询批次列表
        List<AdmissionBatch> batchList = admissionBatchService.selectAdmissionBatchDownList();
        model.addAttribute("batchList", batchList);

        //查询录取规则列表
        /*if(cityId != null && cityId.intValue() > 0){
            List<Region> countyList = regionServiceImpl.selectRegionByParentId(cityId);
            model.addAttribute("countyList", countyList);
        }*/
    }

    /**
     * 根据选择的院校查询科目和录取规则列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param collegeId
     * @return
     */
    @RequestMapping(value = "/querySpecAndRuleListByCollegeId")
    @ResponseBody
    public Object querySpecAndRuleListByCollegeId(Long collegeId) {
        Map<String,Object> resMap = new HashMap<String,Object>();
        if (collegeId == null || collegeId.intValue() == 0) {
            Util.writeError(resMap);
            return resMap;
        }
        try {
            College college = collegeService.selectById(collegeId);
            String specIds = college.getContainSpecialtyIds();
            if(!Tools.isEmpty(specIds)) {
                List<Specialty> specialtyList = specialtyService.selectDownListByIds(specIds.split(","));
                resMap.put("specialtyList",specialtyList);
            }
            List<AdmissionRule> admissionRuleList = admissionInfoServiceImpl.selectAdmiRuleDownListByCollegeId(collegeId);
            resMap.put("admissionRuleList",admissionRuleList);

            Util.writeOk(resMap);
        } catch (Exception e) {
            Util.writeError(resMap);
            Util.writeFail(resMap);
            return resMap;
        }
        return resMap;
    }


}
