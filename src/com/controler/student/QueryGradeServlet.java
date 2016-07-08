package com.controler.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

/**
 * Servlet implementation class QueryGradeServlet
 */
@WebServlet("/queryStudentGrade.do")
public class QueryGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String stuId=request.getParameter("id");
//		String openSchoolTerm=request.getParameter("openSchoolTerm");
		String stuId="201426810501";
		String openSchoolTerm="2015";
		
		StudentDao s=new StudentDao();
		request.setAttribute("list",s.getGradeList(stuId, openSchoolTerm));
		request.getRequestDispatcher("student/grade.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
