//package com.controler.student;
//
//import java.io.IOException;
//
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.bean.Student;
//import com.dao.StudentDao;
//import com.page.*;
//
///**
// * Servlet implementation class FindStudentServlet
// */
//@WebServlet("/findStudent.do")
//public class FindStudentServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FindStudentServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doPost(request,response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		StudentDao dao = new StudentDao();
//		ArrayList<Student> stuList=new ArrayList<Student>();
//		
//		String searchKey=null;
//		String message = null;
//		String limitStart=null;
//		String limitNum=null;
//		Pagination page=null;
//		
//		
//		
//		try {
//			limitStart=request.getParameter("ps");
//			limitNum=request.getParameter("pn");
//			if(limitStart==null)
//				limitStart=dao.getLimitStart();
//			if(limitNum==null)
//				limitNum="10";//dao.getLimitNum();
//			
//			
//			dao.setSqlLimit(limitStart, limitNum);
//			
//			searchKey=request.getParameter("search");
//			if(searchKey==null){	
//				page=new Pagination(dao.total(),Integer.parseInt(limitStart),Integer.parseInt(limitNum));
//				stuList=dao.findAllStudent();
//			}
//			else{
//				page=new Pagination(dao.total(searchKey),Integer.parseInt(limitStart),Integer.parseInt(limitNum));
//				stuList = dao.findByKeyword(searchKey);
//				System.out.println(limitStart);
//				System.out.println(searchKey);
//				System.out.println(dao.total(searchKey));
//				System.out.println(page.toString());
//			}
//			
//			if (!stuList.isEmpty()) {
//				message = "<li>�����ɹ���</li>";
//			} else {
//				System.out.println("wujilu");
//				message = "<li>�޼�¼</li>";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			message = "<li>��ѯ��¼����</li>";
//		}
//		finally{
//			request.setAttribute("result", message);
//			request.setAttribute("stuList", stuList);
//			request.setAttribute("page", page);
//			request.setAttribute("searchKey",searchKey);
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/student.jsp");
//			rd.forward(request, response);
//		}
//	}
//
//}
