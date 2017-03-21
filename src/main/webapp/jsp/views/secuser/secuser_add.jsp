<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<script>
function doSubmit(){
	var form = document.saveForm;
	var login = form.login.value;
	var password = form.password.value;
	var confirmPassword = form.confirmPassword.value;
	var phone = form.phone.value;
	var level = form.level.value;
	if(login==null || login==''){
        document.saveForm.login.focus();
        alert("请填写用户名！");return false;
	}
	if(password==null || password==''){
        document.saveForm.password.focus();
        alert("请填写密码！");return false;
	}
	if(confirmPassword==null || confirmPassword==''){
        document.saveForm.confirmPassword.focus();
        alert("请填写确认密码！");return false;
	}
	if(phone==null || phone==''){
		document.saveForm.phone.focus();
        alert("请填写手机号！");return false;
	}
	if(level==null || level==''){
        alert("请选择用户类型！");return false;
	}
	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
	td{
		border:none;
	}
	.td_left{
		width:9%;
	}
	.td_right{
		height:40px;
	}
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">用户管理</header> -->
	<header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
		<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">用户管理</a><span>&gt;</span>
		<span style="color:#3bb3e0;">新增</span>
	</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="saveForm" action="add" method="post">

		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>用户名<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="login" id="login" value="" />
				</div>
				<div class="row-list">
					<label>真实姓名<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="name" id="name" value="" />
				</div>
				<div class="row-list">
					<label>密码<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="password" id="password" value="" />
				</div>
				<div class="row-list">
					<label>密码确认<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="confirmPassword" id="confirmPassword" value="" />
				</div>
				<div class="row-list">
					<label>手机号<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="phone" id="phone" value="" />
				</div>
				<div class="row-list">
					<label>用户类型<span style="color:red">*</span>：</label>
					<select class="td_text_w" name="level" id="level" class="left">
						<option value="">请选择</option>
						<option value="0">管理员</option>
						<option value="1">系统用户</option>
						<option value="2">店铺用户</option>
					</select>
				</div>
				<div class="row-list">
					<label>所属门店：</label>
					<input class="td_text_w" type="text" name="mallCode" id="mallCode" value="" />
				</div>
				<div class="row-list">
					<label>用户组:</label>
					<c:forEach items="${secRoleList }" var="item" varStatus="status">
						<input style="border:none;" class="left" type="checkbox" name="privilegeIds" id="privilegeIds_${item.id }" value="${item.id }" /><span style="margin-top: 3px;" class="left">${item.name }</span> &nbsp;&nbsp;
					</c:forEach>
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
				
				</div>
			</div>
		</div>
		
	</form>
	</section>
	<div class="bgbtn" >
		<!-- <input type="button" value="保存" class="left btn back_dblue" onclick="doSubmit()"/> 
		<input type="button" value="返回" class="left btn back_dblue" onclick="doBack()" /> -->
		<button type="button" onclick="document.getElementById('formain').submit();" class="left btn back_dblue"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left btn back_dblue" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>