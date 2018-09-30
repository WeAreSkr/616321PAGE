<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>同学录</title>
    <style>
        .block {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
        .right{
            float: right;
        }
    </style>
</head>
<body>
<c:forEach items="${classmates}" var = "classmate"  varStatus="statu">
    <div class="block">
        <a href="/page?stunmb=${classmate.stuNmb}">
            <img src="/img/head/${classmate.headImg}">
            ${classmate.name}
        </a>
    </div>
</c:forEach>
</body>
</html>
