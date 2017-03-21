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
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<link href="<%=path%>/dist/css/salesStyle.css" type="text/css" rel="Stylesheet" />
<style>
   td{
     border:none;
     height:30px;
     line-height:35px;
   }
.disname{
   text-align:left;
   width:20%;
}
.cbn{
   margin-top:5px;
   margin-left:-1px;
}
.cnt{
  width:30%;
}

</style>
<script type="text/javascript">
	window.onload=function(){
		
		 
		 $('#startTimeStr').datetimepicker({
				dateFormat:'yy-mm-dd',
				timeFormat: 'HH:mm:ss',
				stepHour: 1,
				stepMinute: 1,
				stepSecond: 1
			});
		
		 $('#endTimeStr').datetimepicker({
			 	dateFormat:'yy-mm-dd',
				timeFormat: 'HH:mm:ss',
				stepHour: 1,
				stepMinute: 1,
				stepSecond: 1
		});
	}


	
 
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
 
	 
		//全选功能
			function doChoose(){
				//首先要取到"全选"复选框的选中状态
				var state = document.getElementById('all').checked;
				//让所有的single复选框的状态和state保持一致
				var singles = document.getElementsByName('activity_id');
				//循环遍历每一个single
				for(var i=0;i<singles.length;i++){
					singles[i].checked = state;
				}
			}
		
			//当我们将每一个single都选中的时候,让"全选"复选框自动选中
			function chooseSingle(){
				var count = 0;
				//判断每一个single是否都选中了呢 ?
				var singles = document.getElementsByName('activity_id');
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
				var activity_ids="";
					//判断每一个single是否都选中了呢 ?
					var singles = document.getElementsByName('activity_id');
					for(var i=0;i<singles.length;i++){
						if(singles[i].checked){
							var svalue=singles[i].value;
							if(svalue){
								activity_ids=activity_ids+svalue+"-";
							}
						}
					}
					
					if(activity_ids){
						if(activity_ids.charAt(activity_ids.length-1)=="-"){
							activity_ids=activity_ids.substr(0,activity_ids.length-1);
						}
					}
					
					if(activity_ids){
						var data1=activity_ids;
						$.ajax({			
								url:"<%=path%>/promotion/onlineShopProducts",
								type:"POST",
								data: 'activity_ids='+data1+"&type="+type,
								dataType: 'text',
								success:function(data){
									console.log(data);
								},
								error:function(err){
									alert(err);
								}
							})
					}
			}
			
			function getproList(){
				var products = new Array();
				$("#pro_item tr").each(function(i,item){
						var obj={};
						var productId = $(item).closest('tr').find("[name='product_id']").val();
						var pSendType = $(item).closest('tr').find("[name='p_send_type']").val();
						var pCode = $(item).closest('tr').find("[name='p_code']").val();
						var pName = $(item).closest('tr').find("[name='p_name']").val();
						var marketPrice = $(item).closest('tr').find("[name='p_price']").val();
						obj.product_id=productId;
						obj.p_code=pCode;
						obj.p_name=pName;
						obj.p_send_type=pSendType;
						obj.p_price=marketPrice;
						products.push(obj);
				});
				if(products!=null&&products.length){
					var str=JSON.stringify(products);
					$("#actProducts").val(str);
				}else{
					$("#actProducts").val('');
				}
			}
			
			function doSubmitCheck(){
				var form = document.formain;
				var name = form.name.value;
				//var bannerFile = form.bannerFile.value;
				var startTimeStr = form.startTimeStr.value;
				var endTimeStr = form.endTimeStr.value;
				if(name==null || name==''){
			        alert("活动名称不能为空！");
			        return false;
				}
				/* if(bannerFile==null || bannerFile==''){
			        alert("活动banner图不能为空！");
			        return false;
				}  */
				if(startTimeStr==null || startTimeStr==''){
			        alert("活动开始日期不能为空！");
			        return false;
				}
				if(endTimeStr==null || endTimeStr==''){
			        alert("活动结束日期不能为空！");
			        return false;
				}
				getproList();
				form.submit();
			}

			//弹出门店窗口
			function popupProOpen1(){
				document.getElementById('fade1').style.display='block'
				document.getElementById('popupDiv1').style.display='block'
			}
			function popupProClose1(){
				document.getElementById('fade1').style.display='none'
				document.getElementById('popupDiv1').style.display='none'
			}
			
			function btnOnchange(){
				var ifAllMalls=$("input[name='ifAllMalls']:checked").val(); 
				//控制按钮为禁用：  
				if(ifAllMalls==1){
					$("#addMallBtn").hide();
					$("#mall_codes").val('');
				}
				//控制按钮为可用
				if(ifAllMalls==0){
					$("#addMallBtn").show();
				}
			}
</script>
<body>
<c:out value="${message }" />
	<div id="wrap">
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">热销推荐</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="edit?id=<c:out value='${hotsellBase.id}'/>" enctype="multipart/form-data">		
						
						<div class="editPage">
							<div class="editLeft">
								<div class="row-list">
									<label>活动名称<span style="color:red">*</span>：</label>
									<input class="td_text_w" name="name" id="name" type="text" class="left" value="${hotsellBase.name}"/>
								</div>
								<div class="row-list">
									<label>banner图片<span style="color:red">*</span>：</label>
									<div class="imgbox">
	    								<div class="imgnum">
	        								<input type="file" class="filepath" name="bannerFile" id="bannerFile" />
	       									<span class="close">×</span>
	        								<img src="${hotsellBase.bannerPath}" class="img1" />
	        								<img src="" class="img2" />
	    								</div>
									</div>
								</div>
								<div class="row-list">
									<label>活动时间<span style="color:red">*</span>：</label>
									<input style="width:30%;" type="text" name="startTimeStr" id="startTimeStr" value="<fmt:formatDate value="${hotsellBase.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" class="datatime-input"/>
									<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
									<input style="width:30%;" type="text" name="endTimeStr" id="endTimeStr" value="<fmt:formatDate value="${hotsellBase.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" class="datatime-input"/>
								</div>
							</div>
							<div class="line"></div>
							<div class="editRight">
								<div class="row-list">
								
								</div>
							</div>
						</div>
						
							<div class="height" style="display: none;">
								商品筛选器；
								</span>
							</div>
							<hr>
							<div class="section_table">
							<table cellspacing="none">
								
							<span>
							<input type="hidden" class="td_text_w" name="productIds" id="productIds" value="<c:out value="${hotsellBase.productIds}"/>" />
							<a href="" id="popupLink" target="popupWin" onclick="setProductIds();popupProOpen();"><span style="display:inline-block;margin:6px 0px 0px 0px ;" class="back_dblue btn compa"><i class="icon-btn icon-add"></i>添加商品</span></a>
							</span>
						<thead style="background:#EBEBEB;">
							<th>商品名称</th>
							<th>商品条形码</th>
							<th>商品价格</th>
						</thead>
						<tbody id="pro_item">
						<c:forEach var="actProducts" items="${hotsellBase.actProductsArray}" varStatus="status">
						 	<tr class="goods_tr">
								<td class="delbox">
								 	<input style="width:100%" type="hidden" name="product_id" readonly="readonly" value="${actProducts.productId}"/>
								 	<input style="width:100%" type="hidden" name="p_send_type" readonly="readonly" value="${actProducts.pSendType}"/>
								 	<input style="width:100%;" type="text" name="p_name" readonly="readonly" value="${actProducts.pName}"/>
								</td>
								<td class="delbox">
								 	<input style="width:100%" type="text" name="p_code" readonly="readonly" value="${actProducts.pCode}"/>
								</td>
								<td class="delbox">
								 	<input style="width:100%;" type="text" name="p_price" readonly="readonly" value="${actProducts.pPrice}"/>
								</td>
							</tr>
							</c:forEach>
						</tbody>
						</table>
						</div>
						</form>
						</div>						
				</section>
				<div class="bgbtn">
				    <span ><button type="button" onclick="doSubmitCheck();" value="" class="left back_dblue col_white btn">保存</button></span>
	                <span  class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>	
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose();">×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	
   		<!-- 弹出门店选择框 -->
	<div id="fade1" class="black_overlay">  
    </div>
    <div id="popupDiv1" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose1();">×</span>  
		<iframe style="position: absolute; width: 98%; height: 98%; border-radius: 3px;" id="popupWin1" name="popupWin1" frameborder="0">
		</iframe>
   	</div>
	</div>
	</body>
<script type="text/javascript">
		var browser=navigator.appName
		var b_version=navigator.appVersion
		var version=b_version.split(";");
		var trim_Version=version[1].replace(/[ ]/g,""); 
		 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
		  $(".compa").css("margin","0px 0px 6px 3px")
		}
		 
		 function setProductIds(){
			 var checkedProductId = $("#productIds").val();
			 var action = "<%=basePath%>/product/selectPopup?popupFlg=2&params=1&productIds="+checkedProductId;
			 $("#popupLink").attr("href",action);
		}
		 
		 //选择完以后重新判断高度。
		 function funcHeight(){
			 var tempHeight = $("#wrap").height()
			 if(tempHeight>window.parent.$("#target").height()){
				 window.parent.$("#target").css("height",tempHeight);
				 window.parent.$(".cont_aside").css("height",tempHeight+70);
			 }
		}
</script>
</html>
