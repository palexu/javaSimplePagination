package com.controler.grade;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Grade;
import com.dao.GradeDao;

/**
 * Servlet implementation class AddGreadServlet
 */
@WebServlet("/showAddGrade.do")
public class ShowAddGreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAddGreadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String teaId=request.getParameter("teaId");
//		String couId=request.getParameter("couId");
		
		String teaId="01";
		String couId="0001";
		
		GradeDao d=new GradeDao();
		ArrayList<Grade> all=d.getList(teaId, couId);
		request.setAttribute("all", all);
		request.getRequestDispatcher("/teacher/showAddGrade.jsp").forward(request, response);
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
