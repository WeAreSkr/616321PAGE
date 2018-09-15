<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register" method="post">
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
