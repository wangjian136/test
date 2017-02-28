package cn.edu.ccut.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccut.factory.ServiceFactory;

@WebServlet(name = "loginservlet", urlPatterns = { "/login.do" })
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (ServiceFactory.getStudentService().login(username, password)) {
				request.getSession().setAttribute("username", username);
				request.getRequestDispatcher("/admin/list/welcome.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMsg", "用户名或密码错误，请重新输入！");
				request.getRequestDispatcher("/admin/login/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
