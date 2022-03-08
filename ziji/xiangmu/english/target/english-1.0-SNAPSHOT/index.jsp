<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>攀攀随机出单词2.0</title>
    <style>
        #danci {
            size: 600px;
            font-size: 100px;
        }
    </style>
</head>
<body>
<div>
    当前单词库<a id="ku0">english0001</a> 收藏的单词库<a id="sku0">english0002</a>
    共有单词<a id="dancishu"></a>个，当前第<a id="dangqiangid"></a>个，你已刷单词<a id="shunxu"></a>个
    单词顺序<a id="dancibiao"></a>
</div>
<div>
    <button id="button5"> 选择单词库</button>
    <div id="div1">
        <a id="ku1"> english0001</a>
        <a id="ku2"> english0002</a>
        <a id="ku3"> english0003</a>
    </div>
</div>
<div>
    <a href="index.jsp" class="aa1" id="danci"></a>
</div>
<div>
    <a id="fanyi"></a>
</div>
<div>
    <button id="button">下一个</button>
    <button id="button2">翻译</button>
    <button id="button3">上一个</button>
    <button id="button4">收藏单词</button>
</div>
<div id="div2">
    <a id="sku1"> english0002</a>
    <a id="sku2"> english0003</a>
    <a id="sku3"> english0004</a>
</div>
</body>
<script>
    up2()
    let dancifanyi = "错误";
    // let shangdanci;
    let cixu = 0;
    let dancicixu = [];
    let bu = document.getElementById("button2");
    let bu1 = document.getElementById("button");
    let bu2 = document.getElementById("button3");
    let bu3 = document.getElementById("button4");
    let bu4 = document.getElementById("button5");

    bu.onclick = fanyi;
    bu1.onclick = xiayige;
    bu2.onclick = shangyige;
    bu3.onclick = shoucang;
    bu4.onclick = danciku;
    document.getElementById("ku1").onclick = ku1;
    document.getElementById("ku2").onclick = ku2;
    document.getElementById("ku3").onclick = ku3;
    document.getElementById("ku0").onclick = ku0;

    document.getElementById("sku1").onclick = sku1;
    document.getElementById("sku2").onclick = sku2;
    document.getElementById("sku3").onclick = sku3;
    document.getElementById("sku0").onclick = sku0;
    function sku1() {
        document.getElementById("sku0").innerHTML = "english0002";
    }
    function sku2() {
        document.getElementById("sku0").innerHTML = "english0003";
    }
    function sku3() {
        document.getElementById("sku0").innerHTML = "english0004";
    }

    function ku0() {
        //设置当前单词库

    }

    function ku1() {
        document.getElementById("ku0").innerHTML = "english0001";

    }

    function ku2() {
        document.getElementById("ku0").innerHTML = "english0002";
    }

    function ku3() {
        document.getElementById("ku0").innerHTML = "english0003";
    }

    function danciku() {
        let a = document.getElementById("div1");
        let b = document.createElement("a");

    }

    function up2() {
        xindanci();
    }

    function shoucang() {
        let a = document.getElementById("dangqiangid").innerHTML;
        let b = document.getElementById("danci").innerHTML;
        let c = document.getElementById("sku0").innerHTML;
        // alert(a + b + dancifanyi);

        let bb = a + "," + b + "," + dancifanyi+","+c
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET", "b?shoucang=" + bb, true);
        xmlHttp.send();
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                // cixu=cixu-1;
                let shuju = xmlHttp.responseText;
                alert(shuju)
            }
        }
    }


    function shangyige() {
        if (cixu === 0 || cixu === 1) {
            alert("当前为第" + cixu + "个,没有上一个")
        } else {
            let a = cixu - 1;
            // alert("上单词次序为"+a+"对应的单词id为"+dancicixu[cixu-2])
            //2.创建XMLHttpRequest核心对象
            let xmlHttp = new XMLHttpRequest();
            //3打开链接
            let ku = document.getElementById("ku0").innerHTML;
            xmlHttp.open("GET", "a?shangyige=" + dancicixu[cixu - 2]+","+ku, true);
            //4.发送请求
            xmlHttp.send();
            //5处理响应
            xmlHttp.onreadystatechange = function () {
                //判断请求响应是否成功
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    cixu = cixu - 1;
                    //将响应数据显示到标签.
                    let shuju = xmlHttp.responseText;
                    var shuju2 = shuju.split(",");
                    document.getElementById("danci").innerHTML = shuju2[2];
                    document.getElementById("dancishu").innerHTML = shuju2[0];
                    document.getElementById("dangqiangid").innerHTML = shuju2[1];
                    document.getElementById("shunxu").innerHTML = cixu;
                    // shangdanci = shuju2[1];
                    dancifanyi = shuju2[3];
                }
            }
        }
    }

    function xiayige() {
        // alert( dancicixu.length+"...."+cixu)
        if (dancicixu.length === cixu) {
            up2();
        } else {
            // alert("没有创建新单词")
            //2.创建XMLHttpRequest核心对象
            let xmlHttp = new XMLHttpRequest();
            //3打开链接
            let ku = document.getElementById("ku0").innerHTML;
            xmlHttp.open("GET", "a?shangyige=" + dancicixu[cixu]+","+ku, true);
            //4.发送请求
            xmlHttp.send();
            //5处理响应
            xmlHttp.onreadystatechange = function () {
                //判断请求响应是否成功
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

                    //将响应数据显示到标签.
                    let shuju = xmlHttp.responseText;
                    var shuju2 = shuju.split(",");
                    document.getElementById("danci").innerHTML = shuju2[2];
                    document.getElementById("dancishu").innerHTML = shuju2[0];
                    document.getElementById("dangqiangid").innerHTML = shuju2[1];
                    document.getElementById("shunxu").innerHTML = cixu;
                    dancifanyi = shuju2[3];
                    cixu = cixu + 1;
                }
            }
        }

    }

    function fanyi() {
        document.getElementById("fanyi").innerHTML = dancifanyi;
    }

    //生成新的单词
    function xindanci() {
        //2.创建XMLHttpRequest核心对象
        let xmlHttp = new XMLHttpRequest();
        //3打开链接
        let ku = document.getElementById("ku0").innerHTML;
        xmlHttp.open("GET", "aa?username=aa" + "," + ku, true);
        //4.发送请求
        xmlHttp.send();
        //5处理响应
        xmlHttp.onreadystatechange = function () {
            //判断请求响应是否成功
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                //将响应数据显示到标签.
                let shuju = xmlHttp.responseText;
                var shuju2 = shuju.split(",");
                document.getElementById("danci").innerHTML = shuju2[2];
                document.getElementById("dancishu").innerHTML = shuju2[0];
                document.getElementById("dangqiangid").innerHTML = shuju2[1];
                document.getElementById("shunxu").innerHTML = cixu;
                if (cixu === 0) {
                    dancicixu[0] = shuju2[1];
                } else {
                    dancicixu[cixu] = shuju2[1];
                }
                document.getElementById("dancibiao").innerHTML = dancicixu;
                dancifanyi = shuju2[3];
                cixu = cixu + 1;
            }
        }
    }

</script>
</html>