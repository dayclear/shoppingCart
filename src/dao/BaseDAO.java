package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public String url = "jdbc:mysql://localhost:3306/shopping";
	public String user = "root";
	public String pwd = "222222";
	public String driver = "com.mysql.jdbc.Driver";
	
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);//�������
			//��ȡ����
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close (Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
