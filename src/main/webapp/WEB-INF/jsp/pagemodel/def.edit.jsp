<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="/editor.md/css/editormd.css" />
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
            <td> sex:</td> <td>
            <input type="radio" name="sex" value="0" <c:if test="${page.sex==0}">checked</c:if> />boy
            <input type="radio" name="sex" value="1"<c:if test="${page.sex==1}">checked</c:if> />gril
            </td>
        </tr>

    </table>




    <div class="editormd" id="test-editormd">
    <textarea class="editormd-markdown-textarea" name="md"><c:if test="${md==null}">
## 说明
服务器不提供图片上传功能，请使用外部图片连接。
[makedown语法参考](https://github.com/liubailin2017/MakeDownLearn)
## 示例图片
-你可以把图片上传到你qq空间，然后能下面这种格式引用可就可显示对应的图片，显示右边的效果。
![](https://avatars2.githubusercontent.com/u/30728091?s=460&v=4)
    </c:if><c:if test="${md!=null}">${md}</c:if></textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea class="editormd-html-textarea" name="htmlex"></textarea>
    </div>

    <script src="editor.md/examples/js/jquery.min.js"></script>
    <script src="editor.md/editormd.min.js"></script>

    <script type="text/javascript">
        var testEditor;

        $(function() {
            testEditor = editormd("test-editormd", {
                width   : "90%",
                height  : 640,
                saveHTMLToTextarea: true,
                syncScrolling : "single",
                path    : "../editor.md/lib/"
            });

        });

        function show() {
            var content = $(".editormd-markdown-textarea").val()+$(".editormd-html-textarea").val();
            alert(content);
        }
    </script>


        <input type="submit" value="submit">

</form>
</body>
</html>

