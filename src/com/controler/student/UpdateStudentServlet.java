package com.controler.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.StudentDao;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent.do")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentServlet() {
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("q");
		
		if (action.equals("toM")) {
			StudentDao dao = new StudentDao();
			Student student = null;
			String message = null;
			String stu_id=request.getParameter("stu_id");
			try {
				student = dao.findById(stu_id);
				if (student!=null) {
					request.setAttribute("student", student);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateStudent.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", message);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		

		} else if (action.equals("m")) {
			StudentDao dao = new StudentDao();
			Student student = new Student();
			String message = null;
			try {
				student.setStu_id(request.getParameter("stu_id"));
				student.setName(request.getParameter("name"));
				student.setSex(request.getParameter("sex"));
				student.setSpeciality(request.getParameter("speciality"));
				student.setSchoolYear(request.getParameter("schoolYear"));
				student.setEmail(request.getParameter("email"));
				student.setTel(request.getParameter("tel"));
				boolean success = dao.updateStudent(student);
				if (success) {
					message = "<li>成功修改一条记录！</li>";
				} else {
					message = "<li>修改记录错误！</li>";
				}
			} catch (Exception e) {
				message = "<li>修改记录错误！</li>";
			}
			request.setAttribute("result", message);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/status.jsp");
			rd.forward(request, response);
		}
	}

}
