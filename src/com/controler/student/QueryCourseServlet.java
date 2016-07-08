package com.controler.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

/**
 * Servlet implementation class QueryCourseServlet
 */
@WebServlet("/QueryCourseServlet")
public class QueryCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String stuId=request.getParameter("stuId");
//		String openSchoolTerm=request.getParameter("openSchoolTerm");
		String stuId="201426810501";
		String openSchoolTerm="2015";
		StudentDao d=new StudentDao();
		request.setAttribute("list", d.getCourseList(stuId, openSchoolTerm));
		request.getRequestDispatcher("student/course.jsp").forward(request,response);
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
