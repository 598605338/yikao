package com.linjia.web.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjia.base.controller.BaseController;
import com.linjia.web.model.User;
import com.linjia.web.service.UserService;

/**
 * 用户控制器  （DEMO）
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	

	@Autowired
	private UserService userService;
	
	/**
	 * 添加用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request){
		System.out.println("开始添加");
//		User user = new User(3,28,"员工",3,"6944732100390l",6944732100390l,"lxl");
//		userService.insert(user);
//		
//		System.out.println("添加成功");
//		logger.debug("我就是个日志....I was Debug");
//		logger.info("我就是个日志....I was Info");
//		logger.error("我就是个日志....I was error");
//		request.setAttribute("message", "添加成功");
		return "success";
	}
	
	
	/**
	 * 更新用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request){
		System.out.println("开始更新");
		User user = new User(3,28,"员工",3,"6944732100390l",6944732100390l,"lxl");
		userService.update(user);
		
		System.out.println("更新成功");
		request.setAttribute("message", "更新成功");
		return "success";
	}
	
	/**
	 * 根据Id删除用户
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/delUser")
	public String delUser(HttpServletRequest request,Long id){
		System.out.println("开始删除");
		userService.delete(id);
		
		System.out.println("删除成功");
		request.setAttribute("message", "删除成功");
		return "success";
	}
	
	/**
	 * 根据Id取得用户
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request,Long id){
		User user = userService.selectById(id);
		
		System.out.println("查询成功");
		request.setAttribute("message", "查询成功：name = "+ user.getUserName());
		return "success";
	}
	
	/**
	 * 取得所有用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		List<User> allList = userService.selectList();
		logger.debug("我就是个日志....I was Debug");
		logger.info("我就是个日志....I was Info");
		logger.error("我就是个日志....I was error");
		System.out.println("查询成功");
		request.setAttribute("message", "总共成员数： "+ allList.size());
		return "success";
	}
	
	/**
	 * 以Json形式输出对象
	 * 
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllUserByJson")
	public List<User> getAllUserByJson(HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		List<User> list = userService.selectList();
		return list;
	}
	
	
	
}
