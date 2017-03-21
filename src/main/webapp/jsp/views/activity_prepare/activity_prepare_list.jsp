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
	.amend{
		width:15%;
		padding-left:2%;
	}
</style>
<script>
window.onload=function(){
	/*  $('#activityStartTimeStr').datetimepicker({
			dateFormat:'yy-mm-dd',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1
		});
	
	 $('#activityEndTimeStr').datetimepicker({
		 	dateFormat:'yy-mm-dd',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1
	}); */
	 
 /* $('#activityStartTimeStr').datepicker();

 $('#activityEndTimeStr').datepicker(); */
	
	 var startDateTextBox = $('#activityStartTimeStr');
	 var endDateTextBox = $('#activityEndTimeStr');

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
function deleteRecord(){
	var recordIds = new Array();
	$("[name='id']").each(function(i,item){
		if(item.checked==true)
			recordIds.push(item.value);
	});
	if(recordIds.length > 0){
		document.location.href="delete?recordIds=" + recordIds;
	}else{
		alert("请选择要删除的记录");
	}
}
</script>
<body>
	<div id="wrap">
				<!-- <header class="cont_section_header">预约购买管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<span style="color:#3bb3e0;">预约购买管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form name="form" id="formSearch" action="select" method="post">
						<div class="row">
							<input type="text" name="pName" placeholder="商品名称" id="pName" value="<c:out value="${query.pName }"/>" class="td_text_w" />
							<input type="text" name="activityStartTimeStr" placeholder="活动时间起" id="activityStartTimeStr" value="<c:out value="${query.activityStartTimeStr }"/>"  class="datatime-input" />
							<input type="text" name="activityEndTimeStr" placeholder="活动时间止" id="activityEndTimeStr" value="<c:out value="${query.activityEndTimeStr }"/>"  class="datatime-input"/>
							<select name="activityStatus" id="activityStatus" class="left">
								<option value="">状态</option>
								<option value="0">未开始</option>
								<option value="1">销售中</option>
								<option value="2">已售罄</option>
								<option value="3">已结束</option>
							</select>
						</div>
						<div class="col-click">
							<button type="button" onclick="document.getElementById('formSearch').submit();" class="left back_dblue col_white btn" ><i class="icon-btn icon-search"></i>查询</button>
							<button type="button" class="left back_dblue col_white btn" onClick="resetForm();" ><i class="icon-btn icon-reset"></i>重置</button>
						</div>
					</form>	
						</div>		
						<div class="section_table">
							<table cellspacing="none" class="table_hover">
						<div class="click">
							<a href="javascript:void(0)" onclick="javascript:location.href='toAdd'"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>新增</span></a>
							<a href="javascript:void(0)" onclick="deleteRecord();"><span class="left back_dblue btn"><i class="icon-btn icon-delete"></i>删除</span></a>
						</div>
						<thead style="background:#EBEBEB;">
							<th><input style="margin-left:23%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>
							<th>创建时间</th>
							<th>商品名称</th>
							<th>描述</th>
							<th>商品图片</th>
							<th>参与活动价</th>
							<th>活动开始时间</th>
							<th>活动结束时间</th>
							<th>状态</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${activityPrepareList }" varStatus="status">
							<tr class="goods_tr">
								<td style="width:2.5%;"><input style="margin-left:23%;" type="checkbox" name="id" value="<c:out value="${item.id }" />"/></td>
								<td><fmt:formatDate value="${item.creDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><c:out value="${item.pName }"/></td>
								<td><c:out value="${item.description }"/></td>
								<td><img src="${item.imagePath }" style="width:45px;" /></td>
								<td><c:out value="${item.activityPrice }"/></td>
								<td><fmt:formatDate value="${item.activityStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.activityEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><c:if test="${item.activityStatus==0 }">未开始</c:if><c:if test="${item.activityStatus==1}">销售中</c:if><c:if test="${item.activityStatus==2}">已售罄</c:if><c:if test="${item.activityStatus==3}">已结束</c:if></td>
								<td class="">
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
									<a href="javascript:void(0)" onclick="javascript:location.href='deleteActivityPrepare?recordIds=<c:out value="${item.id }" />'"><i class="icon-op icon-op-delete"></i>删除</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="select" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="" />
				    <input type="hidden" name="pageSize" id="pageSize" value="" />
				    <input type="hidden" name="pName" id="pName" value="<c:out value="${query.pName}"/>" />
				    <input type="hidden" name="activityStartTimeStr" id="activityStartTimeStr" value="<c:out value="${query.activityStartTimeStr}"/>" />
				    <input type="hidden" name="activityEndTimeStr" id="activityEndTimeStr" value="<c:out value="${query.activityEndTimeStr}"/>" />
				    <input type="hidden" name="activityStatus" id="activityStatus" value="<c:out value="${query.activityStatus}"/>" />
					<%-- <a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex-1 }" />);"><span class="left page">上一页</span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex }" />);"><span class="left page page_chose"><c:out value="${query.pageIndex }" /></span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex+1 }" />);"><span class="left page">下一页</span></a> --%>
				   </form>
				   <div id="div_pager"></div>
				</footer>
	</div>
</body>
</html>

<script>
//初始化
$("#activityStatus").val(<c:out value="${query.activityStatus }" />);
/**2017.2.10
 * 分页插件
 */
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
	$("#pName").val(null);
	$("#activityStartTimeStr").val(null);
	$("#activityEndTimeStr").val(null);
	$("#activityStatus").val("");
}

/*
 * 全选
 */
function selAll(o){
	var selFlg = o.checked;
	$("[name='id']").each(function(i,item){
		if(selFlg){
			item.checked=true;
		}else{
			item.checked=false;
		}
	});
}

/*
 * 删除
 */



function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}
</script>