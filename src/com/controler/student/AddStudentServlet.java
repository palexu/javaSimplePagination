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
			student.setStu_id(request.getParameter("stu_id"));
   	    	student.setName(request.getParameter("name"));
   	    	student.setSex(request.getParameter("sex"));
   	    	student.setSpeciality(request.getParameter("speciality"));
   	    	student.setSchoolYear(request.getParameter("schoolYear"));
   	    	student.setEmail(request.getParameter("email"));
   	    	student.setTel(request.getParameter("tel"));
			boolean success = dao.addStudent(student);
			if (success) {
				message = "<li>成功插入一条记录！</li>";
				
			} else {
				message = "<li>插入记录错误！</li>";
			}
		} catch (Exception e) {
			message = "<li>插入记录错误！</li>";
		}
		finally{
			request.setAttribute("result", message);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/status.jsp");
			rd.forward(request, response);
		}
	}

}
