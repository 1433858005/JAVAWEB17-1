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
    <title>学生列表</title>
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
                    <small>学生列表 —— 显示所有学生</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/student/toAddStudent">新增</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>主键</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>学号</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>身份证</th>
                    <th>学生证件照</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="student" items="${requestScope.get('list')}">
                    <tr>
                        <td>${Student.getid()}</td>
                        <td>${Student.getnames()}</td>
                        <td>${Student.getsex()}</td>
                        <td>${Student.getage()}</td>
                        <td>${Student.getstuNo()}</td>
                        <td>${Student.getphone()}</td>
                        <td>${Student.getemail()}</td>
                        <td>${Student.getidCard()}</td>
                        <td>${Student.getphoto()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/student/toUpdateStudent?id=${student.getid()}">更改</a> |
                            <a href="${pageContext.request.contextPath}/student/del/${student.getid()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
