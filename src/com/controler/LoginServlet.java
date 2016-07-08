package com.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.bean.Student;
import com.bean.Teacher;
import com.dao.AdminDao;
import com.dao.BaseDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userType = request.getParameter("userType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (userType.equals("student")) {
			StudentDao d = new StudentDao();
			Student stu = d.login(username, password);
			if (stu == null) {
				response.sendRedirect("error.html");
				return;
			} else {
				request.getSession().setAttribute("user", stu);
				response.sendRedirect("student/studentManager.jsp");
				return;
			}
		}else if (userType.equals("teacher")) {
			TeacherDao d = new TeacherDao();
			Teacher t = d.login(username, password);
			if (t == null) {
				response.sendRedirect("error.html");
				return;
			} else {
				request.getSession().setAttribute("user", t);
				response.sendRedirect("teacher/teacherManager");
				return;
			}
		}else if (userType.equals("admin")) {
			AdminDao d = new AdminDao();
			Admin a = d.login(username, password);
			if (a == null) {
				response.sendRedirect("error.html");
				return;
			} else {
				request.getSession().setAttribute("user", a);
				response.sendRedirect("admin/adminManager.jsp");
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
