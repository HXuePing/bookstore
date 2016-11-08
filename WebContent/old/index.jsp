<%@ page language="java"   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>首页</title>
 <style type="text/css">
    	body{
    		margin:0px;
    		padding:0px;
    		text-align: center;
    	}
    	
    	#container{
    		width: 1280px;
    		height: 400px;
    		
    	}
    	#main{
    		margin-top: 20px; 
    	}
    	#head{
    		text-align: center;
    	}
    	
    	#categories{
    		border: solid 1px blue;
    		width: 250px;
    		padding-left: 20px;
    		height: 400px;
    		line-height: 40px;
    		float: left;
    	}
    	
    	#books{
    		float: left;
    		margin-left: 40px;
    	}
    	
    	#image{
    		float: left;
    	}
    	
    	#info{
    		float: left;
    	}
    	
    	#book{
    		float: left;
    		width:230px;
    	}
    	
    </style>
</head>
<body>
	aaa
	<div id="container">
		<%-- <div id="head">
			<%@ include file="head.jsp" %>
		</div> --%>
		
		<div id="main">
			<div id="categories">
			书籍列表：
				<c:forEach var="c" items="${categories}">
					<li><a href='${pageContext.request.contextPath }/client/IndexServlet?category_id=${c.id }'>${c.name}</a></li>
				</c:forEach>
			</div>
			<div id="books">
				<c:forEach var="b" items="${bookbean.list }">
					<div id="book">												
						<img alt="图片" src="${pageContext.request.contextPath }/images/${b.image}">
						<div id="info">
							<li>${b.name }</li>
							<li>${b.author}</li>
							<li>${b.price }</li>
							<li>${b.id }</li>
							<li>
							<a href="${pageContext.request.contextPath }/client/BuyServlet?id=${b.id }" >购买</a>
							</li>
						</div>
						<div style="clear: both"></div>
					</div>
					
				</c:forEach>
				<div style="clear: both"></div>
  				<br/>
  				<div id="pagebar">
  					总共${bookbean.totalpage }页
  					当前${bookbean.currentpage }页
  					<c:forEach var="bar" items="${bookbean.pagebar }">
  						<a href="${pageContext.request.contextPath }/client/IndexServlet?currentpage=${bar}&category_id=${param.category_id }">${bar}</a>
  					</c:forEach>
  					
  				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>