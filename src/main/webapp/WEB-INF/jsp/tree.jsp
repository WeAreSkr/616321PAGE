<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>welcome</title>
    <script src="js/jquery.min.js"></script>
    <link  rel="stylesheet" href="/css/welcome.css">
    <script src="/js/jquery.waypoints.min.js"></script>

</head>
<body style="background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
<header class="site-header">
    <div class="wrapper">
        <h1 class="site-header__title">616321</h1>
    </div>
</header>
<div style="float:right;">
<c:if test="${user!=null}">

    <p>${user.nickname}</p>
    <img width="100px" height="100px" src="img/head/${user.headImg}">

</c:if>
<c:if test="${user==null}">
    <a href="/login">登录</a>
</c:if>
</div>
<section class="timeline">
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

