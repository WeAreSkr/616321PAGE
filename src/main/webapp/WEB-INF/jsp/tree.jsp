<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>welcome</title>
    <link  rel="stylesheet" href="/css/welcome.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <script src="/js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body style="background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
<header class="site-header" >
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
                    <li><a href="# ">首页</a></li>
                    <li><a href="# ">关于我们</a></li>
                    <li><a href="#">意见建议</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="/addevent">添加日志</a></li>
                   <li>
                    <c:if test="${user!=null}">
                        <p>${user.name}</p>
                        <img width="100px" height="100px" src="img/head/${user.headImg}">
                    </c:if>
                    <c:if test="${user==null}">
                        <a href="/login">登录</a>
                    </c:if>
                   </li>
                </ul>
            </div>

        </div>
    </nav>

</header>
<%--<div style="float: right;">--%>
    <%--<c:if test="${user!=null}">--%>

        <%--<p>${user.name}</p>--%>
        <%--<img width="100px" height="100px" src="img/head/${user.headImg}">--%>

    <%--</c:if>--%>
    <%--<c:if test="${user==null}">--%>
        <%--<a href="/login">登录</a>--%>
    <%--</c:if>--%>
<%--</div>--%>


<section class="timeline">
    <div class="wrapper">
        <h1 class="site-header__title">jquery Vertical Time Axis</h1>
    </div>
    <div class="wrapper">
        <c:forEach items="${events}" var = "event"  varStatus="statu">

            <div class="timeline__item timeline__item--${statu.index}">
                <div class="timeline__item__station"></div>
                <div class="timeline__item__content">
                    <h2 class="timeline__item__content__date">${event.formatDt}</h2>
                    <br/>
                    <c:forEach items="${event.divPath}" var="path" >
                      <img src="img/eventimg/${path}"/>
                    </c:forEach>
                    <p class="timeline__item__content__description">${event.title}<br/>${event.content}</p>
                </div>
            </div>
        </c:forEach>

    </div>
</section>

<script>
    function customWayPoint(className, addClassName, customOffset) {
        var waypoints = $(className).waypoint({
            handler: function(direction) {
                if (direction == "down") {
                    $(className).addClass(addClassName);
                } else {
                    $(className).removeClass(addClassName);
                }
            },
            offset: customOffset
        });
    }

    var defaultOffset = '50%';

    for (i = 0; i < ${events.size()}; i++) {
        customWayPoint('.timeline__item--' + i, 'timeline__item-bg', defaultOffset);
    }
</script>

</body>
</html>

