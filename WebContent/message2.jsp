<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"> 
var t=5;//设定跳转的时间 
setInterval("refer()",1000); //启动1秒定时 
function refer(){  
    if(t==0){ 
        location="http://localhost:8080/bookstore/newManager.jsp"; //#设定跳转的链接地址 
    } 
    document.getElementById('show').innerHTML=""+t+"秒后跳转到主页"; // 显示倒计时 
    t--; // 计数器递减 
    //本文转自： 
} 
</script> 
</head>
<body>
<div style="margin: 0 auto;text-align: center;width: 800px;height: 800px;">
${message }<br>
<span id="show"></span>
</div>
</body>
</html>