<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
第二种解析上传文件的方法<hr/>

	<form action="parserUploadFile2" method="post"  enctype="multipart/form-data">
		<input type="file" name="file" /> 
		<input type="submit" value="上传" />
	</form>
</body>
</html>