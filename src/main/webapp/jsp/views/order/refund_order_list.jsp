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
		 $("[name='refund_type'][value='<c:out value="${query.refund_type}"/>']").attr("checked",true);
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
			$("[name='formain']").attr("action","<%=path%>/orderQuery/leadOutRefundOrder");
			$("[name='formain']").submit();
			$("[name='formain']").attr("action","refundOrderlist");
		}
	 
	 function addRefund(){
			window.location.href="<%=path%>/jsp/views/order/refund_order_add.jsp";
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
				<!-- <header class="cont_section_header">退款订单</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">退款订单</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/orderQuery/refundOrderlist">
							<div class="row">
								<input name="id" placeholder="退款单号" id="id" type="text" class="left" value="${query.id}"/>
								<input name="order_group_id" placeholder="订单号" id="order_group_id" type="text" class="left" value="${query.order_group_id}"/>
								<input name="mall_name" placeholder="门店名称" id="mall_name" type="text" class="left" value="${query.mall_name}"/>
								<input name="mall_code" placeholder="门店编号" id="mall_code" type="text" class="left" value="${query.mall_code}"/>
								<select name="status" id="status" class="left">
									<option value="" >退款状态</option>
									<option value="0">无退款</option>
									<option value="1">等待退款</option>
									<option value="2">正在退款</option>
									<option value="3">已退款</option>
									<option value="4">退款失败</option>
									<option value="5">未确定 </option>
									<option value="6">转入代发</option>
								</select>
								<select name="refund_type" id="refund_type" class="left">
									<option value="">退款方式</option>
									<option value="1">人工</option>
									<option value="2">自动</option>
								</select>
								<input class="datatime-input" placeholder="下单时间起" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" size="25">
								<input class="datatime-input" placeholder="下单时间止" type="text" name="endDate" id="endDate" value="${query.endDate}" size="25">
								<input type="hidden" id="pageIndex" name="pageIndex" value=${query.pageIndex}>
								<input type="hidden" id="querySource" name="querySource" value=0>
							</div>
							<div class="col-click">
								<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>
						</div>						
						<div class="section_table">
							<table class="table_hover" cellspacing="none" style="margin-top:-10px;">
						<div class="height" style="margin:7px 0px 17px -5px;">
							<!-- <span ><input type="button" value="导出" class="left back_dblue btn onbtn" onclick="exportProduct()"/></span>
							<span ><input type="button" value="新增" class="left back_dblue btn onbtn" onclick="addRefund()"/></span> -->
							<span ><button type="button" class="left back_dblue btn onbtn" onclick="exportProduct()"><i class="icon-btn icon-export"></i>导出</button></span>
							<span ><button type="button" class="left back_dblue btn onbtn" onclick="addRefund()"><i class="icon-btn icon-add"></i>新增</button></span>
							<span class="right">共${query.totalNums}条订单数据&nbsp;</span>
						</div>
						<thead style="background:#EBEBEB">
							<th>编号</th>
							<th>退款单号</th>
							<th>订单单号</th>
							<th>在线支付退款流水号</th>
							<th>订单状态</th>
							<th>创建时间</th>
							<th>审核时间</th>
							<th>门店编码</th>
							<th>门店名称</th>
							<th>退款用户</th>
							<th>联系电话</th>
							<th>审核状态</th>
							<th>退款方式</th>
							<th>退款金额</th>
							<th>退积分</th>
							<th>订单金额来源</th>
						</thead>
						<tbody>
						    <c:forEach var="order" items="${orderlist}" varStatus="status">
						    <tr class="goods_tr">
								<td>${status.index+1}</td>
								<td>
								<a href="<%=path%>/orderQuery/refundInfoDetail?id=${order.order_group_id}">${order.id}</a>
								</td>
								<td>
								<a href="<%=path%>/orderQuery/refundOrderDetail?id=${order.id}&order_type=${order.order_type}">${order.order_group_id}</a>
								</td>
								<td>${order.serial_no}</td>
								<td>
									<c:choose>  
	  										<c:when test="${order.refund_onlinepay_status==0}">
	  											无退款
	   										</c:when> 
	   										<c:when test="${order.refund_onlinepay_status==1}">
	  											等待退款
	   										</c:when>
	   										<c:when test="${order.refund_onlinepay_status==2}">
	  											正在退款 
	   										</c:when> 
	   										<c:when test="${order.refund_onlinepay_status==3}">
	  											已退款 
	   										</c:when>
	   										<c:when test="${order.refund_onlinepay_status==4}">
	  											退款失败
	   										</c:when> 
	   										<c:when test="${order.refund_onlinepay_status==5}">
	  											未确定
	   										</c:when>
	   										<c:when test="${order.refund_onlinepay_status==5}">
	  											转入代发
	   										</c:when>
	   									</c:choose> 
								</td>
								<td>
								<fmt:formatDate value="${order.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
								<fmt:formatDate value="${order.confirm_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>${order.mall_code}</td>
								<td>${order.mall_name}</td>
								<td>${order.custname}</td>
								<td>${order.custphone}</td>
								<td>
								<c:choose>  
	  										<c:when test="${order.refund_status==1}">
	  											未审核
	   										</c:when> 
	   										<c:when test="${order.refund_status==2}">
	  											已审核
	   										</c:when>
	   										<c:when test="${order.refund_status==3}">
	  											取消
	   										</c:when>
	   								</c:choose> 
								
								</td>
								<td>
									<c:choose>  
	  										<c:when test="${order.refund_type==1}">
	  											人工退款 
	   										</c:when> 
	   										<c:when test="${order.refund_type==2}">
	  											自动退款
	   										</c:when>
	   								</c:choose> 
								</td>
								<td>${order.refund_amount}</td>
								<td>${order.return_points}</td>
								<td>${order.pay_type_name}</td>
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
		hrefFormer : 'orderQuery/refundOrderlist',
		//链接尾部
		hrefLatter :'',
		getLink : function(n) {
			return "../"+this.hrefFormer + this.hrefLatter + "?pageIndex=" + n+"&pageSize="+pageSize //参数名跟上面相同
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
   $(".height .onbtn").css("margin","13px 0px 7px 10px")
}
</script>
</html>
