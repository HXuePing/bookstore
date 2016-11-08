<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>后台左侧导航页面</title>	
    <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$(".handle").css("cursor","pointer");
    		$(".handle").nextUntil(".c").hide();
    		if($(this).next().css("display")=="none"){
    			$(this).nextUntil(".c").show();
    		}else{
    			$(this).nextUntil(".c").hide();
    		}
    	});
    
    </script>
  </head> 
  <body>
    <ul>
    	<li>
    		<div class="handle">分类管理</div>
    	<div class="c"><a href="${pageContext.request.contextPath }/manager/addcategory.jsp"  target="right">添加分类</a></div>
	    <div class="c"><a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=getAll"  target="right">查看分类</a></div>
		
    	</li>
    	<br>
    	<li>
    		<div class="handle">图书管理</div>
 		<div class="c"> <a href="${pageContext.request.contextPath }/manager/BookServlet?method=addUI"  target="right">添加图书</a></div>
		<div class="c"><a href="${pageContext.request.contextPath }/manager/BookServlet?method=getAll"  target="right">查看图书</a></div>		
    	</li>
    	<br>
    	<li>
    		<div class="handle">订单管理</div>
		<div class="c"><a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=getAll&state=false"  target="right">待处理订单</a></div>
		<div class="c"><a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=getAll&state=true"  target="right">已发货订单</a></div>
    	</li>  	   	
    </ul>
  </body>
</html>
