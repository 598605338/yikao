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
	var type = form.type.value;
	var description = form.description.value;
	if(name==null || name==''){
        document.saveForm.name.focus();
        alert("请输入标签名称！");return false;
	}
	if(type==null || type==''){
        document.saveForm.type.focus();
        alert("请选择标签类型！");return false;
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
		margin-left:-245%;
	}
	.abd{
		margin-top:16px;
		margin-left:-190%;
	}
	#description{
		margin-top:3px;
	}
	label{
		border:
	}
	.td_left{
		width:23%;
	}
	td{
		line-height:34px;
	}
</style>
<body>
	<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">标签管理</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">标签管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增标签</span>
				</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="saveForm" action="add" method="post">
	
	<div class="editPage">
		<div class="editLeft">
			<div class="row-list">
				<label>标签名称<span style="color:red">*</span>：</label>
				<input class="td_text_w" type="text" name="name" id="name" value="" />
			</div>
			<div class="row-list">
				<label>标签类型<span style="color:red">*</span>：</label>
				<div>
					<input style="border:none;" class="left" type="radio" name="type" disabled value="1"  />
					<span class="left" style="margin-top: 2px;">促销标签</span>
					<input style="border:none;" class="left" type="radio" name="type" value="2" />	
					<span class="left" style="margin-top: 2px;">商品标签</span>
				</div>
			</div>
			<div class="row-list">
				<label style="padding-top:-3%;">标签描述：</label>
				<textarea style="width: 63.5%;" name="description" id="description" class="td_text_w"></textarea>
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
	<div class="bgbtn">
		<!-- <input type="button" value="保存" class="left btn back_dblue" onclick="doSubmit();" /> 
		<input type="button" value="返回" class="left btn back_dblue" onclick="doBack();" /> -->
		<button type="button" class="left btn back_dblue" onclick="doSubmit();" ><i class="icon-btn icon-save"></i>保存</button> 
		<button type="button" class="left btn back_dblue" onclick="doBack();" ><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>