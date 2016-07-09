package com.controler.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.CourseDao;
import com.dao.StudentDao;

/**
 * Servlet implementation class QueryCoursesLearnedServlet
 */
@WebServlet("/coursesLearned")
public class QueryCoursesLearnedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCoursesLearnedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student stu=(Student) request.getSession().getAttribute("user");
		String stuId=stu.getId();
//		String openSchoolTerm=request.getParameter("openSchoolTerm");
//		String stuId="201426810501";
//		String openSchoolTerm="2015";
		CourseDao d=new CourseDao();
		request.setAttribute("list", d.getCoursesLearned(stuId));
		StudentDao s=new StudentDao();
		request.setAttribute("totalCredit", s.getCredit(stuId));
		request.getRequestDispatcher("student/coursesLearned.jsp").forward(request,response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
