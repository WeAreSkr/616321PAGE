<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${tmpuser.name}的主页</title>
</head>
<p>
qq:<p>${page.qq}</p><br/>

电话:<p>${page.phone}</p><br/>
文章:<p>${page.desc}</p><br/>
<form action="/comment" method="post">
    <input type="hidden" name="pageid" value="${page.pageId}">
    <input type="textarea" cols="30" name="msg" rows="30"/><br>
    <input type="submit" value="留言"/>
    <br>
</form>
<a href="/page">edit</a>
</body>
</html>
