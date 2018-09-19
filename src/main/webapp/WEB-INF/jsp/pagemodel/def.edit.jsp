<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}的主页</title>
</head>
<body>
<form action="/page" method="post" >
    <table>
        <input type="hidden" name="pageId" value="${page.pageId}">

<tr>
   <td>qq:<br/> </td> <td><input type="text" name="qq" value="${page.qq}"></td>
</tr>
        <tr>
            <td>desc: </td> <td>  <textarea name="desc"  cols="22" rows="7" warp="virtual">${page.desc}</textarea></td>
        </tr>
        <tr>
            <td>  phone:</td> <td> <input type="text" name="phone" value="${page.phone}"> </td>
        </tr>
        <tr>
            <td> sex:</td> <td>   <input type="radio" name="sex" value="boy">boy<input type="radio" name="sex" value="girl">gril </td>
        </tr>

        <tr>
            <td>  <input type="submit" value="submit"></td>
        </tr>

    </table>
</form>
</body>
</html>

