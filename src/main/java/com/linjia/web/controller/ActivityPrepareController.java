package com.linjia.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.tools.UploadImage;
import com.linjia.tools.Util;
import com.linjia.web.model.ActivityPrepare;
import com.linjia.web.query.ActivityPrepareQuery;
import com.linjia.web.service.ActivityPrepareService;

/**
 * 预约购买模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/activityPrepare")
public class ActivityPrepareController extends BaseController {

	@Autowired
	private ActivityPrepareService activityPrepareService;

	/**
	 * 取得预约购买列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getActivityPrepareList(ActivityPrepareQuery query, Model model) {
		if (!Tools.isEmpty(query.getpName()))
			query.setpNameQuery("%" + query.getpName() + "%");
		if(!Tools.isEmpty(query.getActivityStartTimeStr()))
			query.setActivityStartTime(DateComFunc.strToDate(query.getActivityStartTimeStr(), "yyyy-MM-dd"));
		if(!Tools.isEmpty(query.getActivityEndTimeStr()))
			query.setActivityEndTime(DateComFunc.strToDate(query.getActivityEndTimeStr(), "yyyy-MM-dd"));

		List<ActivityPrepare> activityPrepareList = activityPrepareService.selectByPageList(query);
		
		//查询分页数据总数量
		int pnums = activityPrepareService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute("activityPrepareList", activityPrepareList);
		model.addAttribute("query", query);

		return "activity_prepare/activity_prepare_list";
	}

	/**
	 * 添加预约购买活动商品 
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addActivityPrepareInfo(HttpServletRequest request, ActivityPrepare activityPrepare, Model model) {
		if (activityPrepare == null || Tools.isEmpty(activityPrepare.getpCode())) {
			model.addAttribute("message", "请填写正确的预约商品信息");
			return "activity_prepare/activity_prepare_add";
		}
		try {
			if(!Tools.isEmpty(activityPrepare.getActivityStartTimeStr()))
				activityPrepare.setActivityStartTime(DateComFunc.strToDate(activityPrepare.getActivityStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityPrepare.getActivityEndTimeStr()))
				activityPrepare.setActivityEndTime(DateComFunc.strToDate(activityPrepare.getActivityEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityPrepare.getGetselfStartTimeStr()))
				activityPrepare.setGetselfStartTime(DateComFunc.strToDate(activityPrepare.getGetselfStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityPrepare.getGetselfEndTimeStr()))
				activityPrepare.setGetselfEndTime(DateComFunc.strToDate(activityPrepare.getGetselfEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath, activityPrepare.getUploadImage());
			
			activityPrepare.setImagePath(uploadPath);
			activityPrepare.setCreDate(new Date());
			activityPrepare.setUpdateDate(new Date());
			activityPrepareService.insert(activityPrepare);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "activity_prepare/activity_prepare_add";
		}
		return "redirect:/activityPrepare/select";
	}

	/**
	 * 跳转到添加活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, Model model) {
		Long maxSortIndex = activityPrepareService.selectMaxSortIndex();
		model.addAttribute("maxSortIndex", maxSortIndex);
		return "activity_prepare/activity_prepare_add";
	}

	/**
	 * 删除活动记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteActivityPrepare")
	public String deleteActivityPrepare(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的活动记录");
			return "redirect:/activityPrepare/select";
		}
		try {
			String[] recordIdArray = recordIds.split(",");
			for (String recordId : recordIdArray) {
				activityPrepareService.delete(Long.valueOf(recordId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/activityPrepare/select";
		}
		return "redirect:/activityPrepare/select";
	}

	/**
	 * 跳转到编辑活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model, String message) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "activity_prepare/activity_prepare_list";
		}
		ActivityPrepare activityPrepare = activityPrepareService.selectById(id);
		model.addAttribute("activityPrepare", activityPrepare);
		if(!Tools.isEmpty(message))
			model.addAttribute("message", message);
		
		return "activity_prepare/activity_prepare_edit";
	}

	/**
	 * 编辑预约购买活动商品
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editReceiveCardCouponInfo(HttpServletRequest request, ActivityPrepare activityPrepare, Model model) {
		if (activityPrepare == null || Tools.isEmpty(activityPrepare.getpCode())) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "redirect:/activityPrepare/toEdit";
		}
		try {
			if(!Tools.isEmpty(activityPrepare.getActivityStartTimeStr()))
				activityPrepare.setActivityStartTime(DateComFunc.strToDate(activityPrepare.getActivityStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityPrepare.getActivityEndTimeStr()))
				activityPrepare.setActivityEndTime(DateComFunc.strToDate(activityPrepare.getActivityEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityPrepare.getGetselfStartTimeStr()))
				activityPrepare.setGetselfStartTime(DateComFunc.strToDate(activityPrepare.getGetselfStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityPrepare.getGetselfEndTimeStr()))
				activityPrepare.setGetselfEndTime(DateComFunc.strToDate(activityPrepare.getGetselfEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath, activityPrepare.getUploadImage());
			
			activityPrepare.setImagePath(uploadPath);
			activityPrepare.setUpdateDate(new Date());
			
			activityPrepareService.update(activityPrepare);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/activityPrepare/toEdit";
		}
		return "redirect:/activityPrepare/select";
	}

}
