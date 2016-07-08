package com.controler.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.TeacherDao;

/**
 * Servlet implementation class GetTeacherCourse
 */
@WebServlet("/GetTeacherCourse")
public class GetTeacherCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTeacherCourse() {
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
		String teaId="01";
		String openSchoolTerm="2015";
		TeacherDao d=new TeacherDao();
		request.setAttribute("list", d.getCourseList(teaId, openSchoolTerm));
		request.getRequestDispatcher("teacher/course.jsp").forward(request,response);
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
