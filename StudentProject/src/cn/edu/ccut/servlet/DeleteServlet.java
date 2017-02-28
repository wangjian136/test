package cn.edu.ccut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccut.factory.ServiceFactory;

@WebServlet(name = "deleteservlet", urlPatterns = { "/delete.do" })
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			int stuid = Integer.parseInt(id);
			request.setAttribute("path", request.getContextPath());
			if (ServiceFactory.getStudentService().delete(stuid)) {
				request.getRequestDispatcher("page.do?currentPage=1").forward(request, response);
			}
		} catch (Exception e) {
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
