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

	 function orderQuery(num){
		 if(!num){
			 num=0;
		 }
		 $("#querySource").val(num);
		 $('#formain').submit();
	 }

	 function exportProduct(){
			$("[name='formain']").attr("action","<%=path%>/orderQuery/leadOutPtOrder");
			$("[name='formain']").submit();
			$("[name='formain']").attr("action","pinTuanlist");
		}
	 
	 function doSubmitCheck(){
			var form = document.formain;
			var third_logistics_no = form.third_logistics_no.value;
			if(third_logistics_no==null || third_logistics_no==''){
		        alert("物流单号不能为空！");
		        return false;
			}else{
				//var reg = new RegExp("^[0-9]*$");
				//if(!(reg.test(third_logistics_no))){  
			    //    alert("物流单号有误!");  
			   //     return false;
			   // } 
			}
			document.getElementById('lgform').submit();
			return true;
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
    .div_alert{
        height: 210px;
        width: 367px;
    }
    .alert_btn .btn{
        margin-left: 0;
        padding: 0 40px;
    }
    .alert_btn{
        margin-top: 15px;
    }
    #third_logistics_no{
        margin-top: 3px;
        height: 26px;
    }
    #send_type{
        margin-top: 3px;
        width: 172px;
    }
    #lgform p{
        margin-bottom: 10px;
        overflow: hidden;
        line-height: 37px;
    }
    #lgform span{
        font-size: 15px;
        margin-right: 12px;
    }
    .mL11{
        margin-left:11px !important;
    }
</style>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">团购订单</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">订单</a><span>&gt;</span>
					<span style="color:#3bb3e0;">团购订单</span>
				</header>
				<section class="cont_section_section">
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/orderQuery/pinTuanlist">
							<div class="row">
								<input name="receive_name" placeholder="收货人" id="receive_name" type="text" class="left" value="${query.receive_name}"/>
								<input name="order_id" placeholder="订单号" id="order_id" type="text" class="left" value="${query.order_id}"/>
								<input name="receive_phone" placeholder="手机号码" id="receive_phone" type="text" class="left" value="${query.receive_phone}"/>
								<select name="pay_status" id="pay_status" class="left">
									<option value="">支付状态</option>
									<option value="0">未付款</option>
									<option value="1" selected="selected">已付款</option>
								</select>
								<select name="ptStatus" id="ptStatus" class="left">
									<option value="">组团状态</option>
									<option value="0">组团中</option>
									<option value="2">组团失败</option>
									<option value="1" selected="selected">已成团</option>
								</select>
								<select name="status" id="status" class="left">
									<option value="">订单状态</option>
									<option value="4">拼团中</option>
									<option value="0" selected="selected">待确认</option>
									<option value="1">配送中</option>
									<option value="2">已完成</option>
									<option value="3">已取消</option>
								</select>
								<input class="datatime-input" placeholder="下单时间起" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" >
								<input class="datatime-input" placeholder="下单时间止" type="text" name="endDate" id="endDate" value="${query.endDate}" >
								<input type="hidden" id="pageIndex" name="pageIndex" value=${query.pageIndex}>
								<input type="hidden" id="querySource" name="querySource" value=0>
							</div>
							<div class="col-click">
								<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>
						</div>
						<div class="section_table">
							<table class="table_hover" cellspacing="none" style="margin-top:-10px;">
						<div class="height" style="margin:7px 0px 17px -5px;">
							<!-- <span ><input type="button" value="导出" class="left back_dblue btn onbtn" onclick="exportProduct()"/></span> -->
							<span ><button type="button" class="left back_dblue btn onbtn" onclick="exportProduct()"><i class="icon-btn icon-export"></i>导出</button></span>
							<span class="right">共${query.totalNums}条订单数据&nbsp;</span>
						</div>
						<thead style="background:#EBEBEB;">
							<th>订单号</th>
							<th>团编号</th>
							<th>下单时间</th>
							<th>订单状态</th>
							<th>拼团状态</th>
							<th>订单类型</th>
							<th>参团人数</th>
							<th>商品名称</th>
							<th>收货人</th>
							<th>收货地址</th>
							<th>联系方式</th>
							<th>第三方物流名称</th>
							<th>物流单号</th>
							<th>支付方式</th>
							<th>支付时间</th>
							<th>发货时间</th>
							<th>总金额</th>
							<th>实付金额</th>
							<th>运费</th>
							<th>优惠金额</th>
							<th>积分</th>
							<th>操作</th>
						</thead>
						<tbody>
						    <c:forEach var="order" items="${orderlist}" varStatus="status">
						    <tr class="goods_tr">
								<td>
								<a href="<%=path%>/orderQuery/pinTuanDetail?&orderId=${order.order_id}">${order.order_id}</a>
								</td>
								<td>${order.teamId}</td>
								<td><fmt:formatDate value="${order.cre_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>
									<c:choose>
	  										<c:when test="${order.status==0}">
	  											待发货
	   										</c:when>
	   										<c:when test="${order.status==1}">
	  											派送中
	   										</c:when>
	   										<c:when test="${order.status==2}">
	  											已完成
	   										</c:when>
	   										<c:when test="${order.status==3}">
	  											已取消
	   										</c:when>
	   										<c:when test="${order.status==4}">
	  											进行中
	   										</c:when>
	   									</c:choose>
								</td>
								<td>
									<c:choose>
	  										<c:when test="${order.pt_status==0}">
	  											拼团中
	   										</c:when>
	   										<c:when test="${order.pt_status==1}">
	  											已成团
	   										</c:when>
	   										<c:when test="${order.pt_status==2}">
	  											拼团失败
	   										</c:when>
	   								</c:choose>
								</td>
								<td>
									<c:choose>
	  										<c:when test="${order.order_type==1}">
	  											团购订单
	   										</c:when>
	   								</c:choose>
								</td>
								<td>${order.ptp_nums}</td>
								<td>${order.p_name}</td>
								<td>${order.custname}</td>
								<td>${order.address}</td>
								<td>${order.phone}</td>
								<td>${order.third_logistics_name}
								</td>
								<td>${order.third_logistics_no}</td>
								<td>
									<c:choose>
  										<c:when test="${order.pay_type==0}">
  											微信支付
   										</c:when>
   										<c:when test="${order.pay_type==1}">
  											 钱包支付
   										</c:when>
   									</c:choose>
								</td>
								<td>
								<fmt:formatDate value="${order.pay_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
								<fmt:formatDate value="${order.send_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>${order.price}</td>
								<td>${order.real_price}</td>
								<td>${order.send_fee}</td>
								<td>${order.benefit_price}</td>
								<td>${order.add_score}</td>
								<td>
									<c:choose>
  										<c:when test="${order.status==0}">
											<a href="javascript:void(0)" onclick="openlgWin(${order.order_id});"><span class="left back_dblue btn btn_import">添加物流信息</span></a>
										</c:when>
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

		<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 -->
		<div class="div_hid" id="spm" style="display: none;"></div>
		<!-- 弹出导入页面 -->
        <div class="div_alert spms">
            <header class="div_alert_top">添加团购订单物流信息</header>
            <section class="div_alert_mid">
                 <form action="<%=path%>/orderQuery/updatePtOrder" id="lgform" name="lgform" method="post" >
                        <input type="hidden"  class="btn_file" id="ptOrderId" name="order_id" />
                        <input type="hidden"  class="btn_file" id="ptOrderId" name="status" value=1 />
                        <p><span class="left">物流单号:</span><input type="text"  class="btn_file left" id="third_logistics_no" name="third_logistics_no" /></p>
                        <p>
                            <span class="left">物流名称:</span>
			    <select style="width:171px;margin-left:0px;" name="third_logistics_name" id="third_logistics_name" class="left">
                    <option value="圆通快递"  selected = "selected">圆通快递</option>
					<option value="顺风快递">顺风快递</option>
					<option value="申通快递">申通快递</option>
					<option value="汇通快递">汇通快递</option>
					<option value="中通快递">中通快递</option>
					<option value="韵达快递">韵达快递</option>
					<option value="天天快递">天天快递</option>
					<option value="全峰快递">全峰快递</option>
					<option value="优速快递">优速快递</option>
					<option value="国通快递">国通快递</option>
					<option value="快捷快递">快捷快递</option>
               </select>
                        </p>
                    <p class="alert_btn">
                        <!-- <input type="submit"  class="left back_dblue btn btn_import"  value="提交" />
                        <input type="button"  class="left back_dblue btn btn_import mL11" onclick="closePopup();"  value="取消" /> -->
                        <button type="button" onclick="doSubmitCheck()" class="left back_dblue btn btn_import"><i class="icon-btn icon-save"></i>提交</button>
                        <button type="button" class="left back_dblue btn btn_import mL11" onclick="closePopup();"><i class="icon-btn icon-goback"></i>取消</button>
                    </p>
                </form>
            </section>
           <a href="javascript:void(0);" onclick="closePopup();"><span class="close">×</span></a >
        </div>
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
		hrefFormer : 'orderQuery/pinTuanlist',
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

	function openlgWin(orderId){
		$("#ptOrderId").val(orderId);
		var target=$("#spm");
		var _div=$(".div_alert");
		target.css({"display":"block"});
		_div.css({"display":"block"});
	};

	function closePopup(){
		var target=$("#spm");
		var _div=$(".div_alert");
		target.css({"display":"none"});
		_div.css({"display":"none"});
		$("#ptOrderId").val('');
	}
	$("#pay_status").val('<c:out value="${query.pay_status}"/>');
	$("#ptStatus").val('<c:out value="${query.ptStatus}"/>');
	$("#status").val('<c:out value="${query.status}"/>');
</script>
<script type="text/javascript">
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,"");
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
   $(".height .onbtn").css("margin","13px 0px 7px 10px")
}
</script>
</html>
