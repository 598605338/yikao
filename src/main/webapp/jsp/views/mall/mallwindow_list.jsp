<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="<%=path%>/js/divPage/productStyle.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<jsp:include page="../header.jsp" />
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
	 
	//全选功能
		function doChoose(){
			//首先要取到"全选"复选框的选中状态
			var state = document.getElementById('all').checked;
			//让所有的single复选框的状态和state保持一致
			var singles = document.getElementsByName('MallNameAndCode');
			//循环遍历每一个single
			for(var i=0;i<singles.length;i++){
				singles[i].checked = state;
			}
		}
	
		//当我们将每一个single都选中的时候,让"全选"复选框自动选中
		function chooseSingle(){
			var count = 0;
			//判断每一个single是否都选中了呢 ?
			var singles = document.getElementsByName('MallNameAndCode');
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
 
		function doWithMallCodes(){
				var mCodes="";
				var mNames="";
				debugger;
					//判断每一个single是否都选中了呢 ?
					var singles = document.getElementsByName('MallNameAndCode');
					for(var i=0;i<singles.length;i++){
						if(singles[i].checked){
							var svalue=JSON.parse((singles[i].value).split("*").join('\"'));
							var codeVal=svalue.mCode;
							var nameVal=svalue.mName;
							if(codeVal){
								mCodes=mCodes+codeVal+",";
							}
							if(nameVal){
								mNames=mNames+nameVal+";";
							}
						}
					}
					
					if(mCodes){
						if(mCodes.charAt(mCodes.length-1)==","){
							mCodes=mCodes.substr(0,mCodes.length-1);
						}
					}else{
						alert("请选择门店");
					}
					
					if(mCodes){
						$(window.parent.document).find("[id='mall_codes']").val(mCodes);
					}
					if(mNames){
						$(window.parent.document).find("[id='mall_names']").html(mNames);
						$(window.parent.document).find("[id='mall_names']").val(mNames);
					}
					//关闭当前页面
					window.parent.popupProClose1();
					return false; 
		}

</script>
<body>
<div id="wrap">
		<c:out value="${message }" />
				<!-- <header class="cont_section_header">门店列表</header> -->
				<header class="cont_section_header"> <span
					class="cont_section_header_1">门店列表</span> <i
					class="cont_section_header_2"></i> <i class="cont_section_header_3"></i>
				<i class="cont_section_header_4"></i></header>
				
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/shop/shopwinList">
							<div class="row">
								<input name="mallName" placeholder="门店名称" id="mallName" type="text" class="left" value="${query.mallName}"/>
								<input name="mallCode" placeholder="门店编码" id="mallCode" type="text" class="left" value="${query.mallCode}"/>
							</div>
							<div class="col-click">
								<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>
						</div>
						<div class="section_table">
							<table cellspacing="none">
						<div class="click" style="min-height:31px;">
							<!-- <span><input type="button" value="选择" class="left back_dblue btn" onclick="doWithMallCodes()"/></span> -->
							<a href="javascript:void(0)" onclick="doWithMallCodes()"><span class="left back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
							<span class="right">共${query.totalNums}家门店信息&nbsp;</span>
						</div>
						<thead style="background:#ebebeb;">
							<th style="margin-left:5%;"><input style="margin-left:25%;" type="checkbox" name="all" id="all" onclick="doChoose()"></th>
							<th>门店名称</th>
							<th>门店编号</th>
							<th>地址</th>
							<th>联系电话</th>
							<th>门店营业状态</th>
						</thead>
						        <tbody>
						        	<c:forEach var="shop" items="${shopList}" varStatus="status">
						        		<tr class="goods_tr">
						        			<td><input style="margin-left:25%;" type="checkbox" name="MallNameAndCode" id="MallNameAndCode" value="{*mCode*:*${shop.mallCode}*,*mName*:*${shop.mallName}*}" onclick="chooseSingle()"></td>
											<td>${shop.mallName}</td>
											<td>${shop.mallCode}</td>
											<td>${shop.address}</td>
											<td>${shop.phone}</td>
											<td>
												<c:choose>  
			  										<c:when test="${shop.mallStatus==1}">
			  											 正常营业
			   										</c:when>  
												    <c:otherwise>
														    休息中 
												    </c:otherwise>  
											</c:choose>
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
	hrefFormer : 'shop/shopwinList',
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