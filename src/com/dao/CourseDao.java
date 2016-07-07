package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
