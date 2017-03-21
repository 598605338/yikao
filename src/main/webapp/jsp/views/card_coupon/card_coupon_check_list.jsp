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
				<!-- <header class="cont_section_header">卡券管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">卡券</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">卡券管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">查看券码</span>
				</header>
				
				<section class="cont_section_section">					
					<div class="goodsManage">
					
					
					
					<div class="cont_section_head">
						<form name="form" id="formSubmit" action="toCheckCardCoupon" method="post">
							<div class="row">
								<input type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${query.cardCouponId }"/>" />
								<select name="useStatus" id="useStatus" class="left">
									<option value="">卡券状态</option>
									<option value="0">未使用</option>
									<option value="1">已使用</option>
									<option value="2">已过期</option>
								</select>
								<input placeholder="会员手机号" type="text" name="phone" id="phone" value="<c:out value="${query.phone }"/>" class="left" />
							</div>
							<div class="col-click">
								<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>	
					</div>
					
								
						</div>		
						<div class="section_table">
						<div class="click">
							<span class="left back_dblue btn"  onclick="exportProduct();"><i class="icon-btn icon-export"></i>导出</span>
						</div>
						
							<table cellspacing="none">
						<thead>
							<th>操作</th>
							<th>劵码</th>
							<th>卡券类型</th>
							<th>卡券名称</th>
							<th>券有效期</th>
							<th>发放时间</th>
							<th>领取时间</th>
							<th>码状态</th>
							<th>商品条码</th>
							<th>商品名称</th>
							<th>会员名</th>
							<th>会员手机号</th>
							<th>使用门店</th>
							<th>抵扣金额</th>
							<th>使用时间</th>
							<th>订单号</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${userCardCouponList }" varStatus="status">
							<tr class="goods_tr" >
								<td><c:if test="${item.useStatus==0 }"><a href="javascript:void(0)" onclick="kefuVerification(${item.id })">核销</a></c:if><c:if test="${item.useStatus==1 }">已核销</c:if>&nbsp;&nbsp;</td>
								<td><c:out value="${item.id }"/></td>
								<td><c:if test="${item.cardType == 1}">商品券</c:if><c:if test="${item.cardType == 3}">代金券</c:if><c:if test="${item.cardType == 5}">免运费券</c:if></td>
								<td><c:out value="${item.cardName }"/></td>
								<td><fmt:formatDate value="${item.useStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>～<fmt:formatDate value="${item.useEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.receiveTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><c:if test="${item.useStatus==0 }">未使用</c:if><c:if test="${item.useStatus==1 }">已使用</c:if></td>
								<td><c:out value="${item.pCode }"/></td>
								<td><c:out value="${item.pName }"/></td>
								<td><c:out value="${item.userId }"/></td>
								<td><c:out value="${item.phone }"/></td>
								<td><c:out value="${item.mallCode }"/></td>
								<td><c:out value="${item.cardCouponPrice }"/></td>
								<td><fmt:formatDate value="${item.useTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><c:out value="${item.groupId }"/></td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						<div style="overflow:hidden;margin-top:20px;">
							<!-- 卡券类型：3.代金券 1.商品券 5.免运费券  6.链接券 7.券码 -->
							<!-- <a class="left back_dblue col_white btn" href="javascript:void(0)" onclick="javascript:location.href='toAdd?cardType=3'">代金券/满减卷</a>&nbsp;&nbsp;
							<a class="left back_dblue col_white btn" href="javascript:void(0)" onclick="javascript:location.href='toAdd?cardType=1'">商品卷</a>&nbsp;&nbsp;
							<a class="left back_dblue col_white btn" href="javascript:void(0)" onclick="javascript:location.href='toAdd?cardType=5'">免运费卷</a>&nbsp;&nbsp; -->
							<a class="left back_dblue col_white btn" href="javascript:void(0)" onclick="javascript:location.href='select'">返回</a>&nbsp;&nbsp;
						</div>
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="toCheckCardCoupon" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="<c:out value="${query.pageIndex}"/>" />
				    <input type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${query.cardCouponId}"/>" />
				    <input type="hidden" name="useStatus" id="useStatus" value="<c:out value="${query.useStatus}"/>" />
				    <input type="hidden" name="phone" id="phone" value="<c:out value="${query.phone}"/>" />
					<%-- <a href="javascript:void(0)" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex-1 }" />);"><span class="left page">上一页</span></a>
					<a href="javascript:void(0)" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex }" />);"><span class="left page page_chose"><c:out value="${query.pageIndex }" /></span></a>
					<a href="javascript:void(0)" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex+1 }" />);"><span class="left page">下一页</span></a> --%>
				   </form>
				   <div id="div_pager"></div>
	</footer>
	</div>
</body>
</html>

<script>

$("#useStatus").val(<c:out value="${query.useStatus}"/>);
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
 * 核销
 */
function kefuVerification(userCardCouponId){
	var useStatus = $("#useStatus").val();
	var phone = $("#phone").val();
	document.location.href="kefuVoucherVerification?userCardCouponId="
			+userCardCouponId+"&cardCouponId=<c:out value='${query.cardCouponId }'/>&pageIndex=<c:out value='${query.pageIndex}'/>&useStatus="+useStatus+"&phone="+phone;
}

/*
 * 重置
 */
function resetForm(){
	$("#useStatus").val("");
	$("#phone").val("");
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}

/*
 * 导出
 */
function exportProduct(){
	$("[name='form']").attr("action","exportCardCouponDetail");
	$("[name='form']").submit();
	$("[name='form']").attr("action","toCheckCardCoupon");
}
</script>