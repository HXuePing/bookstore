<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"> 
var t=5;//�趨��ת��ʱ�� 
setInterval("refer()",1000); //����1�붨ʱ 
function refer(){  
    if(t==0){ 
        location="http://localhost:8080/bookstore/newManager.jsp"; //#�趨��ת�����ӵ�ַ 
    } 
    document.getElementById('show').innerHTML=""+t+"�����ת����ҳ"; // ��ʾ����ʱ 
    t--; // �������ݼ� 
    //����ת�ԣ� 
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