package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NamecardSelect {
	
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
		//connect to DB
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql = "SELECT * " +
					"FROM NAMECARD " +
					"ORDER BY NAME DESC";
			System.out.println(sql);
			rs = stmt.executeQuery(sql); //rs initially points to 0th row
			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append(rs.getInt("no"));
				sb.append("|");
				sb.append(rs.getString("name"));
				sb.append("|");
				sb.append(rs.getString("mobile"));
				sb.append("|");
				sb.append(rs.getString("email"));
				sb.append("|");
				sb.append(rs.getString("company"));
				System.out.println(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
