<%@ page language="java"    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html lang="en">

  <head>
    <title>购物车列表页面</title>
  </head>
  <style>
  	table{
  		width: 80%;
	margin-top: 100px;
  	}
  	table tr th{
  		color:blue;
  	}
  	a{
  		text-decoration: none;
  	}
  	a:hover{
  	color:red;
  	}
  	
  	button{
  		background: blue;
width: 100px;
height: 40px;
border-radius: 9px;
color:white;
font-size:16px; 
 cursor: pointer;
  	}
  	
  </style>
<body style="text-align: center">

<span></span>
<table align="center" border="1" bordercolor="#0000FF">

	<tr bgcolor="gainsboro" >
		<th>书名
		</th>
		<th>售价
		</th>
		<th>数量
		</th>
		<th>小计
		</th>
	</tr>
	
	<c:forEach var="e" items="${cart.map }">
		<tr>
			<td style="height:40px;">${e.value.book.name }</td>
			<td>${e.value.book.price }</td>
			<td>${e.value.quantity}</td>
			<td>${e.value.price }</td>
			</tr>
	</c:forEach>
	<tr>
   			<td colspan="2">合计</td>
   			<td colspan="2">${cart.price }元</td>
   		</tr>

</table>
<br>
<br>
<br>
<button onclick="window.location.href='${pageContext.request.contextPath }/client/OrderServlet'">生成订单</button>
</body>
</html>
