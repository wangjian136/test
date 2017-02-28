package cn.edu.ccut.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccut.factory.ServiceFactory;
import cn.edu.ccut.vo.Student;

@WebServlet(name = "pageservlet", urlPatterns = { "/page.do" })
@SuppressWarnings("serial")
public class PageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String currentPage = request.getParameter("currentPage");
			if (currentPage == null || "".equals(currentPage)) {
				currentPage = "1";
			}
			int currPage = Integer.parseInt(currentPage);
			if (currPage <= 0) {
				currPage = 1;
			}
			List<Student> all = new ArrayList<Student>();
			all = ServiceFactory.getStudentService().listAll(currPage, 10);
			request.setAttribute("all", all);
			request.setAttribute("currentPage", currPage);
			request.getRequestDispatcher("/admin/list/first.jsp").forward(request, response);
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
