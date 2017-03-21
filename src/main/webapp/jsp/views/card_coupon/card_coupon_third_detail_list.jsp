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
<body>
<div id="wrap">
				<!-- <header class="cont_section_header">第三方合作券查看详情</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">卡券</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">三方卡券</a><span>&gt;</span>
					<span style="color:#3bb3e0;">第三方合作券查看详情</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
					
						<div class="cont_section_head">
							<form name="form" id="formSubmit" action="selectThirdDetail" method="post">
								<input type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${query.cardCouponId }"/>"> 
									<div class="row">
										<select name="status" id="status" class="left">
											<option value="">卡券状态</option>
											<option value="0">未领取</option>
											<option value="1">已领取</option>
											<option value="2">未领取</option>
										</select>
									</div>
									<div class="col-click">
										<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
										<button type="button" class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
									</div>
								</form>		
						</div>		
							
						<div class="section_table">
							<table cellspacing="none">
						<thead>
							<th>创建时间</th>
							<th>卡券名称</th>
							<th>代金券劵码/链接</th>
							<th>卡券类型</th>
							<th>状态</th>
							<th>有效期</th>
							<th>兑换时间</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${cardCouponThirdList }" varStatus="status">
							<tr class="goods_tr" >
								<td><fmt:formatDate value="${item.creDate }" pattern="yyyy-MM-dd"/></td>
								<td><c:out value="${item.name }"/></td>
								<td><c:out value="${item.content }"/></td>
								<td><c:if test="${item.type==6 }">链接券</c:if><c:if test="${item.type==7 }">券码</c:if></td>
								<td><c:if test="${item.status==0 }">未领取</c:if><c:if test="${item.status==1 }">已领取</c:if></td>
								<td><fmt:formatDate value="${item.validStartTime }"/>～<fmt:formatDate value="${item.validEndTime }"/></td>
								<td><fmt:formatDate value="${item.exchangeTime }"/></td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="selectThirdDetail" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="" />
				    <input type="hidden" name="pageSize" id="pageSize" value="" />
				    <input type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${query.cardCouponId }"/>"> 
				    <input type="hidden" name="status" id="status" value="<c:out value="${query.status}"/>" />
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
//初始化条件
$("#status").val("<c:out value="${query.status}"/>");

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
	$("#status").val("");
}


function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}
</script>