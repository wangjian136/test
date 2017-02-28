<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>My JSP 'index.jsp' starting page</title>
		<base href="${requestScope.path}">
	</head>

	<body>
		<jsp:forward page="/admin/login/login.jsp" />
	</body>

</html>