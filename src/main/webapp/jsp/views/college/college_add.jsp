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
	var specialtyName = form.specialtyName.value;
	if(specialtyName==null || specialtyName==''){
        document.saveForm.specialtyName.focus();
        alert("请输入院校名称！");return false;
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
	<!-- <header class="cont_section_header">品牌管理</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">基本信息</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">院校管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增院校</span>
				</header>
	<section class="cont_section_section_border">
	<form id="formSubmit" class="goods_new" name="saveForm" action="add" method="post">
	
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>院校名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="collegeName" id="collegeName" value="" />
				</div>
				<div class="row-list">
					<label>所属省<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="provinceName" id="provinceName" value="" />
					<select name="provinceId" id="provinceId" class="td_text_w">
						<option value="">请选择</option>
						<c:forEach items="${provinceList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>所属市<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="cityName" id="cityName" value="" />
					<select name="cityId" id="cityId" class="td_text_w">
						<option value="">请选择</option>
						<c:forEach items="${cityList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>所属区<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="countyName" id="countyName" value="" />
					<select name="countyId" id="countyId" class="td_text_w">
						<option value="">请选择</option>
						<c:forEach items="${countyList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
					<label>详细地址<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="address" id="address" value="" />
				</div>
				<div class="row-list">
					<label>固定电话<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="mobile" id="mobile" value="" />
				</div>
				<div class="row-list">
					<label>移动电话<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="phone" id="phone" value="" />
				</div>
			</div>
			<div class="row-list">
				<label>院校科目选择<span style="color:red">*</span>：</label>
				<div style="width:100%;display:inline;float:left;">
					<c:forEach items="${countyList }" var="item" varStatus="status">
					<div class="height">
						<input class="left" type="checkbox" name="specialtyIds" id="specialtyIds_"+${varStatus.index}  value="{item.id}" /><label class="left">${item.name}</label>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
	</form>
	</section>
	<div class="bgbtn">
		<button type="button" onclick="document.getElementById('formSubmit').submit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue  btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>