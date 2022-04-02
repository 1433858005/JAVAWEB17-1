<%--
  Created by IntelliJ IDEA.
  User: 29821
  Date: 2022/4/1
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增学生</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/student/addStudent" method="post">
        主键：<input type="text" name="id"><br><br><br>
        姓名：<input type="text" name="names"><br><br><br>
        性别：<input type="text" name="sex"><br><br><br>
        年龄：<input type="text" name="age"><br><br><br>
        学号：<input type="text" name="stuNo"><br><br><br>
        手机号码：<input type="text" name="phone"><br><br><br>
        邮箱：<input type="text" name="email"><br><br><br>
        身份证：<input type="text" name="idCard"><br><br><br>
        证件照：<input type="text" name="photo"><br><br><br>
        <input type="submit" value="添加">
    </form>

</div>
</body>
</html>
