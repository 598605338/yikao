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
		  var payType='<c:out value="${orderInfo.pay_type}"/>';
		 var orderSource='<c:out value="${orderInfo.orderSource}"/>';
		  var status='<c:out value="${orderInfo.status}"/>';
		  var pay_status='<c:out value="${orderInfo.pay_status}"/>';
		  var sendType='<c:out value="${orderInfo.send_type}"/>';
		 var payText="";
		 var statusText="";
		 var payText="";
		 var paystatusText="";
		 var sendTypeText="";
		 if(orderSource==1&&payType==0){
		 	payText="微信支付";
		 }else if(orderSource==1&&payType==1){
		 	payText="钱包支付";
		 }else if(orderSource==1&&payType==2){
		 	payText="积分支付";
		 }else if(orderSource==2||orderSource==3||orderSource==4||orderSource==6){
		 	payText="非商城订单在线支付";
		 }
		 $("#payText").text(payText);
		 
		 if(orderSource==1&&status==0){
		 	statusText="未付款";
		 }else if(orderSource==1&&status==1){
		 	statusText="已付款";
		 }else if(orderSource==1&&status==2){
		 	statusText="商家已确认";
		 }else if(orderSource==1&&status==3){
		 	statusText="商家已取消";
		 }else if(orderSource==1&&status==4){
		 	statusText="派送中";
		 }else if(orderSource==1&&status==5){
		 	statusText="已完成";
		 }else if(orderSource==1&&status==6){
		 	statusText="客户取消订单";
		 }else if(orderSource==1&&status==7){
		 	statusText="已接单";
		 }else if(orderSource==1&&status==8){
		 	statusText="超时取消订单";
		 }else if(orderSource==1&&status==9){
		 	statusText="客服操作退款";
		 }else if(orderSource==2&&status<4){
		 	statusText="待确认";
		 }else if(orderSource==2&&status==6){
		 	statusText="已确认";
		 }else if(orderSource==2&&status==8){
		 	statusText="已完成";
		 }else if(orderSource==2&&status==9){
		 	statusText="已取消";
		 }else if(orderSource==3&&status==1){
		 	statusText="待确认";
		 }else if(orderSource==3&&status==5){
		 	statusText="已确认";
		 }else if(orderSource==3&&status==7){
		 	statusText="正在取餐";
		 }else if(orderSource==3&&status==8){
		 	payText="正在配送";
		 }else if(orderSource==3&&status==9){
		 	statusText="已完成";
		 }else if(orderSource==3&&status==10){
		 	statusText="已取消";
		 }else if(orderSource==4&&status==41000){
			 	statusText="待确认";
		 }else if(orderSource==4&&status==32000){
			 	statusText="已确认";
		 }else if(orderSource==4&&status==33040){
			 	statusText="派送中";
		 }else if(orderSource==4&&status==33060){
			 	statusText="已完成";
		 }else if(orderSource==4&&status==20020){
			 	statusText="已取消";
		 }else if(orderSource==4&&status==20030){
			 	statusText="订单取消申请中";
		 }else if(orderSource==4&&status==20010){
			 	statusText="已锁定";
		 }else if(orderSource==6&&status==1){
			 	statusText="新订单";
		 }else if(orderSource==6&&status==2){
			 	statusText="确认订单";
		 }else if(orderSource==6&&status==3){
			 	statusText="派送中";
		 }else if(orderSource==6&&status==4){
			 	statusText="已取餐";
		 }else if(orderSource==6&&status==5){
			 	statusText="派送成功";
		 }else if(orderSource==6&&status==6){
			 	statusText="派送失败";
		 }else if(orderSource==6&&status==7){
			 	statusText="订单完成";
		 }else if(orderSource==6&&status==8){
			 	statusText="订单取消";
		 }else if(orderSource==6&&status==9){
			 	statusText="争取处理中";
		 }else if(orderSource==6&&status==10){
			 	statusText="用户申请退单";
		 }else if(orderSource==6&&status==11){
			 	statusText="用户申请取消订单";
		 }else if(orderSource==6&&status==12){
			 	statusText="取消取消申请";
		 }
		 $("#statusText").text(statusText);
	
		 if(orderSource==1&&pay_status==0){
		 	paystatusText="未付款";
		 }else if(orderSource==1&&pay_status==1){
		 	paystatusText="已付款";
		 }else if((orderSource==2||orderSource==3&&pay_status==2)||orderSource==4||orderSource==6){
		 	paystatusText="已付款";
		 }else{
		 	paystatusText="未付款";
		 }
		  $("#paystatusText").text(paystatusText);
		  
		 if(orderSource==1&&sendType==0){
			  sendTypeText="送货上门";
		}else if(orderSource==1&&sendType==1){
			sendTypeText="上门自提";
		}else if(orderSource==2||orderSource==3||orderSource==4||orderSource==6){
			sendTypeText="送货上门";
		 }
		  $("#sendTypeText").text(sendTypeText);
		  
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
   /*  border:1px solid red;*/
   	   white-space:nowrap;  
   }
   .back{
   	  width:10%;
   	  height:14px;
   	  line-height:10px;
    /*border:1px solid blue;*/
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
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">订单列表</a><span>&gt;</span>
					<span style="color:#3bb3e0;">订单详情</span>
				</header>
				<form class="goods_new" method="post">	
			<section class="cont_section_section_border">
					<header class="cont_section_tab_header">订单信息</header>	
						<table class="order_table">
							<tr>
								<td><label>订单号：</label><span>${orderInfo.id}</span></td>
								<td><label>订单状态：</label><span id="statusText"></span></td>
								<td><label>订单金额：</label><span>${orderInfo.real_price}</span></td>
								<td><label>赠送金额：</label><span>${orderInfo.benefit_price}</span></td>
								<td><label>退款状态：无</label></td>
							</tr>
							<tr>
								<td><label>支付状态：</label><span id="paystatusText">$</span></td>
								<td><label>支付方式：</label><span id="payText"></span></td>
								<td><label>配送方式：</label><span id="sendTypeText"></span></td>
								<td><label>运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：</label><span>${orderInfo.send_price}</span></td>
								<td><label>订单总金额：</label><span>${orderInfo.total_price}</span></td>
							</tr>
							<tr>
								<td><label>订单满减：</label><span>无</span></td>
								<td><label>优惠金额：</label><span>${orderInfo.benefit_price}</span></td>
								<td><label>支付时间：</label><span>${orderInfo.pay_time}</span></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><label>优惠券名称：</label><span>无</span></td>
								<td><label>优惠券类型：</label><span>无</span></td>
								<td><label>抵扣金额：</label><span>无</span></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					<header class="cont_section_tab_header" style="margin-top:20px">客户信息</header>	
						<table>
							<tr>
								<td style="width:25%;"><label>用户名：</label><span>${orderInfo.receive_phone}</span></td>
								<td style="width:25%;"><label>收货人：</label><span>${orderInfo.receive_name}</span></td>
								<td style="width:25%;"><label>收货电话：</label><span>${orderInfo.receive_phone}</span></td>
								<td style="width:25%;"><label>期望送达时间：</label><span><fmt:formatDate value="${orderInfo.cust_send_date}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
							</tr>
							<tr>
								<td colspan="4"><label style="display: inline-block;float: left;text-align:right; width: 11%;">收货信息：</label><span style="display: inline-block; float: left;margin-top: 1px;">${orderInfo.receive_address}</span></td>
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
						<header class="cont_section_tab_header" style="margin-top:30px;">订单备注</header>					
						<div class="height">
							<label class="left">${orderInfo.remark}</label>
						</div>
						<div class="emp"></div>
						<header class="cont_section_tab_header" style="margin-top:20px;broder:none;">物信息号</header>		
						<table class="order_table">
							<tr>
								<td><label>物流单号：</label><span>${logisticsInfo.order_id}</span></td>
								<td><label>物流公司：</label><span>${logisticsInfo.logisticsName}</span></td>
								<td><label>物流状态：</label><span>${logisticsInfo.statusName}</span></td>
								<td><label>配送姓名：</label><span>${logisticsInfo.dmName}</span></td>
							</tr>
							<tr>
								<td><label>接单时间：</label><span><fmt:formatDate value="${logisticsInfo.recive_date}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
								<td><label>配送时间：</label><span><fmt:formatDate value="${logisticsInfo.send_date}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
								<td><label>送达时间：</label><span><fmt:formatDate value="${logisticsInfo.finished_date}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
								<td><label>配送电话：</label><span>${logisticsInfo.dmPhone}</span></td>
							</tr>
						</table>
					</section>
					<div class="bgbtn">
						<span  class="left btn back_dblue" onclick="colsePage()"><i class="icon-btn icon-goback"></i>返回</span>
					</div>
				</form>
			</div>
	</body>
</html>
