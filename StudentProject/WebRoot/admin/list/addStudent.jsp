<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("path", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>index</title>
		<base href="${requestScope.path}">
		<script type="text/javascript" src="js/student.js"></script>
	</head>

	<body>
		<div style="border-left:100px solid white;text-align: left;">欢迎使用学生信息管理系统^_^</div>
		<div id="header" style="border-right:100px solid white;border-left:100px solid white;">
			<img src="images/header.jpg" height="60px" width="1100px" />
		</div>
		<div style="border-left:100px solid white;height: 20px;width: 1100px;text-align: right;background-color: aqua;">
			欢迎${sessionScope.username}用户,
			<a href="${path}/admin/login/logout.jsp">注销</a>
		</div>
		<div id="content" style="border-left:100px solid white;background-color:#FFD700;height:430px;width:200px;float:left;">
			<ul>
				<li>
					<a href="page.do">首页</a>
				</li>
				<li>
					<a href="admin/list/addStudent.jsp">增加学生</a>
				</li>
				<li>
					<a href="first.html">身份验证</a>
				</li>
				<li>
					<a href="first.html">信息发布</a>
				</li>
			</ul>
		</div>
		<div id="index" style="background-color: royalblue;height:430px;width:900px;float:left;">
			<h1 style="text-align: center;">添加学生</h1>
			<form action="create.do" method="post">
				<fieldset>
					<legend>学生信息录入</legend>
					学号：<input type="text" name="id" pattern="\d*" title="该项仅为数字！" required /><br /> 姓名：<input type="text" name="name" required /><br /> 性别：
					<input type="radio" name="sex" value="男" checked />男 <input type="radio" name="sex" value="女" />女<br /> 年龄：<input type="text" name="age" pattern="\d{2}" title="该项为2位数字！" required /><br /> 电话：<input type="text" name="tel" pattern="\d{11}" title="该项为11位数字！" required /><br /> 住址：
					<input type="text" name="loc" required /><br /> <input type="submit" value="提交" /> <input type="reset" value="重置" />
				</fieldset>
			</form>
		</div>
		<div id="footer" style="border-right:100px solid white;border-left:100px solid white;">
			<img src="images/footer.jpg" height="60px" width="1100px" />
		</div>
		<div style="border-right:200px solid white;text-align: right;">版权所有&nbsp;www.wangjian.com</div>
	</body>

</html>