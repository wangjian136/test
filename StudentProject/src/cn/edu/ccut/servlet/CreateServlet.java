package cn.edu.ccut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccut.factory.ServiceFactory;
import cn.edu.ccut.vo.Student;

@WebServlet(name = "createservlet", urlPatterns = { "/create.do" })
@SuppressWarnings("serial")
public class CreateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTf-8");
			response.setCharacterEncoding("UTf-8");
			Student vo = new Student();
			vo.setId(Integer.parseInt(request.getParameter("id")));
			vo.setName(request.getParameter("name"));
			vo.setSex(request.getParameter("sex"));
			vo.setAge(Integer.parseInt(request.getParameter("age")));
			vo.setTel(request.getParameter("tel"));
			vo.setLoc(request.getParameter("loc"));
			if (ServiceFactory.getStudentService().insert(vo)) {
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
