<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<c:forEach items="${events }" var = "event"  varStatus="statu">
    title:<h3>${event.title}</h3>
    content:<h3>${event.content}</h3>
</c:forEach>
</body>
</html>

