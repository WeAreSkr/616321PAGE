<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addevent</title>
    <script src="/js/jquery.min.js"></script>
    <style>
        .error {
            color: #ff0000;
        }

    </style>

</head>
<body>
<s:form action="addevent" method="post" modelAttribute="event" enctype="multipart/form-data">
    <table>
        <tr>
            <td>title:</td>
            <td> <s:input path="title"/><s:errors path="title" cssClass="error"></s:errors></td>

        </tr>
        <tr>
            <td>content:</td>
            <td><s:textarea path="content" cols="20" rows="10"/><s:errors path="content" cssClass="error"></s:errors></td>
        </tr>
        <tr>
            <td>edit:</td>
            <td><s:input path="editor" /><s:errors path="editor" cssClass="error"></s:errors></td>
        </tr>
        <tr>
            <td>Imgs:</td>
            <td>

                <div id="imgselect">

                </div>

            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
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
