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
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">订单详情</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">预约订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">预约订单详情</span>
				</header>
				<form class="goods_new" enctype="multipart/form-data" method="post">	
			<section class="cont_section_section">
					<header class="cont_section_tab_header">订单信息</header>					
						<div class="height">
							<label class="left">订单号：</label>
							<label class="left">${orderInfo.id}</label>
							<span class="left">&nbsp;&nbsp;订单状态：</span>
							<label class="left">${orderInfo.status}</label>
							<span class="left">&nbsp;&nbsp;订单金额：</span>
							<label class="left">${orderInfo.total_price}</label>
							<span class="left">&nbsp;&nbsp;赠送金额：</span>
							<label class="left">${orderInfo.benefit_price}</label>
							<span class="left">&nbsp;&nbsp;退款状态：</span>
							<label class="left">无</label>
						</div>
						<div class="emp"></div>
						<div class="height">
							<label class="left">支付状态：</label>
							<label class="left">${orderInfo.pay_status}</label>
							<span class="left">&nbsp;&nbsp;支付方式：</span>
							<label class="left">${orderInfo.pay_type}</label>
							<span class="left">&nbsp;&nbsp;配送方式：</span>
							<label class="left">${orderInfo.send_type}</label>
							<span class="left">&nbsp;&nbsp;运费：</span>
							<label class="left">${orderInfo.send_price}</label>
							<span class="left">&nbsp;&nbsp;订单总金额：</span>
							<label class="left">${orderInfo.total_price}</label>
						</div>
						<div class="emp"></div>
						<div class="height">
							<label class="left">支付方式：</label>
							<label class="left">${orderInfo.pay_type}</label>
							<span class="left">&nbsp;&nbsp;订单满减：</span>
							<label class="left">无</label>
							<span class="left">&nbsp;&nbsp;优惠金额</span>
							<label class="left">${orderInfo.benefit_price}</label>
							<span class="left">&nbsp;&nbsp;支付时间</span>
							<label class="left">${orderInfo.pay_time}</label>
						</div>
						<div class="emp"></div>
						<div class="height">
							<label class="left">优惠券名称：</label>
							<label class="left">无</label>
							<span class="left">&nbsp;&nbsp;优惠券类型</span>
							<label class="left">无</label>
							<span class="left">&nbsp;&nbsp;抵扣金额</span>
							<label class="left">无</label>
						</div>
						<div class="emp"></div>
					<header class="cont_section_tab_header">客户信息</header>					
						<div class="height">
							<label class="left">用户名：</label>
							<label class="left">${orderInfo.receive_phone}</label>
							<span class="left">&nbsp;&nbsp;收货人</span>
							<label class="left">${orderInfo.receive_name}</label>
							<span class="left">&nbsp;&nbsp;收货电话</span>
							<label class="left">${orderInfo.receive_phone}</label>
							<span class="left">&nbsp;&nbsp;配送时间</span>
							<label class="left">${orderInfo.send_date} ${orderInfo.send_hour}</label>
						</div>
						<div class="emp"></div>
						<div class="height">
							<label class="left">收货信息：</label>
							<label class="left">${orderInfo.receive_address}</label>
						</div>
						<div class="emp"></div>
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
						<header class="cont_section_tab_header">订单备注</header>					
						<div class="height">
							<label class="left">${orderInfo.remark}</label>
						</div>
						<div class="emp"></div>
						<header class="cont_section_tab_header">物信息号</header>					
						<div class="height">
							<label class="left">物流单号：</label>
							<label class="left">${logisticsInfo.order_id}</label>
							<span class="left">&nbsp;&nbsp;物流公司</span>
							<label class="left">${logisticsInfo.logisticsName}</label>
							<span class="left">&nbsp;&nbsp;物流状态</span>
							<label class="left">${logisticsInfo.statusName}</label>
							<span class="left">&nbsp;&nbsp;配送姓名</span>
							<label class="left">${logisticsInfo.dmName}</label>
						</div>
						<div class="emp"></div>
						<div class="height">
							<label class="left">接单时间：</label>
							<label class="left">${logisticsInfo.recive_time}</label>
							<span class="left">&nbsp;&nbsp;送达时间</span>
							<label class="left">${logisticsInfo.send_time}</label>
							<span class="left">&nbsp;&nbsp;配送电话</span>
							<label class="left">${logisticsInfo.dmPhone}</label>
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
