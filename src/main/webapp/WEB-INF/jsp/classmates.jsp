<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>同学录</title>
    <jsp:include page="head.jsp"></jsp:include>
    <style>
        .block {
            color: #000;
            border-radius: 10px;
            background-color: #b2dba1;
            border-bottom: 3px solid #008800;
            border-right: 3px solid #008800;
            border-top: 3px solid #00ff00;
            border-left: 3px solid #00ff00;

            margin: 10px;
            padding: 10px;

        }
        .right{
            position: absolute;
            left: 130px;
            line-height: 50px;
            height: 100px;

        }
        .left{
            width:100px;
            height:100px;
        }
        .head_img{
            border-radius: 50%;

        }
    </style>
</head>
<body>
<jsp:include page="navigation.jsp"></jsp:include>
<c:forEach items="${classmates}" var = "classmate"  varStatus="statu">
    <a  target="_blank"  style="display: block" href="/page?stunmb=${classmate.stuNmb}">
    <div class="block">
        <div class="right">
        <label>${classmate.name}<c:if test="${classmate.authority == 1}">(班长）</c:if></label><br/>
        ${classmate.dsc}
        </div>

        <div class="left">
            <img class="head_img" src="/img/head/${classmate.headImg}" >
        </div>

    </div>
    </a>
</c:forEach>
</body>
</html>
