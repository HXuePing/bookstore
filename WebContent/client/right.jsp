<%@ page language="java"   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>首页</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/webstyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<style>
.books{
		width: 1100px;
}

.image{
	height: 200px;
	width: 200px;
	overflow: hidden;
}
</style>
</head>
<body>
	<div id="container">
	
		<div class="main">
			<div class="books">
				<c:forEach var="b" items="${bookbean.list }">
					<div class="book">		
					<div class="image">								
						<img alt="图片" src="${pageContext.request.contextPath }/images/${b.image }">
						</div>		
						<div class="info">
						<ul >
							<li>书名：${b.name }</li>
							<li>作者：${b.author}</li>
							<li>价格：${b.price }</li>
							<li>
							<a href="${pageContext.request.contextPath }/client/BuyServlet?id=${b.id }" >购买</a>
							</li>
							
							</ul>
						</div>
					
						<div style="clear: both"></div>
					</div>
					
				</c:forEach>
				<div style="clear: both"></div>
  				<br/>
  				<div class="pagebar">
  					总共${bookbean.totalpage }页
  					当前第${bookbean.currentpage }页
  					
  					<c:forEach var="bar" items="${bookbean.pagebar }">
  						<a href="${pageContext.request.contextPath }/client/IndexServlet?currentpage=${bar}&category_id=${param.category_id }">${bar}</a>
  					</c:forEach>
  				
  				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>