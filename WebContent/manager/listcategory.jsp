<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>分类列表</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  
  <body >
  <div class="same-head">
  		<%@include file="../newManager.jsp" %>
  </div>

   	<div style="width: 750px;margin: 0 auto;">
   	<table class="table table-striped table-hover table-bordered" >
   		<caption><h2>书籍分类信息</h2></caption>
   		<tr>
   		
   			<td>分类名称</td>
   			<td>分类描述</td>
   			<td>操作</td>
   		</tr>
   		
   		<c:forEach var="category" items="${list}">
   			<tr>
   				<td>${category.name }</td>
	   			<td>${category.description }</td>
	   			<td>
	   				<a href="#" class="btn btn-primary btn-sm ">修改</a>
	   				<a href="${pageContext.request.contextPath}/manager/CategoryServlet?method=delete&id=${category.id}" class="btn  btn-sm btn-danger">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	</div>
  </body>
</html>
