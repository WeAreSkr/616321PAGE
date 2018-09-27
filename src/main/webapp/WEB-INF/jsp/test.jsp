<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<form action="/page" method="post" >
<input type="hidden" name="pageId" value="${page.pageId}">
<label>QQ:</label><input type="text" name="qq" value="${page.qq}"><br>
<label>desc:</label><input type="text" name="desc" value="${page.desc}"><br>
<label>phone:</label><input type="text" name="phone" value="${page.phone}"><br>
<input type="submit" value="submit">
</form>
</body>
</html>

