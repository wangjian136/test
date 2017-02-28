package cn.edu.ccut.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccut.factory.ServiceFactory;

@WebServlet(name = "bandeleteservlet", urlPatterns = { "/banDelete.do" })
@SuppressWarnings("serial")
public class BanDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTf-8");
			response.setCharacterEncoding("UTf-8");
			Set<Integer> all = new HashSet<Integer>();
			String[] ids = request.getParameterValues("id");
			for (int i = 0; i < ids.length; i++) {
				all.add(Integer.parseInt(ids[i]));
			}
			if (ServiceFactory.getStudentService().bantchDelete(all)) {
				request.getRequestDispatcher("page.do?currentPage=1").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
