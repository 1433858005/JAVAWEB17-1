<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-md-4 column" >
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
        <a class="btn btn-primary" id="del">删除</a>
        <a class="btn btn-primary" id="gai" href="${pageContext.request.contextPath}/book/toUpdateBook?id=0">更改</a>
    </div>
    <div id="div1">

    </div>
</div>
<table >
    <thead>
    <tr>
        <th>Id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>学号</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>身份证号</th>
        <th>证件照</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="b" items="${requestScope.get('list')}">
        <tr>
            <td>${b.id}</td>
            <td>${b.name}</td>
            <td>${b.gender}</td>
            <td>${b.age}</td>
            <td>${b.studentid}</td>
            <td>${b.phone}</td>
            <td>${b.email}</td>
            <td>${b.identitycard }</td>
            <td><img src=${b.img} alt="未上传证件照" width="200" height="100"></td>
            <td>${book.getDetail()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}">更改</a> |
                <a href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</body>
</html>
