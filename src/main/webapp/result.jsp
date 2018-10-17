<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg.title}</title>
    <style>
        .block {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
        .err{
            border: #9D1E15 solid 2px;
        }
        .right{
            float: right;
        }
    </style>
</head>
<body>
<c:if test="${msg.code == 0}">
    <p class="block">${msg.msg}</p>
</c:if>
<c:if test="${msg.code != 0}">
    <p class="block err">${msg.msg}</p>
</c:if>
<br/>

<c:if test="${msg.redirect == null}">
    <a href="/">传送门</a>
</c:if>
<c:if test="${msg.redirect!=null}">
    <a href="${msg.redirect}">传送门</a>
</c:if>
</body>
</html>
