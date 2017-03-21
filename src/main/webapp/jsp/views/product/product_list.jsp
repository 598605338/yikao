<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<%=path%>/js/divPage/dividePage.css" type="text/css"
	rel="Stylesheet" />
<link href="<%=path%>/js/divPage/productStyle.css" type="text/css"
	rel="Stylesheet" />
<jsp:include page="../header.jsp" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<style>
a:link {
	color: #2285C5;
}

a:hover {
	color: #3BB3E0;
}

a:active {
	color: #19699D;
}

</style>
<body>
	<c:out value="${message }" />
	<div id="wrap">
		<c:if test="${popupFlg == 1 }">
			<header class="cont_section_header"> <span
				class="cont_section_header_1">商品管理</span> <i
				class="cont_section_header_2"></i> <i class="cont_section_header_3"></i>
			<i class="cont_section_header_4"></i></header>
		</c:if>
		<c:if test="${popupFlg != 1 }">
			<header class="cont_section_header_bread"> <i class="icon-op icon-op-address" style="margin-right: 5px;"></i>当前位置：
			<a href="javascript:void(0);" class="topNavClick"
				style="color: #323232;">商品</a> <span>&gt;</span> <span
				style="color: #3bb3e0;">商品管理</span> </header>
		</c:if>
		<section class="cont_section_section">
		<div class="goodsManage">
			<div class="cont_section_head">
				<form name="form" id="formSearch"
					action="select?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>"
					method="post">
					<div class="row">
						<input type="text" class="td_text_w" name="pCode"
							id="pCode" placeholder="商品编码"
							value="<c:out value="${query.pCode}"/>" /> <input class="col-1"
							type="text" class="td_text_w" name="name" id="name"
							placeholder="商品名称" value="<c:out value="${query.name}"/>" />
						<select name="pSendType" id="pSendType">
							<option value="">商品类型</option>
							<option value="0">门店商品</option>
							<option value="1">非门店商品</option>
						</select>
						<select name="largeCatagoryId" id="largeCatagoryId">
							<option value="">商品大分类</option>
							<c:forEach items="${largeCatagoryList }" var="item"
								varStatus="status">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
						<select name="middleCatagoryId" id="middleCatagoryId">
							<option value="">商品中分类</option>
							<c:forEach items="${middleCatagoryList }" var="item"
								varStatus="status">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-click">
						<button type="button" class="left back_dblue col_white btn"
							onclick="document.getElementById('formSearch').submit();">
							<i class="icon-btn icon-search"></i>查询
						</button>
						<button type="button" class="left back_dblue col_white btn"
							onClick="resetForm();">
							<i class="icon-btn icon-reset"></i>重置
						</button>
					</div>
				</form>
			</div>

			<div class="section_table">
				<table cellspacing="none" class="table_hover">
					<div class="click">
						<c:if test="${popupFlg != 1 && popupFlg != 2}">
							<span class="left back_dblue btn"
								onclick="javascript:location.href='toPcode'"><i
								class="icon-btn icon-add"></i>新增商品</span>
							<span class="left back_dblue btn" onclick="deleteProduct();"><i
								class="icon-btn icon-delete"></i>删除</span>
							<span class="left back_dblue btn btn_import"><i
								class="icon-btn icon-import"></i>导入</span>
							<span class="left back_dblue btn" onclick="exportProduct();"><i
								class="icon-btn icon-export"></i>导出</span>
						</c:if>
						<c:if test="${popupFlg == 2}">
							<a href="javascript:void(0)" onclick="multiSelect();"><span
								class="left back_dblue btn"><i
									class="icon-btn icon-enable"></i>选择</span></a>
						</c:if>
					</div>
					<thead class="baColor">
						<c:if test="${popupFlg != 1 }">
							<th><input style="margin-left: 20%;" type="checkbox"
								name="selAll" onclick="selAll(this);" /></th>
						</c:if>
						<c:if test="${popupFlg == 1 }">
							<th>操作</th>
						</c:if>
						<th>商品编码</th>
						<th>创建时间</th>
						<th>商品类型</th>
						<c:if test="${popupFlg != 1 && popupFlg != 2}">
							<th>商品图片</th>
						</c:if>
						<th>商品名称</th>
						<th>价格</th>
						<th>一级分类</th>
						<th>二级分类</th>
						<c:if test="${popupFlg != 1 && popupFlg != 2}">
							<th>操作</th>
						</c:if>
					</thead>
					<tbody>
						<c:forEach var="item" items="${productList }" varStatus="status">
							<tr class="goods_tr">
								<c:if test="${popupFlg != 1 }">
									<td style="width: 2.5%;"><input style="margin-left: 20%;"
										type="checkbox" name="productId"
										value="<c:out value="${item.id }" />" /></td>
								</c:if>
								<c:if test="${popupFlg == 1 }">
									<td><a href="javascript:void(0);" onclick="select(this);">选择</a>
										<input type="hidden" name="productId"
										value="<c:out value="${item.id }" />" /> <input type="hidden"
										name="imagePath" value="<c:out value="${item.imagePath }" />" />
									</td>
								</c:if>
								<td><c:out value="${item.pCode }" /></td>
								<td><fmt:formatDate value="${item.creDate }"
										pattern="yyyy/MM/dd HH:mm:ss" /></td>
								<td><c:if test="${item.pSendType == '0' }">门店商品</c:if> <c:if
										test="${item.pSendType == '1' }">非门店商品</c:if> <input
									type="hidden" name="pSendType"
									value="<c:out value="${item.pSendType }" />" /></td>
								<c:if test="${popupFlg != 1 && popupFlg != 2}">
									<td><img style="width: 45px;"
										src="<c:out value="${item.imagePath }"/>" /></td>
								</c:if>
								<td><c:out value="${item.name }" /></td>
								<td><c:out value="${item.marketPrice }" /></td>
								<td><c:out value="${item.largeCatagoryName }" /></td>
								<td><c:out value="${item.middleCatagoryName }" /></td>
								<c:if test="${popupFlg != 1 && popupFlg != 2 }">
									<td>
										<p class="add_left">
											<a class="offset" href="javascript:void(0)"
												onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />&pageIndex=<c:out value="${query.pageIndex }" />'"><i
												class="icon-op icon-op-edit"></i>修改</a>
										</p>
										<p class="add_right">
											<a class="off" href="javascript:void(0)"
												onclick="javascript:location.href='deleteProduct?productIds=<c:out value="${item.id }" />&pageIndex=<c:out value="${query.pageIndex }" />'"><i
												class="icon-op icon-op-delete"></i>删除</a>
										</p>
										<p class="add_lefta">
											<a href="javascript:void(0)"
												onclick="javascript:location.href='toUploadBannerImage?id=<c:out value="${item.id }" />&pageIndex=<c:out value="${query.pageIndex }" />'"><i
												class="icon-op icon-op-figure"></i>上传轮播图</a>
										</p>
										<p class="add_righta">
											<a href="javascript:void(0)"
												onclick="javascript:location.href='toDetail?id=<c:out value="${item.id }" />&pageIndex=<c:out value="${query.pageIndex }'" />"><i
												class="icon-op icon-op-details"></i>商品详情</a>
										</p>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
		</section>
		<footer class="cont_section_footer">
		<form name="pageForm"
			action="select?popupFlg=<c:out value="${popupFlg}"/>&params=<c:out value="${params}"/>"
			method="post">
			<input type="hidden" name="pageIndex" id="pageIndex" value="" /> <input
				type="hidden" name="pageSize" id="pageSize" value="" /> <input
				type="hidden" name="pCode" id="pCode"
				value="<c:out value="${query.pCode}"/>" /> <input type="hidden"
				name="name" id="name" value="<c:out value="${query.name}"/>" /> <input
				type="hidden" name="pSendType" id="pSendType"
				value="<c:out value="${query.pSendType}"/>" /> <input type="hidden"
				name="largeCatagoryId" id="largeCatagoryId"
				value="<c:out value="${query.largeCatagoryId}"/>" /> <input
				type="hidden" name="middleCatagoryId" id="middleCatagoryId"
				value="<c:out value="${query.middleCatagoryId}"/>" />
			<%-- <a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex-1 }" />);"><span class="left page">上一页</span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex }" />);"><span class="left page page_chose"><c:out value="${query.pageIndex }" /></span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex+1 }" />);"><span class="left page">下一页</span></a> --%>
		</form>
		<div id="div_pager"></div>
		</footer>

		<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 -->
		<div class="div_hid" id="spm" style="display: none;"></div>
		<!-- 弹出导入页面 -->
		<div class="div_alert">
			<header class="div_alert_top">导入商品</header>
			<section class="div_alert_mid">
			<form action="" id="upfile" name="upfile" method="post"
				enctype="multipart/form-data">
				<input type="file" class="btn_file left" name="file" /> <a
					href="javascript:void()" onclick="importProduct();"><span
					class="btn left btn_post">上传文件</span></a> <a href="javascript:void()"
					onclick="javascript:location.href='download'"><span
					class="btn left btn_load">下载模板</span></a>
			</form>
			</section>
			<footer class="div_alert_bot"> <a href="javascript:void()"
				onclick="closePopup();"><span class="btn btn_alertClose">关闭</span></a>
			</footer>
			<a href="javascript:void()" onclick="closePopup();"><span
				class="close">×</span></a>
		</div>
	</div>
	<!--wrap stop-->
</body>
</html>

<script>
//设置默认选中
$("#pSendType").val(<c:out value="${query.pSendType}"/>);

/**2017.2.9
 * 导入按钮。
 */
$(".btn_import").on("click",function(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"block"}); 
	_div.css({"display":"block"});
	return false;
});
/**2017.2.9
 * 翻页功能
 */
//1、总记录数数
var totalRecords = ${pnums};
//2、每页记录数
var pageSize=10;
//3、当前页
var pageNo = ${query.pageIndex}; //这里设置参数名
if (!pageNo) {
	pageNo = 1;
}

var totalPage = dividePage.getTotals(totalRecords,pageSize);
//4、生成分页控件 根据分页的形式在这里设置
dividePage.init({
	pno : pageNo,
	//总页码
	total : totalPage,
	//总数据条数
	totalRecords : totalRecords,
	//链接前部
	hrefFormer : 'select',
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
</script>

<script>
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
	});
}

/*
 * 删除
 */
function deleteProduct(){
	var productIds = new Array();
	$("[name='productId']").each(function(i,item){
		if(item.checked == true)
			productIds.push(item.value);
	});
	if(productIds.length > 0){
		document.location.href="deleteProduct?productIds=" + productIds;
	}else{
		alert("请选择需要删除的商品");
	}
}

/*
 * 导出
 */
function exportProduct(){
	$("[name='form']").attr("action","exportProduct");
	$("[name='form']").submit();
	$("[name='form']").attr("action","select");
}

/*
 * 导入
 */
function importProduct(){
	var formData = new FormData();
	var files = $('input[name="file"]').prop('files');
	if(files == null){
		alert("请先选择上传文件");
		return false;
	}
	formData.append("file",files[0]);
	$.ajax({ 
		url : "importProduct", 
		type : 'POST', 
		data : formData, 
		// 告诉jQuery不要去处理发送的数据
		processData : false, 
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend:function(){
		console.log("正在进行，请稍候");
		},
		success : function(result) { 
			alert(result["message"]);
		}, 
		error : function(r) { 
			alert(result["message"]);
		} 
	});
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}

function popupImport(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"block"}); 
	_div.css({"display":"block"});
	return false; 
}
function closePopup(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"none"}); 
	_div.css({"display":"none"});
	return false; 
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
		console.log(paramArray)
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
		$("#pro_item",window.parent.document).empty();
		 
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
		$("#pro_item",window.parent.document).append("<input type='hidden' id='actProducts' name='actProducts' readonly='readonly' value='' />");
	}
		if(selFlag==2){	
		$("#pro_item2",window.parent.document).empty();
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
		$("#pro_item2",window.parent.document).append("<input type='hidden' id='actTradeProducts' name='actTradeProducts' readonly='readonly' value='' />");
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

/* $(window).resize(function(){
	var mayNum = (Math.floor(($(".cont_section_head").width()-230) / $(".row").children().eq(0).outerWidth(true)))*$(".row").children().eq(0).outerWidth(true);
	var shiji = $(".row").children().length*$(".row").children().eq(0).outerWidth(true)
	console.log(mayNum+":"+shiji)
	mayNum < shiji ?　$(".row").css("width",mayNum+"px"):$(".row").css("width",shiji+"px");
}) */

</script>