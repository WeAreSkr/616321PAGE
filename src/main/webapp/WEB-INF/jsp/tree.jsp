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
<style type="text/css">
    .dialog p{
        display:block;
        height: 10px;
        padding: 10px;
        border: slateblue 1px solid;
    }
    .dialog {
        margin-top: -200px;
        margin-left: -400px;
        background: slateblue;
        width: 400px;
        height: 200px;
        position: fixed;
        top: 100%;
        left: 100%;
    //    visibility: hidden;
    }
    .dialog .close{
        margin-top: -10px;
        display: inline-block;
        float: right;
        background: crimson;

    }
    .dialog .tvdate{
        height: 10px;
        float: right;
    }
    .dialog * {
        margin: 0px;
    }
    .dialog p{
        height: 20px;
    }
    .dialog .tvDayTxt{
        height: 100px;
    }

</style>
<script type="text/javascript">
    window.onload= function () {

        document.getElementById("tvdate").innerHTML=Date().substr(3,12);
    }
    function closeClick() {
        var dialog = document.getElementById("dialog");
        dialog.style.visibility = "hidden";
    }
</script>
<div id="dialog" class="dialog">
    <p style="margin-top: 0px; background: olivedrab ;height: 10px"><span style="float:left;adisplay:inline-block;margin-top: -10px">每日一句</span><a class="close" onclick="closeClick()">X</a></p>
    <p class="tvDayTxt">
        ${daysentence}
    </p>
    <p style="height: 10px; color: green">距离四川专升本考试还剩: <span style="color: red;font-size: 20px">${daycount}</span> 天</p>
    <p id="tvdate" class="tvdate"></p>
    <p>访问量:${count}</p>
</div>
</body>
</html>

