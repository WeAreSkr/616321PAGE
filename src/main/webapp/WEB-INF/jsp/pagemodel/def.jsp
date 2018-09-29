<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${tmpuser.name}的主页</title>
</head>
<label>QQ:</label>${page.qq}<br/>

<label>电话:</label>${page.phone}<br/>
<label>格言:</label>${page.desc}<br/>
<label>性别:</label>${page.sex}<br>
<!-- 自定义的页面-->
<div id="mypage">
${htmlex}
</div>
<form action="/comment" method="post">
    <input type="hidden" name="pageid" value="${page.pageId}">
    <table>
        <h3 style="position: center">留言栏</h3>
        <textarea name="msg" id="" cols="30" rows="10"></textarea>
    </table>
    <%--<input type="textarea" cols="30" name="msg" rows="30"/><br>--%>
    <input type="submit" value="留言" style="width: 230px;height: 40px;background: #3b7ae3;border-radius:10px;"/>

</form>
<a href="/page">edit</a>
</body>
</html>
