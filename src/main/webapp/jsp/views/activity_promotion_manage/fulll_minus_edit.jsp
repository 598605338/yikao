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
		height:38px;
	}
	.aleft{
		width:20%;
		text-align:left;
	}
	.goods_tr{
	   height:40px;
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
				var ifaddPromotion = form.ifaddPromotion.value;
				var promotion_condition_1= form.promotion_condition_1.value;
				var promotion_condition_2= form.promotion_condition_2.value;
				var fullReduceMoney= form.fullReduceMoney.value;
				var if_useCardCoupons = form.if_useCardCoupons.value;
				var if_first_work = form.if_first_work.value;
				var if_add = form.if_add.value;
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

				if(ifaddPromotion==null || ifaddPromotion==''){
			        alert("促销条件不能为空！");
			        return false;
				}else{
					if(ifaddPromotion==1){
						if(promotion_condition_2){
							$("#promotion_condition_2").val('');
						}
						if(!promotion_condition_1){
							 alert("促销条件金额不能为空！");
						        return false;
						}else{
							var reg = new RegExp("^[0-9]*$");
							var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
							if(!(reg.test(promotion_condition_1)||reg1.test(promotion_condition_1))){
						        alert("促销条件金额格式有误!");
						        return false;
						    }
						}
					}

					if(ifaddPromotion==0){
						if(promotion_condition_1){
							$("#promotion_condition_1").val('');
						}
						if(!promotion_condition_2){
							 alert("促销条件件数不能为空！");
						        return false;
						}else{
							var reg = new RegExp("^[0-9]*$");
							if(!reg.test(promotion_condition_2)){
						        alert("件数请输入正整数!");
						        return false;
						    }
						}
					}
				}
				if(fullReduceMoney==null || fullReduceMoney==''){
			        alert("满减金额不能为空！");
			        return false;
				}else{
					var reg = new RegExp("^[0-9]*$");
					var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
					if(!(reg.test(fullReduceMoney)||reg1.test(fullReduceMoney))){
				        alert("满减金额格式有误!");
				        return false;
				    }
				}
				if(if_useCardCoupons==null || if_useCardCoupons==''){
			        alert("是否使用卡券不能为空！");
			        return false;
				}
				if(if_first_work==null || if_first_work==''){
			        alert("是否首单生效不能为空！");
			        return false;
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
<c:out value="${message }" />
	<div id="wrap">
				<!-- <header class="cont_section_header">订单满减</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">订单满减</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
				<section class="cont_section_section_border">
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/promotion/updateActivityInfo" >
							<!-- <header class="cont_section_tab_header">满减基本信息</header> -->
							
							<div class="editPage">
								<div class="editLeft">
									<div class="row-list">
										<label>促销名称：</label>
										<input  class="td_text_w" name="activity_name" id="activity_name" type="text" class="left" value="${activityInfo.activity_name}"/>
									</div>
									<div class="row-list">
										<label>促销日期：</label>
										<input style="width:30%;" class="datatime-input dbox" type="text"  name="beginDate" id="beginDate" value="${activityInfo.beginDate}" >
										<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
										<input style="width:30%;" class="datatime-input dbox" type="text"  name="endDate" id="endDate" value="${activityInfo.endDate}" >
									</div>
									<div class="row-list">
										<label>优先级：</label>
										<input class="td_text_w dbox"  name="priority" id="priority" type="text" class="left" value="${activityInfo.priority}"/>
									</div>
									<div class="row-list">
										<label>促销条件：</label>
										<input style="float:left" type="radio" id="ifaddPromotion" name="ifaddPromotion" value=1 class="left">
										<span style="float:left;margin-top:2px;" >满</span>
										<input style="width:54%;" name="promotion_condition_1" id="promotion_condition_1" type="text"  value="${activityInfo.promotion_condition_1}"/><b>元</b>
									</div>
									<div class="row-list">
										<label></label>
										<input  type="radio" id="ifaddPromotion" name="ifaddPromotion" value=0 class="left">
										<span style="float:left;margin-top:2px;" >满</span>
										<input style="width:54%;" name="promotion_condition_2" id="promotion_condition_2" type="text" value="${activityInfo.promotion_condition_2}"/><b>件</b>
									</div>
									<div class="row-list">
										<label>满减金额：</label>
										<input class="td_text_w" name="fullReduceMoney" id="fullReduceMoney" type="text" class="left" value="${activityInfo.fullReduceMoney}"/>
									</div>
								</div>
								<div class="line"></div>
								<div class="editRight">
									<div class="row-list">
										<label>是否使用卡劵：</label>
										<input class="left" type="radio" id="if_useCardCoupons" value=1 name="if_useCardCoupons"><span style="margin-top: 2px;" class="left" >是</span>
										<input style="margin-left:20px;" class="left"  type="radio" id="if_useCardCoupons" value=0  name="if_useCardCoupons"><span style="margin-top: 2px;" class="left">否</span>
									</div>
									<div class="row-list">
										<label>是否首单生效：</label>
										<input class="left" type="radio" id="if_first_work" value=1 name="if_first_work"><span style="margin-top: 2px;" class="left" >是</span>
										<input  style="margin-left:20px;" class="left"  type="radio" id="if_first_work" value=0 name="if_first_work"><span style="margin-top: 2px;" class="left">否</span>
									</div>
									<div class="row-list">
										<label>是否可累计：</label>
										<input class="left" type="radio" id="if_add" value=1 name="if_add"><span style="margin-top: 2px;" class="left" >是</span>
										<input style="margin-left:20px;" class="left" type="radio" id="if_add" value=0 name="if_add"><span style="margin-top: 2px;" class="left">否</span>
									</div>
									<div class="row-list">
										<label>参与门店：</label>
										<input class="left" type="radio" id="ifAllMalls" value=1 name="ifAllMalls" onchange="btnOnchange()"><span style="margin-top:2px;" class="left" >全部门店</span>
										<input  style="margin-left:20px;" class="left"  type="radio" id="ifAllMalls" value=0 name="ifAllMalls" onchange="btnOnchange()"><span style="margin-top: 2px;" class="left">部分门店</span>
										<input type="hidden" id="mall_codes" value="${activityInfo.mall_codes}" name="mall_codes">
									</div>
									<div id="addMallBtn" class="row-list">
										<label ><a href="<%=basePath%>/shop/shopwinList?pageIndex=1" target="popupWin1" onclick="popupProOpen1();"><span style="margin: 0;" class="back_dblue left btn"><i class="icon-btn icon-add"></i>添加门店</span></a></label>
										<div id="mall_names" class="td_text_w" style="min-height: 30px; border: 1px solid #aaa;"></div>
									</div>
									<div class="row-list">
										<label>促销标签：</label>
										<input class="td_text_w" type="text" id="promotion_label" name="promotion_label" value="${activityInfo.promotion_label}">
										<input type="hidden" name="activity_id" readonly="readonly" value="${activityInfo.activity_id}"/>
										<input type="hidden" id="activity_type"  value=1 name="activity_type" />
										<input type="hidden" id="status" value=${activityInfo.status}  name="status" />
										<input type="hidden" id="selector_goods" value="${activityInfo.selector_goods}"  name="selector_goods" />
									</div>
								</div>
							</div>
							
					<!--	<header class="cont_section_tab_header">商品筛选器</header>	-->
							<div class="height" style="display: none;">
							商品筛选器；
							<span >

							<!-- <input type="button" value="添加商品" class="left back_dblue btn" onclick="addproduct()"/> -->
						</div>
							<hr>
							<div class="section_table">
							<table cellspacing="none">
								<input type="hidden" class="td_text_w" name="productIds" id="productIds" value="<c:out value="${activityInfo.productIds}"/>" />
								<a href="" id="popupLink" target="popupWin" onclick="setProductIds();popupProOpen();"><span style="display:inline-block;margin-top:7px;" class="back_dblue btn"><i class="icon-btn icon-add"></i>添加商品</span></a>
							<thead style="background:#EBEBEB ;">
								<th>商品名称</th>
								<th>商品条形码</th>
								<th>商品价格</th>
							</thead>
							<tbody id="pro_item">
						<c:forEach var="activity" items="${activityInfo.products}" varStatus="status">
						 	<tr class="goods_tr" style="border:none">
								<td>
								 	<input style="width:100%;" type="hidden" name="product_id" readonly="readonly" value="${activity.product_id}"/>
								 	<input style="width:100%;" type="hidden" name="p_send_type" readonly="readonly" value="${activity.p_send_type}"/>
								 	<input style="width:100%;" type="text" name="p_name" readonly="readonly" value="${activity.p_name}"/>
								</td>
								<td>
							 		<input style="width:100%;" type="text" name="p_code" readonly="readonly" value="${activity.p_code}"/>
								</td>
								<td>
								 	<input style="width:100%;"  type="text" name="p_price" readonly="readonly" value="${activity.p_price}"/>
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
					<!-- <span ><input type="submit" value="保存" class="left back_dblue col_white btn"/></span>
					<span ><input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span>
					<p class="right back_dblue btn" onclick="window.history.back()">返回</p> -->
					<span ><button type="button" onclick="doSubmitCheck();" value="" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button></span>
					<span ><button type="button" class="left back_dblue btn" onclick="cleanForm()" value=""><i class="icon-btn icon-reset"></i>重置</button></span>
	                <span  class="left back_dblue btn cnt" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">
    </div>
    <div id="popupDiv" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose();" >×</span>
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>
   	</div>

   		<!-- 弹出门店选择框 -->
	<div id="fade1" class="black_overlay">
    </div>
    <div id="popupDiv1" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose1();" >×</span>
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin1" name="popupWin1" frameborder="0">
		</iframe>
   	</div>
	</div>
	</body>
<script type="text/javascript">
$("[name='if_useCardCoupons'][value=<c:out value="${activityInfo.if_useCardCoupons}"/>]").attr("checked",true);
var promotion_condition_1="${activityInfo.promotion_condition_1}";
var promotion_condition_2="${activityInfo.promotion_condition_2}";
if(promotion_condition_1){
	$("[name='ifaddPromotion'][value=1]").attr("checked",true);
}
if(promotion_condition_2){
	$("[name='ifaddPromotion'][value=0]").attr("checked",true);
}
$("[name='if_first_work'][value=<c:out value="${activityInfo.if_first_work}"/>]").attr("checked",true);
$("[name='if_add'][value=<c:out value="${activityInfo.if_add}"/>]").attr("checked",true);
var ifMallAll="${activityInfo.mall_codes}";
if(ifMallAll){
	$("[name='ifAllMalls'][value=0]").attr("checked",true);
}else{
	$("[name='ifAllMalls'][value=1]").attr("checked",true);
	$("#addMallBtn").hide();
}

/* 选择完重新选择高度 */
function funcHeight(){
	 var tempHeight = $("#wrap").height()
	 if(tempHeight>window.parent.$("#target").height()){
		 window.parent.$("#target").css("height",tempHeight);
		 window.parent.$(".cont_aside").css("height",tempHeight+70);
	 }
}

function setProductIds(){
	 var checkedProductId = $("#productIds").val();
	 var action = "<%=basePath%>/product/selectPopup?popupFlg=2&params=1&productIds="+checkedProductId;
	 $("#popupLink").attr("href",action);
}
$("#promotion_condition_1").focus(function(){
	 $(this).siblings("input[name='ifaddPromotion']").prop('checked', 'checked');
})
$("#promotion_condition_2").focus(function(){
	 $(this).siblings("input[name='ifaddPromotion']").prop('checked', 'checked');
})
</script>
</html>
