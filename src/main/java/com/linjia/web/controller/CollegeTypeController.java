package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.CollegeType;
import com.linjia.web.query.CollegeTypeQuery;
import com.linjia.web.service.CollegeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 院校模块
 *
 * @author lixinling
 */
@Controller
@RequestMapping("/collegeType")
public class CollegeTypeController extends BaseController {

    @Autowired
    private CollegeTypeService collegeTypeService;


    /**
     * 取得院校类型列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param query
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/select")
    public String getCollegeTypeList(CollegeTypeQuery query, Model model, String message) throws UnsupportedEncodingException {

        if(!Tools.isEmpty(query.getName()))
            query.setNameQuery("%"+query.getName()+"%");
        List<CollegeType> collegeTypeList = collegeTypeService.selectBySerach(query);

        //查询列表总数量
        int pnums = collegeTypeService.countByExample(query);
        model.addAttribute("query", query);
        model.addAttribute("collegeTypeList",collegeTypeList);
        model.addAttribute("pnums", pnums);
        if (!Tools.isEmpty(message))
            model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

        return "college_type/college_type_list";
    }

    /**
     * 添加院校类型
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param collegeType
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String addCollegeTypeInfo(CollegeType collegeType, Model model) {
        if (collegeType == null || Tools.isEmpty(collegeType.getName())) {
            model.addAttribute("message", "请填写正确的院校类型名称");
            return "college_type/college_type_add";
        }
        try {
            collegeTypeService.insert(collegeType);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "college_type/college_type_add";
        }
        return "redirect:/collegeType/select";
    }

    /**
     * 跳转到添加院校分类页
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {

        return "college_type/college_type_add";
    }

    /**
     * 删除院校分类
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param model
     */
    @RequestMapping(value = "/deleteCollegeType")
    public String deleteCollegeType(String ids, Model model) {
        if (ids == null) {
            model.addAttribute("message", "请选择要删除的院校类型");
            return "college_type/college_type_list";
        }
        try {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                collegeTypeService.delete(Long.valueOf(id));
            }
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "redirect:/collegeType/select";
        }
        return "redirect:/collegeType/select";
    }

    /**
     * 跳转到编辑院校分类页
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
            return "college_type/college_type_list";
        }
        CollegeType collegeType = collegeTypeService.selectById(id);
        model.addAttribute("collegeType",collegeType);
        return "college_type/college_type_edit";
    }

    /**
     * 编辑院校
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param collegeType
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String editCollegeInfo(CollegeType collegeType, Model model) {
        if (collegeType == null || Tools.isEmpty(collegeType.getName())) {
            model.addAttribute("message", "请填写正确的院校分类名称");
            return "college_type/college_type_edit";
        }
        try {
            collegeTypeService.update(collegeType);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "college_type/college_type_edit";
        }
        return "redirect:/collegeType/select";
    }


}
