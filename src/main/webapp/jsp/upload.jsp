<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传图片</title>
</head>
<body>
	<form action="../advManage/uploadFile" method="post" enctype="multipart/form-data">
		上传:<input type="file" name="file" />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>