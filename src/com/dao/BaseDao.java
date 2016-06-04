package com.dao;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class BaseDao {
   DataSource dataSource;
   // 在构造方法中返回数据源对象
public BaseDao () {
	    try {
	       Context context = new InitialContext();
	       dataSource = 
(DataSource)context.lookup("java:comp/env/jdbc/exp7");
	    }catch(NamingException ne){
	       System.out.println("Exception:"+ne);
	    }
	  }
// 返回一个连接对象
	  public Connection getConnection()throws Exception{
		 return dataSource.getConnection(); 
	  }
}