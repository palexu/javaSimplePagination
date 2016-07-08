package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import com.bean.AvgGrade;
import com.bean.Grade;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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
			// se.printStackTrace();
			return false;
		}
	}

	public boolean updateGrade(Grade grade) {
		String sql = "update xujy_Grades set xjy_couId=?,xjy_teaId=?,xjy_grade=? where xjy_stuId=? ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, grade.getCouId());
			pstmt.setString(2, grade.getTeaId());
			pstmt.setString(3, grade.getGrade());
			pstmt.setString(4, grade.getStuId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			// se.printStackTrace();
			return false;
		}
	}

	/**
	 * select AVG(gra.xjy_grade),time.xjy_claId,cou.xjy_name from xujy_Grades as
	 * gra,xujy_SchoolTimeTable as time,xujy_Students as stu,xujy_Courses cou
	 * where time.xjy_claId=stu.xjy_claId and time.xjy_couId=gra.xjy_couId and
	 * gra.xjy_stuId=stu.xjy_id and time.xjy_couId=cou.xjy_id and
	 * time.xjy_teaId='01' Group by time.xjy_claId
	 * 
	 * @param teaId
	 * @return
	 */
	public ArrayList<AvgGrade> getClassAvgGrade(String teaId) {
		ArrayList<AvgGrade> list = new ArrayList<AvgGrade>();
		String sql = "select AVG(gra.xjy_grade) avgGrade,time.xjy_claId claId,cou.xjy_name couName from xujy_Grades as gra,xujy_SchoolTimeTable as time,xujy_Students as stu,xujy_Courses cou where time.xjy_claId=stu.xjy_claId and time.xjy_couId=gra.xjy_couId and gra.xjy_stuId=stu.xjy_id and time.xjy_couId=cou.xjy_id and time.xjy_teaId=? Group by time.xjy_claId,time.xjy_couId ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AvgGrade g = new AvgGrade();
				g.setClaId(rs.getString("claId"));
				g.setCouName(rs.getString("couName"));
				g.setAvgGrade(rs.getString("avgGrade"));
				list.add(g);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return list;
	}

	/**
	 * 虽然是findAllStudents，但是只需要找到该教师的学生就可以 取出所有学生（有些可能已有成绩） 然后 和已有成绩的学生合并 list
	 * 
	 * 
	 * select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id
	 * couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName,0 grade
	 * from xujy_SchoolTimeTable as time, xujy_Students as stu, xujy_Teachers as
	 * tea, xujy_Courses as cou where stu.xjy_claId=time.xjy_claId and
	 * tea.xjy_id=time.xjy_teaId and cou.xjy_id=time.xjy_couId and
	 * time.xjy_teaId='01' and time.xjy_couId='0001'
	 * 
	 * 
	 * @return
	 */
	public ArrayList<Grade> findAllStudents(String teaId, String couId) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = " select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id "
				+ " teaId,tea.xjy_name teaName,0 grade "
				+ " from xujy_SchoolTimeTable as time,xujy_Students as stu,xujy_Teachers as tea,xujy_Courses as cou "
				+ " where stu.xjy_claId=time.xjy_claId " + " and   tea.xjy_id=time.xjy_teaId "
				+ " and   cou.xjy_id=time.xjy_couId " + " and   time.xjy_teaId=?	" + " and   time.xjy_couId=? ";// 取出该老师该课程的学生成绩信息,并组合后放置到grade中
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade g = new Grade();
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
	
	public ArrayList<Grade> findAllStudents(String teaId, String couId,String claId) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = " select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id "
				+ " teaId,tea.xjy_name teaName,0 grade "
				+ " from xujy_SchoolTimeTable as time,xujy_Students as stu,xujy_Teachers as tea,xujy_Courses as cou "
				+ " where stu.xjy_claId=time.xjy_claId " + " and   tea.xjy_id=time.xjy_teaId "
				+ " and   cou.xjy_id=time.xjy_couId " + " and   time.xjy_teaId=?	" + " and   time.xjy_couId=? and time.xjy_claId=?";// 取出该老师该课程的学生成绩信息,并组合后放置到grade中
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			pstmt.setString(3, claId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade g = new Grade();
				g.setStuId(rs.getString("stuId"));
				g.setCouId(rs.getString("couId"));
				g.setTeaId(rs.getString("teaId"));
				g.setGrade(rs.getString("grade"));
				g.setTeaName(rs.getString("teaName"));
				g.setStuName(rs.getString("stuName"));
				g.setCouName(rs.getString("couName"));
				g.setClaId(claId);
				list.add(g);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return list;
	}

	public Grade findStudent(String teaId, String couId, String stuId) {
		Grade g = new Grade();
		String sql = " select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id "
				+ " teaId,tea.xjy_name teaName,0 grade "
				+ " from xujy_SchoolTimeTable as time,xujy_Students as stu,xujy_Teachers as tea,xujy_Courses as cou "
				+ " where stu.xjy_claId=time.xjy_claId " + " and   tea.xjy_id=time.xjy_teaId "
				+ " and   cou.xjy_id=time.xjy_couId " + " and   time.xjy_teaId=?	"
				+ " and   time.xjy_couId=? and stu.xjy_id=?";// 取出该老师该课程的学生成绩信息,并组合后放置到grade中
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			pstmt.setString(3, stuId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				g.setStuId(rs.getString("stuId"));
				g.setCouId(rs.getString("couId"));
				g.setTeaId(rs.getString("teaId"));
				g.setGrade(rs.getString("grade"));
				g.setTeaName(rs.getString("teaName"));
				g.setStuName(rs.getString("stuName"));
				g.setCouName(rs.getString("couName"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return g;
	}

	/**
	 * 找到已有成绩的学生
	 * 
	 * select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id
	 * couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name
	 * teaName,gra.xjy_grade grade from xujy_Grades as gra,xujy_Teachers as
	 * tea,xujy_Courses as cou,xujy_Students as stu where
	 * gra.xjy_stuId=stu.xjy_id and gra.xjy_teaId=tea.xjy_id and
	 * gra.xjy_couId=cou.xjy_id and gra.xjy_teaId='01' and gra.xjy_couId='0001'
	 * 
	 * @param teaId
	 * @param couId
	 * @return
	 */
	public ArrayList<Grade> findStudentsHasGrade(String teaId, String couId) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = "select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName,gra.xjy_grade grade from xujy_Grades as gra,xujy_Teachers as tea,xujy_Courses as cou,xujy_Students as stu where gra.xjy_stuId=stu.xjy_id and gra.xjy_teaId=tea.xjy_id and gra.xjy_couId=cou.xjy_id and gra.xjy_teaId=? and gra.xjy_couId=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade g = new Grade();
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
	
	public ArrayList<Grade> findStudentsHasGrade(String teaId, String couId,String claId) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = "select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName,gra.xjy_grade grade from xujy_Grades as gra,xujy_Teachers as tea,xujy_Courses as cou,xujy_Students as stu where gra.xjy_stuId=stu.xjy_id and gra.xjy_teaId=tea.xjy_id and gra.xjy_couId=cou.xjy_id and gra.xjy_teaId=? and gra.xjy_couId=? and stu.xjy_claId=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			pstmt.setString(3, claId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade g = new Grade();
				g.setStuId(rs.getString("stuId"));
				g.setCouId(rs.getString("couId"));
				g.setTeaId(rs.getString("teaId"));
				g.setGrade(rs.getString("grade"));
				g.setTeaName(rs.getString("teaName"));
				g.setStuName(rs.getString("stuName"));
				g.setCouName(rs.getString("couName"));
				g.setClaId(claId);
				list.add(g);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return list;
	}

	/**
	 * 算法待优化 合并两个list
	 * 
	 * @param teaId
	 * @param couId
	 * @return
	 */
	public ArrayList<Grade> getList(String teaId, String couId) {
		ArrayList<Grade> all = findAllStudents(teaId, couId);
		ArrayList<Grade> has = findStudentsHasGrade(teaId, couId);
		for (int i = 0; i < has.size(); i++) {
			all.add(has.get(i));
		}
		all.sort(new CustomComparator());
		for (int i = 0; i < all.size() - 1; i++) {
			for (int j = all.size() - 1; j > i; j--) {
				if (all.get(j).getStuId().equals(all.get(i).getStuId())) {
					all.remove(i);
				}
			}
		}
		return all;
	}
	
	public ArrayList<Grade> getList(String teaId, String couId,String claId) {
		ArrayList<Grade> all = findAllStudents(teaId, couId,claId);
		ArrayList<Grade> has = findStudentsHasGrade(teaId,couId,claId);
		for (int i = 0; i < has.size(); i++) {
			all.add(has.get(i));
		}
		all.sort(new CustomComparator());
		for (int i = 0; i < all.size() - 1; i++) {
			for (int j = all.size() - 1; j > i; j--) {
				if (all.get(j).getStuId().equals(all.get(i).getStuId())) {
					all.remove(i);
				}
			}
		}
		return all;
	}
	
	public ArrayList<Grade> findStudentsHasGradeAsc(String teaId, String couId) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = "select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName,gra.xjy_grade grade from xujy_Grades as gra,xujy_Teachers as tea,xujy_Courses as cou,xujy_Students as stu where gra.xjy_stuId=stu.xjy_id and gra.xjy_teaId=tea.xjy_id and gra.xjy_couId=cou.xjy_id and gra.xjy_teaId=? and gra.xjy_couId=? order by grade desc";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade g = new Grade();
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
	
	public ArrayList<Grade> findStudentsHasGradeAsc(String teaId, String couId,String claId) {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String sql = "select stu.xjy_id stuId,stu.xjy_name stuName,cou.xjy_id couId,cou.xjy_name couName,tea.xjy_id teaId,tea.xjy_name teaName,gra.xjy_grade grade from xujy_Grades as gra,xujy_Teachers as tea,xujy_Courses as cou,xujy_Students as stu where gra.xjy_stuId=stu.xjy_id and gra.xjy_teaId=tea.xjy_id and gra.xjy_couId=cou.xjy_id and gra.xjy_teaId=? and gra.xjy_couId=? and stu.xjy_claId=? order by grade desc";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teaId);
			pstmt.setString(2, couId);
			pstmt.setString(3, claId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade g = new Grade();
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

	public class CustomComparator implements Comparator<Grade> {
		@Override
		public int compare(Grade o1, Grade o2) {
			return o1.getStuId().compareTo(o2.getStuId());
		}
	}
}
