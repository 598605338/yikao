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
<link href="<%=path%>/dist/css/salesStyle.css" type="text/css" rel="Stylesheet" />
<style>
   td{
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
/**
 * 日期插件
 * API：http://www.malot.fr/bootstrap-datetimepicker/demo.php
 */
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
				var activity_name = form.activity_name.value;
				var beginDate = form.beginDate.value;
				var endDate = form.endDate.value;
				var priority = form.priority.value;
				var if_add = form.if_add.value;
				var discount = form.discount.value;
				var ifAllMalls = form.ifAllMalls.value;
				var mall_codes = form.mall_codes.value;
				var promotion_label = form.promotion_label.value;
				if(activity_name==null || activity_name==''){
			        alert("活动名称不能为空！");
			        return false;
				}
				if(beginDate==null || beginDate==''){
			        alert("活动开始日期不能为空！");
			        return false;
				}
				if(endDate==null || endDate==''){
			        alert("活动结束日期不能为空！");
			        return false;
				}
				if(priority==null || priority==''){
			        alert("优先级不能为空！");
			        return false;
				}else{
					var reg = new RegExp("^[0-9]*$"); 
					if(!reg.test(priority)){  
				        alert("优先级请输入数字!");  
				        return false;
				    } 
				}
				if(discount==null || discount==''){
			        alert("折扣不能为空！");
			        return false;
				}else{
					var reg = new RegExp("^[0-9]*$");
					var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
					if(!(reg.test(discount)||reg1.test(discount))){  
						alert("折扣格式有误!");  
				        return false;
				    }else{
				    	if(discount>1){
				       	  alert("折扣数最大为1!");  
				       	  return false;
						}
				    } 
				}
				if(if_add==null || if_add==''){
			        alert("是否可累计不能为空！");
			        return false;
				}
				if(ifAllMalls==null || ifAllMalls==''){
			        alert("使用门店不能为空！");
			        return false;
				}else{
					if(ifAllMalls==0){
						if(mall_codes==null || mall_codes==''){
					        alert("请添加门店！");
					        return false;
						}
					}
				}
				
				if(promotion_label==null || promotion_label==''){
			        alert("促销标签不能为空！");
			        return false;
				}else{
					var reg=/^[\u2E80-\u9FFF]+$/;//Unicode编码中的汉字范围
					if(!reg.test(promotion_label)){
						alert("促销标签只能输入汉字！");
				        return false;
					};
				}
				getproList();
				document.getElementById('formain').submit();
				return true;
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
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">第二件半价</header>	 -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">第二件半价</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/promotion/insertFullMinus" >
							<!-- <header class="cont_section_tab_header">第二件半价基本信息</header>	 -->
							
							<div class="editPage">
								<div class="editLeft">
									<div class="row-list">
										<label>促销名称：</label>
										<input class="td_text_w" name="activity_name" id="activity_name" type="text" class="left" value="${query.activity_name}"/>
									</div>
									<div class="row-list">
										<label>促销日期：</label>
										<input style="width:30%" class="datatime-input" placeholder="促销时间起" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" >
										<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
										<input style="width:30%;" class="datatime-input" placeholder="促销时间止" type="text" name="endDate" id="endDate" value="${query.endDate}" >
									</div>
									<div class="row-list">
										<label>优先级：</label>
										<input class="td_text_w" name="priority" id="priority" type="text" class="left" value="${query.priority}"/>
									</div>
									<div class="row-list">
										<label>第二件折扣：</label>
										<input class="td_text_w" name="discount" id="discount" type="text" class="left" value="${query.discount}"/>
									</div>
									<div class="row-list">
										<label>是否可累计：</label>
										<input class="left" type="radio" id="if_add" value=1 name="if_add"><span style="margin-top: 2px;" class="left" />是</span>
										<input style="margin-left:20px;" class="left" type="radio" id="if_add" value=0 name="if_add" checked="checked" /><span style="margin-top: 2px;" class="left">否</span>
									</div>
									<div class="row-list">
										<label>参与门店：</label>
										<input class="left" type="radio" id="ifAllMalls" value=1 name="ifAllMalls" onchange="btnOnchange()" checked="checked" /><span style="margin-top: 2px;" class="left" >全部门店</span>
										<input style="margin-left:20px;" class="left" type="radio" id="ifAllMalls" value=0 name="ifAllMalls" onchange="btnOnchange()"><span style="margin-top: 2px;" class="left">部分门店</span>
										<input type="hidden" id="mall_codes" value="${query.mall_codes}" name="mall_codes">
									</div>
									<div class="row-list" id="addMallBtn" style="display: none;">
										<label><a href="<%=basePath%>/shop/shopwinList?pageIndex=1" target="popupWin1" onclick="popupProOpen1();"><span style="margin: 0;" class="back_dblue left btn"><i class="icon-btn icon-add"></i>添加门店</span></a></label>
										<div class="td_text_w" style="min-height: 30px; border: 1px solid #aaa;" id="mall_names"></div>
									</div>
									<div class="row-list">
										<label>促销标签：</label>
										<input class="td_text_w" type="text" id="promotion_label" value="${query.promotion_label}" name="promotion_label">
										<input type="hidden" id="status"  value=1 name="status" />
										<input type="hidden" id="activity_type" value=3 name="activity_type" />
									</div>
								</div>
								<div class="line"></div>
								<div class="editRight">
									<div class="row-list">
									
									</div>
								</div>
							</div>
								
						<!--<header class="cont_section_tab_header">商品筛选器</header>	-->
							<div class="height" style="display: none;">
								商品筛选器；
								<!-- <input type="button" value="添加商品" class="left back_dblue btn" onclick="onlineAll(1)"/> -->
							</span>
						</div>
						<hr>
							<div class="section_table">
							<table cellspacing="none">
								
							<span>
							<input type="hidden" class="td_text_w" name="productIds" id="productIds" value="<c:out value="${activityInfo.productIds}"/>" />
							<a href="" id="popupLink" target="popupWin" onclick="setProductIds();popupProOpen();"><span style="display:inline-block;margin:6px 0px 0px 0px ;" class="back_dblue btn compa"><i class="icon-btn icon-add"></i>添加商品</span></a>
							</span>
						<thead style="background:#EBEBEB;">
							<th>商品名称</th>
							<th>商品条形码</th>
							<th>商品价格</th>
						</thead>
						<tbody id="pro_item">
						</tbody>
						</table>
						</div>
						</form>
						</div>						
				</section>
				<div class="bgbtn" >
					<!-- <span ><input type="submit" value="保存" class="left back_dblue col_white btn"/></span>
					<span ><input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span>
				    <span class="right back_dblue btn" onclick="window.history.back()">返回</span> -->
				    <span ><button type="button" onclick="doSubmitCheck();" value="" class="left back_dblue col_white btn"><i class="icon-btn icon-save"></i>保存</button></span>
					<!-- <span ><button type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value=""><i class="icon-btn icon-reset"></i>重置</button></span> -->
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
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin1" name="popupWin1" frameborder="0">
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
		  $(".compa").css("margin","0px 0px 6px 5px")
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
