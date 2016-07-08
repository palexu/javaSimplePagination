package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;

public class AdminDao extends BaseDao{
	public Admin login(String name,String pass){
		String sql = "select * from xujy_Admin where name=? and password=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Admin a=new Admin();
				a.setUsername(name);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
