<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/js/jquery.min.js"></script>
    <title>添加班级相册</title>
    <jsp:include page="../../head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../head.jsp"></jsp:include>
<form action="/authority/1/addimgs" method="post" enctype="multipart/form-data">
    <p>描述：</p><input type="text" name="dsc">

    <div id="imgselect">

    </div>
    <input type="submit" value="提交">
</form>
<button onclick="addimgs()">添加图片</button>
<script>
    function  addimgs() {
        var imgselect = $("#imgselect");
        imgselect.append(" <input type=\"file\" name=\"imgs\"> <br/>");
    }
</script>
</body>
</html>
