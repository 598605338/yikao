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
import com.linjia.web.model.ActivityProduct;
import com.linjia.web.model.HotsellBase;
import com.linjia.web.model.HotsellProduct;
import com.linjia.web.query.ActivityPrepareQuery;
import com.linjia.web.query.HotsellBaseQuery;
import com.linjia.web.service.ActivityPrepareService;
import com.linjia.web.service.HotsellService;

/**
 * 热门销售模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/hotsell")
public class ActivityHotsellController extends BaseController {

	@Autowired
	private HotsellService hotsellService;

	
	/**
	 * 取得热销活动列表
	 * lixinling 
	 * 2017年2月10日 下午2:00:36
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getActivityHotsellList(HotsellBaseQuery query, Model model) {
		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");
		if(!Tools.isEmpty(query.getStartTimeStr()))
			query.setStartTime(DateComFunc.strToDate(query.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		if(!Tools.isEmpty(query.getEndTimeStr()))
			query.setEndTime(DateComFunc.strToDate(query.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));

		List<HotsellBase> activityHotsellList = hotsellService.selectByPageList(query);
		
		//查询分页数据总数量
		int pnums = hotsellService.totalCountByPage(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute("activityHotsellList", activityHotsellList);
		model.addAttribute("query", query);

		return "activity_hotsell_recommend/hotsell_recommend_list";
	}

	/**
	 * 添加热销活动
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addActivityHotsellInfo(HttpServletRequest request, HotsellBase hotsellBase, Model model) {
		if (hotsellBase == null || Tools.isEmpty(hotsellBase.getName())) {
			model.addAttribute("message", "请填写正确的预约商品信息");
			return "activity_hotsell_recommend/hotsell_recommend_add";
		}
		try {
			if(!Tools.isEmpty(hotsellBase.getStartTimeStr()))
				hotsellBase.setStartTime(DateComFunc.strToDate(hotsellBase.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(hotsellBase.getEndTimeStr()))
				hotsellBase.setEndTime(DateComFunc.strToDate(hotsellBase.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath, hotsellBase.getBannerFile());
			
			hotsellBase.setBannerPath(uploadPath);
			Date date = new Date();
			hotsellBase.setCreDate(date);
			hotsellBase.setUpdateDate(date);
			hotsellBase.setPublishDate(date);
			hotsellService.insertActivity(hotsellBase);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "activity_hotsell_recommend/hotsell_recommend_add";
		}
		return "redirect:/hotsell/select";
	}

	/**
	 * 跳转到添加活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(Model model) {
		return "activity_hotsell_recommend/hotsell_recommend_add";
	}

	/**
	 * 删除活动记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteActivityHotsell(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的活动记录");
			return "redirect:/hotsell/select";
		}
		try {
			String[] recordIdArray = recordIds.split(",");
			for (String recordId : recordIdArray) {
				hotsellService.delete(Long.valueOf(recordId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/hotsell/select";
		}
		return "redirect:/hotsell/select";
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
			return "activity_hotsell_recommend/activity_hotsell_list";
		}
		HotsellBase hotsellBase = hotsellService.selectById(id);
		List<HotsellProduct> productList = hotsellService.selectByBaseId(hotsellBase.getId());
		//查询商品信息
		if(productList != null && productList.size() >0){
			StringBuilder proIds = new StringBuilder();
			for(HotsellProduct item : productList){
				proIds.append(item.getProductId()).append(",");
			}
			hotsellBase.setProductIds(proIds.substring(0, proIds.length()-1));
			hotsellBase.setActProductsArray(productList);
		}
		model.addAttribute("hotsellBase", hotsellBase);
		if(!Tools.isEmpty(message))
			model.addAttribute("message", message);
		
		return "activity_hotsell_recommend/hotsell_recommend_edit";
	}

	/**
	 * 编辑热销推荐活动信息
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editHotsellInfo(HttpServletRequest request, HotsellBase hotsellBase, Model model) {
		if (hotsellBase == null || Tools.isEmpty(hotsellBase.getName())) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "redirect:/hotsell/toEdit";
		}
		try {
			if(!Tools.isEmpty(hotsellBase.getStartTimeStr()))
				hotsellBase.setStartTime(DateComFunc.strToDate(hotsellBase.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(hotsellBase.getEndTimeStr()))
				hotsellBase.setEndTime(DateComFunc.strToDate(hotsellBase.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath, hotsellBase.getBannerFile());
			
			hotsellBase.setBannerPath(uploadPath);
			hotsellBase.setUpdateDate(new Date());
			
			hotsellService.updateHotsell(hotsellBase);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/hotsell/toEdit";
		}
		return "redirect:/hotsell/select";
	}
	

	/**
	 * 编辑热销推荐活动信息
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateStatus")
	public String updateStatus(HttpServletRequest request, Integer id, Integer online, Model model) {
		if (id == null || id == 0) {
			model.addAttribute("message", "Id不能为空");
			return "redirect:/hotsell/select";
		}
		try {
			hotsellService.updateStatusByPrimaryKey(id,online);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/hotsell/select";
		}
		return "redirect:/hotsell/select";
	}

}
