package jdbc.test;
import java.sql.*;

public class TransactionPairs {
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
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			String sql = "UPDATE ACCOUNT SET balance = balance + ? WHERE accountno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, -1500);
			pstmt.setString(2, "111");
			pstmt.executeUpdate();
			pstmt.setInt(1, 1500);
			pstmt.setString(2, "222");
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt.close();
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
