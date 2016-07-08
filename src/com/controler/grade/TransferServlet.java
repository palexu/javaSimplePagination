package com.controler.grade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Grade;
import com.dao.GradeDao;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/gradeTransfer.do")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stuId=request.getParameter("stuId");
		String couId=request.getParameter("couId");
		String teaId=request.getParameter("teaId");
		
		GradeDao d=new GradeDao();
		Grade g=d.findStudent(teaId, couId, stuId);
		
		HttpSession session=request.getSession();
		session.setAttribute("grade", g);
		response.sendRedirect("teacher/addGrade.jsp");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
