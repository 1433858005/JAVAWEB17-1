<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="denglu" method="post">
  <br>
  <br>
  账户名：<input type="text" placeholder="请输入账户名" name="username" value="${param.u}"></br>
  密码：<input type="password" placeholder="请输入密码" name="password"></br>
  <button>登录</button>
  <button>注册</button>
</form>
<%
  String error=request.getParameter("e");
  if ("1".equals(error)){
%>
<p style="color: blue">登录失败，账号或密码错误</p>
<%
  }
%>
</body>
</html>
