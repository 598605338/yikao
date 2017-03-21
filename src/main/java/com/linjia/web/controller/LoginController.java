package com.linjia.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.SecUser;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.SecUserService;

/**
 * 用户控制器  （DEMO）
 * 
 * @author lixinling
 *
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private SecUserService secUserService;

	/**
	 * 登陆功能
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		String msg = "";
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String validateCode = request.getParameter("validateCode");

		/*
		 * System.out.println(userName); System.out.println(password);
		 * System.out.println(validateCode);
		 */
		// 验证验证码
		if (Tools.isEmpty(validateCode)) {
			msg = "请输入验证码";
			model.addAttribute("message", msg);
			return "login";
		} else if (!validateCode.equalsIgnoreCase((String) request.getSession().getAttribute("vercode"))) {
			msg = "验证码不正确";
			model.addAttribute("message", msg);
			return "login";
		}

		// 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 登录，即身份验证
			subject.login(token);
			if (subject.isAuthenticated()) {

				// 查询用户信息放入session里
				SecUser secUser = secUserService.selectByLogin(userName);
				request.getSession().setAttribute("user", secUser);
				//session过期时间设置为10个小时
				SecurityUtils.getSubject().getSession().setTimeout(1000*60*60*10l);
				// return "redirect:/";

				if (subject.hasRole("2")) {
					if (subject.isPermitted("2")) {
						System.out.println("拥有活动管理权限");
					}
				} else if (subject.hasRole("1")) {
					if (subject.isPermitted("2")) {
						System.out.println("拥有活动管理权限");
					}
					if (subject.isPermitted("1")) {
						System.out.println("拥有商品管理权限");
					}
				}

			} else {
				return "login";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			model.addAttribute("message", msg);
			System.out.println(msg);
		}
		if (Tools.isEmpty(msg)) {
			return "redirect:/index";
		} else {
			return "login";
		}
	}

	/**
	 * 跳转至index.jsp
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "index";
	}

	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/validateCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response, Model model) {
		BufferedImage img = new BufferedImage(81, 30, BufferedImage.TYPE_3BYTE_BGR);// TYPE_INT_RGB
		// 得到该图片的绘图对象
		Graphics g = img.getGraphics();
		Random r = new Random();
		Color c = new Color(200, 150, 255);
		g.setColor(c);
		// 填充整个图片的颜色
		g.fillRect(0, 0, 81, 30);
		// 向图片中输出数字和字母
		StringBuffer sb = new StringBuffer();
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int index, len = ch.length;
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));// 输出的字体和大小
			g.drawString("" + ch[index], (i * 18) + 3, 22);// 写什么数字，在图片的什么位置画
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("vercode", sb.toString());
		try {
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");
			ImageIO.write(img, "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注销
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/doLogout")
	public String doLogout(HttpServletRequest request, Model model) {
		Subject subject = SecurityUtils.getSubject();
		try {
			String username = subject.getPrincipal().toString();
			if (subject.isAuthenticated()) {
				subject.logout();// session
									// 会销毁,在SessionListener监听session销毁，清理权限缓存
				logger.debug("用户[" + username + "]退出登录");
			}
		} catch (Exception e) {
			logger.error("连接超时。");
		}
		return "login";
	}
}
