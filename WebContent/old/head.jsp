<%@ page language="java"     pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>网上书店</h1>
<br><br>
<div>
	<div style="margin-left: 40%;float: left;" >
		<a href="${pageContext.request.contextPath }/index.jsp">首页</a>	
		<a href="${pageContext.request.contextPath }/client/listcart.jsp">查看购物车</a>	
		<a href="#">查看自己的订单</a>	
	</div>

	<div style="float: right;">
		<c:if test="${user==null}">
		<form action="${pageContext.request.contextPath}/client/LoginServlet" method="post">
			用户名<input type="text" name="username" >
			密码<input type="text" name="password">
			<input type="submit" value="登录">
			<input type="button" value="注册" onclick="javascript:window.location.href='${pageContext.request.contextPath}/client/register.jsp'">
		</form>
		</c:if>
		<c:if test="${user!=null }">
			欢迎你${user.username }
		</c:if>
	</div>

<div style="clear: both;"></div>
</div>
<hr>