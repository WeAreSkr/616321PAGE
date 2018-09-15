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
        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
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
            <td>Img:</td>
            <td>
                <input type="file" name="imgs"> <br/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</s:form>


</body>
</html>
