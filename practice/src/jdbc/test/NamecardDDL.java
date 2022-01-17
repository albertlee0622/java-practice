package jdbc.test;

import java.sql.*;

public class NamecardDDL {

	public static void main(String[] args) {
		
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
		final String USER = "scott";
		final String PASSWORD = "tiger";
		
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			sql = "CREATE TABLE NAMECARD ( " +
					"NO  NUMBER CONSTRAINT PK_NAMECARD PRIMARY KEY, " +
					"NAME VARCHAR2(20) NOT NULL, " +
					"MOBILE VARCHAR2(20) NOT NULL, " +
					"EMAIL VARCHAR2(40), " +
					"COMPANY VARCHAR2(60))";
			stmt.executeUpdate(sql);
			sql = "CREATE SEQUENCE SEQ_NAMECARD_NO " +
					"INCREMENT BY 1 " +
					"START WITH 1";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {}
		}
	}

}
