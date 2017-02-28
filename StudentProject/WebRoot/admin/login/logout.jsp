<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>用户注销</title>
		<base href="${requestScope.path}">
		<%
			session.invalidate();
		%>
		<script type="text/javascript">
			alert("注销成功！");
			window.location = "index.jsp";
		</script>
	</head>

</html>