package com.linjia.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.NoticeManager;
import com.linjia.web.query.NoticeManagerQuery;
import com.linjia.web.service.NoticeManagerService;

/**
 * 公告管理模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/noticeManager")
public class NoticeManagerController extends BaseController {

	@Autowired
	private NoticeManagerService noticeManagerService;

	/**
	 * 取得公告列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getNoticeManagerList(NoticeManagerQuery query, Model model) {
		List<NoticeManager> noticeManagerList = noticeManagerService.selectByPageList(query);
		model.addAttribute(noticeManagerList);

		return "notice_manager/notice_manager_list";
	}
	
	/**
	 * 添加公告
	 * lixinling 
	 * 2016年8月30日 下午3:03:19
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addNoticeManagerInfo(HttpServletRequest request, NoticeManager noticeManager, Model model) {
		if (noticeManager == null || Tools.isEmpty(noticeManager.getContent())) {
			model.addAttribute("message", "请填写正确的公告内容");
			return "notice_manager/notice_manager_add";
		}
		try {
			String creatorId = Util.getUser(request).getLogin();// 从session中取的登陆用户的信息
			noticeManager.setCreatorId(creatorId);
			noticeManager.setCreDate(new Date());
			noticeManager.setDeleted(false);
			noticeManagerService.insert(noticeManager);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "notice_manager/notice_manager_add";
		}
		return "redirect:/noticeManager/select";
	}

	/**
	 * 跳转到添加公告页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "notice_manager/notice_manager_add";
	}

	/**
	 * 删除公告
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param noticeIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteNotice")
	public String deleteNotice(String noticeIds, Model model) {
		if (noticeIds == null) {
			model.addAttribute("message", "请选择要删除的公告记录");
			return "notice_manager/notice_manager_list";
		}
		try {
			String[] noticeIdArray = noticeIds.split(",");
			for (String noticeId : noticeIdArray) {
				noticeManagerService.delete(Long.valueOf(noticeId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "notice_manager/notice_manager_list";
		}
		return "redirect:/noticeManager/select";
	}

	/**
	 * 跳转到编辑公告页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "notice_manager/notice_manager_list";
		}
		NoticeManager noticeManager = noticeManagerService.selectById(id);
		model.addAttribute("noticeManager", noticeManager);
		return "notice_manager/notice_manager_edit";
	}

	/**
	 * 编辑公告
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editNoticeManagerInfo(NoticeManager noticeManager, Model model) {
		if (noticeManager == null || Tools.isEmpty(noticeManager.getContent())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "notice_manager/notice_manager_edit";
		}
		try {
			noticeManagerService.update(noticeManager);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "notice_manager/notice_manager_edit";
		}
		return "redirect:/noticeManager/select";
	}
}
