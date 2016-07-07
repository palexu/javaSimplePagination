package com.controler.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Teacher;
import com.dao.TeacherDao;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/addTeacher.do")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		TeacherDao dao = new TeacherDao();
		Teacher teacjer = new Teacher();
		String message = null;
		try {
			teacjer.setId(request.getParameter("id"));
			teacjer.setName(request.getParameter("name"));
			teacjer.setAge(request.getParameter("age"));
			teacjer.setGender(request.getParameter("gender"));
			teacjer.setPosition(request.getParameter("position"));
			teacjer.setTel(request.getParameter("tel"));
			boolean success = dao.addTeacher(teacjer);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
