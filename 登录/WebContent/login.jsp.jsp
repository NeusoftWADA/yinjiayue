<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<from action="LoginServlet" method="post">
<h3>登录</h3>
账号:<input name="userName" type="text"><br>
密码:<input name="password" type="password"><br>
<input type="submit" value="提交">

</from>

</body>
</html>