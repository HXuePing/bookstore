<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>添加分类页面</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div class="same-head">
  		<%@include file="../newManager.jsp" %>
  </div>
  
   
  <div >
    <form action="${pageContext.request.contextPath}/manager/CategoryServlet?method=add" method="post">
    	  <div style="">
    	<table width="500px;"  style="margin: 50px auto;">
    	
    	<tr>
    		<td style="padding: 20px;">分类名称：</td>
    		<td><input type="text" name="name" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>分类描述：</td>
    		<td><textarea rows="4" cols="40" name="description"></textarea></td>
    	</tr>
    	<tr>
    		<td><br></td>
    		<td style="padding-top: 10px;"><input type="submit" value="添加分类" class="btn btn-danger"></td>
    	</tr>
    	</table>
    	 </div>
    </form>
   </div>
  </body>
</html>
