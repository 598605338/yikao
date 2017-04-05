package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.query.AdmissionBatchQuery;
import com.linjia.web.service.AdmissionBatchService;
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
@RequestMapping("/admissionBatch")
public class AdmissionBatchController extends BaseController {

    @Autowired
    private AdmissionBatchService admissionBatchService;


    /**
     * 取得批次列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param query
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/select")
    public String getAdmissionBatchList(AdmissionBatchQuery query, Model model, String message) throws UnsupportedEncodingException {

        if(!Tools.isEmpty(query.getName()))
            query.setNameQuery("%"+query.getName()+"%");
        List<AdmissionBatch> admissionBatchList = admissionBatchService.selectBySerach(query);

        //查询列表总数量
        int pnums = admissionBatchService.countByExample(query);
        model.addAttribute("query", query);
        model.addAttribute("admissionBatchList",admissionBatchList);
        model.addAttribute("pnums", pnums);
        if (!Tools.isEmpty(message))
            model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

        return "admission_batch/admission_batch_list";
    }

    /**
     * 添加批次
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param admissionBatch
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String addAdmissionBatchInfo(AdmissionBatch admissionBatch, Model model) {
        if (admissionBatch == null || Tools.isEmpty(admissionBatch.getName())) {
            model.addAttribute("message", "请填写正确的批次");
            return "admission_batch/admission_batch_add";
        }
        try {
            admissionBatchService.insert(admissionBatch);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "admission_batch/admission_batch_add";
        }
        return "redirect:/admissionBatch/select";
    }

    /**
     * 跳转到添加批次页
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {

        return "admission_batch/admission_batch_add";
    }

    /**
     * 删除批次
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param model
     */
    @RequestMapping(value = "/deleteAdmissionBatch")
    public String deleteAdmissionBatch(String ids, Model model) {
        if (ids == null) {
            model.addAttribute("message", "请选择要删除的批次");
            return "admission_batch/admission_batch_list";
        }
        try {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                admissionBatchService.delete(Long.valueOf(id));
            }
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "redirect:/admissionBatch/select";
        }
        return "redirect:/admissionBatch/select";
    }

    /**
     * 跳转到编辑批次页
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
            return "admission_batch/admission_batch_list";
        }
        AdmissionBatch admissionBatch = admissionBatchService.selectById(id);
        model.addAttribute("admissionBatch",admissionBatch);
        return "admission_batch/admission_batch_edit";
    }

    /**
     * 编辑批次
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param admissionBatch
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String editCollegeInfo(AdmissionBatch admissionBatch, Model model) {
        if (admissionBatch == null || Tools.isEmpty(admissionBatch.getName())) {
            model.addAttribute("message", "请填写正确的批次名称");
            return "admission_batch/admission_batch_edit";
        }
        try {
            admissionBatchService.update(admissionBatch);
        } catch (Exception e) {
            model.addAttribute("message", "系统错误");
            return "admission_batch/admission_batch_edit";
        }
        return "redirect:/admissionBatch/select";
    }


}
