package jdbc.test;

import java.sql.*;

public class UsingPrepareStatement {
	
	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	static final String USER = "scott"; 
	static final String PASSWORD = "tiger";
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		String sql = "UPDATE NAMECARD SET NAME = ? WHERE NO = ?";
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "JUN");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
