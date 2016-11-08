<%@ page language="java" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>
        .dialog .panel {
            -webkit-box-shadow: 1px 1px 0px #ffffff;
            -moz-box-shadow: 1px 1px 0px #ffffff;
            box-shadow: 1px 1px 0px #ffffff;
        }
    </style>
</head>
<body>
<div class="dialog">
    <div class="panel panel-default">
       <!-- <p class="panel-heading no-collapse" style="font-size: 17px" ><b>五邑大学&#45;&#45;学生宿舍管理系统</b></p>-->
        <p class="no-collapse panel-heading" style="font-size: 17px" ><b>网上书店&#45;&#45;注册</b></p>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post">
                <div class="form-group">
                    <label for="username">用户名：</label>
                    <input type="text"  id="username" class="form-control span12" name="username">
                    <!--<input type="text" class="form-control span12">-->
                </div>
                <div class="form-group">
                    <label for="password">密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" class="form-control form-control span12 "  id="password" name="password" >
                </div>
                <div class="form-group">
                    <label for="phone">电&nbsp;&nbsp;&nbsp;话：</label>
                    <input type="text" class="form-control form-control span12 "  id="phone"  name="phone">
                </div>
                <div class="form-group">
                    <label for="cellphone">手&nbsp;&nbsp;&nbsp;机：</label>
                    <input type="text" class="form-control form-control span12 "  id="cellphone" name="cellphone">
                </div>
                <div class="form-group">
                    <label for="address">住&nbsp;&nbsp;&nbsp;址：</label>
                    <input type="text" class="form-control form-control span12 "  id="address" name="address">
                </div>
                <div class="form-group">
                    <label for="email">邮&nbsp;&nbsp;&nbsp;箱：</label>
                    <input type="text" class="form-control form-control span12 "  id="email" name="email">
                </div>
              <input type="submit" value="注册" class="btn btn-primary pull-right">
              <%--   <a href="${pageContext.request.contextPath }/client/RegisterServlet" >注册</a> --%>
                <div class="clearfix"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>