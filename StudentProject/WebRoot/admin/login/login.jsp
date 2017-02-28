<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>用户登录</title>
		<base href="${requestScope.path}">
		<script type="text/javascript" src="js/student.js"></script>
		<link type="text/css" href="css/form.css" rel="stylesheet" />
	</head>

	<body>
		<div style="border-left:100px solid white;text-align: left;">欢迎使用学生信息管理系统^_^</div>
		<div id="header" style="border-right:100px solid white;border-left:100px solid white;">
			<img src="images/header.jpg" height="60px" width="1100px" />
		</div>
		<div style="background-color:aqua;border-left:100px solid white;border-right:150px solid white;height: 400px;">
			<div style="height: 100px;"></div>
			<div style="border-left:400px solid aqua;float: left;height:300px;"></div>
			<div style="text-align: center;float: left;height:300px;">
				<form action="login.do" method="post" onSubmit="return validate()">
					<table border="1">
						<tr>
							<td colspan="3"><strong>用户登录</strong></td>
						</tr>
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" id="username" class="init" onBlur="validateName()"></td>
							<td><span id="usernameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;码：</td>
							<td><input type="text" name="password" id="password" class="init" onBlur="validatePass()"></td>
							<td><span id="passwordMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
						</tr>
						<tr>
							<td colspan="3"><input type="submit" value="登陆"> <input type="reset" value="重置"></td>
						</tr>
					</table>
				</form>
				<h3 style="text-align: center;color: red">${requestScope.errorMsg}</h3>
			</div>
		</div>
		<div id="footer" style="border-right:100px solid white;border-left:100px solid white;">
			<img src="images/footer.jpg" height="60px" width="1100px" />
		</div>
		<div style="border-right:200px solid white;text-align: right;">版权所有&nbsp;www.wangjian.com</div>
	</body>

</html>