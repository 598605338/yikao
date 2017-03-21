<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8" />
<title></title>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link rel="stylesheet" href="<%=basePath %>dist/css/common.css" />
<link rel="stylesheet" href="<%=basePath %>dist/css/goods.css" />
<script src="<%=basePath %>dist/js/jquery-1.11.2.js"></script>
<script src="<%=basePath %>dist/js/common.js?timestamp="+Math.random()></script>
<script src="<%=basePath %>dist/js/goods.js"></script>
</head>
