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
	var name = form.name.value;
	if(name==null || name==''){
        document.saveForm.collegeName.focus();
        alert("请输入院校分类名称！");return false;
	}

	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
	.abc{
		margin-top:16px;
		margin-left:-230%;
	}
	.abd{
		margin-top:16px;
		margin-left:-180%;
	}
	#description{
		margin-top:3px;
	}
	.td_left{
		width:22%;
	}
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">基本信息</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">院校类型管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增院校类型</span>
				</header>
	<section class="cont_section_section_border">
	<form id="formSubmit" class="goods_new" name="saveForm" action="add" method="post">
	
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>院校类型名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="name" id="name" value="" />
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
			</div>
		</div>
		
	</form>
	</section>
	<div class="bgbtn">
		<button type="button" onclick="doSubmit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue  btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>
<script>


</script>