<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>

<label for="username">姓名:</label><input type="text" id="username">
<span id="uSpan"></span><br>

</body>
<Script>
  //1.为绑定失去焦点事件
  document.getElementById("username").onblur = function () {
    //2.创建XMLHttpRequest核心对象
    let xmlHttp = new XMLHttpRequest();
    //3打开链接
    let username = document.getElementById("username").value;
    xmlHttp.open("post","a",true);
    // POST发送请求必须设置请求头
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    // application/x-www-form-urlencoded    表单字符类型
    // multiline/form-data      表单类型
    // application/json
    // text/xml

    //4.发送请求
    xmlHttp.send("username="+username);
    //5处理响应
    xmlHttp.onreadystatechange = function () {
      //判断请求响应是否成功
      if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
        //将响应数据显示到标签
        document.getElementById("uSpan").innerHTML = xmlHttp.responseText;
      }
    }
  }
</Script>

</html>