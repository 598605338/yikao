package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.Specialty;
import com.linjia.web.query.SpecialtyQuery;
import com.linjia.web.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * 科目模块
 *
 * @author lixinling
 */
@Controller
@RequestMapping("/specialty")
public class SpecialtyController extends BaseController {

    @Autowired
    private SpecialtyService specialtyService;

    /**
     * 取得科目列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param query
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/select")
    public String getSpecialtyList(SpecialtyQuery query, Model model, String message) throws UnsupportedEncodingException {

        List<Specialty> specialtyList = specialtyService.selectBySerach(query);

        //查询列表总数量
        int pnums = specialtyService.countByExample(query);
        model.addAttribute("query", query);
        model.addAttribute(specialtyList);
        model.addAttribute("pnums", pnums);
        if (!Tools.isEmpty(message))
            model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

        return "specialty/specialty_list";
    }

    /**
     * 添加科目
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param specialty
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String addSpecialtyInfo(Specialty specialty, Model model) {
        if (specialty == null || Tools.isEmpty(specialty.getSpecialtyName())) {
            model.addAttribute("message", "请填写正确的科目名称和描述");
            return "specialty/specialty_add";
        }
        try {
            specialty.setCreDate(new Date());
            specialty.setDeleted(false);
            specialtyService.insert(specialty);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "specialty/specialty_add";
        }
        return "redirect:/specialty/select";
    }

    /**
     * 跳转到添加科目页
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "specialty/specialty_add";
    }

    /**
     * 删除科目
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param model
     */
    @RequestMapping(value = "/deleteSpecialty")
    public String deleteSpecialty(String ids, Model model) {
        if (ids == null) {
            model.addAttribute("message", "请选择要删除的科目");
            return "specialty/specialty_list";
        }
        try {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                specialtyService.delete(Long.valueOf(id));
            }
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "redirect:/specialty/select";
        }
        return "redirect:/specialty/select";
    }

    /**
     * 跳转到编辑品牌页
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
            return "specialty/specialty_list";
        }
        Specialty specialty = specialtyService.selectById(id);
        model.addAttribute("specialty", specialty);
        return "specialty/specialty_edit";
    }

    /**
     * 编辑品牌
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param specialty
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String editBrandInfo(Specialty specialty, Model model) {
        if (specialty == null || Tools.isEmpty(specialty.getSpecialtyName())) {
            model.addAttribute("message", "请填写正确的科目名称");
            return "specialty/specialty_edit";
        }
        try {
            specialtyService.update(specialty);
//			model.addAttribute("message", "编辑成功");
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "specialty/specialty_edit";
        }
        return "redirect:/specialty/select";
    }

}
