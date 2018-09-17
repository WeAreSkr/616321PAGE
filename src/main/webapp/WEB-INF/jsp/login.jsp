
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/login" method="post">
    <input type="text" name="stuNmb"/><br>
    <input type="password" name="pwd"/><br>
    <input type="submit" value="登录"/>
    <a href="/register">没有账号？点击注册</a>
    <br>
</form>
</body>
</html>
