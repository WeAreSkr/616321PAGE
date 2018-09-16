<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register" method="post">
    <p>Note: 请放心设置任何密码，后台使用md加密，数据管理员是无法查看您的密码！但我无法保证连接服务器时不被人拦截掉</p>
    Name:
<select name="name">

    <c:forEach items="${names}" var="name">
        <option value="${name}">${name}</option>
    </c:forEach>
</select>
   stuNmb: <input type="text" name="stuNmb"/>
        pwd<input type="password" name="pwd"/>
        repwd<input type="password" name="rePwd"/>
    <input type="submit" value="register"/>
</form>
</body>
</html>
