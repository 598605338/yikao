<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客单价分布统计报表</title>
</head>
<body>
<div id="wrap">
<iframe id="reportFrame" frameborder="0" width="100%" height="1200"src="<%=path%>/ReportServer?reportlet=/linjia/sumSalesByPriceInterval.cpt"></iframe>  
</div>
</body>
</html>