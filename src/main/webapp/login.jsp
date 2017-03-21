<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邻家后台管理系统--登录页</title>
<link rel="stylesheet" href="<%=basePath %>dist/css/common.css" />
<link rel="stylesheet" href="<%=basePath %>dist/css/login.css" />
<script src="<%=basePath %>dist/js/jquery-1.11.2.js"></script>

<script type="text/javascript">
		if(self!=top){
			parent.window.location.replace(window.location.href);
		}
</script>
</head>
<body>
		<div class="login_none"></div>
		<div id="login">
			<header class="login_header" style="width:40%;margin:0 auto;">
				<img style="width:95%;"  src="<%=basePath %>dist/images/header.png" alt="" />
			</header>
			<section class="login_section">
				<div class="login_sl left">
					<img class="login_spic" src="<%=basePath %>dist/images/login_sl.png" alt="" />
				</div>
				<form class="login_sm left linear_login" action="<%=basePath %>doLogin" method="post">
					<div class="login_smIn_top">
						<p>
							<span style="font-family: '微软雅黑';">用户登录</span>
							<span style="font-family: '微软雅黑';" class="login_smIn_eng">Userlogin</span>
						</p>
					</div>
					<div class="login_smIn_inp login_inp_one">
						<label for="">用户名：</label>
						<input type="text" id="userName"  name="userName"/>
					</div>
					<div class="login_smIn_inp">
						<label for="">密&nbsp;码：</label>
						<input type="password" id="password" name="password" />
					</div>
					<div class="login_smIn_inp">
						<label for="">验证码：</label>
						<p style="width:50%;display:inline-block;"><input style="width:100%;" type="text" name="validateCode" id="validateCode" /></p>
						<p style="width:5%;display:inline-block;">
							<span class="login_smIn_code" style="width:3%;">
							    <img name="vercode_img" id="vercode_img" alt="点击更换" title="点击更换" src="<%=basePath%>validateCode" onclick="javascript:reloadVerifyCode();" style="margin-left:5px;margin-top:2px;cursor: pointer;">	
						    </span>
						</p>
					</div>
					<div class="login_smIn_txt" style="text-align:center;"><c:out value="${message }" /></div>
					<div class="login_smin_btn">
						<input type="submit" class="left back_dblue col_white btn" value="登录"/>
						<input type="button" class="left back_dblue col_white btn" value="取消" />
					</div>
				</form>
				<div class="login_sr left">
					<img class="login_spic" src="<%=basePath %>dist/images/login_sr.png" alt="" />
				</div>
			</section>
		</div>
	</body>
</html>
<script>
function reloadVerifyCode(){  
    var timenow = new Date().getTime();                          
    document.getElementById("vercode_img").src="<%=basePath%>validateCode?d="+timenow;  
}  
</script>