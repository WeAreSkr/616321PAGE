<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="/css/input.css">
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navigation.jsp"></jsp:include>
<form action="register" method="post">
    <div class="__center" >
        <div class="map_item">
            <label class="name">名字: </label>     <select name="name">
            <c:forEach items="${names}" var="name">
                <option value="${name}">${name}</option>
            </c:forEach>
        </select>
        </div>

        <div class="map_item">
            <label class="name"> 学号:  </label>  <input  class="input_text" type="text" name="stuNmb"/></div>
        <div class="map_item">
            <label class="name">密码：</label>    <input class="input_text" type="password" name="pwd"/>  </div>
        <div class="map_item">
            <label class="name">确认密码：</label> <input class="input_text" type="password" name="rePwd"/>  </div>

    <input type="submit" value="注册"/>
    </div>
</form>
</body>
</html>
