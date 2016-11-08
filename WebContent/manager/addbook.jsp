<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>添加图书</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div class="same-head">
  		<%@include file="../newManager.jsp" %>
  </div>
    <form action="${pageContext.request.contextPath }/manager/BookServlet?method=add" method="post" enctype="multipart/form-data">
    	<table width="500px" style="margin: 50px auto;">
    	<tr style="padding-top:10px; ">
    		<td >书名</td>
    		<td>
    		<div class="form-group">
    		<input type="text" name="name" style="width: 200px" class="form-control"></div></td>
    	<tr>
    	<tr>
    		<td>作者</td>
    		<td>
    		<div class="form-group">
    		<input type="text" name="author" style="width: 200px" class="form-control">
    		</div>
    		</td>
    	</tr>
    	<tr>
    		<td>售价</td>
    		<td>
    		<div class="form-group">
    		<input type="text" name="price" style="width: 200px" class="form-control">
    		</div>
    		</td>
    	</tr>
    	<tr>
    		<td>图片</td>
    		<td>
    		<div class="form-group">
    		<input type="file" name="image" style="width: 200px"></div></td>
    	</tr>
    	<tr>
    		<td>描述</td>
    		<td>
    		<div class="form-group">
    		<textarea class="form-control" rows="4" cols="40" name="description" ></textarea>
    		</div>
    		</td>
    	</tr>
    	<tr>
    		<td>所属分类</td>
    		<td>
    		<div class="form-group">
    			<select name="category_id">
    				<c:forEach var="category"  items="${list}">
    					<option value="${category.id }">${category.name }</option>
    				</c:forEach>
    			</select>
    			</div>
    		</td>
    	</tr>
    	<tr>
    		<td></td><td style="padding-top: 10px;">
    		<div class="form-group">
    		<input type="submit" value="添加书籍" class="btn btn-danger">
    		</div>
    		</td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
