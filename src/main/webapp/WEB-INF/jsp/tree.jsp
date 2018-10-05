<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body style="background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
<jsp:include page="navigation.jsp"></jsp:include>
<section class="timeline">
    <div class="wrapper">
        <c:forEach items="${events}" var = "event"  varStatus="statu">

            <div class="timeline__item timeline__item--${statu.index}">
                <div class="timeline__item__station"></div>
                <div class="timeline__item__content">
                    <h2 class="timeline__item__content__date">${event.formatDt}</h2>
                    <br/>

                        <c:forEach items="${event.divPath}" var="path" >
                            <a   target="_blank"  href="/img/eventimg/${path}">
                          <img src="/img/eventimg/${path}.jpg"/>
                            </a>
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

