package com.linjia.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.constants.Application;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.Privilege;
import com.linjia.web.model.SecRole;
import com.linjia.web.model.SecUser;
import com.linjia.web.query.SecRoleQuery;
import com.linjia.web.query.SecUserQuery;
import com.linjia.web.service.PrivilegeService;
import com.linjia.web.service.SecRoleService;
import com.linjia.web.service.SecUserService;

/**
 * 角色权限管理模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/secrole")
public class SecRoleController extends BaseController {

	@Autowired
	private SecRoleService secRoleService;

	@Autowired
	private PrivilegeService privilegeService;

	/**
	 * 分页取得角色列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getSecRoleList(HttpServletRequest request, SecRoleQuery query, Model model, String message) {
		SecUser user = (SecUser) request.getSession().getAttribute("user");
		if (user != null) {
			query.setLevel(user.getLevel());
			query.setUserId(user.getId());
		}

		List<SecRole> secRoleList = secRoleService.selectByPageList(query);

		// 查询分页数据总数量
		int pnums = secRoleService.countByExample(query);
		model.addAttribute(secRoleList);
		model.addAttribute("pnums", pnums);
		if (!Tools.isEmpty(message))
			model.addAttribute("message", message);
		model.addAttribute("query", query);

		return "secrole/secrole_list";
	}

	/**
	 * 添加角色
	 * lixinling 
	 * 2016年8月30日 下午3:03:19
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addSecRoleInfo(HttpServletRequest request, SecRole secRole, Model model) {
		if (secRole == null || Tools.isEmpty(secRole.getName()) || Tools.isEmpty(secRole.getDescription())) {
			model.addAttribute("message", "请填写正确的角色信息");
			return "secrole/secrole_add";
		}

		try {
			String creatorId = Util.getUser(request).getLogin();// 从session中取的登陆用户的信息
			secRole.setCreator(creatorId);
			secRole.setCreDate(new Date());
			secRole.setUpdateDate(new Date());
			secRole.setUpdater(creatorId);
			secRoleService.insert(secRole);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "secrole/secrole_add";
		}
		return "redirect:/secrole/select";
	}

	/**
	 * 跳转到添加角色页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(String userId, Long id, Model model) {
		SecRole secRole = secRoleService.selectById(id);
		model.addAttribute("secRole", secRole);
		return "secrole/secrole_edit";
	}

	/**
	 * 添加角色
	 * lixinling 
	 * 2016年8月30日 下午3:03:19
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editSecRoleInfo(HttpServletRequest request, SecRole secRole, Model model) {
		if (secRole == null || Tools.isEmpty(secRole.getName()) || Tools.isEmpty(secRole.getDescription())) {
			model.addAttribute("message", "请填写正确的角色信息");
			return "secrole/secrole_edit";
		}

		try {
			String creatorId = Util.getUser(request).getLogin();// 从session中取的登陆用户的信息
			secRole.setUpdateDate(new Date());
			secRole.setUpdater(creatorId);
			secRoleService.update(secRole);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "secrole/secrole_edit";
		}
		return "redirect:/secrole/select";
	}

	/**
	 * 跳转到添加角色页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "secrole/secrole_add";
	}

	/**
	 * 删除角色
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param noticeIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteSecrole")
	public String deleteSecrole(String secroleIds, Model model) {
		if (secroleIds == null) {
			model.addAttribute("message", "请选择要删除的角色记录");
			return "redirect:/secrole/select";
		}
		try {
			String[] secroleIdArray = secroleIds.split(",");
			for (String secroleId : secroleIdArray) {
				secRoleService.delete(Long.valueOf(secroleId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/secrole/select";
		}
		return "redirect:/secrole/select";
	}

	/**
	 * 访问授权 
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param secroleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/accessPrivilege")
	public String accessPrivilege(int secroleId, Model model) {
		if (secroleId == 0) {
			model.addAttribute("message", "请选择要访问授权的记录");
			return "redirect:/secrole/select";
		}
		try {
			List<Integer> privilegeList = privilegeService.selectPrivilegeIdByRoleId(secroleId);
			model.addAttribute("privilegeListStr", privilegeList.toString());
			model.addAttribute("secroleId", secroleId);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/secrole/select";
		}
		return "/secrole/access_privilege_list";
	}

	/**
	 * 更新授权信息 
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param noticeIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePrivilege")
	public String updatePrivilege(HttpServletRequest request, int secroleId, String privilegeIds, Model model) {
		if (secroleId == 0) {
			model.addAttribute("message", "请选择要更新访问授权的记录");
			model.addAttribute("secroleId", secroleId);
			return "redirect:/secrole/accessPrivilege";
		} else if (Tools.isEmpty(privilegeIds)) {
			model.addAttribute("message", "请选择要更新的权限");
			model.addAttribute("secroleId", secroleId);
			return "redirect:/secrole/accessPrivilege";
		}
		try {
			privilegeService.updateRolePrivilege(request, secroleId, privilegeIds);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/secrole/select";
		}
		return "redirect:/secrole/select";
	}

}
