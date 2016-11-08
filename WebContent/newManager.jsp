
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/managerwebstyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/nav2.js"></script>
</head>
<style>
#main-context{
	
}
</style>
<script type="text/javascript">
/* $(function(){
	
	  $("#addcategory").click(function(){
	        $.ajax({//按钮栏显示
	            url:"/bookstore/manager/addcategory.html",
	            dataType:"html",
	            type:"get",
	            success:function(data){
	          
	                $("#main-context").html(data);
	        
	             }
	    }); 
	  $("#zhiye").click(function(){
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

	  });
  });
}); */
	</script>
<body>
    <div class="header">
       <div class="header-logo">
          网上书店后台管理系统
       </div>
        <div class="header-nav">
            <ul class="list">
                <li><a href="#">分类管理</a>
                    <div class="down">
                        <a href="${pageContext.request.contextPath}/manager/addcategory.jsp" >添加分类</a>
                        <a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=getAll">查看分类</a>

                    </div>

                </li>
                <li><a href="#">图书管理</a>
                    <div class="down">
                        <a href="${pageContext.request.contextPath }/manager/BookServlet?method=addUI">添加图书</a>
                        <a href="${pageContext.request.contextPath }/manager/BookServlet?method=getAll">查看图书</a>

                    </div>

                </li>
                <li><a href="#">订单管理</a>
                    <div class="down">
                        <a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=getAll&state=false">待处理订单</a>
                        <a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=getAll&state=true">发货订单</a>

                    </div>

                </li>
            </ul>
        </div>
    </div>
    
</body>
</html>