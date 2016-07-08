package com.controler.grade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Grade;
import com.dao.GradeDao;
import com.dao.StudentDao;

/**
 * Servlet implementation class AddGradeServlet
 */
@WebServlet("/addGrade.do")
public class AddGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String couId=request.getParameter("couId");
		String teaId=request.getParameter("teaId");
		String stuId=request.getParameter("stuId");
		String grade=request.getParameter("grade");
		String claId=request.getParameter("claId");
		
		Grade g=new Grade();
		g.setCouId(couId);
		g.setTeaId(teaId);
		g.setStuId(stuId);
		g.setGrade(grade);
		
		GradeDao d=new GradeDao();
		if(d.addGrade(g)){//添加成功，增加学分
			StudentDao s=new StudentDao();
			s.addCredit(stuId, couId);
		}else{
			d.updateGrade(g);
		}
		request.removeAttribute("stuId");
		request.removeAttribute("grade");
		String str="showAddGrade.do?id="+teaId+"&info="+couId+":"+claId;
		System.out.println(str);
		response.sendRedirect(str);
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
