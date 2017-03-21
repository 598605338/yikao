<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<body>
<div id="wrap">
				<!-- <header class="cont_section_header">反馈管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<span style="color:#3bb3e0;">反馈管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
							<form name="form" id="formSubmit" action="select" method="post">
								<div class="row">
									<input type="text" placeholder="反馈内容" name="comment" id="comment" value="<c:out value="${query.comment }"/>" />
									<input type="text" placeholder="联系方式" name="contactWay" id="contactWay" value="<c:out value="${query.contactWay }"/>" />
									<input type="text" placeholder="反馈时间起" name="creDateStartStr" id="creDateStartStr" value='<fmt:formatDate value="${query.creDateStart }" pattern="yyyy-MM-dd HH:mm:ss"/>' class="datatime-input"  />
									<input type="text" placeholder="反馈时间止" name="creDateEndStr" id="creDateEndStr" value="<fmt:formatDate value="${query.creDateEnd }" pattern="yyyy-MM-dd HH:mm:ss"/>" class="datatime-input" />
								</div>
								<div class="col-click">
									<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
									<button type="button" class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
								</div>
							</form>
						</div>		
						<div class="section_table">
							<table class="table_hover" cellspacing="none">
						<thead style="background:#EBEBEB;">
							<th>用户ID</th>
							<th>用户名称</th>
							<th>反馈内容</th>
							<th>联系方式</th>
							<th>反馈时间</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${feedbackList }" varStatus="status">
							<tr class="goods_tr" >
								<td><c:out value="${item.userId }"/></td>
								<td><c:out value="${item.custname }"/></td>
								<td style="max-width:300px;"><c:out value="${item.comment }" /></td>
								<td><c:out value="${item.contactWay }" /></td>
								<td><fmt:formatDate value="${item.creDate }"  pattern="yyyy-MM-dd"/></td>
								<td>
									<a class="mr10" href="javascript:void(0)" onclick="javascript:location.href='selectDetail?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-details"></i>查看</a>
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
				    <input type="hidden" name="comment" id="comment" value="<c:out value="${query.comment}"/>" />
				    <input type="hidden" name="contactWay" id="contactWay" value="<c:out value="${query.contactWay}"/>" />
				    <input type="hidden" name="creDateStartStr" id="creDateStartStr" value="<c:out value="${query.creDateStartStr}"/>" />
				    <input type="hidden" name="creDateEndStr" id="creDateEndStr" value="<c:out value="${query.creDateEndStr}"/>" />
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
window.onload=function(){		 
	 $('#creDateStartStr').datetimepicker({
			dateFormat:'yy-mm-dd',
			timeFormat: 'HH:mm:ss',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1
		});
	
	 $('#creDateEndStr').datetimepicker({
		 	dateFormat:'yy-mm-dd',
			timeFormat: 'HH:mm:ss',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1
	});
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
	$("#comment").val(null);
	$("#contactWay").val("");
	$("#creDateStartStr").val("");
	$("#creDateEndStr").val("");
}


function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}
</script>
