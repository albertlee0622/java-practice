package jdbc.test;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class NamecardUpdate {
	static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	static final String USER = "SCOTT";
	static final String PASSWORD = "TIGER";
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql = "UPDATE NAMECARD " +
					"SET EMAIL = 'jessie@albertlee.com' " +
					"WHERE NAME = 'JESSIE'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
