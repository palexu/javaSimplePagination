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
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addStudent.do")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
			student.setCredit(request.getParameter("credit"));
			boolean success = dao.addStudent(student);
			if (success) {
				message = "成功";
				
			} else {
				message = "失败";
			}
		} catch (Exception e) {
			message = "异常";
		}
		finally{
			request.setAttribute("result", message);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/status.jsp");
			rd.forward(request, response);
		}
	}

}
