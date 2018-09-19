<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核班级志事件</title>
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
<form name="/authority/1/pass" method="post">
<h1>请选择通过的事件</h1>
<c:forEach items="${nopassevents}" var = "event"  varStatus="statu">
    <div class="block">

    <h2>${event.formatDt}</h2><br/>
            <c:forEach items="${event.divPath}" var="path" >
                <img src="/img/eventimg/${path}"/>
            </c:forEach>
            <br/>
            标题：${event.title}<br/>
            内容：${event.content}<br/>
            编辑：${event.editor}<br/>
            提交： ${event.stuNmb}
    <input class="right" type="checkbox" name="code" value="${event.code}"></div>
    </div>
</c:forEach>
    <input class="right" type="submit" value="确定" >
</form>
</body>
</html>
