package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NamecardInsert {
	
	static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	static final String USER = "scott";
	static final String PASSWORD = "tiger";
	
	public static void main(String[] args) {
		//load JDBC driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//connect to database
		Connection conn = null; //to close it in final block
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql = "INSERT INTO NAMECARD VALUES " +
						"(SEQ_NAMECARD_NO.NEXTVAL," +
						"'JESSIE'," +
						"'510-666-0000'," +
						"'albert@thealbert.com'," +
						"'Amazon')";
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
