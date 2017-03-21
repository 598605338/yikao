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
<body>
<div id="wrap">
<c:out value="${message }" />
				<header class="cont_section_header"> <span
				class="cont_section_header_1">商品管理</span> <i
				class="cont_section_header_2"></i> <i class="cont_section_header_3"></i>
			<i class="cont_section_header_4"></i></header>
				<section class="cont_section_section">					
				<div class="goodsManage">
				  <div class="cont_section_head">
					<form name="form" id="formSearch" action="selectPopup?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>" method="post" onsubmit="setSelectProIds();">
						<div class="row">
							<input type="text" class="td_text_w" placeholder="商品编码" name="pCode" id="pCode" value="<c:out value="${query.pCode}"/>" />
							<input type="hidden" class="td_text_w" name="productIds" id="productIds" value="<c:out value="${productIds}"/>" />
							<input  type="text" class="td_text_w" placeholder="商品名称" name="name" id="name" value="<c:out value="${query.name}"/>" />
							<select name="pSendType" id="pSendType" class="left">
								<option value="">商品类型</option>
								<option value="0">门店商品</option>
								<option value="1">非门店商品</option>
							</select>
							<select name="largeCatagoryId" id="largeCatagoryId" >
								<option value="">商品搭分类</option>
								<c:forEach items="${largeCatagoryList }" var="item" varStatus="status">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
							</select>
							<select name="middleCatagoryId" id="middleCatagoryId" >
								<option value="">商品中分类</option>
								<c:forEach items="${middleCatagoryList }" var="item" varStatus="status">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-click">
							<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSearch').submit();"><i class="icon-btn icon-search"></i>查询</button>
							<button type="button" class="left back_dblue col_white btn" onClick="resetForm();"><i class="icon-btn icon-reset"></i>重置</button>
						</div>
					</form>	
				  </div>		

						<div class="section_table">
							<table cellspacing="none">
						<div class="click">
							<c:if test="${popupFlg == 2}">
							<a href="javascript:void(0)" onclick="multiSelect();"><span class="left back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
							</c:if>
						</div>
						<thead class="baColor">
							<c:if test="${popupFlg != 1 }">
							<th><input style="margin-left:20%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>
							</c:if>
							<c:if test="${popupFlg == 1 }">
							<th >操作</th>
							</c:if>
							<th>商品编码</th>
							<th>创建时间</th>
							<th>商品类型</th>
							<th>商品名称</th>
							<th>价格</th>
							<th>一级分类</th>
							<th>二级分类</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${productList }" varStatus="status">
							<tr class="goods_tr">
								<c:if test="${popupFlg != 1 }">
								<td style="width:2.5%;"><input style="margin-left:20%;" type="checkbox" name="productId" value="<c:out value="${item.id }" />" onchange="checkedChange(this);"/></td>
								</c:if>
								<c:if test="${popupFlg == 1 }">
								<td>
								<a href="javascript:void(0);" onclick="select(this);">选择</a>
								<input type="hidden" name="imagePath" value="<c:out value="${item.imagePath }" />"/>
								</td>
								</c:if>
								<td><c:out value="${item.pCode }" /></td>
								<td><fmt:formatDate value="${item.creDate }" pattern="yyyy/MM/dd HH:mm:ss"/></td>
								<td>
								<c:if test="${item.pSendType == '0' }">门店商品</c:if><c:if test="${item.pSendType == '1' }">非门店商品</c:if>
									<input type="hidden" name="pSendType" value="<c:out value="${item.pSendType }" />"/>
								</td>
								<td><c:out value="${item.name }" /></td>
								<td><c:out value="${item.marketPrice }" /></td>
								<td><c:out value="${item.largeCatagoryName }" /></td>
								<td><c:out value="${item.middleCatagoryName }" /></td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				<footer class="cont_section_footer">
				    <form name="pageForm" action="selectPopup?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="" />
				    <input type="hidden" name="pageSize" id="pageSize" value="" />
				    <input type="hidden" name="pCode" id="pCode" value="<c:out value="${query.pCode}"/>" />
				    <input type="hidden" name="name" id="name" value="<c:out value="${query.name}"/>" />
				    <input type="hidden" name="pSendType" id="pSendType" value="<c:out value="${query.pSendType}"/>" />
				    <input type="hidden" name="largeCatagoryId" id="largeCatagoryId" value="<c:out value="${query.largeCatagoryId}"/>" />
				    <input type="hidden" name="middleCatagoryId" id="middleCatagoryId" value="<c:out value="${query.middleCatagoryId}"/>" />
				   </form> 
					<div id="div_pager"></div>
				</footer>
				</div>
</body>
</html>

<script>
/**2017.2.9
 * 分页插件：
 */
//1、设置默认选中
$("#pSendType").val(<c:out value="${query.pSendType}"/>);

//2、总记录数数
var totalRecords = ${pnums};
//3、每页记录数
var pageSize=10;
//4、当前页
var pageNo = ${query.pageIndex}; //这里设置参数名
if (!pageNo) {
	pageNo = 1;
}

var totalPage = dividePage.getTotals(totalRecords,pageSize);
//5、生成分页控件 根据分页的形式在这里设置
dividePage.init({
	pno : pageNo,
	//总页码
	total : totalPage,
	//总数据条数
	totalRecords : totalRecords,
	//链接前部
	hrefFormer : 'selectPopup',
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

var selectedProductIds = '<c:out value="${productIds}"/>';
var selectedIdsArray;
var params ='<c:out value="${params}"/>'; 
if(params && params =='2'){
	selectedProductIds = '<c:out value="${tradeProductIds}"/>';
}

if(selectedProductIds){
	selectedIdsArray = selectedProductIds.split(",");
}else{
	selectedIdsArray = new Array();
}
//默认勾选已选过的商品
if(selectedIdsArray != null && selectedIdsArray.length>0){
$("[name='productId']").each(function(i,item){
	if($.inArray(item.value,selectedIdsArray) != -1){
		item.checked=true;
	}
});
}
</script>

<script>
/*2017.2.9
 * 设置所选商品Id
 */
function setSelectProIds(){

	if(selectedIdsArray != null){
		selectedProductIds = selectedIdsArray.join(",");
	}
	$("#productIds").val(selectedProductIds);
}

/*2017.2.9
 * 选择改变事件
 */
function checkedChange(o){
	var checkStatus = o.checked;
	if(checkStatus){
		selectedIdsArray.push(o.value);
		var obj={};
		var productId = $(o).closest('tr').find("[name='productId']").val();
		var pSendType = $(o).closest('tr').find("[name='pSendType']").val();
		var pCode = $(o).closest('tr').children('td:eq(1)').text();
		var pName = $(o).closest('tr').children('td:eq(4)').text();
		var marketPrice = $(o).closest('tr').children('td:eq(5)').text();
		obj.product_id=productId;
		obj.p_send_type=pSendType;
		obj.p_code=pCode;
		obj.p_name=pName;
		obj.p_price=marketPrice;
		if(params && params =='2'){
			$("#pro_item2",window.parent.document).append(
					"<tr class='goods_tr'>"	+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='hidden' name='product_id' readonly='readonly' value='"+productId+"'/>"+
						 	"<input style='width:100%;text-align:center;' type='hidden' name='p_send_type' readonly='readonly' value='"+pSendType+"'/>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_name' readonly='readonly' value='"+pName+"'/>"+
						"</td>"+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_code' readonly='readonly' value='"+pCode+"'/>"+
						"</td>"+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_price' readonly='readonly' value='"+marketPrice+"'/>"+
						"</td>"+
						"<td>"+
					 	"<input style='width:100%;text-align:center;' type='text' name='p_trade_price' value='' />"+
					"</td>"+
					"<td>"+
				 	"<input style='width:100%;text-align:center;' type='text' value=''  name='quantity' />"+
				"</td>"+
					"</tr>"	
				);
		}else{
		$("#pro_item",window.parent.document).append(
			"<tr class='goods_tr'>"	+
				"<td>"+
				 	"<input style='width:100%;text-align:center;' type='hidden' name='product_id' readonly='readonly' value='"+productId+"'/>"+
				 	"<input style='width:100%;text-align:center;' type='hidden' name='p_send_type' readonly='readonly' value='"+pSendType+"'/>"+
				 	"<input style='width:100%;text-align:center;' type='text' name='p_name' readonly='readonly' value='"+pName+"'/>"+
				"</td>"+
				"<td>"+
				 	"<input style='width:100%;text-align:center;' type='text' name='p_code' readonly='readonly' value='"+pCode+"'/>"+
				"</td>"+
				"<td>"+
				 	"<input style='width:100%;text-align:center;' type='text' name='p_price' readonly='readonly' value='"+marketPrice+"'/>"+
				"</td>"+
			"</tr>"	
		);
		}
	}else{
		var index = $.inArray(o.value,selectedIdsArray);
		if(index != -1){
			selectedIdsArray.splice(index,1);
			
			//父窗口中所选的商品unchecked的情况下要移除
			$("#pro_item",window.parent.document).children("tr").each(function(i,item){
				var cVal = $(item).find("[name='product_id']").val();
				if(o.value == cVal){
					$(item).remove();
				}
			});
		}
	}
}

/*
 * 重置
 */
function resetForm(){
	$("#pSendType").val(0);
	$("#pCode").val(null);
	$("#name").val(null);
	$("#largeCatagoryId").val('');
	$("#middleCatagoryId").val('');
}

/*
 * 全选
 */
function selAll(o){
	var selFlg = o.checked;
	$("[name='productId']").each(function(i,item){
		if(selFlg){
			item.checked=true;
		}else{
			item.checked=false;
		}
		
		//拼接或删除已选商品
		checkedChange(item);
	});
}


function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	
	setSelectProIds();
	var action="selectPopup?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>&productIds="+selectedProductIds;
	if(params && params =='2'){
		//交钱换购兑换商品
		action="selectPopup?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>&tradeProductIds="+selectedProductIds;
	}
	$("[name='pageForm']").attr("action",action);
	$("[name='pageForm']").submit();
}

//popup单选
function select(o){
	var productId = $(o).closest('tr').find("[name='productId']").val();
	var pSendType = $(o).closest('tr').find("[name='pSendType']").val();
	var imagePath = $(o).closest('tr').find("[name='imagePath']").val();
	var pCode = $(o).closest('tr').children('td:eq(1)').text();
	var pName = $(o).closest('tr').children('td:eq(4)').text();
	var marketPrice = $(o).closest('tr').children('td:eq(5)').text();
	var params = '<c:out value="${params}"/>';
	if(params){
		//传参的顺序一定要一致
		var paramArray = params.split(",");
		if(paramArray[0])
			$("#"+paramArray[0],window.parent.document).val(productId);
		if(paramArray[1])
			$("#"+paramArray[1],window.parent.document).val(pCode);
		if(paramArray[2])
			$("#"+paramArray[2],window.parent.document).val(pName);
		if(paramArray[3])
			$("#"+paramArray[3],window.parent.document).val(pSendType);
		if(paramArray[4])
			$("#"+paramArray[4],window.parent.document).attr("src",imagePath);
		if(paramArray[5])
			$("#"+paramArray[5],window.parent.document).val(marketPrice);
		if(paramArray[6])
			$("#"+paramArray[6],window.parent.document).val(imagePath);
		
	//关闭当前页面
	window.parent.popupProClose();
	return false; 
	}
}

//popup多选
function multiSelect(){
	var flag = true;
	var products = new Array();
	var params = '<c:out value="${params}"/>';
	var selFlag=0;
	if(params){
		//传参的顺序一定要一致
		var paramArray = params.split(",");
		selFlag=paramArray[0];
	}
	if(selFlag==1){
		setSelectProIds();
		$("#productIds",window.parent.document).val($("#productIds").val());
		$("#pro_item",window.parent.document).append("<input type='hidden' id='actProducts' name='actProducts' readonly='readonly' value='' />");
		flag=false;
		
		/* $("#pro_item",window.parent.document).empty();
		 
		$("[name='productId']").each(function(i,item){
			if(item.checked == true){
				var obj={};
				var productId = $(item).closest('tr').find("[name='productId']").val();
				var pSendType = $(item).closest('tr').find("[name='pSendType']").val();
				var pCode = $(item).closest('tr').children('td:eq(1)').text();
				var pName = $(item).closest('tr').children('td:eq(4)').text();
				var marketPrice = $(item).closest('tr').children('td:eq(5)').text();
				obj.product_id=productId;
				obj.p_send_type=pSendType;
				obj.p_code=pCode;
				obj.p_name=pName;
				obj.p_price=marketPrice;
				products.push(obj);
				$("#pro_item",window.parent.document).append(
					"<tr class='goods_tr'>"	+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='hidden' name='product_id' readonly='readonly' value='"+productId+"'/>"+
						 	"<input style='width:100%;text-align:center;' type='hidden' name='p_send_type' readonly='readonly' value='"+pSendType+"'/>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_name' readonly='readonly' value='"+pName+"'/>"+
						"</td>"+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_code' readonly='readonly' value='"+pCode+"'/>"+
						"</td>"+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_price' readonly='readonly' value='"+marketPrice+"'/>"+
						"</td>"+
					"</tr>"	
				);
				flag=false;			
			}
		});
		$("#pro_item",window.parent.document).append("<input type='hidden' id='actProducts' name='actProducts' readonly='readonly' value='' />"); */
	}
		if(selFlag==2){	
			setSelectProIds();
			$("#tradeProductIds",window.parent.document).val($("#productIds").val());
			$("#pro_item2",window.parent.document).append("<input type='hidden' id='actTradeProducts' name='actTradeProducts' readonly='readonly' value='' />");
			flag=false;
		/* $("#pro_item2",window.parent.document).empty();
		console.log($("#pro_item2",window.parent.document));
		$("[name='productId']").each(function(i,item){
			if(item.checked == true){
				var obj={};
				var productId = $(item).closest('tr').find("[name='productId']").val();
				var pSendType = $(item).closest('tr').find("[name='pSendType']").val();
				var pCode = $(item).closest('tr').children('td:eq(1)').text();
				var pName = $(item).closest('tr').children('td:eq(4)').text();
				var marketPrice = $(item).closest('tr').children('td:eq(5)').text();
				$("#pro_item2",window.parent.document).append(
					"<tr class='goods_tr'>"	+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='hidden' name='product_id' readonly='readonly' value='"+productId+"'/>"+
						 	"<input style='width:100%;text-align:center;' type='hidden' name='p_send_type' readonly='readonly' value='"+pSendType+"'/>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_name' readonly='readonly' value='"+pName+"'/>"+
						"</td>"+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_code' readonly='readonly' value='"+pCode+"'/>"+
						"</td>"+
						"<td>"+
						 	"<input style='width:100%;text-align:center;' type='text' name='p_price' readonly='readonly' value='"+marketPrice+"'/>"+
						"</td>"+
						"<td>"+
					 	"<input style='width:100%;text-align:center;' type='text' name='p_trade_price' value='' />"+
					"</td>"+
					"<td>"+
				 	"<input style='width:100%;text-align:center;' type='text' value=''  name='quantity' />"+
				"</td>"+
					"</tr>"	
				);
				flag=false;			
			}
		});
		$("#pro_item2",window.parent.document).append("<input type='hidden' id='actTradeProducts' name='actTradeProducts' readonly='readonly' value='' />"); */ 
	}
		
	if(flag){
		alert("请选择商品");
		return false;
	}
	
	
	//选择完后需要重新判断高度，用回调函数去判断。
	if(typeof window.parent.funcHeight=="function")
		window.parent.funcHeight();
	//关闭当前页面
	window.parent.popupProClose();
	return false; 
}
/**
 * 选完一级分类 选二级分类。
 */
$("#largeCatagoryId").on("change",function(){
	$("#middleCatagoryId").html("<option value=''>请选择二级分类</option>")
	 $.ajax({
		cache:false,
		type:"POST",
		url:"queryMidCatagoryByLargeId",
		data:{"largeId":$(this).children('option:selected').val()},
		success:function(result){
			if(result != null && result.status=='ok'){
				var middleCatagoryList = result.middleCatagoryList;
				if(middleCatagoryList.length > 0){
				$.each(middleCatagoryList,function(i,item){
					var _temp=$("<option>");
					var _id=item.id;
					var _name=item.name;
					_temp.attr("value",_id).text(_name);
					$("#middleCatagoryId").append(_temp);
				});
				//$("#middleCatagoryId").show();
				}else{
					//$("#middleCatagoryId").hide();
				}
			}
		}, 
		error:function(result){
			alert("请求错误");
		}
	});
}); 
$("#largeCatagoryId").val(<c:out value="${query.largeCatagoryId}"/>);
$("#middleCatagoryId").val(<c:out value="${query.middleCatagoryId}"/>);
</script>