<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>订单列表</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  
  <body >
  <div class="same-head">
  		<%@include file="../newManager.jsp" %>
  </div>
<div style="width: 850px;margin: 0 auto;">
   	<table class="table table-striped table-hover table-bordered">
   		<caption><h2>订单信息</h2></caption>
   		<tr>
   			<td>订单人</td>
   			<td>下单时间</td>
   			<td>订单状态</td>
 			<td>订单总价</td>
 			<td>操作</td>
   		</tr>

			<c:forEach var="order" items="${list}">
				<tr>
					<td>
						${order.user.username }
					</td>
					<td>
						${order.ordertime }
					</td>
					<td>
						${order.state==false?'未发货':'已发货' }
					</td>
					<td>
						${order.price }
					</td>
					<td>
						<a
							href="${pageContext.request.contextPath }/manager/OrderServlet1?method=find&id=${order.id }" class="btn  btn-sm btn-danger">查看明细</a>
						<a href="#" class="btn btn-primary btn-sm ">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
  </body>
</html>
