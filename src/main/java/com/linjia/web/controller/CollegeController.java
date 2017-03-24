package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.College;
import com.linjia.web.model.Region;
import com.linjia.web.query.CollegeQuery;
import com.linjia.web.service.CollegeService;
import com.linjia.web.service.impl.RegionServiceImpl;
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
@RequestMapping("/college")
public class CollegeController extends BaseController {

    @Autowired
    private CollegeService collegeService;
    @Autowired
    private RegionServiceImpl regionServiceImpl;

    /**
     * 取得院校列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param query
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/select")
    public String getCollegeList(CollegeQuery query, Model model, String message) throws UnsupportedEncodingException {

        List<College> collegeList = collegeService.selectBySerach(query);

        //查询列表总数量
        int pnums = collegeService.countByExample(query);
        model.addAttribute("query", query);
        model.addAttribute(collegeList);
        model.addAttribute("pnums", pnums);
        if (!Tools.isEmpty(message))
            model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

        return "college/college_list";
    }

    /**
     * 添加院校
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param college
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String addCollegeInfo(College college, Model model) {
        if (college == null || Tools.isEmpty(college.getCollegeName())) {
            model.addAttribute("message", "请填写正确的院校名称和描述");
            return "college/college_add";
        }
        try {
//            college.setCreDate(new Date());
            college.setDeleted(false);
            collegeService.insert(college);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "college/college_add";
        }
        return "redirect:/college/select";
    }

    /**
     * 跳转到添加院校页
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {
        //查询省级区域列表
        getProvinceList(model);
        return "college/college_add";
    }

    /**
     * 删除院校
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param model
     */
    @RequestMapping(value = "/deleteCollege")
    public String deleteCollege(String ids, Model model) {
        if (ids == null) {
            model.addAttribute("message", "请选择要删除的院校");
            return "college/college_list";
        }
        try {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                collegeService.delete(Long.valueOf(id));
            }
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "redirect:/college/select";
        }
        return "redirect:/college/select";
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
            return "college/college_list";
        }
        College college = collegeService.selectById(id);

        //查询省级区域列表
        getProvinceList(model);
        model.addAttribute("college", college);
        return "college/college_edit";
    }

    /**
     * 编辑院校
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param college
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String editCollegeInfo(College college, Model model) {
        if (college == null || Tools.isEmpty(college.getCollegeName())) {
            model.addAttribute("message", "请填写正确的院校名称");
            return "college/college_edit";
        }
        try {
            collegeService.update(college);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "college/college_edit";
        }
        return "redirect:/college/select";
    }

    /**
     * 查询省级区域列表
     *
     * @author: lixinling
     * @date: 2017/3/24 16:40
     * @param: [model]
     * @return: void
     */
    private void getProvinceList(Model model) {

        //查询一级区域列表
        List<Region> provinceList = regionServiceImpl.selectRegionByParentId(0);
        model.addAttribute("provinceList", provinceList);
    }


}
