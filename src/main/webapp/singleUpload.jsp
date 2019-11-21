<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单文件 上传</title>
</head>
<body>
    <div style="margin: 0 auto;margin-top: 100px;">
        <form action="upload/uploadFile" method="post" enctype="multipart/form-data">
            <p>
                <span>文件:</span>
                <input type="file" name="file">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</body>
</html>