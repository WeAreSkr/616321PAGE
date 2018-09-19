<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg.title}</title>
</head>
<body>
code: ${msg.code}
<br/>
msg: ${msg.msg}
<c:if test="${msg.redirect == null}">
    <a href="/">传送门</a>
</c:if>
<c:if test="${msg.redirect!=null}">
    <a href="${msg.redirect}">传送门</a>
</c:if>
</body>
</html>
