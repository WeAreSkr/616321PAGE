<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
<style>
    .textarea-inherit {
        width: 100%;
        overflow: auto;
        word-break: break-all; //解决兼容问题
    }
</style>
    <link href="/css/makedown.css" rel="stylesheet" />
    <title>${tmpuser.name}的主页</title>
</head>
<img src="/img/head/${tmpuser.headImg}"></br>
<label>QQ:</label>${page.qq}<br/>
<label>电话:</label>${page.phone}<br/>
<label>格言:</label>${page.desc}<br/>
<label>性别:</label><c:if test="${page.sex == 1}">女</c:if><c:if test="${page.sex ==0}">男</c:if><br>
<!-- 自定义的页面-->
<div id="mypage">
${htmlex}
</div>
<h3 style="position: center">留言栏</h3>
<c:forEach items="${comments}" var="comment">
    <p><a href="/page?stunmb=${comment.classmate.stuNmb}"> ${comment.classmate.name}</a>:${comment.msg}</p>
    <c:if test="${user.stuNmb == comment.classmate.stuNmb}">
        <a href="/authority/0/delcomment?tmpStuNmb=${tmpuser.stuNmb}&commentId=${comment.commId}">删除</a>
    </c:if>
    <hr/>
</c:forEach>

<form action="/authority/0/addcomment" method="post">
    <input type="hidden" name="pageId" value="${page.pageId}">
    <input type="hidden" name="stuNmb" value="${user.stuNmb}"> <!-- 当前登录的用户 -->
    <input type="hidden" name="tmpStuNmb" value="${tmpuser.stuNmb}">
    <table>

        <textarea class="textarea-inherit" name="msg" rows="10"></textarea>
    </table>
    <input type="submit" value="留言" style="width: 230px;height: 40px;background: #3b7ae3;border-radius:10px;"/>
</form>

</body>
</html>
