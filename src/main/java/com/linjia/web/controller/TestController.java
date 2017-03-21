package com.linjia.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linjia.web.model.User;
import com.linjia.web.service.TestService;


/** 
 * @author  lixinling: 
 * @date 2016年7月1日 下午4:16:39 
 * @version 1.0 
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	/**
	 * 测试数据库连接池连接池
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/testPool")
	public String testPool(HttpServletRequest request){
		System.out.println("开始测试。。。");
		testService.testPools();
		
		return "success";
	}
	
	/**
	 * 测试事务管理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/testTransaction")
	public String testTransaction(HttpServletRequest request){
		
		System.out.println("开始测试。。。" + request.getRemoteAddr());
//		testService.updateAge();
//		testService.testTransaction();
//		testService.testInsertBatch();
		return "success";
	}
	
	/**
	 * 测试图片上传
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/testUpload")
	public void testUpload(HttpServletRequest request,HttpServletResponse response){
		System.out.println("开始测试。。。");
		try {
			response.getOutputStream().print("<html><body><table style='border:solid 1px red'><tr><td>aaaa</td></tr></table></body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return "uploadinfo";
	}
	
	/**
	 * 测试token
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/testToken", method = {RequestMethod.POST })
	public String testToken(HttpServletRequest request, @RequestBody User user){
		//{"userId":"lxl","age":28,"userName":"lixinling","token":"token1111122223333"}
		System.out.println("开始测试。。。");
//		System.out.println(request.getParameter("token"));
		System.out.println("token:"  + "user:" + user.toString() );
		JSONObject json = new JSONObject();
		json.put("userId", "lxl");
		json.put("token", "token1111122223333");
		System.out.println(json.toString());
		return "success";
	}
}
