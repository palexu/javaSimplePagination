package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Student;

public class SqlDao extends BaseDao{
	
	//  学生成绩按每学年成绩统计
	public ArrayList<Student> getStudentGradeOrderByYear(){
		String sql = "update xujy_Students set xjy_id=?,xjy_name=?,xjy_gender=?,xjy_age=?,xjy_origin=?,xjy_area=?,xjy_credit=?  where xjy_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getAge());
			pstmt.setString(5, student.getOrigin());
			pstmt.setString(6, student.getArea());
			pstmt.setString(7, student.getCredit());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	//  学生成绩名次排定
	public ArrayList<Student> getStudentOrderByGrade(){
		String sql = "update xujy_Students set xjy_id=?,xjy_name=?,xjy_gender=?,xjy_age=?,xjy_origin=?,xjy_area=?,xjy_credit=?  where xjy_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getAge());
			pstmt.setString(5, student.getOrigin());
			pstmt.setString(6, student.getArea());
			pstmt.setString(7, student.getCredit());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	//	每门课程平均成绩统计
	//	学生所学课程及学分统计
	//	对每个学生输入成绩的时候，自动生成学生的已修学分总数
	//	学生成绩查询
	//	教师任课查询
	//	班级课程开设查询

	
}
