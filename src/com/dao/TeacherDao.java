package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Teacher;

public class TeacherDao extends BaseDao{
	public boolean addTeacher(Teacher teacher) {
		String sql = "INSERT INTO xujy_Teachers" + "(xjy_id,xjy_name,xjy_age,xjy_gender,xjy_position,xjy_tel)VALUES(?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getId());
			pstmt.setString(2, teacher.getName());
			pstmt.setString(3, teacher.getAge());
			pstmt.setString(4, teacher.getGender());
			pstmt.setString(5, teacher.getPosition());
			pstmt.setString(6, teacher.getTel());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
