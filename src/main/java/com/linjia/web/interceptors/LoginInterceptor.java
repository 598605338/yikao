package com.linjia.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.linjia.web.model.SecUser;

/**
 * 验证用户是否登陆，如果已经登陆则接着执行相关操作，没有登陆则跳回登录页面
 * （  preHandle在业务处理器处理请求之前被调用，
 *   postHandle在业务处理器处理请求执行完成后,生成视图之前执行，
 *   afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 。
 *   所以要想实现自己的权限管理逻辑，需要继承HandlerInterceptorAdapter并重写其三个方法）
 * 
 * @author lixinling
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);



	/* 在业务处理器处理请求之前被调用
	 * 
	 * 如果返回false，则从当前拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true，执行下一个拦截器，直到所有的拦截器都执行完毕。
	 * 再执行被拦截的Controller
	 * 然后进入拦截器链
	 * 从最后一个拦截器往回执行所有的postHandle()
	 * 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		request.getSession().setAttribute("user",new User(3,28,"员工",3,"6944732100390l",6944732100390l,"lxl"));
		SecUser loginUser = (SecUser)request.getSession().getAttribute("user");
		if(loginUser == null){
			log.info("Interceptor:跳转到login页面");
//			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			request.setAttribute("var", "请先登陆");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
			String path = request.getContextPath();
			response.sendRedirect(path + "/login.jsp");
			return false;
		}else{
			return true;
		}
	}
	
	
	/* postHandle在业务处理器处理请求执行完成后,生成视图之前执行
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作    
     * 可在modelAndView中加入数据，比如当前时间
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("==============执行顺序: 2、postHandle================");    
        if(modelAndView != null){  //加入当前时间    
//            modelAndView.addObject("var", "测试postHandle,preHandle；");    
        } 
	}
	
	
	/* 
	 * afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
