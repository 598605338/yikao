package com.linjia.web.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.linjia.web.model.SecUser;

/** 
 * @author  lixinling: 
 * @date 2016年11月16日 下午2:10:58 
 * @version 1.0 
*/
public class CheckLoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 不过滤的uri
		String[] notFilter = new String[] { "index.html", "login.jsp" };

		// 请求的uri
		String uri = request.getRequestURI();

		// uri中包含.jsp时才进行过滤
		if (uri.indexOf(".jsp") != -1) {

			// 是否过滤
			boolean doFilter = true;

			for (String s : notFilter) {
				if (uri.indexOf(s) != -1) {
					doFilter = false;
					break;
				}
			}

			if (doFilter) {
				SecUser loginUser = (SecUser) request.getSession().getAttribute("user");
				if (loginUser == null) {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else {
					filterChain.doFilter(request, response);
				}
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

}
