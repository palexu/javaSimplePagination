package com.controler.course;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Course;
import com.dao.CourseDao;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/addCourse.do")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		CourseDao dao = new CourseDao();
		Course course = new Course();
		String message = null;
		try {
			course.setId(request.getParameter("id"));
			course.setName(request.getParameter("name"));
			course.setCredit(request.getParameter("credit"));
			course.setCheckType(request.getParameter("checkType"));
			course.setPeriod(request.getParameter("period"));
			boolean success = dao.addCourse(course);
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
