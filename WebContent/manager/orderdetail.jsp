<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="same-head">
  		<%@include file="../newManager.jsp" %>
  </div>
  <div style="width: 1200px;margin: 0 auto;">
    <table class="table table-striped table-hover table-bordered">
   		<h3>订单明细</h3>
   		<tr>
   			<td>书名</td>
   			<td>售价</td>
   			<td>数量</td>
   			<td>应收货款</td>
   		</tr>
   		
   		<c:forEach var="orderitem" items="${order.orderitems}">
   			<tr>
	   			<td>${orderitem.book.name }</td>
	   			<td>${orderitem.book.price }</td>
	   			<td>${orderitem.quantity }</td>
	   			<td>${orderitem.price }元</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">总计应收货款</td>
   			<td colspan="2">${order.price }元</td>
   		</tr>
   	</table>
   	</div>
   	<br/><br/>
   <div style="width: 1200px;margin: 0 auto;">
    <table class="table table-striped table-hover table-bordered">
  		<h3>收货人详细地址</h3>
  		<tr>
  			<td>用户</td>
  			<td>电话</td>
  			<td>手机</td>
  			<td>地址</td>
  			<td>邮箱</td>
  		</tr>
  		
  		<tr>
  			<td>${order.user.username }</td>
  			<td>${order.user.phone }</td>
  			<td>${order.user.cellphone }</td>
  			<td>${order.user.address }</td>
  			<td>${order.user.email }</td>
  		</tr>
  	</table>
  	</div>
  	<br/>
  	<div style="width: 1200px;margin: 0 auto;">
  	<a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=update&id=${order.id }" class="btn btn-danger btn-sm ">确认发货</a>
 </div>
  </body>
</html>
