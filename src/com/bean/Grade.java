package com.bean;

public class Grade {
	String stuId;
	String couId;
	String teaId;
	
	String grade;
	
	String teaName;
	String stuName;
	String couName;
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCouId() {
		return couId;
	}
	public void setCouId(String couId) {
		this.couId = couId;
	}
	public String getCouName() {
		return couName;
	}
	public void setCouName(String couName) {
		this.couName = couName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTeaId() {
		return teaId;
	}
	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	@Override
	public String toString() {
		return "Grade [stuId=" + stuId + ", couId=" + couId + ", teaId=" + teaId + ", grade=" + grade + ", teaName="
				+ teaName + ", stuName=" + stuName + ", couName=" + couName + "]";
	}
	
}
