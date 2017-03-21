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
		 
		 $("#transtatus").val('<c:out value="${query.transtatus}"/>');
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
 

</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">会员充值记录列表</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">会员</a><span>&gt;</span>
					<span style="color:#3bb3e0;">会员充值记录列表</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
							<form name="formain" id="formain" method="post" action="<%=path%>/cust/getAccountcashdepositRecordList">
								<div class="row">
									<input name="custname" placeholder="会员名称" id="custname" type="text" class="left" value="${query.custname}"/>
									<input name="phone" placeholder="手机号" id="phone" type="text" class="left" value="${query.phone}"/>
									<select name="transtatus" id="transtatus" class="left">
										<option value="">充值状态</option>
										<option value="0">未完成</option>
										<option value="1">已完成</option>
									</select>
									<input class="datatime-input" placeholder="充值时间起" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" >
									<input class="datatime-input" placeholder="充值时间止" type="text"  name="endDate" id="endDate" value="${query.endDate}" >
									<input type="hidden" id="pageIndex" name="pageIndex" value="${query.pageIndex}">
								</div>
								<div class="col-click">
									<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button>
									<button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
								</div>
							</form>
						</div>
						
						<div class="section_table">
							<div class="click" style="margin:0; margin-bottom: -20px;">
								<span class="right">共${query.totalNums}条记录&nbsp;</span>
							</div>
							<table class="table_hover" cellspacing="none">
						<thead style="background:#EBEBEB">
							<th>充值流水号</th>
							<th>会员号</th>
							<th>会员名</th>
							<th>会员卡号</th>
							<th>充值日期</th>
							<th>充值金额</th>
							<th>充值来源</th>
						</thead>
						<tbody>
						<c:forEach var="record" items="${recordlist}" varStatus="status">
						 	<tr class="goods_tr">
								<td>${record.xid}</td>
								<td>${record.accountaccesscode}</td>
								<td>${record.custname}</td>
								<td>${record.cardNo}</td>
								<td><fmt:formatDate value="${record.trantime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${record.occur}</td>
								<td>微信支付</td>
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
