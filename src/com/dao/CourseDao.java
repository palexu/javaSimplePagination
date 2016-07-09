package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Course;

public class CourseDao extends BaseDao{
	public boolean addCourse(Course course) {
		String sql = "INSERT INTO xujy_Courses" + "(xjy_id,xjy_name,xjy_credit,xjy_checkType,xjy_period)VALUES(?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, course.getId());
			pstmt.setString(2, course.getName());
			pstmt.setString(3, course.getCredit());
			pstmt.setString(4, course.getCheckType());
			pstmt.setString(5, course.getPeriod());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 查询所有学过的课程
	 * @return
	 */
	public ArrayList<Course> getCoursesLearned(String stuId){
		ArrayList<Course> list=new ArrayList<Course>();
		String sql = "select cou.xjy_id couId,cou.xjy_name couName,cou.xjy_credit credit,cou.xjy_checkType checkType,cou.xjy_period period,stu.xjy_credit totalCredit from xujy_Courses as cou,xujy_Students as stu,xujy_Grades as gra where gra.xjy_stuId=stu.xjy_id and gra.xjy_couId=cou.xjy_id and gra.xjy_stuId=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, stuId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Course c=new Course();
				c.setId(rs.getString("couId"));
				c.setName(rs.getString("couName"));
				c.setCredit(rs.getString("credit"));
				c.setCheckType(rs.getString("checkType"));
				c.setPeriod(rs.getString("period"));
				c.setTotalCredit(rs.getString("totalCredit"));
				list.add(c);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return list;
	}
}
