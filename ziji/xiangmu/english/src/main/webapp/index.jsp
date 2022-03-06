<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>攀攀随机出单词2.0</title>
    <style>
        #danci{
           size: 600px;
            font-size: 100px;
        }
    </style>
</head>
<body>
<div>
    <a href="index.jsp" class="aa1" id="danci">

    </a>
</div>
</body>
<script>
    up2()
    function up2() {
        //2.创建XMLHttpRequest核心对象
        let xmlHttp=new XMLHttpRequest();
        //3打开链接
        xmlHttp.open("GET","aa?username=aa",true);
        //4.发送请求
        xmlHttp.send();
        //5处理响应
        xmlHttp.onreadystatechange=function(){
            //判断请求响应是否成功
            if(xmlHttp.readyState==4&&xmlHttp.status==200){
                //将响应数据显示到标签.
                // alert(666)
                document.getElementById("danci").innerHTML=xmlHttp.responseText;
            }
        }

    }
</script>
</html>