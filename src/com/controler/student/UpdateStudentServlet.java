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
		System.out.println("update");
		if (action.equals("toM")) {
			StudentDao dao = new StudentDao();
			Student student = null;
			String message = null;
			String stu_id=request.getParameter("id");
			try {
				student = dao.findById(stu_id);
				if (student!=null) {
					request.setAttribute("student", student);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/updateStudent.jsp");
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
				student.setId(request.getParameter("id"));
				student.setName(request.getParameter("name"));
				student.setGender(request.getParameter("gender"));
				student.setAge(request.getParameter("age"));
				student.setOrigin(request.getParameter("origin"));
				student.setArea(request.getParameter("area"));
				System.out.println(student.toString());
//				student.setCredit(request.getParameter("credit"));
//				student.setClaId(request.getParameter("claId"));

				boolean success = dao.updateStudent(student);
				if (success) {
					message = "操作成功";
				} else {
					message = "操作失败";
				}
			} catch (Exception e) {
				message = "操作异常";
			}
			request.getSession().setAttribute("user", student);
			request.setAttribute("result", message);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/status.jsp");
			rd.forward(request, response);
		}
	}

}
