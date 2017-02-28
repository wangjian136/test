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
			<a href="admin/login/logout.jsp">注销</a>
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
			<h1 style="text-align: center;">学生信息管理</h1>
			<form action="banDelete.do" method="post" onsubmit="return banchConfirm('id')">
				<table border="1" style="width:900px;">
					<tr>
						<td><input type="checkbox" id="allStudent" onclick="selectAll('allStudent','id')">全选</td>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>电话</th>
						<th>住址</th>
						<th colspan="2">操作</th>
					</tr>
					<c:forEach items="${all }" var="obj" end="9">
						<tr>
							<td><input type="checkbox" id="id" name="id" value="${obj.id}"></td>
							<td>${obj.id}</td>
							<td>${obj.name}</td>
							<td>${obj.sex}</td>
							<td>${obj.age}</td>
							<td>${obj.tel}</td>
							<td>${obj.loc}</td>
							<td>
								<a href="admin/list/updateStudent.jsp?id=${obj.id}&name=${obj.name}&sex=${obj.sex}&age=${obj.age}&tel=${obj.tel}&loc=${obj.loc}">修改</a>
							</td>
							<td>
								<a href="delete.do?id=${obj.id}" onclick="return fun();">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div style="float:left">
					<a href="page.do?currentPage=1">首页</a>&nbsp;&nbsp;
					<a href="page.do?currentPage=${currentPage-1}">上一页</a>&nbsp;&nbsp;
					<a href="page.do?currentPage=${currentPage+1}">下一页</a>
				</div>
				<div style="float: right;">
					<input type="submit" value="批量删除" />
				</div>
			</form>
			<div style="float:left">
				<form action="page.do" method="post">
					<input type="text" name="currentPage" maxlength="2" size="2">
					<input type="submit" value="GO">当前页码：${currentPage }
				</form>
			</div>
		</div>
		<div id="footer" style="border-right:100px solid white;border-left:100px solid white;">
			<img src="images/footer.jpg" height="60px" width="1100px" />
		</div>
		<div style="border-right:200px solid white;text-align: right;">版权所有&nbsp;www.wangjian.com</div>
	</body>

</html>