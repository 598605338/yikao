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
	$("#order_type").val('<c:out value="${reOrder.order_type}"/>');
	$("#refundReason").val('<c:out value="${reOrder.refundReason}"/>');
}
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
	    
	    function doSubmitCheck(){
			var form = document.formain;
			var orderGroupId = form.orderGroupId.value;
			var order_type = form.order_type.value;
			var refundPayee = form.refundPayee.value;
			var loginPhone = form.loginPhone.value;
			var refundReason= form.refundReason.value;
			var order_price = form.order_price.value;
			var send_price = form.send_price.value;
			var benefit_price = form.benefit_price.value;
			var refundAmount = form.refundAmount.value;
			var returnPoints = form.returnPoints.value;
			var real_payPrice=form.real_payPrice.value;
			
			if(orderGroupId==null || orderGroupId==''){
		        alert("门店名称不能为空！");
		        return false;
			}else{
					var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(orderGroupId)){ 
				        alert("订单号应由数字组成!");  
				        return false;
				}
			}
			if(order_type==null || order_type==''){
		        alert("订单来源不能为空！");
		        return false;
			}
			if(refundPayee==null || refundPayee==''){
		        alert("联系人不能为空！");
		        return false;
			}
			if(loginPhone==null || loginPhone==''){
		        alert("联系电话不能为空！");
		        return false;
			}else{
				if(!(/^1[34578]\d{9}$/.test(loginPhone))){ 
			        alert("手机号码格式有误，请重填!");  
			        return false; 
			    } 
			}
			if(refundReason==null || refundReason==''){
		        alert("请选择退货原因！");
		        return false;
			}
			if(order_price==null || order_price==''){
		        alert("订单总金额不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(order_price)||reg1.test(order_price))){  
			        alert("订单总金额格式有误!");  
			        return false;
			    } 
			}
			if(returnPoints==null || returnPoints==''){
		        alert("退积分不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(returnPoints)||reg1.test(returnPoints))){  
			        alert("退积分格式有误!");  
			        return false;
			    } 
			}
			if(!send_price){
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(send_price)||reg1.test(send_price))){  
			        alert("运费格式有误!");  
			        return false;
			    } 
			}
			if(!benefit_price){
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(benefit_price)||reg1.test(benefit_price))){  
			        alert("优惠金额格式有误!");  
			        return false;
			    } 
			}
			if(refundAmount==null || refundAmount==''){
		        alert("实际退款金额不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(refundAmount)||reg1.test(refundAmount))){  
			        alert("实际退款金额格式有误!");  
			        return false;
			    } 
			}
			if(Number(refundAmount)>Number(real_payPrice)){
				alert("退款金额不应大于实付金额!");
				return false;
			}
			var tt=$("#textremark").val();
			if(tt){
				$("#remark").val(tt);
			}
			document.getElementById('formain').submit();
			return true;
		}
	    
	    function queryOrder(){
	    	var form = document.formain;
			var orderId = form.orderGroupId.value;
			var order_type = form.order_type.value;
			if(!orderId){
				alert("请选择订单号!");
				return;
			}
			if(!order_type){
				alert("请选择订单类型!");
				return;
			}
	    	if(orderId){
	    		var reg = new RegExp("^[0-9]*$");
				if(!(reg.test(orderId))){  
			        alert("请确认订单号是否有误!");  
			        return false;
			    } else{
					$.ajax({			
						url:"<%=path%>/orderQuery/getRefundInfo",
						type:"POST",
						data: 'order_type='+order_type+"&orderId="+orderId,
						dataType: 'json',
						success:function(data){
							if(data.status=="ok"){
								var order=data.order;
								if(order){
									$("#refundPayee").val(order.refundPayee);
									$("#loginPhone").val(order.loginPhone);
									$("#order_price").val(order.order_price);
									$("#send_price").val(order.send_price);
									$("#benefit_price").val(order.benefit_price);
									$("#userId").val(order.userId);
									$("#returnPoints").val(order.returnPoints);
									$("#payTypeId").val(order.payTypeId);
									$("#real_payPrice").val(order.real_payPrice);
									var explain=order.remark;
									if(explain){
										$("#textExplain").val(explain);
									}
								}else{
									alert("未查到订单信息,请确认填写是否有误!");
									return;
								}
							}else{
								alert("订单查询异常!");
								return;
							}
						},
						error:function(err){
							alert(err);
						}
					})
			    }
			}
	    }
</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">添加退款单</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">退款订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">添加退款单</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<div>
						<form name="formain" id="formain" method="post" action="<%=path%>/orderQuery/addRefundOrder" >
						
						<div class="editPage">
							<div class="editLeft">
								<div class="row-list">
									<label>订单号：</label>
									<input class="td_text_w" style="width: 48.5%;" name="orderGroupId" id="orderGroupId" type="text" class="left" value="${reOrder.orderGroupId}"/>
									<!-- <input type="button" class="left back_dblue col_white btn" value="查询" onclick="queryOrder();" /> -->
									<button class="left back_dblue col_white btn"  style="margin: 0;width: 14.7%;position: relative; top: 1px;" onclick="queryOrder();return false;" ><i class="icon-btn icon-search"></i>查询</button>
								</div>
								<div class="row-list">
									<label>订单类型：</label>
									<select class="td_text_w" name="order_type" id="order_type">
									<option value="">-请选择-</option>
									<option value=1>普通订单</option>
									<option value=2>团购订单</option>
									<option value=3>积分订单</option>
									</select>
								</div>
								<div class="row-list">
									<label>联系人：</label>
									<input name="refundPayee" id="refundPayee" type="text" class="td_text_w" value="${reOrder.refundPayee}" readonly="readonly" />
									<input name="userId" id="userId" type="hidden" class="left" value="${reOrder.userId}" />
								</div>
								<div class="row-list">
									<label>手机号：</label>
									<input name="loginPhone" id="loginPhone" type="text" class="td_text_w" value="${reOrder.loginPhone}" readonly="readonly" />
								</div>
								<div class="row-list">
									<label>退款原因：</label>
									<select class="td_text_w" id="refundReason" name="refundReason">
										<option value="">请选择</option>
										<option value="未在约定时间送达">未在约定时间送达</option>
										<option value="价格错误">价格错误</option>
										<option value="拍错了/不想要了">拍错了/不想要了</option>
										<option value="商品无货部分退款">商品无货部分退款</option>
										<option value="长时间未确认接单">长时间未确认接单</option>
										<option value="内部测试订单">内部测试订单</option>
										<option value="拍错重新下单">拍错重新下单</option>
										<option value="全部/部分商品无货取消订单">全部/部分商品无货取消订单</option>
										<option value="联系不到客户">联系不到客户</option>
										<option value="门店配货错误">门店配货错误</option>
										<option value="换货后退差额">换货后退差额</option>
									</select>
								</div>
								<div class="row-list">
									<label>订单总金额：</label>
									<input name="order_price" class="td_text_w" id="order_price" type="text" class="left" value="${reOrder.order_price}" readonly="readonly" />
									<input name="payTypeId" id="payTypeId" type="hidden" value="${reOrder.payTypeId}" />
								</div>
								<div class="row-list">
									<label>客户实付金额：</label>
									<input id="real_payPrice" type="text" class="td_text_w" value="${reOrder.real_payPrice}" readonly="readonly" />
								</div>
								<div class="row-list">
									<label>运费：</label>
									<input name="send_price" id="send_price" type="text" class="td_text_w" value="${reOrder.send_price}" readonly="readonly" />
								</div>
							</div>
							<div class="line"></div>
							<div class="editRight">
								<div class="row-list">
									<label>优惠金额：</label>
									<input name="benefit_price" id="benefit_price" class="td_text_w" type="text" value="${reOrder.benefit_price}" readonly="readonly" />
								</div>
								<div class="row-list">
									<label>实际退款：</label>
									<input name="refundAmount" id="refundAmount" class="td_text_w" type="text" value="${reOrder.refundAmount}"/>
								</div>
								<div class="row-list">
									<label>退积分：</label>
									<input name="returnPoints" id="returnPoints" type="text" class="td_text_w" value="${reOrder.returnPoints}" readonly="readonly" />
								</div>
								<div class="row-list">
									<label>订单说明：</label>
									<textarea class="td_text_w" id="textExplain" cols ="45" rows = "5" readonly="readonly" ></textarea>
								</div>
								<div class="row-list">
									<label>客服备注：</label>
									<textarea class="td_text_w" id="textremark" cols ="30" rows = "5" ></textarea>
									<input name="remark" id="remark" type="hidden" class="left" value="${reOrder.remark}"/>
								</div>
							</div>
						</div>
						
						</form>
						</div>						
					</div>					 
			</section>
			<div class="bgbtn">
				<!-- <input type="submit" value="确认" class="left back_dblue col_white btn"/>
				<input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="取消"/> -->
				<button type="button" onclick="doSubmitCheck();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>确认</button>
				<button type="button" class="left back_dblue btn" onclick="cleanForm()" value=""><i class="icon-btn icon-goback"></i>取消</button>
				<span class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
			</div>
		</div>
	</body>
</html>
