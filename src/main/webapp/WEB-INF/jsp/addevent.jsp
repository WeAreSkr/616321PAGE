<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addevent</title>
    <style>
        .error {
            color: #ff0000;
        }
        .input_text{
            border-left: solid black 2px;
            border-top: solid black 2px;
            border-radius: 5px;
        }

        .opearator {
            width: 100px;
            height: 100px;
            position: fixed;
            top: 100px;
            left: 100%;
            margin-left: -100px;
            z-index: 100;
        }

        .map_item .name{
            display: inline-block;
            width: 120px;
        }

        #baseinfo{
            position: relative;
            width: 100%
        }
        .divline{
            text-align: center;
            height: 32px;
            width: 100%;
            background-color: #1d75b3;
            line-height: 32px;
            border-bottom: inset green 2px;
        }
    </style>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navigation.jsp"></jsp:include>
<s:form action="addevent" method="post" modelAttribute="event" enctype="multipart/form-data">
<div class="map_item">
    <label class="name">
        标题:</label>
            <s:input path="title"/><s:errors path="title" cssClass="error"></s:errors>
    </div>
    <div class="map_item">
        <label class="name">
            内容:</label>
            <s:textarea  path="content" cols="20" rows="10"/><s:errors path="content" cssClass="error"></s:errors>
    </div>
    <div class="map_item">
        <label class="name">编辑：</label>
            <s:input path="editor" /><s:errors path="editor" cssClass="error"></s:errors>
    </div>
     Imgs:

                <div id="imgselect">

                </div>

                <input type="submit" value="提交"/>


    <table>
        <tr><td align="right">事件日期:  </td><td>

            <div id="box">
                <select name="year" id="sel1">
                    <option value="year">年</option>
                </select>
                <select name="month" id="sel2">
                    <option value="month">月</option>
                </select>
                <select name="day" id="sel3">
                    <option value="day">日</option>
                </select>
                <span id="result"></span>
            </div></td></tr>
    </table>
    <script src="/js/dateselector.js"></script>


</s:form>
<button onclick="addimgs()">添加图片</button>
<script>
    function  addimgs() {
        var imgselect = $("#imgselect");
        imgselect.append(" <input type=\"file\" name=\"imgs\"> <br/>");
    }
</script>

</body>
</html>
