package com.linjia.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.Utils;
import com.linjia.base.controller.BaseController;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.Brand;
import com.linjia.web.model.TailGoodsClear;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.query.TailGoodsClearQuery;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.TailGoodsClearService;

/**
 * 尾货清仓模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/tailGoodsClear")
public class TailGoodsClearController extends BaseController {

	@Autowired
	private TailGoodsClearService tailGoodsClearService;

	/**
	 * 取得尾货清仓列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getTailGoodsClearList(TailGoodsClearQuery query, Model model) {
		List<TailGoodsClear> tailGoodsClearList = tailGoodsClearService.selectByPageList(query);

		// 查询分页数据总数量
		int pnums = tailGoodsClearService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute("tailGoodsClearList", tailGoodsClearList);
		model.addAttribute("query", query);

		return "tail_goods_clear/tail_goods_clear_list";
	}

	/**
	 * 添加尾货清仓
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addTailGoodsClearInfo(TailGoodsClear tailGoodsClear, Model model) {
		if (tailGoodsClear == null || Tools.isEmpty(tailGoodsClear.getpCode())) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "tail_goods_clear/tail_goods_clear_add";
		}
		try {
			if (!Tools.isEmpty(tailGoodsClear.getPublishStartTimeStr()))
				tailGoodsClear.setPublishStartTime(DateComFunc.strToDate(tailGoodsClear.getPublishStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(tailGoodsClear.getPublishEndTimeStr()))
				tailGoodsClear.setPublishEndTime(DateComFunc.strToDate(tailGoodsClear.getPublishEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(tailGoodsClear.getSearchTimeStr()))
				tailGoodsClear.setSearchTime(DateComFunc.strToDate(tailGoodsClear.getSearchTimeStr(), "yyyy-MM-dd HH:mm:ss"));

			tailGoodsClear.setpImagePath(Util.replacePath(tailGoodsClear.getpImagePath()));
			tailGoodsClear.setCreDate(new Date());
			tailGoodsClear.setUpdateDate(new Date());
			tailGoodsClearService.insert(tailGoodsClear);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "tail_goods_clear/tail_goods_clear_add";
		}
		return "redirect:/tailGoodsClear/select";
	}

	/**
	 * 跳转到新增页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, Model model) {
		Long maxSortIndex = tailGoodsClearService.selectMaxSortIndex();
		model.addAttribute("maxSortIndex", maxSortIndex);
		return "tail_goods_clear/tail_goods_clear_add";
	}

	/**
	 * 删除记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param recordIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteTailGoodsClear(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的记录");
			return "redirect:/tailGoodsClear/select";
		}
		try {
			String[] recordIdArray = recordIds.split(",");
			for (String recordId : recordIdArray) {
				tailGoodsClearService.delete(Long.valueOf(recordId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/tailGoodsClear/select";
		}
		return "redirect:/tailGoodsClear/select";
	}

	/**
	 * 跳转到编辑页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model, String message) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "redirect:/tailGoodsClear/select";
		}
		TailGoodsClear tailGoodsClear = tailGoodsClearService.selectById(id);
		model.addAttribute("tailGoodsClear", tailGoodsClear);

		if (!Tools.isEmpty(message))
			model.addAttribute("message", message);

		return "tail_goods_clear/tail_goods_clear_edit";
	}

	/**
	 * 编辑尾货清仓记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editTailGoodsClearInfo(TailGoodsClear tailGoodsClear, Model model) {
		if (tailGoodsClear == null || Tools.isEmpty(tailGoodsClear.getpCode())) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "redirect:/tailGoodsClear/toEdit";
		}
		try {
			if (!Tools.isEmpty(tailGoodsClear.getPublishStartTimeStr()))
				tailGoodsClear.setPublishStartTime(DateComFunc.strToDate(tailGoodsClear.getPublishStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(tailGoodsClear.getPublishEndTimeStr()))
				tailGoodsClear.setPublishEndTime(DateComFunc.strToDate(tailGoodsClear.getPublishEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(tailGoodsClear.getSearchTimeStr()))
				tailGoodsClear.setSearchTime(DateComFunc.strToDate(tailGoodsClear.getSearchTimeStr(), "yyyy-MM-dd HH:mm:ss"));

			tailGoodsClear.setpImagePath(Util.replacePath(tailGoodsClear.getpImagePath()));
			tailGoodsClear.setUpdateDate(new Date());

			tailGoodsClearService.update(tailGoodsClear);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/tailGoodsClear/toEdit";
		}
		return "redirect:/tailGoodsClear/select";
	}

	/**
	 * 编辑活动状态或使用状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateStatus")
	public String updateStatus(TailGoodsClear tailGoodsClear, Model model) {
		tailGoodsClear.setUseStatus(!tailGoodsClear.getUseStatus());
		tailGoodsClearService.updateStatusByPrimaryKey(tailGoodsClear);
		return "redirect:/tailGoodsClear/select";
	}
}
