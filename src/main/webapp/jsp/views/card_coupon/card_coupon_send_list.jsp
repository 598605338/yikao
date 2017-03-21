<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
		<div id="wrap">
				<!-- <header class="cont_section_header">发放卡券</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">卡券</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">卡券管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">发放卡券</span>
				</header>
				<div>
				<label>选择会员发放</label>&nbsp;&nbsp;
				<label>卡劵总数:</label><c:out value="${cardCoupon.totalNum }" />&nbsp;&nbsp;
				<label>已领取总数:</label><c:out value="${cardCoupon.getnum }" />&nbsp;&nbsp;
				<label>可在发放总数:</label><c:out value="${cardCoupon.totalNum - cardCoupon.getnum}" />&nbsp;&nbsp;
				</div>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
					
					
					<div class="cont_section_head">
						<form name="form" id="formSubmit" action="toSendCardCoupon" method="post">
							<div class="row">
								<input type="hidden" name="cardId" id="cardId" value="${cardId }" />
								<input type="text" placeholder="会员卡号" name="userId" id="userId" value="<c:out value="${userId }"/>" class="left" />
								<input type="text" placeholder="会员手机号" name="phone" id="custname" value="<c:out value="${phone }"/>" class="left" />
							</div>
							<div class="col-click">
								<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button type="button" class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>		
					</div>		
					
							
						<div class="section_table">
					<!-- <form name="sendForm" action="sendCardCoupon" method="post"> -->
						<table id="tableList" cellspacing="none">
						<thead>
							<th>会员名</th>
							<th>会员卡号</th>
							<th>本次发放数量</th>
							<th>已发放数量</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${selectCustSendCardCouponList }" varStatus="status">
							<tr class="goods_tr" >
								<td><c:out value="${item.custname }" /></td>
								<td><c:out value="${item.userId }" /></td>
								<td><input type="text" value="1" name="sendNum" /></td>
								<td><c:out value="${item.alreadySendNum }" /></td>
								<td>
									<a href="javascript:void(0)" onclick="removeMember(this);">移除</a>&nbsp;&nbsp;
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
					<!-- </form> -->
					</div>
					</div>					
				</section>
				<div class="bgbtn">
					<!-- <input type="button" class="left back_dblue col_white btn" onclick="send()" value="发放" /> -->
					<button type="button" class="left back_dblue col_white btn" onclick="send()"><i class="icon-btn icon-shelves"></i>发放</button>
				</div>
			<hr style="clear:both;"/>
			<header class="cont_section_header">导入会员发放</header>
			<section class="cont_section_section">					
				<div class="goodsManage">
					<form action="" id="upfile" name="upfile" method="post" enctype="multipart/form-data">
						导入:<input type="file" id="file" name="file" />
							<!-- <input type="button" onclick="import_send();" value="发放" /> -->
							<button type="button" class="left back_dblue col_white btn" onclick="import_send();"><i class="icon-btn icon-shelves"></i>发放</button>
					</form>	
				</div>
			</section>
		</div>
</body>
</html>

<script>
/*
 * 重置
 */
function resetForm(){
	$("#custname").val(null);
	$("#userId").val(null);
}

/*
 * 移除发放会员
 */
function removeMember(o){
	$(o).closest('tr').remove();
}

/*
 * 发放
 */
function send(){
	var array = new Array();
	//剩余可发放数量
	var surplusNum = "<c:out value='${cardCoupon.totalNum - cardCoupon.getnum }' />";
	//本次发放数量
	var sendNumTotal = 0;
	$("#tableList tr").each(function(i,item){
		if(i>0){
		var userId = $(this).children("td").eq(1).text();
		var sendNum = $(this).children("td").eq(2).children("input").val();
		array.push(userId+":"+sendNum);
		sendNumTotal += sendNum;
		}
	});
	//alert(array.toString());
	if(sendNumTotal > surplusNum){
		alert("本次发放数量已超过剩余可发放数量，请重新发放");
		return false;
	}
	var data = {"cardId":$("#cardId").val(),"data":array.toString(),"surplusNum":surplusNum,"sendNumTotal":sendNumTotal};
	$.ajax({
		cache:false,
		type:"POST",
		url:"sendCardCoupon",
		data:data,
		dataType:"json",
		success:function(result){
			alert(result["message"]);
		},
		error:function(r){
			alert(r["message"]);
		}
	});
}

//导入并发放
function import_send(){
	var formData = new FormData();
	var files = $('input[name="file"]').prop('files');
	if(files == null || files==''){
		alert("请选择要上传的文件");
		return false;
	}
	formData.append("file",files[0]);
	$.ajax({ 
		url : "importSendMember?cardId="+<c:out value='${cardId }' />, 
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

function submitPageForm(pageIndex){
	$("#pageIndex").val(pageIndex);
	$("[name='pageForm']").submit();
}
</script>