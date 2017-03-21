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
<jsp:include page="../header.jsp" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<script type="text/javascript">
	window.onload=function(){
		 $("#online").val('<c:out value="${query.online}"/>');
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
			var mpCOdes="";
				// $("input['name=mallAndpcode']").val(); 
				//判断每一个single是否都选中了呢 ?
				var singles = document.getElementsByName('mallAndpcode');
				for(var i=0;i<singles.length;i++){
					if(singles[i].checked){
						var svalue=singles[i].value;
						if(svalue){
			//				var mpcode=svalue.split("-");
			//				var mallp={};
			//				mallp.mall_code=mpcode[0];
			//				mallp.p_code=mpcode[1];
			//				mpArray[j]=svalue;
			//				j++;
							mpCOdes=mpCOdes+svalue+"-";
						}
					}
				}
				
				if(mpCOdes){
					if(confirm("你确定要删除选中数据吗?")){
						if(mpCOdes.charAt(mpCOdes.length-1)=="-"){
							mpCOdes=mpCOdes.substr(0,mpCOdes.length-1);
						}
					}else{
						return;
					}
				}else{
					alert("请选择商品!");
					return;
				}
				
				if(mpCOdes){
					var data1=mpCOdes;
					<%-- $.ajax({			
							url:"<%=path%>/shop/delShopProducts",
							type:"POST",
							data: 'mpCOdes='+data1,
							dataType: 'text',
							success:function(data){
								console.log(data);
							},
							error:function(err){
								alert(err);
							}
						}) --%>
					window.location.href="<%=path%>/shop/delShopProducts?mpCOdes="+data1;
				}else{
					alert("未获取到门店编码!");
					return;
				}
	 }
	 
	//全选功能
		function doChoose(){
			//首先要取到"全选"复选框的选中状态
			var state = document.getElementById('all').checked;
			//让所有的single复选框的状态和state保持一致
			var singles = document.getElementsByName('mallAndpcode');
			//循环遍历每一个single
			for(var i=0;i<singles.length;i++){
				singles[i].checked = state;
			}
		}
	
		//当我们将每一个single都选中的时候,让"全选"复选框自动选中
		function chooseSingle(){
			var count = 0;
			//判断每一个single是否都选中了呢 ?
			var singles = document.getElementsByName('mallAndpcode');
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
			
				var mpCOdes="";
					//判断每一个single是否都选中了呢 ?
					var singles = document.getElementsByName('mallAndpcode');
					for(var i=0;i<singles.length;i++){
						if(singles[i].checked){
							var svalue=singles[i].value;
							if(svalue){
								mpCOdes=mpCOdes+svalue+"-";
							}
						}
					}
					
					if(mpCOdes){
						if(confirm("你确定批量操作选中数据吗?")){
							if(mpCOdes.charAt(mpCOdes.length-1)=="-"){
								mpCOdes=mpCOdes.substr(0,mpCOdes.length-1);
							}
						}else{
							return;
						}
					}else{
						alert("请选择商品");
						return;
					}
					
					if(mpCOdes){
						var data1=mpCOdes;
						<%-- $.ajax({			
								url:"<%=path%>/shop/onlineShopProducts",
								type:"POST",
								data: 'mpCOdes='+data1+"&type="+type,
								dataType: 'text',
								success:function(data){
									console.log(data);
								},
								error:function(err){
									alert(err);
								}
							}) --%>
						window.location.href="<%=path%>/shop/onlineShopProducts?mpCOdes="+data1+"&type="+type;
					}else{
						alert("未获取到门店编码！");
						return;
					}
		}
		
		function onlineOne(type,mall_code,p_code){
					if(type&&mall_code&&p_code){
						if(confirm("你确定操作选中数据吗?")){
						<%-- $.ajax({			
								url:"<%=path%>/shop/onlineShopProducts",
								type:"POST",
								data: 'mpCOdes='+data1+"&type="+type,
								dataType: 'text',
								success:function(data){
									console.log(data);
								},
								error:function(err){
									alert(err);
								}
							}) --%>
							window.location.href="<%=path%>/shop/onlineShopOneProducts?mall_code="+mall_code+"&p_code="+p_code+"&type="+type;
						}else{
							return;
						}
					}else{
						alert("数据有问题");
						return;
					}
		}
		
		function downloadFile(){
			if(confirm("你确定下载模板吗?")){
				window.location.href="<%=path%>/shop/leadOutProTemp";
			}
		}
		
		function leadOutFile(){
				 var mall_name=$("#mall_name").val();
				 var mall_code=$("#mall_code").val();
				 var p_code=$("#p_code").val();
				 var p_name=$("#name").val();
				 var status=$("#status").val();
				 var urlparm="?mall_name="+mall_name+"&mall_code="+mall_code+"&p_code="+p_code+"&p_name="+p_name+"&status="+status;
				if(mall_code){
					var reg = new RegExp("^[0-9]*$");
					if(reg.test(mall_code)){
						if(confirm("你确定导出数据吗?")){
				 			window.location.href="<%=path%>/shop/leadOutProducts"+urlparm;
						}
					}else{
						alert("门店编号格式不对!");
						return;
					}
				}else{
					alert("由于数据太多，必须输入门店编号再导出!");
					return;
				}
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
<c:out value="${message }" />
<div id="wrap">
				<!-- <header class="cont_section_header">管理门店商品</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">门店</a><span>&gt;</span>
					<span style="color:#3bb3e0;">管理门店商品</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/shop/queryShopProducts">
							<div class="row">
								<input name="mall_name" placeholder="门店名称" id="mall_name" type="text" class="left" value="${query.mall_name}"/>
								<input name="mall_code" placeholder="门店编号" id="mall_code" type="text" class="left" value="${query.mall_code}"/>
								<input name="p_code" placeholder="商品编码" id="p_code" type="text" class="left" value="${query.p_code}"/>
								<select name="online" id="online" class="left">
									<option value="">商品状态</option>
									<option value="1">上架</option>
									<option value="0">下架</option>
								</select>
								<input name="name" placeholder="商品名称" id="name" type="text" class="left" value="${query.name}"/>
								<input type="hidden" id="pageIndex" name="pageIndex" value=${query.pageIndex}>
							</div>
							<div class="col-click">
								<button type="button" onclick="document.getElementById('formain').submit();" class="left back_dblue btn"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>
						</div>						
						<div class="section_table">
							<table class="table_hover" cellspacing="none"">
						<div class="click">
							<a href="javascript:void(0)"><span class="left back_dblue btn btn_import"><i class="icon-btn icon-add"></i>批量新增门店商品</span></a>
							<a href="javascript:void(0)"><span class="left back_dblue btn btn_import2"><i class="icon-btn icon-setting"></i>批量设置门店商品信息</span></a>
							<span class="left back_dblue btn" onclick="leadOutFile()"><i class="icon-btn icon-export"></i>批量导出门店商品</span>
							<span class="left back_dblue btn"  onclick="delAll()"><i class="icon-btn icon-delete"></i>批量删除</span>
							<span ><button class="left back_dblue btn" onclick="onlineAll('1')"><i class="icon-btn icon-shelves"></i>批量上架</button><button class="left back_dblue btn" onclick="onlineAll('2')"><i class="icon-btn icon-offshelf"></i>批量下架</button></span>
							<span class="right">共${query.totalNums}条商品数据&nbsp;</span>
						</div>
						<thead style="background:#EBEBEB">
							<th><input style="margin-left:25%;" type="checkbox" name="all" id="all" onclick="doChoose()" /></th>
							<th>门店编号</th>
							<th>门店名称</th>
							<th>商品名称</th>
							<th>商品条形码</th>
							<th>商品图片</th>
							<th>市场价格</th>
							<th>销售价格</th>
							<th>库存</th>
							<th>安全库存</th>
							<!-- <th >商品状态</th> -->
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="product" items="${shopProducts}" varStatus="status">
							<tr class="goods_tr" >
								<td><input  style="margin-left:25%;" type="checkbox" name="mallAndpcode" id="mallAndpcode" value="${product.mall_code}@${product.p_code}" onclick="chooseSingle()"></td>
								<td>${product.mall_code}</td>
								<td>${product.mall_name}</td>
								<td>${product.name}</td>
								<td>${product.p_code}</td>
								<td><img style="width:45px;" src="${product.image_path}"/></td>
								<td>${product.market_price}</td>
								<td>${product.sale_price}</td>
								<td>${product.quantity}</td>
								<td>${product.safe_quantity}</td>
								<%-- <td style="color:#2285C5;">
									<c:choose>  
  										<c:when test="${product.online==1}">
  											上架
   										</c:when>  
									    <c:otherwise>
											  下架
									    </c:otherwise>  
									</c:choose>
								</td> --%>
								<td style="color:#2285C5;">
									<c:choose>  
  										<c:when test="${product.online==1}">
  											<a href="#" class="mr10" onclick="onlineOne('2',${product.mall_code},${product.p_code})"><i class="icon-op icon-op-offShelf"></i>下架</a>
   										</c:when>  
									    <c:otherwise>
											<a href="#" class="mr10" onclick="onlineOne('1',${product.mall_code},${product.p_code})"><i class="icon-op icon-op-shelves"></i>上架</a>
									    </c:otherwise>  
									</c:choose>
								</td>
						   </tr>
						</c:forEach>
						</tbody>
					</table>
				</div>		
				</section>
				<footer class="cont_section_footer">
					<div id="div_pager"></div>
				</footer>
			</section>
			
		<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 --> 		
		<div class="div_hid" id="spm" style="display: none;"></div>		
		<!-- 弹出导入页面 -->				
			<div class="div_alert spms">
				<header class="div_alert_top">批量新增门店商品</header>
					<section class="div_alert_mid">
				 <form action="" id="upfile" name="upfile" method="post" enctype="multipart/form-data">
						<input type="file"  class="btn_file left"  name="file" />
						<a href="javascript:void()" onclick="importProduct();"><span class="btn left btn_post" style="margin-left:11%;">上传文件</span></a>
						<a href="javascript:void()" onclick="downloadFile()"><span class="btn left btn_load" style="margin-left:11%;">下载模板</span></a>
				</form>	
					</section>
				<footer class="div_alert_bot">
					<a href="javascript:void()" onclick="closePopup();"><span class="btn btn_alertClose">关闭</span></a>
				</footer>
				<a href="javascript:void()" onclick="closePopup();"><span class="close" style="color:#FFFFFF">×</span></a>
		</div>
		
		<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 --> 		
		<div class="div_hid" id="spm2" style="display: none;"></div>		
		<!-- 弹出导入页面 -->				
			<div class="div_alert spms2">
				<header class="div_alert_top">批量设置门店商品信息</header>
					<section class="div_alert_mid">
				 <form action="" id="upfile" name="upfile" method="post" enctype="multipart/form-data">
						<input type="file"  class="btn_file left"  name="file01" />
						<a href="javascript:void()" onclick="importProduct2();"><span class="btn left btn_post">上传文件</span></a>
				</form>	
					</section>
				<footer class="div_alert_bot" style="background:#FFFFFF;">
					<a href="javascript:void()" onclick="closePopup2();"><span class="btn btn_alertClose">关闭</span></a>
				</footer>
				<a href="javascript:void()" onclick="closePopup2();"><span class="close" style="color:#FFFFFF">×</span></a>
		</div>
		</div>
	</body>
	<script type="text/javascript">
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
		hrefFormer : 'shop/queryShopProducts',
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
		
		
		//设置默认选中
		$(".btn_import").on("click",function(){
			var target=$("#spm");
			var _div=$(".spms");
			target.css({"display":"block"}); 
			_div.css({"display":"block"});
			return false; 
		});
		
		function popupImport(){
			var target=$("#spm");
			var _div=$(".spms");
			target.css({"display":"block"}); 
			_div.css({"display":"block"});
			return false; 
		}
		function closePopup(){
			var target=$("#spm");
			var _div=$(".spms");
			target.css({"display":"none"}); 
			_div.css({"display":"none"});
			return false; 
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
					url : "../shop/leadInProducts", 
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
						var msg=result.message;
						var status=result.status;
						if(status=="ok"){
							var nums=result.nums;
							alert("成功导入"+nums+"条数据");
						}else{
							alert(msg);
						}
					}, 
					error : function(r) { 
						alert("上传失败!");        
					} 
					});
		}
		
		
		//设置默认选中
		$(".btn_import2").on("click",function(){
			var target=$("#spm2");
			var _div=$(".spms2");
			target.css({"display":"block"}); 
			_div.css({"display":"block"});
			return false; 
		});
		
		function popupImport2(){
			var target=$("#spm2");
			var _div=$(".spms2");
			target.css({"display":"block"}); 
			_div.css({"display":"block"});
			return false; 
		}
		function closePopup2(){
			var target=$("#spm2");
			var _div=$(".spms2");
			target.css({"display":"none"}); 
			_div.css({"display":"none"});
			return false; 
		}
		
		/*
		 * 导入
		 */
		function importProduct2(){
				var formData = new FormData();
				var files = $('input[name="file01"]').prop('files');
				if(files == null){
					alert("请先选择上传文件");
					return false;
				}
				formData.append("file",files[0]);
				$.ajax({ 
					url : "../shop/updateBatchProducts", 
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
						var msg=result.message;
						var status=result.status;
						if(status=="ok"){
							var nums=result.nums;
							alert("成功导入"+nums+"条数据");
						}else{
							alert(msg);
						}
					}, 
					error : function(r) { 
						alert("上传失败!");        
					} 
					});
		}
	</script>
	<script type="text/javascript"> 
var browser=navigator.appName 
var b_version=navigator.appVersion 
var version=b_version.split(";"); 
var trim_Version=version[1].replace(/[ ]/g,""); 
if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE6.0") { 
//alert("IE 6.0"); 
} 
else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE7.0") { 
//alert("IE 7.0"); 
} 
else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE8.0") { 
//alert("IE 8.0"); 
} 
else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") { 
	$(".height").css("margin-left","6%");
//alert("IE 9.0"); 
} 
</script>
</html>
