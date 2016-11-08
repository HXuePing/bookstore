<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	书籍列表：
	<c:forEach var="c" items="${categories}">
		<li><a href='${pageContext.request.contextPath }/client/IndexServlet?category_id=${c.id }'>${c.name}</a></li>
	</c:forEach>
</body>
</html>