package com.linjia.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.SecRole;
import com.linjia.web.model.SecUser;
import com.linjia.web.query.SecUserQuery;
import com.linjia.web.service.SecRoleService;
import com.linjia.web.service.SecUserService;

/**
 * 系统用户管理模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/secuser")
public class SecUserController extends BaseController {

	@Autowired
	private SecUserService secUserService;

	@Autowired
	private SecRoleService secRoleService;

	/**
	 * 分页取得用户列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getSecUserList(HttpServletRequest request, SecUserQuery query, Model model) {
		if (!Tools.isEmpty(query.getLogin()))
			query.setLoginQuery("%" + query.getLogin() + "%");
		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");
		if (!Tools.isEmpty(query.getPhone()))
			query.setPhoneQuery("%" + query.getPhone() + "%");

		SecUser user = Util.getUser(request);// 从session中取的登陆用户的信息
		String login = null;
		if (user.getLevel() != null && user.getLevel() > 0) {
			login = user.getLogin();
		}

		List<SecUser> secUserList = secUserService.selectByPageList(query,user.getLevel(),login);

		// 取得分页数据总数量
		int pnums = secUserService.countByExample(query);
		model.addAttribute("secUserList", secUserList);
		model.addAttribute("pnums", pnums);
		model.addAttribute("query", query);

		return "secuser/secuser_list";
	}

	/**
	 * 添加用户
	 * lixinling 
	 * 2016年8月30日 下午3:03:19
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addSecUserInfo(HttpServletRequest request, SecUser secUser, Model model) {
		if (secUser == null || Tools.isEmpty(secUser.getLogin()) || Tools.isEmpty(secUser.getPassword()) || Tools.isEmpty(secUser.getConfirmPassword())
				|| Tools.isEmpty(secUser.getPhone())) {
			model.addAttribute("message", "请填写正确的用户信息");
			return "secuser/secuser_add";
		}

		// 验证密码输入的一致性
		if (!secUser.getPassword().equals(secUser.getConfirmPassword())) {
			model.addAttribute("message", "密码和确认密码不一致，请重新输入");
			return "secuser/secuser_add";
		}

		try {
			String creatorId = Util.getUser(request).getLogin();// 从session中取的登陆用户的信息
			secUser.setCreator(creatorId);
			secUser.setCreDate(new Date());
			secUser.setUpdateDate(new Date());
			secUser.setUpdater(creatorId);
			secUser.setPassword(Util.getMD5(secUser.getPassword()).toLowerCase());
			// 添加用户 并设置角色
			secUserService.insertUserAndRole(secUser);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "secuser/secuser_add";
		}
		return "redirect:/secuser/select";
	}

	/**
	 * 跳转到添加用户页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, Model model) {
		List<SecRole> secRoleList = secRoleService.selectAllRoleInfo();
		model.addAttribute("secRoleList", secRoleList);
		return "secuser/secuser_add";
	}

	/**
	 * 编辑用户
	 * lixinling 
	 * 2016年8月30日 下午3:03:19
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String updateSecUserInfo(HttpServletRequest request, SecUser secUser, Model model) {
		if (secUser == null || Tools.isEmpty(secUser.getLogin()) || Tools.isEmpty(secUser.getPhone())) {
			model.addAttribute("message", "请填写正确的用户信息");
			return "secuser/secuser_edit";
		}

		// 验证密码输入的一致性
		if (!Tools.isEmpty(secUser.getPassword())) {
			if (!secUser.getPassword().equals(secUser.getConfirmPassword())) {
				model.addAttribute("message", "密码和确认密码不一致，请重新输入");
				return "secuser/secuser_edit";
			}
			secUser.setPassword(Util.getMD5(secUser.getPassword()).toLowerCase());
		}

		try {
			String creatorId = Util.getUser(request).getLogin();// 从session中取的登陆用户的信息
			secUser.setUpdateDate(new Date());
			secUser.setUpdater(creatorId);
			// 添加用户 并设置角色
			secUserService.updateUserAndRole(secUser);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "secuser/secuser_edit";
		}
		return "redirect:/secuser/select";
	}

	/**
	 * 跳转到编辑用户页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(String userId, Long id, Model model) {
		SecUser secUser = secUserService.selectById(id);
		model.addAttribute("secUser", secUser);

		// 查询角色列表
		List<SecRole> secRoleList = secRoleService.selectAllRoleInfo();
		model.addAttribute("secRoleList", secRoleList);

		// 查询用户当前所属角色
		List<Integer> roleIdList = secUserService.selectUserRoleByUserId(id);
		if (roleIdList != null)
			model.addAttribute("roleIdListStr", roleIdList.toString());

		return "secuser/secuser_edit";
	}

	/**
	 * 删除用户
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param noticeIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteSecuser")
	public String deleteSecuser(String secuserIds, Model model) {
		if (secuserIds == null) {
			model.addAttribute("message", "请选择要删除的用户记录");
			return "secuser/secuser_list";
		}
		try {
			String[] secuserIdArray = secuserIds.split(",");
			for (String secuserId : secuserIdArray) {
				secUserService.delete(Long.valueOf(secuserId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "secuser/secuser_list";
		}
		return "redirect:/secuser/select";
	}

	/**
	 * 跳转到用户密码修改页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toUpdatePwd")
	public String toEdit(String login, Model model) {

		// 查询用户信息
		SecUser secUser = secUserService.selectByLogin(login);
		if (secUser != null)
			model.addAttribute("id", secUser.getId());

		return "secuser/secuser_update_password";
	}

	/**
	 * 更改用户密码
	 * lixinling 
	 * 2016年11月24日 下午3:03:19
	 * @param noticeManager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public Object updatePassword(HttpServletRequest request, Long id, String oldPassword, String newPassword, String confirmPassword) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (Tools.isEmpty(oldPassword) || Tools.isEmpty(newPassword) || Tools.isEmpty(confirmPassword)) {
			if (Tools.isEmpty(oldPassword))
				resMap.put("message", "请输入原密码");
			if (Tools.isEmpty(newPassword))
				resMap.put("message", "请输入新密码");
			if (Tools.isEmpty(confirmPassword))
				resMap.put("message", "请输入确认密码");
			Util.writeError(resMap);
			return resMap;
		}

		String oldPwdMd5 = Util.getMD5(oldPassword).toLowerCase();
		if (newPassword.equals(confirmPassword)) {
			SecUser secUser = secUserService.selectById(id);
			if (secUser != null && oldPwdMd5.equals(secUser.getPassword())) {
				secUser.setPassword(Util.getMD5(newPassword).toLowerCase());
				secUserService.update(secUser);
			} else {
				resMap.put("message", "输入的原密码不正确，请重新输入");
				Util.writeError(resMap);
				return resMap;
			}
		} else {
			resMap.put("message", "密码和确认密码不一致，请重新输入");
			Util.writeError(resMap);
			return resMap;
		}

		resMap.put("message", "密码修改成功");
		Util.writeOk(resMap);
		return resMap;
	}
}
