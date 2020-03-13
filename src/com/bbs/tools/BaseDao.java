package com.bbs.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	// 加载驱动类
	static {
		try {Class.forName("com.mysql.jdbc.Driver");} catch (Exception e) {}
	}
	private static String URL = "jdbc:mysql://localhost:3306/bbs_system?useUnicode=true&characterEncoding=UTF-8";
	private static String USER = "root";// 数据库账户
	private static String PASSWORD = "123";// 数据库密码
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getCon() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	/**
	 * 关闭方法
	 * @param con
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	/**
	 * 更改内容操作
	 * @param ps
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public static int update(PreparedStatement ps,Object args[]) 
			throws SQLException{
		// foreach
		for(int i = 0;i < args.length;i++) {
			ps.setObject(i+1,args[i]);
		}
		return ps.executeUpdate();
	}
	/**
	 * 查询返回结果集
	 * @param ps
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	 public static ResultSet query(PreparedStatement ps,Object[] args) 
		      throws SQLException{
		   	if(args != null) {
		   		for(int i=0;i<args.length;i++) {
		   			ps.setObject(i+1, args[i]);
		   		}
		    }
		    return ps.executeQuery();
	}
}








