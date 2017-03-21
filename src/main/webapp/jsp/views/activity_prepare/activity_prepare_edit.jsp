<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<jsp:include page="../header.jsp" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script>
function doSubmit(){
	var form = document.editForm;
	var activityStartTimeStr = form.activityStartTimeStr.value;
	var activityEndTimeStr = form.activityEndTimeStr.value;
	var pCode = form.pCode.value;
	var activityPrice = form.activityPrice.value;
	var activityQuantity = form.activityQuantity.value;
	if(activityStartTimeStr==null || activityStartTimeStr==''){
        document.editForm.activityStartTimeStr.focus();
        alert("请选择活动开始时间！");return false;
	}
	if(activityEndTimeStr==null || activityEndTimeStr==''){
        document.editForm.activityEndTimeStr.focus();
        alert("请选择活动结束时间！");return false;
	}
	if(pCode==null || pCode==''){
        alert("请选择商品！");return false;
	}
	if(activityPrice==null || activityPrice==''){
        document.editForm.activityPrice.focus();
        alert("请输入活动价！");return false;
	}
	if(activityQuantity==null || activityQuantity==''){
        document.editForm.activityQuantity.focus();
        alert("请输入活动库存！");return false;
	}
	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}
/**2017.2.10
 * 这是一个日期插件
 * Demo地址：http://www.cnblogs.com/linJie1930906722/p/6066071.html
 * 类似第六个开始结束区间(第二种写法)
 */
window.onload=function(){
	var startDateTextBox = $('#activityStartTimeStr');
	var endDateTextBox = $('#activityEndTimeStr');

	$.timepicker.datetimeRange(
		startDateTextBox,
		endDateTextBox,
		{
			minInterval: (1000*60*60*24-1), // 1hr
			dateFormat: 'yy-mm-dd', 
			timeFormat: 'HH:mm:ss',
			start: {}, // start picker options
			end: {} // end picker options					
		}
	);
	
	var startDateTextBox = $('#getselfStartTimeStr');
	var endDateTextBox = $('#getselfEndTimeStr');

	$.timepicker.datetimeRange(
		startDateTextBox,
		endDateTextBox,
		{
			minInterval: (1000*60*60*24-1), // 1hr
			dateFormat: 'yy-mm-dd', 
			timeFormat: 'HH:mm:ss',
			start: {}, // start picker options
			end: {} // end picker options					
		}
	);
}
</script>
<style>
	td{
		border:none;
	}
	.td_right{
		display:block;
		margin-left:-15%;
	}
	.height{
		height:40px;
	}
	.td_left{
		width:22%;
	}
</style>
<body>
	<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">预约购买管理</header> -->
	<header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
		<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">预约购买管理</a><span>&gt;</span>
		<span style="color:#3bb3e0;">修改</span>
	</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="editForm" action="edit" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="id" id="id" value="<c:out value="${activityPrepare.id }"/>" />
		
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>活动时间<span style="color:red">*</span>：</label>
					<input type="text" name="activityStartTimeStr" id="activityStartTimeStr" value="<fmt:formatDate value="${activityPrepare.activityStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"  class="datatime-input td_text_w"/>
				</div>
				<div class="row-list">
					<label ></label> 
					<input type="text" name="activityEndTimeStr" id="activityEndTimeStr" value="<fmt:formatDate value="${activityPrepare.activityEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" class="datatime-input td_text_w"/>
				</div>
				<div class="row-list">
					<label>提货时间：</label>
					<input class="left" style="border:none;" type="radio" name="gettimeType" value="1" onchange="gettimeTypeChange(1)"/>	
					<span class="left">静态时间</span>
					<input class="left" style="border:none;" type="radio" name="gettimeType" value="2" onchange="gettimeTypeChange(2)"/>
					<span class="left">动态时间</span>
				</div>
				<div id="gettimeType_1">
					<div class="row-list">
						<label ></label>
						<input style="display:inline-block !important; height:30px;width:30%;" type="text" name="getselfStartTimeStr" id="getselfStartTimeStr" value="<fmt:formatDate value="${activityPrepare.getselfStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"  class="datatime-input"/>
						<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
						<input style="display:inline-block !important; height:30px;width:30%;" type="text" name="getselfEndTimeStr" id="getselfEndTimeStr" value="<fmt:formatDate value="${activityPrepare.getselfEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"  class="datatime-input"/>
					</div>
				</div>
				<div id="gettimeType_2" style="display:none;">
					<div class="row-list">
						<label></label>
						<span class="left">预约后</span><input class="td_text_w_30 left" type="text" name="numDaysLater" id="numDaysLater" value="<c:out value="${activityPrepare.numDaysLater }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><span class="left">天领取</span>		
					</div>
				</div>
				<div class="row-list">
					<label>商品名称：</label>
					<input class="td_text_w" type="text" style="width: 47.5%;margin-right: 1.7%;" name="pName" id="pName" readonly="readonly" value="<c:out value="${activityPrepare.pName }"/>" />
					<input class="td_text_w" type="hidden" name="productId" id="productId" value="<c:out value="${activityPrepare.productId }"/>" />
					<input class="td_text_w" type="hidden" name="pSendType" id="pSendType" value="<c:out value="${activityPrepare.pSendType }"/>" />
					<a href="<%=basePath%>/product/select?popupFlg=1&activityFlg=1&params=productId,pCode,pName,pSendType,null,marketPrice,null" target="popupWin" onclick="popupProOpen();"><span style="width: 9.5%;margin: 0;position: relative;top:1px;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
				</div>
				<div class="row-list">
					<label>商品条形码<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="pCode" id="pCode" readonly="readonly" value="<c:out value="${activityPrepare.pCode }"/>" />
				</div>
				<div class="row-list">
					<label>市场价：</label>
					<input class="td_text_w" type="text" name="marketPrice" id="marketPrice" readonly="readonly" value="<c:out value="${activityPrepare.marketPrice }"/>" />
				</div>
				<div class="row-list">
					<label>参与活动价<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="activityPrice" id="activityPrice" value="<c:out value="${activityPrepare.activityPrice }"/>" maxlength="10"  onkeyup="clearNoNum(this);"/>
				</div>
				<div class="row-list">
					<label>参与活动库存<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="activityQuantity" id="activityQuantity" value="<c:out value="${activityPrepare.activityQuantity }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
				</div>
			</div>
			<div class="line"></div>
			<div class="editRigth">
				<div class="row-list">
					<label>描述：</label>
					<textarea name="description" id="description" class="left td_text_w" maxlength="150" 
						style=" height: 100px;"><c:out value="${activityPrepare.description }"/></textarea>
				</div>
				<div class="row-list">
					<label>商品图片：</label>
					<div class="imgbox">
    					<div class="imgnum">
						<input type="file" class="filepath" name="uploadImage" id="uploadImage" />
       					<span class="close" style="top: 0;">×</span>
        				<img src="<c:out value="${activityPrepare.imagePath }"/>" class="img1" />
        				<img src="" class="img2" />
        				</div>
        			</div>
				</div>
				<div class="row-list">
					<label>排序：</label>
					<input class="td_text_w" type="text" name="sortIndex" id="sortIndex" maxlength="4" value="<c:out value="${activityPrepare.sortIndex }"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
				</div>
			</div>
		</div>
		
	</form>
	</section>
	<div class="bgbtn">
		<button type="button" class="left btn back_dblue" onclick="doSubmit();"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left btn back_dblue" onclick="doBack()" ><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose();" >×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	</div>
</body>
</html>
<script>
var gettimeType = '<c:out value="${activityPrepare.gettimeType }"/>';
$("[name='gettimeType'][value='<c:out value="${activityPrepare.gettimeType }"/>']").attr("checked",true);
gettimeTypeChange(gettimeType);

function gettimeTypeChange(i){
	if(i==1){
		$("#gettimeType_1").show();
		$("#gettimeType_2").hide();
	}else if(i==2){
		$("#gettimeType_2").show();
		$("#gettimeType_1").hide();
	}
}
</script>
<script type="text/javascript"> 
var browser=navigator.appName 
var b_version=navigator.appVersion 
var version=b_version.split(";"); 
var trim_Version=version[1].replace(/[ ]/g,"");  
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") { 
$(".td_left").css("width","8%")
} 
</script>