package com.linjia.web.interceptors;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;


/** 
 * @author  lixinling: 
 * @date 2016年11月16日 下午4:08:59 
 * @version 1.0 
*/
public class LoginViewResolver extends InternalResourceView {
	
	 @Override  
     public boolean checkResource(Locale locale) {  
      File file = new File(this.getServletContext().getRealPath("/") + getUrl());  
      return file.exists();// 判断该页面是否存在  
     }  
}
