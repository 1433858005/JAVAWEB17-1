<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>攀攀随机出单词2.0</title>
    <style>
        .div1{
            left: 20px;
            top: 10px;
            /* font-size: 1px; */
            width:50%;
            height: 80%;
            position: fixed;
            background-color: rgba(240, 223, 175, 0.9);
            color: #660000;
            text-align: center;
            padding: 100px;
            z-index: 1433858005;
            border-radius: 20px;
            border: 2px solid black;
            display: none
        }
        #ku1,#ku2,#ku3{
            font-size: 50px;
        }
        #sku1,#sku2,#sku3{
            font-size: 50px;
        }
        #danci {
            text-decoration: none;
            font-size: 250px;
            text-align: center;
        }
        #dancishu{
            display: none
        }
        #id1,#id2 {
            font-size:75px;
            display: none
        }
        #button ,#button2,#button3,#button4{
            height: 150px;
            width: 300px;
            font-size: 75px;
        }
        #fanyi{
            font-size:75px;
        }
    </style>
</head>
<body>
<div class="div1">

</div>
<div>
    <b id="id1"> 词库<a id="ku0">english0001</a> <br> <a id="shunxu"></a> <br>   词<a id="dancishu"></a> </b>

    <%--    当前第<a id="dangqiangid"></a>个--%>
    <%--    词顺序<a id="dancibiao"></a>--%>
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
    <button id="button4">收藏</button>
</div>
<div>
    <b id="id2">收藏到词库<a id="sku0">english0002</a></b>
</div>
</body>
<script>
    up2()
    let dancifanyi = "错误";
    let cixu = 0;
    let dancicixu = [];
    document.getElementById("button2").onclick = fanyi;
    document.getElementById("button").onclick = xiayige;
    document.getElementById("button3").onclick = shangyige;
    document.getElementById("button4").onclick = shoucang;
    // document.getElementById("button5").onclick = danciku;



    document.getElementById("ku0").onclick = ku0;

    document.getElementById("sku0").onclick = sku0;


    function ku0() {
        //设置当前单词库

    }



    function danciku() {
        let a = document.getElementById("div1");
        let b = document.createElement("a");

    }

    function up2() {
        xindanci();
    }

    function shoucang() {
        let b = document.getElementById("danci").innerHTML;
        let c = document.getElementById("sku0").innerHTML;
        let bb =  b + "," + dancifanyi+","+c
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET", "b?shoucang=" + bb, true);
        xmlHttp.send();
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                let shuju = xmlHttp.responseText;
                alert(shuju)
            }
        }
    }

    //按钮上一个
    function shangyige() {
        if (cixu === 0 || cixu === 1) {
            alert("当前为第" + cixu + "个,没有上一个")
        } else {
            let a = cixu - 1;
            // alert("上单词次序为"+a+"对应的单词id为"+dancicixu[cixu-2])
            let xmlHttp = new XMLHttpRequest();
            let ku = document.getElementById("ku0").innerHTML;
            xmlHttp.open("GET", "a?shangyige=" + dancicixu[cixu - 2]+","+ku, true);
            xmlHttp.send();
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    cixu = cixu - 1;
                    //将响应数据显示到标签.
                    let shuju = xmlHttp.responseText;
                    var shuju2 = shuju.split(",");
                    document.getElementById("danci").innerHTML = shuju2[2];
                    document.getElementById("dancishu").innerHTML = shuju2[0];
                    // document.getElementById("dangqiangid").innerHTML = shuju2[1];
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
            let xmlHttp = new XMLHttpRequest();
            let ku = document.getElementById("ku0").innerHTML;
            xmlHttp.open("GET", "a?shangyige=" + dancicixu[cixu]+","+ku, true);
            xmlHttp.send();
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    let shuju = xmlHttp.responseText;
                    var shuju2 = shuju.split(",");
                    document.getElementById("danci").innerHTML = shuju2[2];
                    document.getElementById("dancishu").innerHTML = shuju2[0];
                    //获取单词的id
                    // document.getElementById("dangqiangid").innerHTML = shuju2[1];
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
        let xmlHttp = new XMLHttpRequest();
        let ku = document.getElementById("ku0").innerHTML;
        xmlHttp.open("GET", "aa?username=aa" + "," + ku, true);
        xmlHttp.send();
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                let shuju = xmlHttp.responseText;
                var shuju2 = shuju.split(",");
                document.getElementById("danci").innerHTML = shuju2[2];
                document.getElementById("dancishu").innerHTML = shuju2[0];
                // document.getElementById("dangqiangid").innerHTML = shuju2[1];
                document.getElementById("shunxu").innerHTML = cixu;
                if (cixu === 0) {
                    dancicixu[0] = shuju2[1];
                } else {
                    dancicixu[cixu] = shuju2[1];
                }
                //显示单词表，展示所有单词
                // document.getElementById("dancibiao").innerHTML = dancicixu;
                dancifanyi = shuju2[3];
                cixu = cixu + 1;
            }
        }
    }
    // 词库和收藏词库设置
    let aa1 = document.querySelector("#ku0");
    aa1.onclick = aaa1;
    let a1 = document.querySelector("#sku0");
    a1.onclick = aaa2;
    function aaa2(){
        let bb1 = document.querySelector(".div1");
        bb1.style.display = "block"
        if (document.getElementById("ku1")){
            bb1.removeChild( document.getElementById("ku1"));
            bb1.removeChild( document.getElementById("ku2"));
            bb1.removeChild( document.getElementById("ku3"));
        }

        if (document.getElementById("sku1")){
            // alert(6666)
        }else {
            let bb2=document.createElement("a");
            let bb3=document.createElement("a");
            let bb4=document.createElement("a");
            bb2.id="sku1"
            bb3.id="sku2"
            bb4.id="sku3"
            bb2.innerHTML="english0002<br>"
            bb3.innerHTML="english0003<br>"
            bb4.innerHTML="english0004"
            bb1.appendChild(bb2)
            bb1.appendChild(bb3)
            bb1.appendChild(bb4)
        }
        document.getElementById("sku1").onclick = sku1;
        document.getElementById("sku2").onclick = sku2;
        document.getElementById("sku3").onclick = sku3;
        function sku1() {
            document.getElementById("sku0").innerHTML = "english0002";
            let bb1 = document.querySelector(".div1");
            bb1.style.display = "none"

        }
        function sku2() {
            document.getElementById("sku0").innerHTML = "english0003";
            let bb1 = document.querySelector(".div1");
            bb1.style.display = "none"

        }
        function sku3() {
            document.getElementById("sku0").innerHTML = "english0004";
            let bb1 = document.querySelector(".div1");
            bb1.style.display = "none"

        }
    }
    function aaa1() {
        let bb1 = document.querySelector(".div1");
        bb1.style.display = "block"
        if (document.getElementById("sku1")){
            bb1.removeChild( document.getElementById("sku1"));
            bb1.removeChild( document.getElementById("sku2"));
            bb1.removeChild( document.getElementById("sku3"));
        }
        if (document.getElementById("ku1")){
            // alert(6666)
        }else {
            let bb2=document.createElement("a");
            let bb3=document.createElement("a");
            let bb4=document.createElement("a");
            bb2.id="ku1"
            bb3.id="ku2"
            bb4.id="ku3"
            bb2.innerHTML="english0001<br>"
            bb3.innerHTML="english0002<br>"
            bb4.innerHTML="english0003"
            bb1.appendChild(bb2)
            bb1.appendChild(bb3)
            bb1.appendChild(bb4)
        }
        document.getElementById("ku1").onclick = ku1;
        document.getElementById("ku2").onclick = ku2;
        document.getElementById("ku3").onclick = ku3;
        function ku1() {
            document.getElementById("ku0").innerHTML = "english0001";
            let bb1 = document.querySelector(".div1");
            bb1.style.display = "none"

        }
        function ku2() {
            document.getElementById("ku0").innerHTML = "english0002";
            let bb1 = document.querySelector(".div1");
            bb1.style.display = "none"
        }
        function ku3() {
            document.getElementById("ku0").innerHTML = "english0003";
            let bb1 = document.querySelector(".div1");
            bb1.style.display = "none"
        }
    }
</script>
</html>