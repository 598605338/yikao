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
<body>
<div id="wrap">
				<header class="cont_section_header">会员促销管理</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form id="formSearch" name="form" action="select" method="post">
						<table cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td style="width:15%">促销名称：</td>
										<td style="width:15%">
											<input type="text" name="activityName" id="activityName" value="<c:out value="${query.activityName }"/>" class="td_text_w" />
										</td>
										<td style="width:15%">促销时间：</td>
										<td style="width:55%">
											<input type="text" name="startTimeStr" id="startTimeStr" value="<c:out value="${query.startTimeStr }"/>" class="datatime-input" style="display:inline-block !important; height:30px;width:30%;" />
											<label>～</label>
											<input type="text" name="endTimeStr" id="endTimeStr" value="<c:out value="${query.endTimeStr }"/>" class="datatime-input" style="display:inline-block !important; height:30px;width:30%;" />
										</td>
									</tr>
								</tbody>
						</table>
					
							<div class="height">
								<div class="bgbtn flex">
									<!-- <input type="submit" class="left back_dblue col_white btn" value="查询" />
									<input type="button" class="left back_dblue col_white btn" value="重置" onClick="resetForm();" /> -->
									<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSearch').submit();"><i class="icon-btn icon-search"></i>查询</button>
									<button type="button" class="left back_dblue col_white btn" onClick="resetForm();"><i class="icon-btn icon-reset"></i>重置</button>
								</div>								
							</div>
					</form>				
						</div>		
						<div class="click">
							<a href="javascript:void(0)" onclick="javascript:location.href='toAdd'"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>新增</span></a>
							<a href="javascript:void(0)" onclick="deleteRecord();"><span class="left back_dblue btn"><i class="icon-btn icon-delete"></i>删除</span></a>
						</div>
						<div class="section_table">
							<table cellspacing="none">
						<thead>
							<th></th>
							<th>促销名称</th>
							<th>活动类型</th>
							<th>开始日期</th>
							<th>结束日期</th>
							<th>使用状态</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${activityMemberPromotionList }" varStatus="status">
							<tr class="goods_tr">
								<td></td>
								<td><c:out value="${item.activityName }"/></td>
								<td><c:if test="${item.activityType == 1 }">注册</c:if></td>
								<td><fmt:formatDate value="${item.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><c:if test="${item.useStatus==false }">启用</c:if><c:if test="${item.useStatus==true }">禁用</c:if></td>
								<td>
									<a href="javascript:void(0)" onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-btn icon-edit"></i>修改</a>&nbsp;&nbsp;
									<a href="javascript:void(0)" onclick="javascript:location.href='deleteActivityMemberPromotion?recordIds=<c:out value="${item.id }" />'"><i class="icon-btn icon-delete"></i>删除</a>&nbsp;&nbsp;
								    <a href="javascript:void(0)" onclick="javascript:location.href='updateStatus?id=<c:out value="${item.id }" />&useStatus=<c:out value="${item.useStatus }" />'"><c:if test="${item.useStatus==false }"><i class="icon-btn icon-disable"></i>禁用</c:if><c:if test="${item.useStatus==true}"><i class="icon-btn icon-enable"></i>启用</c:if></a>
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
				    <input type="hidden" name="activityName" id="activityName" value="<c:out value="${query.activityName}"/>" />
				    <input type="hidden" name="startTimeStr" id="startTimeStr" value="<c:out value="${query.startTimeStr}"/>" />
				    <input type="hidden" name="endTimeStr" id="endTimeStr" value="<c:out value="${query.endTimeStr}"/>" />
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
/**
 * 初始化日期插件
 */
window.onload=function(){
	 $('#startTimeStr').datepicker();
	 $('#endTimeStr').datetimepicker();
}
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
	$("#activityName").val(null);
	$("#startTimeStr").val(null);
	$("#endTimeStr").val(null);
}

/*
 * 删除
 */
function deleteRecord(){
	var recordIds;
	document.location.href="deleteActivityMemberPromotion?recordIds=" + recordIds;
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex); 
	$("#pageSize").val(pageSize); 
	$("[name='pageForm']").submit();
}
</script>