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
<jsp:include page="../header.jsp" />
<script type="text/javascript">
	window.onload=function(){
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
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
 
	 function colsePage(){
	  	/* window.location.href=history.go(-1); */
		 window.history.go(-1);
	 }

</script>
<style>
   header{
   	    border-bottom:1.5px solid #939393;
   	    font-size:17px;
   	    line-height:29px;
   	    font-family: '微软雅黑';
   }
   .code{
   	   width:6%;
   	   height:10px;
   	   text-align:left;
   	   line-height:10px;
   	   white-space:nowrap;  
   }
   .back{
   	  width:8%;
   	  height:10px;
   	  line-height:10px;
   	  text-align:left;
   	  white-space:nowrap;  
   }
   label{
   	  font-size:12px;
   }
   .height{
   	  height:22px;
   	  line-height:22px;
   }
</style>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">订单详情</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">积分订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">积分订单详情</span>
				</header>
				<form class="goods_new" enctype="multipart/form-data" method="post">	
			<section class="cont_section_section_border">
					<header class="cont_section_tab_header">订单信息</header>					
						<div class="height">
							<table cellspacing="none">
								<tr>
									<td>订单号：${orderInfo.id}</td>
									<td>订单状态：${orderInfo.orderStatus}</td>
									<td>订单金额：${orderInfo.price}</td>
									<td>退款状态：无</td>
									<td>支付方式：${orderInfo.payType}</td>
									<td>支付方式：${orderInfo.type}</td>
								</tr>
							</table>
							<!-- <label class="left code"></label>
							<label class="left back"></label>
							<span class="left code"></span>
							<label class="left back"></label>
							<span class="left code"></span>
							<label class="left back"></label>
							<span class="left code"></span>
							<label class="left back"></label>
							<span class="left code"></span>
							<label class="left back"></label>
							<label class="left code"></label>
							<label class="left back"></label> -->
						</div>
						<div class="emp"></div>
					<header class="cont_section_tab_header" style="margin-top:20px">客户信息</header>					
						<div>
							<table>
								<tr>
									<td style="width: 33%;">用户名：${orderInfo.cardNo}</td>
									<td style="width: 33%;">&nbsp;&nbsp;收货人：${orderInfo.custname}</td>
									<td style="width: 33%;">&nbsp;&nbsp;收货电话：${orderInfo.phone}</td>
								</tr>
								<tr>
									<td colspan="3"><label style="width: 14.3%;display: inline-block;float: left;text-align: right;">收货信息：</label><span style="display: inline-block;float: left;">${orderInfo.address}</span></td>
								</tr>
							</table>
						</div>
						<header class="cont_section_tab_header">商品信息</header>	
						<div class="section_auto_table">
							<table cellspacing="none">
						<thead>
							<th>商品SKU</th>
							<th>商品编码</th>
							<th>商品名称</th>
							<th>数量</th>
							<th>商品售价</th>
							<th>优惠分摊后价格</th>
							<th>商品附赠积分</th>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}" varStatus="status">
								<tr class="goods_tr">
									<td>${product.card_coupon_id}</td>
									<td>${product.p_code}</td>
									<td>${product.p_name}</td>
									<td>${product.quantity}</td>
									<td>${product.market_price}</td>
									<td>${product.sale_price}</td>
									<td>${product.score}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
						</div>
						<header class="cont_section_tab_header"  style="margin-top:30px;">订单备注</header>					
						<div class="height">
							<label class="left">${orderInfo.comment}</label>
						</div>
						<div class="emp"></div>
					</section>
					<div class="bgbtn">
						<span  class="left btn back_dblue" onclick="colsePage()"><i class="icon-btn icon-goback"></i>返回</span>
					</div>
				</form>
			</div>
	</body>
</html>
