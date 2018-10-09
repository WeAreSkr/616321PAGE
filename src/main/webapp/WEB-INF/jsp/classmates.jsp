<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>

<head>
    <title>同学录</title>
    <jsp:include page="head.jsp"></jsp:include>
    <style>
        .block {
            border-radius: 10px;
            background-color: #b2dba1;
            border-bottom: 3px solid #888888;
            border-right: 3px solid #888888;
            border-top: 3px solid #00ff00;
            border-left: 3px solid #00ff00;
            margin: 10px;
            padding-top:10px;
            padding-bottom: 10px;
            padding-right: 30px;
            padding-left: 10px;
        }
        .block__{

            border-radius: 10px;
            background-color: #b2dba1;
           border: #8f5536 solid 3px;

            margin: 10px;
            padding-top:10px;
            padding-bottom: 10px;
            padding-right: 30px;
            padding-left: 10px;
        }
        .block:hover{
            border-bottom: 3px solid #00ff00;
            border-right: 3px solid  #00ff00;
            border-top: 3px solid#008800;
            border-left: 3px solid #008800;
        }

        .important {
            background-color: #8f5536;

        }
        .right{
            position: absolute;
            left: 130px;
            height: 100px;
            overflow: hidden;

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
    <div  class="<c:if test="${classmate.pwd == null}">block__</c:if> <c:if test="${classmate.pwd != null}">block</c:if> <c:if test="${classmate.authority==100}">important</c:if>">
        <div class="right">
        <label>${classmate.name}
            <c:if test="${classmate.authority == 1}">(班长）</c:if>
            <c:if test="${classmate.authority == 2}">(学习委员）</c:if>
            <c:if test="${classmate.authority == 3}">(团支书）</c:if>
            <c:if test="${classmate.authority == 4}">(文娱委员）</c:if>
            <c:if test="${classmate.authority == 5}">(心理委员）</c:if>
            <c:if test="${classmate.authority == 6}">(信息委员）</c:if>
            <c:if test="${classmate.authority == 7}">(宣传委员）</c:if>
            <c:if test="${classmate.authority == 8}">(生活委员）</c:if>
            <c:if test="${classmate.authority == 9}">(纪检委员）</c:if>
            <c:if test="${classmate.authority == 10}">(组织委员）</c:if>
            <c:if test="${classmate.authority == 100}">(辅导员）</c:if>
        </label><br/>
                <label style="color: #6A6A6A;">
                ${classmate.dsc}
                </label>
        </div>

        <div >
            <img class="left head_img" alt="图片不见了" src="/img/head/${classmate.headImg}.jpg" >
        </div>

    </div>
    </a>
</c:forEach>
</body>
</html>
