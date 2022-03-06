<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
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
                    <small>书籍列表 —— 显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column" >
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
            <a class="btn btn-primary" id="del">删除</a>
            <a class="btn btn-primary" id="gai" href="${pageContext.request.contextPath}/book/toUpdateBook?id=0">更改</a>
        </div>
        <div id="div1">

        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${requestScope.get('list')}">
                    <tr>
                        <td>${book.getBookID()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getBookCounts()}</td>
                        <td>${book.getDetail()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}">更改</a> |
                            <a href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<body>
<script>
    let dell = document.getElementById("del");
    dell.onclick = up;

    function up() {
        let bb = document.createElement("input");
        bb.type = "text"
        bb.placeholder = "输入要删除的id"
        bb.id = "del1"
        bb.onblur = up3
        let bb2 = document.createElement("a");
        bb2.text = "确定删除"
        bb2.id = "del2"
        let bb3 = document.createElement("a");
        bb3.text = "取消删除"
        bb3.id = "del3"
        bb3.href="/book/allBook"
        // bb2.href="http://blhl.xyz"
        let div1 = document.getElementById("div1");
        div1.appendChild(bb);
        div1.appendChild(bb2);
        div1.appendChild(bb3);
        // **********************************
        // let dell2 = document.getElementById("del2");
        // dell2.onclick = up2;
    }

    function up3() {
        let a = document.getElementById("del1").value;
        if (a !== "") {
            let dell2 = document.getElementById("del2");
            dell2.setAttribute("href", "/book/del/" + a);
        }
    }
</script>
<html>