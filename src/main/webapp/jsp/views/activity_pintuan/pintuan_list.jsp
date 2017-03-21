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
<script type="text/javascript">
/**2017.2.10
 * 这是一个日期插件
 * Demo地址：http://www.cnblogs.com/linJie1930906722/p/6066071.html
 * 类似第六个开始结束区间(第二种写法)
 */
		window.onload=function(){
			 var pg=$("#pageIndex").val();
			 if(!pg){
				 $("#pageIndex").val(1);
			 }
			 
			 $('#createTime').datetimepicker({
					dateFormat:'yy-mm-dd',
					timeFormat: 'HH:mm:ss',
					stepHour: 1,
					stepMinute: 1,
					stepSecond: 1
				});
			
			 $('#createEndTime').datetimepicker({
				 	dateFormat:'yy-mm-dd',
					timeFormat: 'HH:mm:ss',
					stepHour: 1,
					stepMinute: 1,
					stepSecond: 1
			});
			 
			 $('#activityTimeStr').datetimepicker({
				 	dateFormat:'yy-mm-dd',
					timeFormat: 'HH:mm:ss',
					stepHour: 1,
					stepMinute: 1,
					stepSecond: 10
			});
			 
			 $('#activityEndTimeStr').datetimepicker({
				 	dateFormat:'yy-mm-dd',
					timeFormat: 'HH:mm:ss',
					stepHour: 1,
					stepMinute: 1,
					stepSecond: 10
			});
			 
			 $("[name='online'][value='<c:out value="${query.online}"/>']").attr("checked",true);
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
 
	 
	 function delAll(){
		//	 var mpArray=new Array();
		//	 var j=0;
		var baseIds="";
			// $("input['name=mallAndpcode']").val(); 
			//判断每一个single是否都选中了呢 ?
			var singles = document.getElementsByName('baseId');
			for(var i=0;i<singles.length;i++){
				if(singles[i].checked){
					var svalue=singles[i].value;
					if(svalue){
		//				var mpcode=svalue.split(",");
		//				var mallp={};
		//				mallp.mall_code=mpcode[0];
		//				mallp.p_code=mpcode[1];
		//				mpArray[j]=svalue;
		//				j++;
						baseIds=baseIds+svalue+",";
					}
				}
			}
			
			if(baseIds){
				if(confirm("你确定要删除选中数据吗?")){
					if(baseIds.charAt(baseIds.length-1)==","){
						baseIds=baseIds.substr(0,baseIds.length-1);
					}
				}else{
					return;
				}
			}else{
				alert("请选择商品!");
				return;
			}
			
			if(baseIds){
				var data1=baseIds;
				<%-- $.ajax({			
						url:"<%=path%>/pintuan/delPtProducts",
						type:"POST",
						data: 'baseIds='+data1,
						dataType: 'text',
						success:function(data){
							console.log(data);
						},
						error:function(err){
							alert(err);
						}
					}) --%>
				window.location.href="<%=path%>/pintuan/delPtProducts?baseIds="+data1;
			}
	 }
	 
		//全选功能
		function doChoose(){
			//首先要取到"全选"复选框的选中状态
			var state = document.getElementById('all').checked;
			//让所有的single复选框的状态和state保持一致
			var singles = document.getElementsByName('baseId');
			//循环遍历每一个single
			for(var i=0;i<singles.length;i++){
				singles[i].checked = state;
			}
		}
	
		//当我们将每一个single都选中的时候,让"全选"复选框自动选中
		function chooseSingle(){
			var count = 0;
			//判断每一个single是否都选中了呢 ?
			var singles = document.getElementsByName('baseId');
			for(var i=0;i<singles.length;i++){
				if(singles[i].checked){
					count++;
				}
			}
			//根据选中的single的个数,来确定"全选"复选框的状态
			if(count == singles.length){
				document.getElementById('all').checked = true;
			}else{
				document.getElementById('all').checked = false;
			}
		}

		function onlineAll(type){
				var baseIds="";
					//判断每一个single是否都选中了呢 ?
					var singles = document.getElementsByName('baseId');
					for(var i=0;i<singles.length;i++){
						if(singles[i].checked){
							var svalue=singles[i].value;
							if(svalue){
								baseIds=baseIds+svalue+"-";
							}
						}
					}
					
					if(baseIds){
						if(confirm("确定批量发布选中数据吗")){
							if(baseIds.charAt(baseIds.length-1)=="-"){
								baseIds=baseIds.substr(0,baseIds.length-1);
							}
						}else{
							return;
						}
					}else{
						alert("请选择商品!");
						return;
					}
					
					if(baseIds){
						var data1=baseIds;
						<%-- $.ajax({			
								url:"<%=path%>/pintuan/onlinePtProducts",
								type:"POST",
								data: 'baseIds='+data1+"&type="+type,
								dataType: 'text',
								success:function(data){
									console.log(data);
								},
								error:function(err){
									alert(err);
								}
							}) --%>
						window.location.href="<%=path%>/pintuan/onlinePtProducts?baseIds="+data1+"&type="+type;
					}
		}
		
		function getdetail(id){
			window.location.href="<%=path%>/pintuan/getPtBaseInfo?id="+id;
		}
		
		function addProducts(){
			window.location.href="<%=path%>/jsp/views/activity_pintuan/pintuan_add.jsp";
		}
		
		function leadOutFile(){
			if(confirm("确定导出吗")){
				 var mall_name=$("#mall_name").val();
				 var mall_code=$("#mall_code").val();
				 var p_code=$("#p_code").val();
				 var p_name=$("#p_name").val();
				 var status=$("#status").val();
				 var urlparm="?mall_name="+mall_name+"&mall_code="+mall_code+"&p_code="+p_code+"&p_name="+p_name+"&status="+status;
				window.location.href="<%=path%>/shop/leadOutProducts"+urlparm;
			}
		}
		
</script>
<body>
<c:out value="${message }" />
	<div id="wrap">
				<!-- <header class="cont_section_header">拼团管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<span style="color:#3bb3e0;">拼团管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/pintuan/getPtBaseList">
							<div class="row">
								<input name="pName" placeholder="商品名称" id="pName" type="text" class="left" value="${query.pName}" />
								<input type="hidden" id="pageIndex" value=${query.pageIndex} name="pageIndex" />
								<input class="datatime-input" type="text" placeholder="创建时间起" name="createTime" id="createTime" value="${query.createTime}" >
							    <input class="datatime-input" type="text" placeholder="创建时间止" name="createEndTime" id="createEndTime" value="${query.createEndTime}" >
								<select name="online" id="online" class="left">
									<option value="">状态</option>
									<option value=1>上线</option>
									<option value=0>下线</option>
								</select>
								<input class="datatime-input" type="text" placeholder="活动时间起" name="activityTimeStr" id="activityTimeStr" value="${query.activityTimeStr}" >
							    <input class="datatime-input" type="text" placeholder="活动时间止" name="activityEndTimeStr" id="activityEndTimeStr" value="${query.activityEndTimeStr}">
							</div> 
							<div class="col-click">
								<button type="button" onclick="document.getElementById('formain').submit();" class="left back_dblue col_white btn"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>	
						  </div>
						<div class="section_table">
							<table cellspacing="none" class="table_hover">
						<div class="height hig">
							<span class="left back_dblue btn" onclick="addProducts()"><i class="icon-btn icon-add"></i>新增团购</span>
							<span class="left back_dblue btn" onclick="onlineAll(1)"><i class="icon-btn icon-shelves"></i>发布上架</span>
							<span class="left back_dblue btn" onclick="onlineAll(2)"><i class="icon-btn icon-offshelf"></i>下架</span>
							<span class="left back_dblue btn" onclick="delAll()"><i class="icon-btn icon-delete"></i>批量删除</span>
						</div>	
						<thead style="background:#EBEBEB;">
							<th><input style="margin-left:23%;" type="checkbox" name="all" id="all" onclick="doChoose()"></th>
							<th>排序</th>
							<th>创建时间</th>
							<th>描述</th>
							<th>商品名称</th>
							<th>市场价格</th>
							<th>团购价</th>
							<th>库存</th>
							<th>活动人数</th>
							<th>状态</th>
							<th>活动时间</th>
							<th>操作</th>
						</thead>
						<tbody>
						    <c:forEach var="base" items="${baseProducts}" varStatus="status">
						    <tr class="goods_tr">
								<td style="width:2.5%;"><input style="margin-left:23%;" type="checkbox" name="baseId" id="baseId" value="${base.id}@${base.productId}" onclick="chooseSingle()"></td>
								<td>${base.sortIndex}</td>
								<td><fmt:formatDate value="${base.creDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${base.description}</td>
								<td>${base.pName}</td>
								<td>${base.marketPrice}</td>
								<td>${base.ptPrice}</td>
								<td>${base.quantity}</td>
								<td>${base.lowerLimit}-${base.upperLimit}</td>
								<td>
									<c:choose>  
  										<c:when test="${base.online}">
  											上线
   										</c:when>  
									    <c:otherwise>
											下线
									    </c:otherwise>  
									</c:choose>
								
								</td>
								<td>
									<fmt:formatDate value="${base.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>-
									<fmt:formatDate value="${base.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td><a href="#" onclick="getdetail(${base.id})"><i class="icon-op icon-op-details"></i>详情</a></td>
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
	hrefFormer : 'pintuan/getPtBaseList',
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
<script type="text/javascript">
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,""); 
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
   $(".section_table .hig").css("margin-bottom","15px");
}
</script>
