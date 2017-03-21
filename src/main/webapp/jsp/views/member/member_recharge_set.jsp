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
		 var amounts = new Array();
			$("tr").each(function(i,item){
					var amount = $(item).closest('tr').find("[name='amount']").val();
					var giftAmount = $(item).closest('tr').find("[name='giftAmount']").val();
					if(amount||giftAmount){
						var obj={};
						obj.amount=amount;
						obj.giftAmount=giftAmount;
						amounts.push(obj);
					}
			});
			var str=JSON.stringify(amounts);
			$("#amountSetStr").val(str);
			document.getElementById('formain').submit();
		 
	 }  
	      
	    function addInput(){
	    	event.preventDefault();
	    	var tr=$("#addInput");
	    	var row = $("<tr class='goods_tr'><td></td><td><input style='float:left;margin:1.5px 0 0 2px' name='amount' id='amount' type='text'  value='${cashAmount.amount}'/>&nbsp;&nbsp;<input style='float:left;margin:1.5px 2px 0 2px' name='giftAmount' id='giftAmount' type='text'  value='${cashAmount.giftAmount}'/><button style='float:right;margin-right:2px' class='gift_btn'>x</button></td></tr>");
	    	tr.after(row);
	    	removeInput();
	    }
	    
	    function removeInput(){
	    	$(".gift_btn").each(function(){	  
	    		$(this).on("click",function(){
	    			 $(this).parent().parent(".goods_tr").remove();
	    		});	    		
	    	});	    
	    }
</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">会员充值设置</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">会员</a><span>&gt;</span>
					<span style="color:#3bb3e0;">会员充值设置</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<div class="section_table" style="border:none;">
						<form name="formain" id="formain" method="post" action="<%=path%>/cust/saveAccountcashdepositConfig"  >
							<table cellspacing="none" style="width:50%;text-align:center;margin-left: 0;">
						<tbody>
							<tr class="goods_tr" >
								<td style="width:35%;">单笔限额：</td>
								<td><input style="margin:1.5px 0 0 2px;float:left;" name="singleLimitAmount" id="singleLimitAmount" type="text" value="${depConfig.singleLimitAmount}"/></td>
							</tr>
							<tr class="goods_tr">
								<td>单日限额：</td>
								<td><input style="margin:1.5px 0 0 2px;float:left;" name="dayLimitAmount" id="dayLimitAmount" type="text"  value="${depConfig.dayLimitAmount}"/></td>
							</tr>
								<c:forEach var="cashAmount" items="${depConfig.amountList}" varStatus="status">
									<c:choose>  
		  								<c:when test="${status.index==0}">
											<tr class="goods_tr">
												<td>充值金额：</td>
												<td>
												<input style="margin:1.5px 0 0 2px;float:left;" name="amount" id="amount" type="text" value="${cashAmount.amount}"/>
												&nbsp;&nbsp;<input style="margin:1.5px 2px 0 2px;float:left;" name="giftAmount" id="giftAmount" type="text"  value="${cashAmount.giftAmount}"/>
												<span class="left disp" style="float:right;margin-right:2px">&nbsp;<font size="5"><button onclick="addInput()">+</button></font></span>
												</td>
												</div>
											</tr>
		   								</c:when>  
										<c:otherwise>
											<tr class="goods_tr">
												<td></td>
												<td>
												<input style="margin:1.5px 0 0 2px;float:left;" name="amount" id="amount" type="text"  value="${cashAmount.amount}"/>
												&nbsp;&nbsp;<input style="margin:1.5px 0 0 2px;float:left;" name="giftAmount" id="giftAmount" type="text"  value="${cashAmount.giftAmount}"/>
												&nbsp;&nbsp;<input style="margin:1.5px 2px 0 2px;float:right;margin-left:5px;width:25px;height:24px;line-height:20px;" class='gift_btn'  type="button" value="x" onclick="removeInput()">
												</td>
											</tr>
										 </c:otherwise>  
									</c:choose>
								</c:forEach>
								<tr class="goods_tr" id="addInput" style="width: 0px;height:0px;">
								</tr>
							<tr class="goods_tr">
								<td>充值支付方式：</td>
								<td>
								<input style="margin:1.5px 0 0 2px;" name="amountSetStr" id="amountSetStr" type="hidden" class="left" value="${depConfig.amountSetStr}"/>
								<input style="margin:1.5px 0 0 2px;" name="id" id="id" type="hidden" class="left" value="${depConfig.id}"/>
								<select name="pay_type" id="pay_type" class="left">
									<option value="1">微信</option>
								</select>
								</td>
							</tr>
						</tbody>
						</table>
						<!-- <input style="margin:1% 0 0 25%;" type="submit" value="保存" class="left back_dblue col_white btn"/>
						<input style="margin:1% 0 0 1%;" type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/> -->
						
						</form>	
						</div>						
					</div>					 
				</section>
				<div class="bgbtn">
					<button type="button" onclick="doWithAmount()" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
					<button type="button" class="left back_dblue btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
				</div>
				</div>
	</body>
</html>
