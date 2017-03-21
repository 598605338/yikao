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
		 
		$("[name='send_type'][value='<c:out value="${query.send_type}"/>']").attr("checked",true);
		$("[name='pay_status'][value='<c:out value="${query.pay_status}"/>']").attr("checked",true);
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
		 alert("你猜能导出吗?");
			<%-- $("[name='formain']").attr("action","<%=path%>/orderQuery/leadOutThreeOrder");
			$("[name='formain']").submit();
			$("[name='formain']").attr("action","getOrderList"); --%>
		}

</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">预约订单</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">预约订单</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/orderQuery/getOrderList">
							<div class="height flex">
								<span class="left disp">收货人：</span>
								<input name="receive_name" id="receive_name" type="text" class="left" value="${query.receive_name}"/>
								<span class="left disp">订单号：</span>
								<input name="order_id" id="order_id" type="text" class="left" value="${query.order_id}"/>
								<span class="left disp">手机号码：</span>
								<input name="receive_phone" id="receive_phone" style="display:inline-block !important; height:30px;width:45%;" type="text" class="left" value="${query.receive_phone}"/>
								<span class="left disp">门店号：</span>
								<input name="mall_code" id="mall_code" type="text" class="left" value="${query.mall_code}"/>
								<span class="left disp">门店名称：</span>
								<input name="mall_name" id="mall_name" type="text" class="left" value="${query.mall_name}"/>
								<span class="left disp">配送方式：</span>
								<select name="send_type" id="send_type" class="left">
									<option value="">全部</option>
									<option value="0" selected = "selected">送货上门</option>
									<option value="1">上门自提</option>
								</select>
							</div>
							<div class="height flex">	
								<span class="left disp">支付状态：</span>
								<select name="pay_status" id="pay_status" class="left">
									<option value="">全部</option>
									<option value="1" selected = "selected">已付款</option>
									<option value="0">未付款</option>
								</select>
								<span class="left disp">订单状态：</span>
								<select name="status" id="status" class="left">
									<option value="">全部</option>
									<option value="0">未付款</option>
									<option value="1">已付款</option>
									<option value="2" selected = "selected">已确认</option>
									<option value="4">进行中(配送中)</option>
									<option value="5">已完成</option>
									<option value="6">已取消</option>
								</select>
								<span class="left disp">下单时间：</span>
								<input class="datatime-input" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" >--
								<input class="datatime-input" type="text" name="endDate" id="endDate" value="${query.endDate}" >
								<input type="hidden" id="pageIndex" name="pageIndex" value=${query.pageIndex}>
								<input type="hidden" id="querySource" value="${query.querySource}" name="querySource" >
							</div>
							<div class="height">
								<div class="bgbtn flex">
									<!-- <span ><input type="submit" value="查询" class="left back_dblue col_white btn"/></span>
									<span ><input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span> -->
									<span ><button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button></span>
									<span ><button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button></span>
								</div>								
							</div>
						</form>
						</div>						
						<div class="click">
							<span class="left back_dblue btn" onclick="orderQuery(4)"><i class="icon-btn icon-enable"></i>全部订单</span>
							<span class="left back_dblue btn" onclick="orderQuery(1)"><i class="icon-btn icon-enable"></i>商城订单</span>
							<span class="left back_dblue btn" onclick="orderQuery(2)"><i class="icon-btn icon-enable"></i>美团订单</span>
							<span class="left back_dblue btn" onclick="orderQuery(3)"><i class="icon-btn icon-enable"></i>百度订单</span>
						</div>
						<div class="height">
							<!-- <span ><input type="button" value="导出" class="left back_dblue btn" onclick="exportProduct()"/></span> -->
							<span ><button type="button" class="left back_dblue btn" onclick="exportProduct()"><i class="icon-btn icon-export"></i>导出</button></span>
							<span class="right">共${query.totalNums}条订单数据&nbsp;</span>
						</div>
						<div class="section_table">
							<table cellspacing="none">
						<thead>
							<th>订单号</th>
							<th>下单时间</th>
							<th>订单状态</th>
							<th>订单类型</th>
							<th>收货人</th>
							<th>联系方式</th>
							<th>门店号</th>
							<th>门店名称</th>
							<th>配送方式</th>
							<th>支付方式</th>
							<th>支付时间</th>
							<th>总金额</th>
							<th>实付金额</th>
							<th>运费</th>
							<th>优惠金额</th>
							<th>订单渠道</th>
							<th>积分</th>
						</thead>
						<tbody>
						<c:forEach var="order" items="${orderlist}" varStatus="status">
						 	<tr class="goods_tr">
								<td>
								<a href="<%=path%>/orderQuery/orderDetail?shopId=${order.mall_code}&orderId=${order.id}&orderSource=${order.orderSource}">${order.id}</a>
								</td>
								<td><fmt:formatDate value="${order.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>
									<c:choose>  
	  										<c:when test="${order.status==0 and order.orderSource==1}">
	  											未付款
	   										</c:when> 
	   										<c:when test="${order.status==1 and order.orderSource==1}">
	  											已付款
	   										</c:when>
	   										<c:when test="${order.status==2 and order.orderSource==1}">
	  											商家确认
	   										</c:when>
	   										<c:when test="${order.status==3 and order.orderSource==1}">
	  											商家取消
	   										</c:when>
	   										<c:when test="${order.status==4 and order.orderSource==1}">
	  											派送中
	   										</c:when>
	   										<c:when test="${order.status==5 and order.orderSource==1}">
	  											已完成
	   										</c:when>
	   										<c:when test="${order.status==6 and order.orderSource==1}">
	  											客户取消
	   										</c:when>
	   										
	   										<c:when test="${order.status==1 and order.orderSource==2}">
	  											待确认
	   										</c:when>
	   										<c:when test="${order.status==4 and order.orderSource==2}">
	  											商家确认
	   										</c:when>
	   										<c:when test="${order.status==6 and order.orderSource==2}">
	  											派送中
	   										</c:when>
	   										<c:when test="${order.status==8 and order.orderSource==2}">
	  											已完成
	   										</c:when>
	   										<c:when test="${order.status==9 and order.orderSource==2}">
	  											已取消
	   										</c:when>
	   										
	   										<c:when test="${order.status==5 and order.orderSource==3}">
	  											商家确认
	   										</c:when>
	   										<c:when test="${order.status==7 and order.orderSource==3}">
	  											派送中
	   										</c:when>
	   										<c:when test="${order.status==8 and order.orderSource==3}">
	  											派送中
	   										</c:when>
	   										<c:when test="${order.status==9 and order.orderSource==3}">
	  											已完成
	   										</c:when>
	   										<c:when test="${order.status==10 and order.orderSource==3}">
	  											已取消
	   										</c:when>
	   									</c:choose> 
								</td>
								<td>
									<c:choose>  
	  										<c:when test="${order.order_type==1}">
	  											商城订单
	   										</c:when> 
	   										<c:when test="${order.order_type==2}">
	  											美团订单
	   										</c:when>
	   										<c:when test="${order.order_type==3}">
	  											百度订单
	   										</c:when>
	   								</c:choose> 
								</td>
								<td>${order.receive_name}</td>
								<td>${order.receive_phone}</td>
								<td>${order.mall_code}</td>
								<td>${order.mall_name}</td>
								<td>
									<c:choose>  
  										<c:when test="${order.send_type==0 and order.orderSource==1}">
  											送货上门
   										</c:when> 
   										<c:when test="${order.send_type==1 and order.orderSource==1}">
  											 上门自提
   										</c:when>
   										<c:when test="${order.orderSource==2}">
  											送货上门
   										</c:when>
   										<c:when test="${order.orderSource==3}">
  											送货上门
   										</c:when>
   									</c:choose> 
								</td>
								<td>
									<c:choose>  
  										<c:when test="${order.pay_type==0 and order.orderSource==1}">
  											微信支付
   										</c:when> 
   										<c:when test="${order.pay_type==1 and order.orderSource==1}">
  											 钱包支付
   										</c:when>
   										<c:when test="${order.pay_type==2 and order.orderSource==1}">
  											 积分兑换
   										</c:when>
   										<c:when test="${order.orderSource==2}">
  											在线支付
   										</c:when>
   										<c:when test="${order.orderSource==3}">
  											在线支付
   										</c:when>
   									</c:choose> 
								</td>
								<td>${order.pay_time}</td>
								<td>${order.total_price}</td>
								<td>${order.real_price}</td>
								<td>${order.send_price}</td>
								<td>${order.benefit_price}</td>
								<td>
									<c:choose>  
										<c:when test="${order.orderSource==1}">
  											 商城订单
   										</c:when> 
   										<c:when test="${order.orderSource==2}">
  											 商城订单
   										</c:when>
   										<c:when test="${order.orderSource==3}">
  											百度订单
   										</c:when>
   									</c:choose>  
								</td>
								<td>${order.add_score}</td>
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
		hrefFormer : 'orderQuery/getOrderList',
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
</html>
