<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<%=path%>/js/divPage/dividePage.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<jsp:include page="../header.jsp" />
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<style>
     a:link{
        color:#2285C5;
     }
	a:hover{
	
		color:#3BB3E0;
	}
	a:active{
		color:#19699D;
	}
</style>
<script>
/**2017.2.10
 * 这是一个日期插件
 * Demo地址：http://www.cnblogs.com/linJie1930906722/p/6066071.html
 */
window.onload=function(){
	 
	 var startDateTextBox = $('#startTimeStr');
	 var endDateTextBox = $('#endTimeStr');

	 $.timepicker.dateRange(
	 	startDateTextBox,
	 	endDateTextBox,
	 	{
	 		minInterval: (1000*60*60*24*0), // 4 days
	 		maxInterval: (1000*60*60*24*30), // 8 days
	 		start: {}, // start picker options
	 		end: {} // end picker options
	 	}); 
}
</script>
<body>
<div id="wrap">
				<!-- <header class="cont_section_header">第三方合作券</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">卡券</a><span>&gt;</span>
					<span style="color:#3bb3e0;">第三方合作券</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
							<form name="form" id="formSubmit" action="selectThird" method="post">
								<div class="row">
									<input type="text" name="cardName" placeholder="卡券名称" id="cardName" value="<c:out value="${query.cardName }"/>" class="td_text_w" />
									<select name="cardType" id="cardType" class="left">
										<option value="">卡券类型</option>
										<option value="6">链接券</option>
										<option value="7">券码</option>
									</select>
									<input type="text" name="startTimeStr" placeholder="创建时间起" id="startTimeStr" value="<fmt:formatDate value="${query.startTime }" pattern="yyyy-MM-dd" />" class="datatime-input" />
									<input type="text" name="endTimeStr" placeholder="创建时间止" id="endTimeStr" value="<fmt:formatDate value="${query.endTime }" pattern="yyyy-MM-dd" />" class="datatime-input" />
								</div>
								<div class="col-click">
									<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
									<button type="button" class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
								</div>
							</form>	
						</div>				
						<div class="section_table">
							<table class="table_hover" cellspacing="none">
						<div class="click">
							<a href="javascript:void(0)"><span class="left back_dblue btn btn_import"><i class="icon-btn icon-import"></i>导入</span></a>
							<a href="javascript:void(0)" onclick="exportCard();"><span class="left back_dblue btn"><i class="icon-btn icon-export"></i>导出</span></a>
							<!-- <a href="javascript:void()" onclick="javascript:location.href='download'"><span class="left back_dblue btn">模板下载</span></a> -->
						</div>
						<thead style="background:#EBEBEB;">
							<th>创建时间</th>
							<th>卡券名称</th>
							<th style="width:42%">代金券劵码/链接</th>
							<th>卡券类型</th>
							<th>发放数量</th>
							<th>有效期</th>
							<th style="width:8%">操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${cardCouponList }" varStatus="status">
							<tr class="goods_tr" >
								<td><fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd"/></td>
								<td><c:out value="${item.cardName }"/></td>
								<td><c:out value="${item.description }"/></td>
								<td><c:if test="${item.cardType==6 }">链接券</c:if><c:if test="${item.cardType==7 }">券码</c:if></td>
								<td><c:out value="${item.totalNum }"/></td>
								<td><fmt:formatDate value="${item.startTime }"/>～<fmt:formatDate value="${item.endTime }"/></td>
								<td>
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='deleteCardCoupon?cardId=<c:out value="${item.cardId }" />'"><i class="icon-op icon-op-edit"></i>删除</a>
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='selectThirdDetail?cardCouponId=<c:out value="${item.cardId }" />'"><i class="icon-op icon-op-details"></i>查看详情</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="selectThird" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="" />
				    <input type="hidden" name="pageSize" id="pageSize" value="" />
				    <input type="hidden" name="cardName" id="cardName" value="<c:out value="${query.cardName}"/>" />
				    <input type="hidden" name="cardType" id="cardType" value="<c:out value="${query.cardType}"/>" />
				    <input type="hidden" name="startTimeStr" id="startTimeStr" value="<c:out value="${query.startTimeStr}"/>" />
				    <input type="hidden" name="endTimeStr" id="endTimeStr" value="<c:out value="${query.endTimeStr}"/>" />
					<%-- <a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex-1 }" />);"><span class="left page">上一页</span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex }" />);"><span class="left page page_chose"><c:out value="${query.pageIndex }" /></span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex+1 }" />);"><span class="left page">下一页</span></a> --%>
				   </form>
				   <div id="div_pager"></div>
				</footer>
			
			<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 --> 		
		<div class="div_hid" id="spm" style="display: none;"></div>		
		<!-- 弹出导入页面 -->				
			<div class="div_alert">
				<header class="div_alert_top">导入第三方卡券</header>
				<section class="div_alert_mid">
				 <form action="" id="upfile" name="upfile" method="post" enctype="multipart/form-data">
						<input type="file"  class="btn_file left"  name="file" />
						<a href="javascript:void(0)" onclick="importProduct();"><span class="btn left btn_post">上传文件</span></a>
						<a href="javascript:void(0)" onclick="javascript:location.href='download'"><span class="btn left btn_load">下载模板</span></a>
						<span style="color:red;">注*：一次只能导入同一种卡券</span>
				</form>	
				</section>
				<footer class="div_alert_bot">
					<a href="javascript:void(0)" onclick="closePopup();"><span class="btn btn_alertClose">关闭</span></a>
				</footer>
				<a href="javascript:void(0)" onclick="closePopup();"><span class="close">×</span></a>
			</div>
	</div>
</body>
</html>

<script>
//设置筛选条件
$("#cardType").val(<c:out value="${query.cardType}"/>);
$(".btn_import").on("click",function(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"block"}); 
	_div.css({"display":"block"});
	return false; 
});

//总记录数数
var totalRecords = ${pnums};
//每页记录数
var pageSize=10;
//当前页
var pageNo = ${query.pageIndex}; //这里设置参数名
if (!pageNo) {
	pageNo = 1;
}

var totalPage = dividePage.getTotals(totalRecords,pageSize);
//生成分页控件 根据分页的形式在这里设置
dividePage.init({
	pno : pageNo,
	//总页码
	total : totalPage,
	//总数据条数
	totalRecords : totalRecords,
	//链接前部
	hrefFormer : 'select',
	//链接尾部
	hrefLatter :'',
	getLink : function(n) {
		return this.hrefFormer + this.hrefLatter + "?pageIndex=" + n+"&pageSize="+pageSize //参数名跟上面相同
	},
	getLink2 : function(pageIndex,pageSize) {
		return "javascript:submitPageForm("+pageIndex+","+pageSize+");" //参数名跟上面相同
	}
});
dividePage.generPageHtml2();


/*
 * 重置
 */
function resetForm(){
	$("#cardName").val(null);
	$("#cardType").val("");
	$("#startTimeStr").val("");
	$("#endTimeStr").val("");
}

/*
 * 导出
 */
function exportCard(){
	$("[name='form']").attr("action","exportCard");
	$("[name='form']").submit();
	$("[name='form']").attr("action","selectThird");
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}

/*
 * 导入
 */
function importProduct(){
		var formData = new FormData();
		var files = $('input[name="file"]').prop('files');
		if(files == null){
			alert("请先选择上传文件");
			return false;
		}
		formData.append("file",files[0]);
		$.ajax({ 
			url : "importCardCouponThird", 
			type : 'POST', 
			data : formData, 
			// 告诉jQuery不要去处理发送的数据
			processData : false, 
			// 告诉jQuery不要去设置Content-Type请求头
			contentType : false,
			beforeSend:function(){
			console.log("正在进行，请稍候");
			},
			success : function(result) { 
				alert(result["message"]);
			}, 
			error : function(r) { 
				alert(result["message"]);
			} 
			});
}

function closePopup(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"none"}); 
	_div.css({"display":"none"});
	return false; 
}

</script>