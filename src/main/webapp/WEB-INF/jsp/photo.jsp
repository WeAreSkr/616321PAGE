<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-09-22
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link  rel="stylesheet" href="/css/welcome.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">


    <link rel="stylesheet" type="text/css" href="/css/style-1.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/tree.js"></script>
</head>
<body>
<nav class="navbar navbar-default " role="navigation">
    <div class="container-fluid">
        <!--header section -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">616321</a>
        </div>
        <!-- menu section -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="# ">班级志</a></li>
                <li><a href="# ">班级相册</a></li>
                <li><a href="#">同学录</a></li>
                <li class="dropdown">
                    <c:if test="${user!=null}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img style="width: 20px;height: 20px; border-radius: 50px; overflow: hidden;"  src="img/head/${user.headImg}">${user.name}
                            <b class="caret" ></b>
                        </a>
                        <ul class="dropdown-menu" style="width:100px;">
                            <li><a href="/page?stunmb=${user.stuNmb}">我的主页</a></li>
                            <li><a href="/page">编辑主页</a></li>
                            <li><a href="/authority/0/addevent">添加班级志</a></li>
                            <li><a href="#"> 上传相片至班级照片</a> </li>
                            <c:if test="${user.authority == 1}">
                                <li class="divider"></li>
                                <li><a href="/authority/1/pass">审核班级志(班长特有哦)</a></li>
                            </c:if>
                            <li class="divider"></li>
                            <li><a href="/logout">退出登录</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${user==null}">
                        <a href="javascript:showDialog()" class="current">登录</a>
                    </c:if>
                </li>
            </ul>
        </div>

    </div>
</nav>
</body>
</html>
