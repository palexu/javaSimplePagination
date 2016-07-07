package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Grade;

public class GradeDao extends BaseDao {
	/**
	 * 对每个学生输入成绩，并自动生成学生的已修学分总数 记得在对话框里提示“已自动添加学分”
	 * 
	 * @param stuId
	 * @param claId
	 * @return
	 */
	public boolean addGrade(Grade grade) {
		String sql = "insert into xujy_Grades values(?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, grade.getStuId());
			pstmt.setString(2, grade.getCouId());
			pstmt.setString(3, grade.getGrade());
			pstmt.setString(4, grade.getTeaId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * 虽然是findAllStudents，但是只需要找到该教师的学生就可以
	 * 取出所有学生（有些可能已有成绩） 然后 和已有成绩的学生合并
	 * list 存放无成绩的gradeBean，然后和有成绩的比较，替换为有成绩的
	 * 
	 * select
	 * stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName,0 grade
	 * from 
		 * xujy_SchoolTimeTable as time,
		 * xujy_Students as stu,
		 * xujy_Teachers as tea,
		 * xujy_Courses as cou 
	 * where 
		 * stu.xjy_claId=time.xjy_claId 
		 * and tea.xjy_id=time.xjy_teaId 
		 * and cou.xjy_id=time.xjy_couId 
		 * and time.xjy_teaId='01'
		 * and time.xjy_couId='0001'
	 * 
	 * @return
	 */
	public ArrayList<Grade> findAllStudents(String teaId, String couId) {
		ArrayList<Grade> list =new ArrayList<Grade>();
		String sql = "select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id "+"teaId,tea.xjy_name teaName,0 grade"
				+"from xujy_SchoolTimeTable as time,xujy_Students as stu,xujy_Teachers as tea,xujy_Courses as cou"
				+"where stu.xjy_claId=time.xjy_claId"
				+"and   tea.xjy_id=time.xjy_teaId"
				+"and   cou.xjy_id=time.xjy_couId"
				+"and   time.xjy_teaId=?	"
				+"and   time.xjy_couId=?";// 取出该老师该课程的学生成绩信息,并组合后放置到grade中
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Grade g=new Grade();
				g.setStuId(rs.getString("stuId"));
				g.setCouId(rs.getString("couId"));
				g.setTeaId(rs.getString("teaId"));
				g.setGrade(rs.getString("grade"));
				g.setTeaName(rs.getString("teaName"));
				g.setStuName(rs.getString("stuName"));
				g.setCouName(rs.getString("couName"));
				list.add(g);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return list;
	}
}
