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
	    	window.location.href=history.go(-1);
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
/*  border:1px solid red;*/
   	   white-space:nowrap;  
   }
   .back{
   	  width:10%;
   	  height:14px;
   	  line-height:10px;
/* border:1px solid blue;*/
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
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">退款订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">退款订单详情</span>
				</header>
				<form class="goods_new" enctype="multipart/form-data" method="post">	
		      	<section class="cont_section_section_border">
					<header class="cont_section_tab_header" class="order_info" >订单信息</header>	
					<table class="order_table">
						<tr>
							<td><label>订单号：</label><span>${orderInfo.id}</span></td>
							<td><label>订单状态：</label><span>${orderInfo.status}</span></td>
							<td><label>订单金额：</label><span>${orderInfo.total_price}</span></td>
							<td><label>赠送金额：</label><span>${orderInfo.benefit_price}</span></td>
							<td><label>退款状态：</label><span>无</span></td>
						</tr>
						<tr>
							<td><label>支付状态：</label><span>${orderInfo.pay_status}</span></td>
							<td><label>支付方式：</label><span>${orderInfo.pay_type}</span></td>
							<td><label>配送方式：</label><span>${orderInfo.send_type}</span></td>
							<td><label>运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：</label><span>${orderInfo.send_price}</span></td>
							<td><label>订单总金额：</label><span>${orderInfo.total_price}</span></td>
						</tr>
						<tr>
							<td><label>支付方式：</label><span>${orderInfo.pay_type}</span></td>
							<td><label>订单满减：</label><span>无</span></td>
							<td><label>优惠金额：</label><span>${orderInfo.benefit_price}</span></td>
							<td><label>支付时间：</label><span>${orderInfo.pay_time}</span></td>
							<td><label></label><span></span></td>
						</tr>
						<tr>
							<td><label>优惠券名称：</label><span>无</span></td>
							<td><label>优惠券类型：</label><span>无</span></td>
							<td><label>抵扣金额：</label><span>无</span></td>
							<td><label></label><span></span></td>
							<td><label></label><span></span></td>
						</tr>
					</table>
					
					<header class="cont_section_tab_header" style="margin-top:20px">客户信息</header>		
					<table class="order_table">
						<tr>
							<td style="width: 25%;"><label>用户名：</label><span>${orderInfo.receive_phone}</span></td>
							<td style="width: 25%;"><label>收货人：</label><span>${orderInfo.receive_name}</span></td>
							<td style="width: 25%;"><label>收货电话：</label><span>${orderInfo.receive_phone}</span></td>
							<td style="width: 25%;"><label>配送时间：</label><span>${orderInfo.send_date} ${orderInfo.send_hour}</span></td>
						</tr>
						<tr>
							<td colspan="4"><label style="width: 12.5%;">收货信息：</label><span>${orderInfo.receive_address}</span></td>
						</tr>
					</table>
						
						<header class="cont_section_tab_header"  style="margin-top:16px;">商品信息</header>	
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
							<c:forEach var="product" items="${orderInfo.products}" varStatus="status">
								<tr class="goods_tr">
									<td>${product.id}</td>
									<td>${product.pCode}</td>
									<td>${product.pName}</td>
									<td>${product.quantity}</td>
									<td>${product.itemPrice}</td>
									<td>${product.itemPrice*(1-food_discount)}</td>
									<td>${product.itemPrice}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
						</div>
						<header class="cont_section_tab_header"  style="margin-top:30px;;">订单备注</header>					
						<div class="height">
							<label class="left">${orderInfo.remark}</label>
						</div>
						<div class="emp"></div>
						<header class="cont_section_tab_header"  style="margin-top:20px;broder:none;" >物信息号</header>					
						<table class="order_table">
							<tr>
								<td><label>物流单号：</label><span>${logisticsInfo.order_id}</span></td>
								<td><label>物流公司：</label><span>${logisticsInfo.logisticsName}</span></td>
								<td><label>物流状态：</label><span>${logisticsInfo.statusName}</span></td>
								<td><label>配送姓名：</label><span>${logisticsInfo.dmName}</span></td>
							</tr>
							<tr>
								<td><label>接单时间：</label><span>${logisticsInfo.recive_time}</span></td>
								<td><label>送达时间：</label><span>${logisticsInfo.send_time}</span></td>
								<td><label>配送电话：</label><span>${logisticsInfo.dmPhone}</span></td>
								<td><label></label><span></span></td>
							</tr>
						</table>
						<header class="cont_section_tab_header"  style="margin-top:17px;">退款原因</header>					
						<div class="height">
							<label class="left">${orderInfo.cancelReason}</label>
						</div>	
					</section>
					<div class="bgbtn">
						<span  class="left btn back_dblue" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
					</div>
				</form>
		</div>
	</body>
</html>
