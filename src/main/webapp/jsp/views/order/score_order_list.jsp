<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<script type="text/javascript">
	window.onload=function(){
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
		 
		 $('#beginDate').datetimepicker({
				dateFormat:'yy-mm-dd',
				timeFormat: 'HH:mm:ss',
				stepHour: 1,
				stepMinute: 1,
				stepSecond: 1
			});
		
		 $('#endDate').datetimepicker({
			 	dateFormat:'yy-mm-dd',
				timeFormat: 'HH:mm:ss',
				stepHour: 1,
				stepMinute: 1,
				stepSecond: 1
		});
		 
		 $("[name='status'][value='<c:out value="${query.status}"/>']").attr("checked",true);
	}

	 function cunrentPage(){
		 $("#cunrentPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
		 $('#formain').submit();
	} 
	
	 function nextPage(){
		 $("#nextPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 pg=1;
		 }
		 var nextPg=parseInt(pg)+1;
		 $("#pageIndex").val(nextPg);
		 var pg1=$("#pageIndex").val();
		 $('#formain').submit();
	 }
	 
	 function beforePage(){
		 $("#beforePage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 pg=1;
		 }else if(pg>0){
			 pg=pg-1;
		 }
		 $("#pageIndex").val(pg);
		 $('#formain').submit();
	 }
 
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
 
	 function orderQuery(num){
		 if(!num){
			 num=0;
		 }
		 $("#querySource").val(num);
		 $('#formain').submit();
	 }
	 
	 function exportProduct(){
			$("[name='formain']").attr("action","<%=path%>/orderQuery/leadOutScoreOrder");
			$("[name='formain']").submit();
			$("[name='formain']").attr("action","scorelist");
		}

</script>
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
<c:out value="${message }" />
				<!-- <header class="cont_section_header">积分订单</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">积分订单</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head"  >
						<form name="formain" id="formain" method="post" action="<%=path%>/orderQuery/scorelist">
							<div class="row">
								<input name="receive_name" placeholder="收货人" id="receive_name" type="text" class="left" value="${query.receive_name}"/>
								<input name="order_id" placeholder="订单号" id="order_id" type="text" class="left" value="${query.order_id}"/>
								<input name="receive_phone" placeholder="手机号码" id="receive_phone" type="text" class="left" value="${query.receive_phone}"/>
								<select name="status" id="status" class="left">
									<option value="">--订单状态（全部）--</option>
									<option value="0">未支付</option>
									<option value="1" selected="selected">已完成</option>
							    </select>
							    <input class="datatime-input" placeholder="下单时间起" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" >
								<input class="datatime-input" placeholder="下单时间止" type="text" name="endDate" id="endDate" value="${query.endDate}" >
								<input  type="hidden" id="pageIndex" name="pageIndex" value=${query.pageIndex}>
								<input  type="hidden" id="querySource" name="querySource" value=0>
							</div>
							<div class="col-click">
								<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>
						</div>						
						<div class="section_table">
							<table class="table_hover" cellspacing="none" style="margin-top:-10px;">
						<div class="height" style="margin:7px 0px 16px -5px;">
							<!-- <span ><input type="button" value="导出" class="left back_dblue btn onbtn" onclick="exportProduct()"/></span> -->
							<span ><button class="left back_dblue btn onbtn" onclick="exportProduct()"><i class="icon-btn icon-export"></i>导出</button></span>
							<span class="right">共${query.totalNums}条订单数据&nbsp;</span>
						</div>
						<thead style="background:#EBEBEB;">
							<th>订单号</th>
							<th>下单时间</th>
							<th>订单状态</th>
							<th>订单类型</th>
							<th>收货人</th>
							<th>联系方式</th>
							<th>订单名称</th>
							<th>支付类型</th>
							<th>支付价格</th>
							<th>数量</th>
							<th>类型</th>
							<th>卡券单号</th>
							<th>积分</th>
						</thead>
						<tbody>
						   <c:forEach var="order" items="${orderlist}" varStatus="status">
						   <tr class="goods_tr">
								<td>
								<a href="<%=path%>/orderQuery/scoreOrderInfo?orderId=${order.id}">${order.id}</a>
								</td>
								<td><fmt:formatDate value="${order.creDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>
									<c:choose>  
	  									<c:when test="${order.orderStatus==0}">
	  										未付款
	   									</c:when> 
	   									<c:when test="${order.orderStatus==1}">
	  										已付款
	   									</c:when>
	   								</c:choose> 
								</td>
								<td>
									<c:choose>  
	   									<c:when test="${order.order_type==1}">
	  										积分订单
	   									</c:when>
	   								</c:choose> 
								</td>
								<td>${order.custname}</td>
								<td>${order.phone}</td>
								<td>${order.name}</td>
								<td>
									<c:choose>  
	  									<c:when test="${order.payType==0}">
	  										微信支付
	   									</c:when> 
	   									<c:when test="${order.payType==1}">
	  										钱包支付
	   									</c:when>
	   									<c:when test="${order.payType==2}">
	  										纯积分支付
	   									</c:when>
	   								</c:choose> 
								</td>
								<td>${order.price}</td>
								<td>${order.quantity}</td>
								<td>
									<c:choose>  
  										<c:when test="${order.type==1}">
  											第三方合作券
   										</c:when> 
   										<c:when test="${order.type==2}">
  											商品券
   										</c:when>
   									</c:choose> 
								</td>
								<td>${order.cardCouponId}</td>
								<td>${order.score}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>					
				</section>
				<footer class="cont_section_footer">
					 <div id="div_pager"></div>
				</footer>
				</div>
	</body>
	<script>
	//总记录数数
	var totalRecords =${query.totalNums};
	//每页记录数
	var pageSize=${query.pageSize};
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
		hrefFormer : 'orderQuery/scorelist',
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

	function submitPageForm(pageIndex,pageSize){
		$("#pageIndex").val(pageIndex);
		$("#pageSize").val(pageSize);
		$("[name='formain']").submit();
	}
</script>
<script type="text/javascript">
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,""); 
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
   $(".height .onbtn").css("margin","16px 0px 7px 10px")
}
</script>
</html>
