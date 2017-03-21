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
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
 
	 function doWithAmount(){
		 var amounts="";
			//判断每一个single是否都选中了呢 ?
			var singles = document.getElementsByName('amount');
			for(var i=0;i<singles.length;i++){
				var svalue=singles[i].value;
				if(svalue){
					amounts=amounts+svalue+"-";
				}
			}
			
			if(amounts){
				if(amounts.charAt(amounts.length-1)=="-"){
					amounts=amounts.substr(0,amounts.length-1);
				}
			}
			
			if(amounts){
				$("#amountListStr").val(amounts);
			}
		 
	 }   
	      
	    function addInput(){
	    	event.preventDefault();
	    	var btn=$("#addInput");
	      	btn.append('<input name="amount" id="amount" type="text" class="left" value="${cashAmount.amount}"/><button  onclick="removeInput()">Del</button><br />');
	    }
	    
	    function removeInput(){
	    	event.preventDefault();
	    	$(this).closest('input').remove(); 
	    }
	    
	    function colsePage(){
	    	window.history.go(-1);
	    }
</script>
<body>
<div id="wrap">
<c:out value="${message }" />
		<section>
				<!-- <header class="cont_section_header">退款单详情</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">退款订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">退款单详情</span>
				</header>
				<section class="cont_section_section_border">	
					<div class="goodsManage">
						<div>
						<form name="formain" id="formain" method="post" action="<%=path%>/cust/saveAccountcashdepositConfig"  onsubmit="doWithAmount()">
					
						<div class="editPage">
							<div class="editLeft">
								<div class="row-list">
									<label class="left">订单号：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.orderGroupId}" readonly="readonly">
								</div>
								<div class="row-list">
									<label class="left">联系人：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.refundPayee}" readonly="readonly">
								</div>
								<div class="row-list">
									
									<label class="left">手机号：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.loginPhone}" readonly="readonly">
								</div>
								<div class="row-list">
									<label class="left">退款原因：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.refundReason}" readonly="readonly">
								</div>
								<div class="row-list">
									<label class="left">订单总金额：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.order_price}" readonly="readonly">
								</div>
								<div class="row-list">
									<label class="left">运费：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.send_price}" readonly="readonly">
								</div>
								<div class="row-list">
									<label class="left">优惠金额：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.benefit_price}" readonly="readonly">
								</div>
								<div class="row-list">
									
									<label class="left">实际退款：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.refundAmount}" readonly="readonly">
								</div>
								<div class="row-list">
									<label class="left">备注：</label>
									<input type="text" class="td_text_w" value="${reOrderInfo.remark}" readonly="readonly">
								</div>
								<div class="row-list">
									
								</div>
							</div>
							<div class="line"></div>
							<div class="editRight">
								<div class="row-list">
								
								</div>
							</div>
						</div>
						
						</form>
						</div>						
					</div>					 
				</section>
				<div class="bgbtn">
					<!-- <input type="button" class="left back_dblue col_white btn" onclick="window.history.back()" value="返回"/> -->
					<button type="button" class="left back_dblue btn" onclick="window.history.back();return false;"><i class="icon-btn icon-goback"></i>返回</button>
				</div>
			</section>
		</div>
	</body>
</html>
