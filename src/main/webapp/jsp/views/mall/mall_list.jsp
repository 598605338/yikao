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
<style>
	a{
		color:#2285C5;
	}
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
 
	 function addShop(){
			window.location.href="<%=path%>/jsp/views/mall/mall_add.jsp";
		}

	 function shopDetail(mall_code){
			window.location.href="<%=path%>/shop/queryOneShopInfo?mall_code="+mall_code;
	}
	 
	 function shopDelete(mall_code,bd_map_key){
		 if(mall_code&&bd_map_key){
			window.location.href="<%=path%>/shop/lbsMalldel?mall_code="+mall_code+"&bd_map_key="+bd_map_key;
		 }else{
			 alert("对不起,数据缺失不能删除!");
		 }
	}
	 
	function onlineOff(mall_code,type,bd_map_key){
			if(mall_code&&bd_map_key){
				if(confirm("你确定操作选中门店吗?")){
					<%-- $.ajax({			
						url:"<%=path%>/shop/onlineOffShop",
						type:"POST",
						data: 'mallCode='+mall_code+"&operate_type="+type,
						dataType: 'text',
						success:function(data){
							var msg=data.message;
							alert(msg);
							 $('#formain').submit();
						},
						error:function(err){
							alert(err);
						}
					})  --%>
					window.location.href="<%=path%>/shop/onlineOffShop?mallCode="+mall_code+"&operate_type="+type+"&bd_map_key="+bd_map_key;
				}else{
					return;
				}
			}else{
				alert("数据有误,操作异常!");
				return;
			}
	}
	
	function onlineOffAll(type){
		var mallcodes="";
		// $("input['name=mallAndpcode']").val(); 
		//判断每一个single是否都选中了呢 ?
		var singles = document.getElementsByName('mallCode');
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
					mallcodes=mallcodes+svalue+",";
				}
			}
		}
		
		if(mallcodes){
			if(confirm("你确定要删除选中数据吗?")){
				if(mallcodes.charAt(mallcodes.length-1)==","){
					mallcodes=mallcodes.substr(0,mallcodes.length-1);
				}
			}else{
				return;
			}
		}else{
			alert("请选择门店!");
			return;
		}
			
		if(mallcodes){
				<%-- $.ajax({			
					url:"<%=path%>/shop/onlineOffShop",
					type:"POST",
					data: 'mall_codes='+data+"&operate_type="+type,
					dataType: 'text',
					success:function(data){
						var msg=data.message;
						alert(msg);
					},
					error:function(err){
						alert(err);
					}
				})  --%>
				window.location.href="<%=path%>/shop/onlineOffShop?mall_codes="+mallcodes+"&operate_type="+type;
			}else{
				alert("对不起，未获取到门店编码!");
				return;
			}
	}
	
	
	//全选功能
	function doChoose(){
		//首先要取到"全选"复选框的选中状态
		var state = document.getElementById('all').checked;
		//让所有的single复选框的状态和state保持一致
		var singles = document.getElementsByName('mallCode');
		//循环遍历每一个single
		for(var i=0;i<singles.length;i++){
			singles[i].checked = state;
		}
	}

	//当我们将每一个single都选中的时候,让"全选"复选框自动选中
	function chooseSingle(){
		var count = 0;
		//判断每一个single是否都选中了呢 ?
		var singles = document.getElementsByName('mallCode');
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
	 
</script>
<body>
<c:out value="${message }" />
<div id="wrap">
				<!-- <header class="cont_section_header">门店管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">门店</a><span>&gt;</span>
					<span style="color:#3bb3e0;">门店管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/shop/shopList">
							<div class="row">
								<input name="mallName" placeholder="门店名称" id="mallName" type="text" class="left" value="${query.mallName}"/>
								<input type="hidden" id="pageIndex" name="pageIndex" value=${query.pageIndex}>
							</div>
							<div class="col-click">
								<span ><button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button></span>
								<span ><button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button></span>
							</div>
						</form>
						
						</div>						
						<div class="section_table">
							<table class="table_hover" cellspacing="none" style="margin-top:-1px;">
								<div class="click">
									<span class="left back_dblue btn" onclick="addShop()"><i class="icon-btn icon-add"></i>新增门店信息</span>
									<!-- <span class="left back_dblue btn" onclick="onlineOffAll(1)">批量营业</span>
									<span class="left back_dblue btn" onclick="onlineOffAll(0)">批量休店</span> -->
									<span class="right">共${query.totalNums}家门店信息&nbsp;</span>
								</div>
						<div class="emp"></div>
						<thead style="background:#ebebeb;">
							<th><input style="margin-left:25%;" type="checkbox" name="all" id="all" onclick="doChoose()"></th>
							<th>门店名称</th>
							<th>门店编号</th>
							<th>地址</th>
							<th>联系电话</th>
							<th>门店营业状态</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="shop" items="${shopList}" varStatus="status">
							<tr class="goods_tr">
								<td><input  style="margin-left:25%;" type="checkbox" name="mallCode" id="mallCode" value="${shop.mallCode}" onclick="chooseSingle()"></td>
								<td>${shop.mallName}</td>
								<td>${shop.mallCode}</td>
								<td>${shop.address}</td>
								<td>${shop.phone}</td>
								<td>
									<c:choose>  
  										<c:when test="${shop.useflg==1}">
  											启用
   										</c:when>  
									    <c:otherwise>
											    禁用
									    </c:otherwise>  
									</c:choose>
								</td>
								<td><a href="#" class="mr10" onclick="shopDetail('${shop.mallCode}')"><i class="icon-op icon-op-edit"></i>修改</a>
									<c:choose>  
  										<c:when test="${shop.useflg==1}">
  											 <a href="#" class="mr10" onclick="onlineOff('${shop.mallCode}',0,'${shop.bd_map_key}')"><i class="icon-op icon-op-disable"></i>禁用</a>
   										</c:when>  
									    <c:otherwise>
											    <a href="#" class="mr10" onclick="onlineOff('${shop.mallCode}',1,'${shop.bd_map_key}')"><i class="icon-op icon-op-able"></i>启用</a>
									    </c:otherwise>  
									</c:choose>
									<a href="#" class="mr10" onclick="shopDelete('${shop.mallCode}','${shop.bd_map_key}')"><i class="icon-op icon-op-delete"></i>删除</a>
								</td>
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
	hrefFormer : 'shop/shopList',
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
</html>
