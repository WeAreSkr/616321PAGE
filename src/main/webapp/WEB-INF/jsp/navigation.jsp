<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-default " role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/tree">616321</a>
        </div>
        <!-- menu section -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/tree ">班级志</a></li>
                <li><a href="/photo">班级相册</a></li>
                <li><a href="/classmates">同学录</a></li>
                <li class="dropdown">
                    <c:if test="${user!=null}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img style="width: 20px;height: 20px; border-radius: 50px; overflow: hidden;"  src="/img/head/${user.headImg}">${user.name}
                            <b class="caret" ></b>
                        </a>
                        <ul class="dropdown-menu" style="width:100px;">
                            <li><a  target="_blank" href="/page?stunmb=${user.stuNmb}">我的主页</a></li>
                            <li><a href="/page">编辑主页</a></li>
                            <li><a href="/authority/0/addevent">添加班级志</a></li>
                            <c:if test="${user.authority == 1}">
                                <li><a href="/authority/1/addimgs"> 上传相片至班级照片</a> </li>
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
            <input class="ui-dialog-input ui-dialog-input-password" type="password" placeholder="密码" name="pwd"/>
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
