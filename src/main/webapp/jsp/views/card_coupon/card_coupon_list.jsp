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
				<!-- <header class="cont_section_header">卡券管理</header> -->
				<c:if test="${popupFlg == 1 }">
					<header class="cont_section_header"> <span
						class="cont_section_header_1">卡券管理</span> <i
						class="cont_section_header_2"></i> <i class="cont_section_header_3"></i>
					<i class="cont_section_header_4"></i></header>
				</c:if>
				<c:if test="${popupFlg != 1 }">
					<header class="cont_section_header_bread">
						<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
						<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">卡券</a><span>&gt;</span>
						<span style="color:#3bb3e0;">卡券管理</span>
					</header>
				</c:if>
				<c:if test="${popupFlg != 1 }">
				<div class="ticket">
				<!-- 卡券类型：3.代金券 1.商品券 5.免运费券  6.链接券 7.券码 -->
			  	    <ul>
						<li class="list list_1">
							   <div class="tickitTop">
								    <p class="tickitTop_a" style="white-space:nowrap;">代金券/满减券</p>
									<p class="tickitTop_b" style="margin-left:1%;"><a style="color:#FFFFFF" href="javascript:void(0)" onclick="javascript:location.href='toAdd?cardType=3'">立即创建</a></p>
							   </div>	
							
							   <div class="tickitWord">
							          <p>购物时直接抵扣使用,可设置满多少金额使用条件!,每个订单限制使用一张</p>
							   </div>
						</li>
						<li class="list list_2 addList">
							   <div class="tickitTop">
								    <p class="tickitTop_a">商品券</p>
									<p class="tickitTop_b"><a style="color:#FFFFFF;" href="javascript:void(0)" onclick="javascript:location.href='toAdd?cardType=1'">立即创建</a></p>
							   </div>	
							
							   <div class="tickitWord">
							          <p>可以对应任何一件商品,下单时,使用此券,抵消对应商品的金额</p>
							   </div>
						</li>
						<li class="list list_3 addList">
							   <div class="tickitTop">
								    <p class="tickitTop_a">免运费券</p>
									<p class="tickitTop_b"><a style="color:#FFFFFF;" href="javascript:void(0)" onclick="javascript:location.href='toAdd?cardType=5'">立即创建</a></p>

							   </div>	
							
							   <div class="tickitWord">
							          <p>不生成固定金额,以"免运费券"为标示,使用后,自动减去门店设置的运费金额</p>
							   </div>
						</li>
				
						
					</ul>
	
				</div>
				</c:if>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form name="form" id="formSubmit" action="select?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>" method="post">
						<div class="row">
							<input  type="text" name="cardName" placeholder="卡券名称" id="cardName" value="<c:out value="${query.cardName }"/>" class="td_text_w" />
							<select name="cardType" id="cardType" class="left">
								<option value="">卡券类型</option>
								<option value="3">代金券</option>
								<option value="1">商品券</option>
								<option value="5">免运费券</option>
								<c:if test="${popupFlg == 1 }">
									<option value="6">链接券</option>
									<option value="7">券码</option>
								</c:if>
							</select>
							<input type="text" name="startTimeStr" placeholder="卡券有效期起" id="startTimeStr" value='<fmt:formatDate value="${query.startTime }" pattern="yyyy-MM-dd" />'  class="datatime-input" />
							<input type="text" name="endTimeStr" placeholder="卡券有效期止" id="endTimeStr" value="<fmt:formatDate value="${query.endTime }" pattern="yyyy-MM-dd" />" class="datatime-input" />
						</div>
						<div class="col-click">
							<button class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
							<button class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
						</div>
					</form>	
						</div>		
						<div class="section_table">
							<table class="table_hover" cellspacing="none">
						<thead style="background:#EBEBEB;">
							<c:if test="${popupFlg == 1 }">
							<th>操作</th>
							</c:if>
							<th>创建时间</th>
							<th>卡券名称</th>
							<th>卡券类型</th>
							<th>卡券有效期</th>
							<th>卡券限额</th>
							<th>抵扣金额</th>
							<th>发放数量</th>
							<th>领取数量</th>
							<th>使用数量</th>
							<th>卡券状态</th>
							<c:if test="${popupFlg != 1 }"><th>操作</th></c:if>
						</thead>
						<tbody>
						<c:forEach var="item" items="${cardCouponList }" varStatus="status">
							<tr class="goods_tr" >
								<c:if test="${popupFlg == 1 }">
								<td>
									<a href="javascript:void(0);" onclick="select(this);">选择</a>
									<input type="hidden" name="cardCouponId" value="${item.cardId }"/>
									<input type="hidden" name="cardType" value="${item.cardType }"/>
								</td>
								</c:if>
								<td><fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd"/></td>
								<td><c:out value="${item.cardName }"/></td>
								<td>
								<c:if test="${item.cardType==3 }">代金券</c:if><c:if test="${item.cardType==1 }">商品券</c:if><c:if test="${item.cardType==5 }">免运费券</c:if>
								</td>
								<td><fmt:formatDate value="${item.startTime }" pattern="yyyy-MM-dd"/><label>～</label><fmt:formatDate value="${item.endTime }" pattern="yyyy-MM-dd"/></td>
								<td><c:out value="${item.limitMoney }"/></td>
								<td><c:out value="${item.amount }"/></td>
								<td><c:out value="${item.totalNum }"/></td>
								<td><c:out value="${item.getnum }"/></td>
								<td><c:out value="${item.usenum }"/></td>
								<td><c:if test="${item.useflg==1 }">启用</c:if><c:if test="${item.useflg==0 }">禁用</c:if></td>
								<c:if test="${popupFlg != 1 }">
								<td>
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toEdit?id=<c:out value="${item.cardId }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
								    <a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='deleteCardCoupon?cardId=<c:out value="${item.cardId }" />'"><i class="icon-op icon-op-delete"></i>删除</a>
								    <a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toCheckCardCoupon?cardCouponId=<c:out value="${item.cardId }" />'"><i class="icon-op icon-op-viewCode"></i>查看券码</a>
								    <a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toSendCardCoupon?cardId=<c:out value="${item.cardId }" />'"><i class="icon-op icon-op-couponCode"></i>发放券码</a>
								</td>
								</c:if>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="select?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>" method="post">
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
				</div>
</body>
</html>

<script>
//设置筛选条件
$("#cardType").val(<c:out value="${query.cardType}"/>);
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
	$("#cardName").val(null);
	$("#cardType").val("");
	$("#startTimeStr").val("");
	$("#endTimeStr").val("");
}


function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}

function select(o){
	var cardCouponId = $(o).closest('tr').find("[name='cardCouponId']").val();
	var cardName = $(o).closest('tr').children('td:eq(2)').text();
	var cardType = $(o).closest('tr').find("[name='cardType']").val();
	var params = '<c:out value="${params}"/>';
	if(params){
		//传参的顺序一定要一致
		var paramArray = params.split(",");
		if(paramArray[0])
			$("#"+paramArray[0],window.parent.document).val(cardCouponId);
		if(paramArray[1])
			$("#"+paramArray[1],window.parent.document).val(cardName);
		if(paramArray[2])
			$("#"+paramArray[2],window.parent.document).val(cardType);
	}
	
	//关闭当前页面
	window.parent.popupProClose();
	return false; 
}
</script>