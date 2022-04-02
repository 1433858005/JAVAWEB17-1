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
<div> 图片 <img src="" alt="" id="img"></div>
<input type="file" id="a">
<button id="q"></button>

</body>
<script>
  let qq = document.getElementById("q");
  qq.onclick = aaa;
  let qw

  function aaa() {
    let a = document.getElementById("a").files[0];
    var file = a;
    var reader = new FileReader();
    reader.readAsDataURL(file);
    console.log();
    reader.onload = function (e) {
      qw = this.result;
      alert(qw)
      let xmlHttp = new XMLHttpRequest();
      xmlHttp.open("post", "aa", true);
      xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      // xmlHttp.setRequestHeader("Content-type","multiline/form-data");
      // xmlHttp.send(this.result);
      xmlHttp.send("add=111&as="+this.result);
      xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
          let b = xmlHttp.responseText
          alert(b)
          let bb = document.getElementById("img")
          bb.setAttribute("src",b)
        }

      }
    }
  }
</script>

</html>