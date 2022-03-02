<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>el表达式</title>
</head>
<body>

<% request.setAttribute("username","zhangsan");%>
Java代码块: <% out.println(request.getAttribute("username"));%><br>
JSP表达式: <%=request.getAttribute("username")%><br>
EL表达式: ${username}
</body>
</html>