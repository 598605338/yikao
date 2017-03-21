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
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script>
/**2017.2.10
 * 这个是一个jQueryUI日期插件
 * Demo地址：https://jqueryui.com/datepicker/
 */
window.onload=function(){ 		 
	 $('#publishDateStr').datepicker();
}

function doSubmit(){
	var form = document.saveForm;
	var name = form.name.value;
	var timeNode = form.timeNode.value;
	var publishDateStr = form.publishDateStr.value;
	var limitQuantity = form.limitQuantity.value;
	if(name==null || name==''){
        document.saveForm.name.focus();
        alert("请输入活动名称！");return false;
	}
	if(timeNode==null || timeNode==''){
        document.saveForm.timeNode.focus();
        alert("请选择秒杀时间段！");return false;
	}
	if(publishDateStr==null || publishDateStr==''){
        document.saveForm.publishDateStr.focus();
        alert("请输入发放时间！");return false;
	}
	if(limitQuantity==null || limitQuantity==''){
        document.saveForm.limitQuantity.focus();
        alert("请输入每单限购数！");return false;
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
	.placeLeft{
		display: block;
		margin-left:-10%;
	}
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">秒杀管理</header> -->
	<header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
		<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">秒杀管理</a><span>&gt;</span>
		<span style="color:#3bb3e0;">新增</span>
	</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="saveForm" action="addMiaoshaBase" method="post">
		<table cellpadding="0" cellspacing="0">
			<tbody>
				<tr class="height">
					<td class="td_left">
						<label>活动名称<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right placeLeft">
						<input class="td_text_w" type="text" name="name" id="name" value="" maxlength="50" />
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>秒杀时间段<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right placeLeft">
						<input style="float:left;border:none;" type="radio" name="timeNode" value="1"/><label style="float:left;width:45px;margin-left: 0;">9:00</label>
						<input style="float:left;border:none;"  type="radio" name="timeNode" value="2" /><label style="float:left;width:45px;border:none;margin-left: 0;">12:00</label>
						<input style="float:left;border:none;"  type="radio" name="timeNode" value="3" /><label style="float:left;width:45px;margin-left: 0;">15:00</label>
						<input style="float:left;border:none;"  type="radio" name="timeNode" value="4" /><label style="float:left;width:45px;margin-left: 0;">18:00</label>
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>发布时间<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right placeLeft">
						<input class="td_text_w" type="text" name="publishDateStr" id="publishDateStr" value="" readonly='readonly' class="datatime-input"/>
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label style="display:block;margin-top:1%;">每单限购<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right placeLeft">
						<input style="display:block;margin-top:1%;" readonly="readonly" class="td_text_w" type="text" name="limitQuantity" id="limitQuantity" value="1" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</section>
	<div class="bgbtn">
		<!-- <input type="button" value="保存" class="left btn back_dblue" onclick="doSubmit()" /> 
		<input type="button"  value="返回" class="left btn back_dblue" onclick="doBack()" /> -->
		<button type="button" class="left btn back_dblue" onclick="doSubmit()" ><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left btn back_dblue" onclick="window.history.back()" ><i class="icon-btn icon-goback"></i>返回</button>
		<!-- onclick="doBack()" -->
	</div>
	</div>
</body>
</html>
<script type="text/javascript"> 
/**2017.2.10
 * 检测浏览器版本，是否为IE9
 */
var browser=navigator.appName 
var b_version=navigator.appVersion 
var version=b_version.split(";"); 
var trim_Version=version[1].replace(/[ ]/g,"");  
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") { 
$(".td_left").css("width","8%")
} 
</script>