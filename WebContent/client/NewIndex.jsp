<%@ page language="java" 
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
		<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Title</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/webstyle.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>	
		<script >
		/* $(function(){
			
		  $("a").click(function(){
			 $("#testFrame").attr("src","/bookstore/client/IndexServlet2"); */
		        /* $.ajax({//按钮栏显示
		            url:"client/index.jsp",
		            dataType:"jsp",
		            type:"get",
		            success:function(data){
		            	alert(data);
		                $("#context").html(data);
		                $(".main .main-left .list  li[id^='mainindex']").addClass("on");
		                $(".main .main-left .list li[id^='zhiye']").removeClass("on");
		                /*var index=data.url.split("/").length-1;
		                var href=data.url.split("/")[index].substr(0,4);
		                if(href.length>0){
		                    $(".list li[id^='"+href+"']").addClass("on")
		                }else{
		                    $(".list li[id^='"+href+"']").addClass("on")
		                }*/
		               // $("#index").css({"background":"#333"});
		          /*    });

		    });  */
		  /*   $("#zhiye").click(function(){
		        $.ajax({//按钮栏显示
		            url:"zhiye.html",
		            dataType:"html",
		            type:"get",
		            success:function(data){
		                $("#con").html(data);
		                $(".list li[id^='zhiye']").addClass("on");
		                $(".list li[id^='index']").removeClass("on");
		            }
		        });
 */
		</script> 
	</head>
	<body>
	<div class="header">
		<div class="header-top">
			<!--<h2>网上书店</h2>-->
			<div class="text">
			<c:if test="${user==null}">
				<form action="${pageContext.request.contextPath}/client/LoginServlet" method="post">
					用户名:<input type="text" name="username" >
					密码:<input type="text" name="password">
					<input type="submit" value="登录" style="background-color:blue;border-radius: 5px;color: white;font-size: 15px">
					<input type="button" value="注册" style="background-color:blue;border-radius: 5px;color: white;font-size: 15px"  onclick="javascript:window.location.href='${pageContext.request.contextPath}/client/bookstoreregister.jsp'">
				</form>
				</c:if>
			<c:if test="${user!=null }">
			<span style="padding-right: 10px;">欢迎你${user.username }</span>
			&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/client/CancelServlet">注销</a>
		</c:if>
			</div>
		</div>
		<div class="header-logo">
			<h2>网上书店</h2>
				<img src="${pageContext.request.contextPath }/images/Logo.PNG">
		</div>
		<div class="nav">
			<ul class="list">
				<li  id="mainindex"><a href="${pageContext.request.contextPath }/client/IndexServlet">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/client/listcart.jsp">查看购物车</a></li>
				<li><a href="#">查看自己的订单</a></li>
			</ul>
		</div>
		<div class="line"></div>
	</div>
	<div class="main">
		<div class="main-left">
			书籍列表：
			<ul class="list">
				<c:forEach var="c" items="${categories}">
					<li><a href='${pageContext.request.contextPath }/client/IndexServlet?category_id=${c.id }'>${c.name}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="main-right">
		<%-- <iframe src="${pageContext.request.contextPath }/client/IndexServlet2"
                id="testFrame" name="testFrame" frameborder="0" scrolling="no" style="width: 1100px;height:600px;border: 1px solid red;"
                            ></iframe> --%>
             <%@include file="right.jsp" %>               
		</div>
	</div>
	<%-- <iframe id="leftiframe" frameborder="1" src="${pageContext.request.contextPath }/client/left.jsp" width="200" height="500"> 
	</iframe>
	<iframe id="mainiframe" frameborder="1"></iframe> --%>

	
	
	</body>