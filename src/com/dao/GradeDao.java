package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Grade;

public class GradeDao extends BaseDao{
	/**
	 * 对每个学生输入成绩，并自动生成学生的已修学分总数
	 * 记得在对话框里提示“已自动添加学分”
	 * @param stuId
	 * @param claId
	 * @return
	 */
	public boolean addGrade(Grade grade){
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
	 * @return
	 */
	public ArrayList<Grade> findAllStudents(String teaId){
		String sql = "select ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(4, grade.getTeaId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		
	}
}
