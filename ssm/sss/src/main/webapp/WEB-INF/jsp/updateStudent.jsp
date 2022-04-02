<%--
  Created by IntelliJ IDEA.
  User: 29821
  Date: 2022/4/1
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
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
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/student/updateStudent" method="post">
        <input type="hidden" name="id" value="${student.getid()}"/>
        姓名：<input type="text" name="names" value="${student.getnames()}"/>
        性别：<input type="text" name="sex" value="${student.getsex()}"/>
        年龄：<input type="text" name="age" value="${student.getage() }"/>
        学号：<input type="text" name="stuNo" value="${student.getstuNo() }"/>
        手机号码：<input type="text" name="phone" value="${student.getphone() }"/>
        邮箱：<input type="text" name="email" value="${student.getemail() }"/>
        身份证：<input type="text" name="idCard" value="${student.getidaCard() }"/>
        证件照：<input type="text" name="photo" value="${student.getphoto() }"/>
        <input type="submit" value="提交"/>
    </form>

</div>
</body>
</html>
