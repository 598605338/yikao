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
<jsp:include page="../header.jsp" />
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script>
function doSubmit(){
	var form = document.saveForm;
	var type = form.type.value;
	var publishStartTimeStr = form.publishStartTimeStr.value;
	var publishEndTimeStr = form.publishEndTimeStr.value;
	var pCode = form.pCode.value;
	var clearPrice = form.clearPrice.value;
	var mallSupportType = form.mallSupportType.value;
	if(type==null || type==''){
        document.saveForm.type.focus();
        alert("请选择类型！");return false;
	}
	if(publishStartTimeStr==null || publishStartTimeStr==''){
        document.saveForm.publishStartTimeStr.focus();
        alert("请发布开始时间！");return false;
	}
	if(publishEndTimeStr==null || publishEndTimeStr==''){
        document.saveForm.publishEndTimeStr.focus();
        alert("请选择发布结束时间！");return false;
	}
	if(pCode==null || pCode==''){
        alert("请选择商品！");return false;
	}
	if(clearPrice==null || clearPrice==''){
        document.saveForm.clearPrice.focus();
        alert("请输入清仓价！");return false;
	}
	if(type ==1){
	var searchCondition = form.searchCondition.value;
	if(searchCondition !=null || searchCondition !=''){
		if(isNaN(searchCondition)){
        	document.saveForm.clearPrice.focus();
        	alert("预留件数应为数字！");return false;
		}
	}
	
	var searchTimeStr = form.searchTimeStr.value;
	if(searchTimeStr ==null || searchTimeStr ==''){
        document.saveForm.searchTimeStr.focus();
        alert("请选择检索时间！");return false;
	}
	}else if(type ==2){
		var quantity = form.quantity.value;
		if(quantity ==null || quantity ==''){
	        document.saveForm.quantity.focus();
	        alert("请输入参与活动库存数！");return false;
		}
	}
	
	if(mallSupportType == null || mallSupportType ==''){
	     alert("请选择参与门店！");return false;
	}else{
		if(mallSupportType == 2){
			var mallCode = form.mallCode.value;
			if(mallCode == null || mallCode ==''){
				alert("请添加参与门店！");return false;
			}
		}
	}
	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}

window.onload=function(){
	var startDateTextBox = $('#publishStartTimeStr');
	var endDateTextBox = $('#publishEndTimeStr');

	$.timepicker.datetimeRange(
		startDateTextBox,
		endDateTextBox,
		{
			//minInterval: (1000*60*60), // 23:59:59
			maxInterval: (1000*60*60*24*30-1),
			dateFormat: 'yy-mm-dd', 
			timeFormat: 'HH:mm:ss',
			start: {}, // start picker options
			end: {} // end picker options					
		}
	);
	
	$('#searchTimeStr').datetimepicker({
	 	dateFormat:'yy-mm-dd',
	 	timeFormat: 'HH:mm:ss',
	 	hour:'21',
		stepHour: 1,
		stepMinute: 1,
		stepSecond: 1
});
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
		height:38px;
	}
	.td_left{
		width:22%;
	}
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">尾货清仓</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">尾货清仓</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增尾货</span>
				</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="saveForm" action="add" method="post">
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>类型<span style="color:red">*</span>：</label>
					<select name="type" id="type" onchange="typeChange();" class="left td_text_w">
						<option value="">请选择</option>
						<option value="1">每日清仓</option>
						<option value="2">本期清仓</option>
					</select>
				</div>
				<div class="row-list">
					<label>发布时间<span style="color:red">*</span>：</label>
					<input type="text" name="publishStartTimeStr" style="width: 30%;" placeholder="发布时间起" id="publishStartTimeStr" readonly='readonly'  class="datatime-input td_text_w"  />
					<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
					<input type="text" name="publishEndTimeStr" style="width: 30%;" placeholder="发布时间止" id="publishEndTimeStr" readonly='readonly'  class="datatime-input td_text_w"  />
				</div>
				<div class="row-list">
					<label>商品名称：</label>
					<input type="text" style="width:47.5%;margin-right: 1.7%;" name="pName" id="pName" readonly="readonly" value="" class="td_text_w"/>
					<input type="hidden" name="productId" id="productId" value="" class="td_text_w"/>
					<input class="td_text_w" type="hidden" name="pSendType" id="pSendType" value="" />
					<a href="<%=basePath%>/product/select?popupFlg=1&params=productId,pCode,pName,pSendType,imageSrc,marketPrice,pImagePath" target="popupWin" onclick="popupProOpen();"><span style="margin: 0;width: 9.5%;position: relative;top: 1px;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
				</div>
				<div class="row-list">
					<label>商品条形码：</label>
					<input type="text" name="pCode" id="pCode" readonly="readonly" value="" class="td_text_w"/>
				</div>
				<div class="row-list">
					<label>商品价格：</label>
					<input type="text" name="marketPrice" id="marketPrice" readonly="readonly" value="" class="td_text_w"/>
				</div>
				<div class="row-list">
					<label>参与清仓价<span style="color:red">*</span>：</label>
					<input type="text" name="clearPrice" id="clearPrice" value="" class="td_text_w" maxlength="10" onkeyup="clearNoNum(this);"/><b>元</b>
				</div>
				<div id="quantityTr" style="display:none;">
					<div class="row-list">
						<label>参与活动库存<span style="color:red">*</span>：</label>
						<input type="text" name="quantity" id="quantity" value="" class="td_text_w" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</div>
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
					<label>商品图片：</label>
					<img src="<%=path %>/js/inputFile/btn.png" style="height: 142px;width: 182px;border: 1px solid #B3B3B3;" name="imageSrc" id="imageSrc" class="img1" />
					<input type="hidden" value="" name="pImagePath" id="pImagePath"/>
				</div>
				<div id="tbodyCondition" style="display:none;">
					<div class="row-list">
						<label>预留件数<span style="color:red">*</span>：</label>
						<input type="text" name="searchCondition" id="searchCondition" value="0" maxlength="4" class="td_text_w" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</div>
					<div class="row-list">
						<label>检索时间<span style="color:red">*</span>：</label>
						<input type="text" name="searchTimeStr" id="searchTimeStr" value="" class="td_text_w"  readonly='readonly' class="datatime-input" />
					</div>
				</div>
				
				<div class="row-list">
					<label>参与门店<span style="color:red">*</span>：</label>
					<input type="radio" style="border:none;" name="mallSupportType" value="1" class="left" onchange="mallChange('1');" /><span class="left" style="margin-top: 2px;">全部门店</span>
					<input type="radio" style="border:none;" name="mallSupportType" value="2" class="left" onchange="mallChange('2');" /><span class="left" style="margin-top: 2px;">部分门店</span>
					<div style="margin-left:10%;display:none;" id="addMallBtn"><a href="<%=basePath%>/shop/shopwinList?pageIndex=1" target="popupWin1" onclick="popupProOpen1();"><span style="display:inline-block;" class="back_dblue left btn">添加门店</span></a></div>
					<input type="hidden" id="mall_codes" value="${query.mall_codes}" name="mallCode">
				</div>
				<div id="mallNamesDiv" style="display:none;">
					<div class="row-list">
						<label>已选择门店:</label>
						<input type="text" readonly='readonly' id="mall_names" name="mallNames" value="" class="left td_text_w" />
					</div>
				</div>
				<div class="row-list">
					<label>排序：</label>
					<input type="text" name="sortIndex" id="sortIndex" value="<c:out value="${maxSortIndex }"/>" class="td_text_w" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
				</div>
			</div>
		</div>
		
	</form>
	</section>
	<div class="bgbtn">
		<!-- <input style="margin-left:-217%;" type="button" value="保存" class="left btn back_dblue" onclick="doSubmit();"/> 
		<input style="margin-left:-158%;" type="button" value="返回" class="left btn back_dblue" onclick="doBack();" /> -->
		<button type="button" class="left btn back_dblue" onclick="doSubmit();"><i class="icon-btn icon-save"></i>保存</button> 
		<button type="button" class="left btn back_dblue" onclick="doBack();" ><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	
   	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose();">×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	
   		<!-- 弹出门店选择框 -->
	<div id="fade1" class="black_overlay">  
    </div>
    <div id="popupDiv1" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose1();">×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin1" name="popupWin1" frameborder="0">
		</iframe>  
   	</div> 
   	</div>
</body>
</html>

<script>

function typeChange(){
	var type = $("#type").children("option:selected").val();
	if(type == 1){
		$("#quantityTr").hide();
		$("#quantity").val('');
		$("#tbodyCondition").show();
	}else{
		$("#quantityTr").show();
		$("#tbodyCondition").hide();
		$("#searchCondition").val('');
		$("#searchTimeStr").val('');
	}
}

function mallChange(o){
	if(o=='1'){
		$("#addMallBtn").hide();
		$("#mall_codes").val('');
		$("#mall_names").val('');
		$("#mallNamesDiv").hide();
	}else if(o=='2'){
		$("#addMallBtn").show();
		$("#mallNamesDiv").show();
	}
}
</script>
<script type="text/javascript">
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,""); 
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
   $("")
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
