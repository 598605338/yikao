<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	var form = document.editForm;
	var name = form.name.value;
	var description = form.description.value;
	if(name==null || name==''){
        document.editForm.name.focus();
        alert("请填写用户组！");return false;
	}
	if(description==null || description==''){
        document.editForm.description.focus();
        alert("请填写描述信息！");return false;
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
	.td_right{
		display:block;
		margin-left:-17%;
	}
	.height{
		height:45px;
	}
</style>
<body>
	<div id="wrap">
		<font color="red"><c:out value="${message }" /></font>
		<!-- <header class="cont_section_header">权限管理</header> -->
		<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">权限管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">权限修改</span>
				</header>
		<section class="cont_section_section_border">
		<form class="goods_new" name="editForm" action="edit" method="post">
			<input type="hidden" name="id" id="id" value="<c:out value="${secRole.id}"/>" />
			
			<div class="editPage">
				<div class="editLeft">
					<div class="row-list">
						<label>用户组<span style="color:red">*</span>：</label>
						<input class="td_text_w" type="text" name="name" id="name" value="<c:out value="${secRole.name}"/>" />
					</div>
					<div class="row-list">
						<label>描述<span style="color:red">*</span>：</label>
						<textarea name="description" id="description" class="td_text_w"
						style="width: 63.5%; height: 100px;"><c:out value="${secRole.description}"/></textarea>
					</div>
				</div>
				<div class="line"></div>
				<div class="editRight">
					
				</div>
			</div>
			
		</form>
		</section>
		<div class="bgbtn">
			<!-- <input style="margin:11% 0 0 -240%;" type="button" value="保存" class="left btn back_dblue" onclick="doSubmit()"/> 
			<input style="margin:11% 0 0 -189%;" type="button" value="返回" class="left btn back_dblue" onclick="doBack()" /> -->
			<button type="button" onclick="doSubmit()" class="left btn back_dblue"><i class="icon-btn icon-save"></i>保存</button>
			<button type="button" class="left btn back_dblue" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
		</div>
	</div>
</body>
</html>