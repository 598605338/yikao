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
	<section class="cont_section_section_border">
		<div class="height hit">
			<label class="left">反馈内容：</label>
			<textarea name="comment" id="comment" class="left"
				style="width: 360px; height: 100px; max-width: 360px; max-height: 100px;" readonly="readonly"><c:out value="${feedback.comment }"/></textarea>
		</div>
		<div class="emp"></div>
	</section>
	<div class="bgbtn">
		<!-- <input type="button" value="返回" class="left btn back_dblue" onclick="window.history.back()" /> -->
		<button type="button" class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>