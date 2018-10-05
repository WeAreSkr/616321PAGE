<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核班级志事件</title>
    <jsp:include page="../../head.jsp"></jsp:include>
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
    <jsp:include page="../../head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../head.jsp"></jsp:include>
<form name="/authority/1/pass" method="post">
<h1>请选择通过的事件</h1>
<c:forEach items="${nopassevents}" var = "event"  varStatus="statu">
    <div for="codeinput" class="block">
    <h2>${event.formatDt}</h2><br/>
            <c:forEach items="${event.divPath}" var="path" >
                <img src="/img/eventimg/${path}.jpg"/>
            </c:forEach>
            <br/>
            标题：${event.title}<br/>
            内容：${event.content}<br/>
            编辑：${event.editor}<br/>
            提交： ${event.stuNmb}
        on ${event.dt}

        <label for="cid${event.code}">删除</label><input  id="cid${event.code}"  type="checkbox" name="code" value="'code${event.code}':'-1'"/>
        <label for="dcid${event.code}">通过</label><input <c:if test="${event.ispass==1}">checked</c:if>  id="dcid${event.code}"  type="checkbox" name="code" value="'code${event.code}':'1'"/>
        <label for="pcid${event.code}">不通过</label><input <c:if test="${event.ispass==0}">checked</c:if> id="pcid${event.code}"  type="checkbox" name="code" value="'code${event.code}':'0'"/>
        <script>

                $("#cid${event.code}").click(function(){
                        $(this).attr("checked","false");
                        $("#dcid${event.code}").removeAttr('checked');
                        $("#pcid${event.code}").removeAttr('checked');

                });

                $("#dcid${event.code}").click(function(){

                        $("#cid${event.code}").removeAttr("checked");
                        $("#pcid${event.code}").removeAttr("checked");

                });
                $("#pcid${event.code}").click(function(){

                        $("#dcid${event.code}").removeAttr("checked");
                        $("#cid${event.code}").removeAttr("checked");

                });



        </script>
    </div>
</c:forEach>
    <input class="right" type="submit" value="确定" >
</form>

</body>
</html>
