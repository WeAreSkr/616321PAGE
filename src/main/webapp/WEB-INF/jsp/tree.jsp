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
    <script src="/js/jquery.min.js"></script>
    <script src="/js/tree.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/style-1.css">
    <style>
        .dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {background-color: #f1f1f1}

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body style="background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">
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
                                <li><a href="/logout">退出登录</a></li>
                                <li class="divider"></li>
                                <li><a href="/authority/0/addevent">添加班级志</a></li>
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
<div class="ui-mask" id="mask" onselectstart="return false"></div>
<div class="ui-dialog" id="dialogMove" onselectstart='return false;'>
    <div class="ui-dialog-title" id="dialogDrag"  onselectstart="return false;" >
        登录通行证
        <a class="ui-dialog-closebutton" href="javascript:hideDialog();"></a>
    </div>
    <form class="ui-dialog-content" action="/login" method="post">
        <div class="ui-dialog-l40 ui-dialog-pt15">
            <input class="ui-dialog-input ui-dialog-input-username" type="text" placeholder="学号" name="stuNmb"/>
        </div>
        <br>
        <div class="ui-dialog-l40 ui-dialog-pt15">
            <input class="ui-dialog-input ui-dialog-input-password" type="text" placeholder="密码" name="pwd"/>
        </div>
        <br>
        <div>
            <input type="submit" class="ui-dialog-submit" value="登录">
        </div>
        <div class="ui-dialog-l40">
            <a href="/register">立即注册</a>
            <a href="#">忘记密码</a>
        </div>
    </form>
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

