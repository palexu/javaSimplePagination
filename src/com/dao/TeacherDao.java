package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Course;
import com.bean.Student;
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
	
	public ArrayList<Course> getCourseList(String id, String openSchoolTerm) {
		ArrayList<Course> list = new ArrayList<Course>();
		String sql = "select time.xjy_claId claId,time.xjy_couId couId,time.xjy_openSchoolTerm openSchoolTerm, cou.xjy_name couName,cou.xjy_period period,xjy_checkType checkType,xjy_credit credit from xujy_SchoolTimeTable time,xujy_Courses cou where cou.xjy_id=time.xjy_couId and time.xjy_openSchoolTerm=? and time.xjy_teaId=? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, openSchoolTerm);
			pstmt.setString(2, id);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Course cou = new Course();
				cou.setClaId(rst.getString("claId"));
				cou.setId(rst.getString("couId"));
				cou.setName(rst.getString("couName"));
				cou.setCredit(rst.getString("credit"));
				cou.setCheckType(rst.getString("checkType"));
				cou.setPeriod(rst.getString("period"));
				list.add(cou);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	public Teacher findById(String id) {
		Teacher tea = new Teacher();
		String sql = "SELECT *" + " FROM xujy_Teachers WHERE xjy_id = ? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					tea.setId(rst.getString("xjy_id"));
					tea.setName(rst.getString("xjy_name"));
					tea.setAge(rst.getString("xjy_age"));
					tea.setGender(rst.getString("xjy_gender"));
					tea.setPosition(rst.getString("xjy_position"));
					tea.setTel(rst.getString("xjy_tel"));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return tea;
	}
	
	public Teacher login(String id,String password){
		String sql = "select * from xujy_Teachers where xjy_id=? and password=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				return findById(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
