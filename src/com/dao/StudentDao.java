package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.bean.Student;

public class StudentDao extends BaseDao {
	// 分页限制
	private String limitStart = "0";
	private String limitNum = "20";
	private String sqlLimit = " limit 0,20";
	private String orderBy = " order by stu_id ASC ";

	public void setSqlLimit(String start, String num) {
		sqlLimit = " limit " + start + "," + num;
	}

	public void setLimitStart(String start) {
		sqlLimit = " limit " + start + "," + limitNum;
	}

	public void setLimitNum(String num) {
		sqlLimit = " limit " + limitStart + "," + num;
	}

	public String getLimitStart() {
		return limitStart;
	}

	public String getLimitNum() {
		return limitNum;
	}

	public int total() {
		String sql = "select COUNT(*) from students";
		try (Connection conn = dataSource.getConnection(); Statement st = conn.prepareStatement(sql)) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return -1;
	}

	public int total(String searchKey) {
		String sql = "SELECT count(*)"
				+ " FROM students WHERE stu_id like ? or name like ? or sex like ? or schoolYear like ? or speciality like ? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + searchKey + "%");
			pstmt.setString(2, "%" + searchKey + "%");
			pstmt.setString(3, "%" + searchKey + "%");
			pstmt.setString(4, "%" + searchKey + "%");
			pstmt.setString(5, "%" + searchKey + "%");
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					return Integer.parseInt(rst.getString(1));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		}
		return -1;
	}

	// 插入一条客户记录
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO students" + "(stu_id,name,sex,speciality,schoolYear,tel,email)VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getStu_id());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getSpeciality());
			pstmt.setString(5, student.getSchoolYear());
			pstmt.setString(6, student.getTel());
			pstmt.setString(7, student.getEmail());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 按姓名检索客户记录，模糊查询
	public ArrayList<Student> findByKeyword(String searchKey) {

		ArrayList<Student> stuList = new ArrayList<Student>();
		String sql = "SELECT *"
				+ " FROM students WHERE stu_id like ? or name like ? or sex like ? or schoolYear like ? or speciality like ? "
				+ orderBy + sqlLimit;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + searchKey + "%");
			pstmt.setString(2, "%" + searchKey + "%");
			pstmt.setString(3, "%" + searchKey + "%");
			pstmt.setString(4, "%" + searchKey + "%");
			pstmt.setString(5, "%" + searchKey + "%");
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Student student = new Student();
					student.setStu_id(rst.getString("stu_id"));
					student.setName(rst.getString("name"));
					student.setSex(rst.getString("sex"));
					student.setSpeciality(rst.getString("speciality"));
					student.setSchoolYear(rst.getString("schoolYear"));
					student.setEmail(rst.getString("email"));
					student.setTel(rst.getString("tel"));
					stuList.add(student);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return stuList;
	}

	public Student findById(String stu_id) {
		Student student = new Student();
		String sql = "SELECT *" + " FROM students WHERE stu_id = ? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, stu_id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setStu_id(rst.getString("stu_id"));
					student.setName(rst.getString("name"));
					student.setSex(rst.getString("sex"));
					student.setSpeciality(rst.getString("speciality"));
					student.setSchoolYear(rst.getString("schoolYear"));
					student.setEmail(rst.getString("email"));
					student.setTel(rst.getString("tel"));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return student;
	}

	// 查询所有客户信息
	public ArrayList<Student> findAllStudent() {
		ArrayList<Student> stuList = new ArrayList<Student>();
		String sql = "SELECT * FROM students " + orderBy + sqlLimit;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setStu_id(rst.getString("stu_id"));
				student.setName(rst.getString("name"));
				student.setSex(rst.getString("sex"));
				student.setSpeciality(rst.getString("speciality"));
				student.setSchoolYear(rst.getString("schoolYear"));
				student.setEmail(rst.getString("email"));
				student.setTel(rst.getString("tel"));
				stuList.add(student);
			}
			return stuList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteStudent(String custName) {
		String sql = "delete from students where stu_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, custName);
			if (pstmt.executeUpdate() == 1)
				return true;
			else
				return false;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public boolean updateStudent(Student student) {
		String sql = "update students set stu_id=? ,name=? ,sex=? ,speciality=?,schoolYear=?, tel=?,email=?  where stu_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getStu_id());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getSpeciality());
			pstmt.setString(5, student.getSchoolYear());
			pstmt.setString(6, student.getTel());
			pstmt.setString(7, student.getEmail());
			pstmt.setString(8, student.getStu_id());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

}