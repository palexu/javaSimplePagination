package com.controler.grade;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Grade;
import com.bean.Teacher;
import com.dao.GradeDao;

/**
 * Servlet implementation class GetGradeOrderBy
 */
@WebServlet("/getGradeOrderBy.do")
public class ShowGradeAscServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGradeAscServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher t = (Teacher) request.getSession().getAttribute("user");
		String teaId = t.getId();
		String couId = request.getParameter("couId");
		
		GradeDao d=new GradeDao();
		ArrayList<Grade> all=d.findStudentsHasGradeAsc(teaId, couId);
		request.setAttribute("all", all);
		request.getRequestDispatcher("/student/showGradeOrderBy.jsp").forward(request, response);
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
