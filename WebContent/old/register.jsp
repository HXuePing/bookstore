<%@ page language="java" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title></title>
  </head>
  
  <body style="text-align: center">
    
    <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post">
    	<table width="300px">
    	<caption><h2>用户注册</h2></caption>
    	<tr>
    		<td>用户名</td>
    		<td><input type="text" name="username" id="username" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>密码</td>
    		<td><input type="password" name="password" id="password" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>电话</td>
    		<td><input type="text" name="phone" id="phone" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>手机</td>
    		<td><input type="text" name="cellphone" id="cellphone" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>住址</td>
    		<td><input type="text" name="address" id="address" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>邮箱</td>
    		<td>
    			<input type="text" name="email" id="email" style="width: 200px">
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="注册"></td>
    	</tr>
    	</table>
    </form>
    
    
  </body>
</html>
