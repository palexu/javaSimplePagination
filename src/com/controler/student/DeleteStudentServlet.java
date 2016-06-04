package com.controler.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteStudent.do")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentDao dao = new StudentDao();
		String stu_id=null;
		String message = null;
		try {
			// 将传递来的字符串重新使用utf-8编码，以免产生乱码
			stu_id=request.getParameter("stu_id");
			boolean success = dao.deleteStudent(stu_id);
			if (success) {
				message = "<li>成功删除一条记录！</li>";
			} else {
				message = "<li>删除记录错误！</li>";
			}
		} catch (Exception e) {
			message = "<li>删除记录错误！</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/status.jsp");
		rd.forward(request, response);
	}

}
