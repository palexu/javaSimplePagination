package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.bean.Course;
import com.bean.Grade;
import com.bean.Student;

/**
 * 
 * @author xj
 *
 */
public class StudentDao extends BaseDao {

	// public int total() {
	// String sql = "select COUNT(*) from students";
	// try (Connection conn = dataSource.getConnection(); Statement st =
	// conn.prepareStatement(sql)) {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// return Integer.parseInt(rs.getString(1));
	// }
	// } catch (SQLException se) {
	// se.printStackTrace();
	// }
	// return -1;
	// }

	// public int total(String searchKey) {
	// String sql = "SELECT count(*)"
	// + " FROM students WHERE stu_id like ? or name like ? or sex like ? or
	// schoolYear like ? or speciality like ? ";
	// try (Connection conn = dataSource.getConnection(); PreparedStatement
	// pstmt = conn.prepareStatement(sql)) {
	// pstmt.setString(1, "%" + searchKey + "%");
	// pstmt.setString(2, "%" + searchKey + "%");
	// pstmt.setString(3, "%" + searchKey + "%");
	// pstmt.setString(4, "%" + searchKey + "%");
	// pstmt.setString(5, "%" + searchKey + "%");
	// try (ResultSet rst = pstmt.executeQuery()) {
	// if (rst.next()) {
	// return Integer.parseInt(rst.getString(1));
	// }
	// }
	// } catch (SQLException se) {
	// se.printStackTrace();
	// return -1;
	// }
	// return -1;
	// }

	public boolean addStudent(Student student) {
		String sql = "INSERT INTO xujy_Students"
				+ "(xjy_id,xjy_name,xjy_gender,xjy_age,xjy_origin,xjy_area,xjy_credit,xjy_claId)VALUES(?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getAge());
			pstmt.setString(5, student.getOrigin());
			pstmt.setString(6, student.getArea());
			pstmt.setString(7, student.getCredit());
			pstmt.setString(8, student.getClaId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// public ArrayList<Student> findByKeyword(String searchKey) {
	//
	// ArrayList<Student> stuList = new ArrayList<Student>();
	// String sql = "SELECT *"
	// + " FROM students WHERE stu_id like ? or name like ? or sex like ? or
	// schoolYear like ? or speciality like ? "
	// ;
	// try (Connection conn = dataSource.getConnection(); PreparedStatement
	// pstmt = conn.prepareStatement(sql)) {
	// pstmt.setString(1, "%" + searchKey + "%");
	// pstmt.setString(2, "%" + searchKey + "%");
	// pstmt.setString(3, "%" + searchKey + "%");
	// pstmt.setString(4, "%" + searchKey + "%");
	// pstmt.setString(5, "%" + searchKey + "%");
	// try (ResultSet rst = pstmt.executeQuery()) {
	// while (rst.next()) {
	// Student student = new Student();
	// student.setId(rst.getString("id"));
	// student.setName(rst.getString("name"));
	// student.setGender(rst.getString("gender"));
	// student.setAge(rst.getString("age"));
	// student.setOrigin(rst.getString("origin"));
	// student.setArea(rst.getString("area"));
	// student.setCredit(rst.getString("credit"));
	// stuList.add(student);
	// }
	// }
	// } catch (SQLException se) {
	// se.printStackTrace();
	// return null;
	// }
	// return stuList;
	// }

	public Student findById(String id) {
		Student student = new Student();
		String sql = "SELECT *" + " FROM xujy_Students WHERE xjy_id = ? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setId(rst.getString("xjy_id"));
					student.setName(rst.getString("xjy_name"));
					student.setGender(rst.getString("xjy_gender"));
					student.setAge(rst.getString("xjy_age"));
					student.setOrigin(rst.getString("xjy_origin"));
					student.setArea(rst.getString("xjy_area"));
					student.setCredit(rst.getString("xjy_credit"));
					student.setClaId(rst.getString("xjy_claId"));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return student;
	}

	public ArrayList<Student> findAllStudent() {
		ArrayList<Student> stuList = new ArrayList<Student>();
		String sql = "SELECT * FROM xujy_Students ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setId(rst.getString("xjy_id"));
				student.setName(rst.getString("xjy_name"));
				student.setGender(rst.getString("xjy_gender"));
				student.setAge(rst.getString("xjy_age"));
				student.setOrigin(rst.getString("xjy_origin"));
				student.setArea(rst.getString("xjy_area"));
				student.setCredit(rst.getString("xjy_credit"));
				student.setClaId(rst.getString("xjy_claId"));
				stuList.add(student);
				System.out.println("find");
			}
			return stuList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteStudent(String id) {
		String sql = "delete from xujy_Students where xjy_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
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
		String sql = "update xujy_Students set xjy_id=?,xjy_name=?,xjy_gender=?,xjy_age=?,xjy_origin=?,xjy_area=?,xjy_credit=?,xjy_claId=?  where xjy_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			Student old = findById(student.getId());

			String Id = student.getId();
			String Name = student.getName().equals(old.getName()) ? old.getName() : student.getName();
			String Gender = student.getGender().equals(old.getGender()) ? old.getGender() : student.getGender();
			String Age = student.getAge().equals(old.getAge()) ? old.getAge() : student.getAge();
			String Origin = student.getOrigin().equals(old.getOrigin()) ? old.getOrigin() : student.getOrigin();
			String Area = student.getArea().equals(old.getArea()) ? old.getArea() : student.getArea();
			String Credit = old.getCredit();
			String ClaId = old.getClaId();

			pstmt.setString(1, Id);
			pstmt.setString(2, Name);
			pstmt.setString(3, Gender);
			pstmt.setString(4, Age);
			pstmt.setString(5, Origin);
			pstmt.setString(6, Area);
			pstmt.setString(7, Credit);
			pstmt.setString(8, ClaId);
			pstmt.setString(9, student.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * select stu.xjy_id stuId,stu.xjy_name stuName,gra.xjy_grade
	 * grade,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name
	 * teaName from xujy_Grades gra,xujy_SchoolTimeTable time,xujy_Students
	 * stu,xujy_Teachers tea,xujy_Courses cou where stu.xjy_id=gra.xjy_stuId and
	 * stu.xjy_claId=time.xjy_claId and gra.xjy_couId=time.xjy_couId and
	 * tea.xjy_id=time.xjy_teaId and cou.xjy_id=time.xjy_couId and
	 * time.xjy_openSchoolTerm='2015' and gra.xjy_stuId='201426810501'
	 * 
	 * 
	 * 
	 * @param id
	 * @param openSchoolTerm
	 * @return
	 */
	public ArrayList<Grade> getGradeList(String id, String openSchoolTerm) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = "select stu.xjy_id stuId,stu.xjy_name stuName,gra.xjy_grade grade,cou.xjy_id  couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName from xujy_Grades gra,xujy_SchoolTimeTable time,xujy_Students stu,xujy_Teachers tea,xujy_Courses cou where stu.xjy_id=gra.xjy_stuId and stu.xjy_claId=time.xjy_claId and gra.xjy_couId=time.xjy_couId and tea.xjy_id=time.xjy_teaId and cou.xjy_id=time.xjy_couId and time.xjy_openSchoolTerm=? and gra.xjy_stuId=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, openSchoolTerm);
			pstmt.setString(2, id);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Grade g = new Grade();
				g.setStuId(rst.getString("stuId"));
				g.setCouId(rst.getString("couId"));
				g.setTeaId(rst.getString("teaId"));
				g.setGrade(rst.getString("grade"));
				g.setTeaName(rst.getString("teaName"));
				g.setStuName(rst.getString("stuName"));
				g.setCouName(rst.getString("couName"));
				list.add(g);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	/**
	 * select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id
	 * couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName from
	 * xujy_SchoolTimeTable time,xujy_Students stu,xujy_Teachers
	 * tea,xujy_Courses cou where stu.xjy_claId=time.xjy_claId and
	 * tea.xjy_id=time.xjy_teaId and cou.xjy_id=time.xjy_couId and
	 * time.xjy_openSchoolTerm='2015' and stu.xjy_id='201426810501'
	 * 
	 * @param id
	 * @param openSchoolTerm
	 * @return
	 */
	public ArrayList<Course> getCourseList(String id, String openSchoolTerm) {
		ArrayList<Course> list = new ArrayList<Course>();
		String sql = "select cou.xjy_credit credit,cou.xjy_period period,cou.xjy_checkType checkType,stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id  couId, cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName from xujy_SchoolTimeTable time,xujy_Students stu,xujy_Teachers tea,xujy_Courses cou where stu.xjy_claId=time.xjy_claId and tea.xjy_id=time.xjy_teaId and cou.xjy_id=time.xjy_couId and time.xjy_openSchoolTerm=? and stu.xjy_id=? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, openSchoolTerm);
			pstmt.setString(2, id);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Course cou = new Course();
				cou.setId(rst.getString("couId"));
				cou.setName(rst.getString("couName"));
				cou.setCredit(rst.getString("credit"));
				cou.setCheckType(rst.getString("checkType"));
				cou.setPeriod(rst.getString("period"));
				cou.setTeaName(rst.getString("teaName"));
				list.add(cou);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}