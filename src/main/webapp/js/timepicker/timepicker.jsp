<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8" />
<title></title>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1 + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath1 %>js/timepicker/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath1 %>js/timepicker/jquery-ui-timepicker-addon.css" />
<!--<script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>-->
<script type="text/javascript" src="<%=basePath1 %>js/timepicker/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath1 %>js/timepicker/jquery-ui-sliderAccess.js"></script>
<script type="text/javascript" src="<%=basePath1 %>js/timepicker/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="<%=basePath1 %>js/timepicker/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript" src="<%=basePath1 %>js/timepicker/jquery.ui.datepicker-zh-CN.js.js"></script>
<style type="text/css">
/*修改空间的大小,如果不加上这句可能会导致控件过大，不够美观*/
.ui-corner-all{
	font-size:12px;
}
/* .cont_section_head .datatime-input{
	display:inline-block !important; 
	height:30px;width:43%;
} */
</style>
</head>
