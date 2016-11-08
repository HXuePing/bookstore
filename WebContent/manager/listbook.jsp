<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>后台书籍列表</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
    *{
    padding: 0;
    margin: 0;
    }
    </style>
  </head>
	<body >
	<div class="same-head">
  		<%@include file="../newManager.jsp" %>
  </div>
  
   <div style="width: 850px;margin: 0 auto;">
   	<table class="table table-striped table-hover table-bordered">
   		<caption><h2>图书信息</h2></caption>
   		<tr>
   			<td>书名</td>
   			<td>作者</td>
   			<td>描述</td>
   			<td>图片</td>
 			<td>操作</td>
   		</tr>
   		
   		<c:forEach var="book" items="${list}">
   			<tr>
   				<td>${book.name }</td>
   				<td>${book.author }</td>
   				<td>${book.description }</td>
   				<td><a href="${pageContext.request.contextPath }/images/${book.image }">查看图片</a></td>
	   			<td>
	   				<a href="#" class="btn btn-primary btn-sm ">修改</a>
	   				<a href="#" class="btn  btn-sm btn-danger ">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	</div>
   	<br/><br/>
 
    
  </body>
</html>

