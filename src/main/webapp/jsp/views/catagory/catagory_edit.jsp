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
	var form = document.editForm;
	var name = form.name.value;
	if(name==null || name==''){
        document.editForm.name.focus();
        alert("请输入品类名称！");return false;
	}
	form.submit();
}

//返回
function doBack(){
	var largeCatagoryId = $("#largeCatagoryId").val();
	if(largeCatagoryId){
		document.location.href="selectMiddleCatagory?largeCatagoryId=" + largeCatagoryId;
	}else{
		document.location.href="selectLargeCatagory";
	}
}
</script>
<style>
	.bord{
		border:none !important;
	}
	 .domit{
	 	margin:6% 0% 0% -245%;
	 }
      .doack{
	 	margin:6% 0% 0% -195%;
	 }
	 .td_left{
	 	width:22%;
	 }
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">分类管理</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">分类管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="editForm" action="edit" method="post">
		<input type="hidden" name="largeCatagoryId" id="largeCatagoryId" value="<c:out value="${largeCatagoryId }"/>" /> 
		<input type="hidden" name="id" id="id" value="<c:out value="${catagory.id }"/>" />
	    
	    <div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>名称：</label>
					<input  class="td_text_w" type="text" name="name" id="name" value="<c:out value="${catagory.name }"/>" />
				</div>
				<div class="row-list">
					<label>排序：</label>
					<input class="td_text_w" type="text" name="sortIndex" id="sortIndex" value="<c:out value="${catagory.sortIndex }"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
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
		<!-- <input type="button" value="保存" class="left btn back_dblue domit" onclick="doSubmit();"/> 
		<input type="button" value="返回" class="left btn back_dblue doack" onclick="doBack();" /> -->
		<button type="button" onclick="doSubmit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>