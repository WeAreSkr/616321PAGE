<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/input.css">

<jsp:include page="../head.jsp"></jsp:include>
    <link rel="stylesheet" href="/editor.md/css/editormd.css" />
    <title>编辑${user.name}的主页</title>
</head>
<body>
<jsp:include page="../navigation.jsp"></jsp:include>
<div class="divline">
    基本信息编辑区
</div>
<form action="/page" method="post" >
    <div class="opearator" >
    <input type="submit" style="background-color: #1d75b3" value="保存"></div>
        <input type="hidden" name="pageId" value="${page.pageId}"/>
    <div id="baseinfo">
        <div class="map_item">
        <label class="name">qq: </label>       <input class="input_text" type="text" name="qq" value="${page.qq}"/></div>
        <div class="map_item">
            <label class="name">电话号码:</label>  <input class="input_text" type="text" name="phone" value="${page.phone}"/></div>
        <div class="map_item">
            <label class="name">男孩还是女孩：</label>
            <input type="radio" name="sex" id="sex0" value="0" <c:if test="${page.sex==0}">checked</c:if> /> <label for="sex0">boy</label>
            <input type="radio" name="sex" id="sex1" value="1"<c:if test="${page.sex==1}">checked</c:if> /> <label for="sex1">girl</label>
        </div>
    </div>
<div class="divline">
自定义页面编辑区
</div>
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
                width   : "100%",
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

</form>
</body>
</html>

