package productivity.tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import productivity.tracker.database.tables.Session;

public class SQLiteDatabase implements AutoCloseable {

	private static SQLiteDatabase instance = new SQLiteDatabase();

	public static SQLiteDatabase getDatabase() {
		return instance;
	}

	private Connection conn;

	private SQLiteDatabase() {
		Class.forName("org.sqlite.JDBC");
		try {
			
			// DB location
			String url = "jdbc:sqlite:D:/Code/GitHub/Productivity-Tracker/src/main/resources/ProductivityDB.db";

			// Create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
	}

	public void add(String sqlStatement, Session sesh) {

		try (PreparedStatement pstmt = conn.prepareStatement(sqlStatement)) {
			pstmt.setInt(1, sesh.getSessionEfficiency());
			pstmt.setInt(2, sesh.getSessionStartTime());
			pstmt.setInt(3, sesh.getSessionDuration());
			pstmt.setInt(4, sesh.getSessionDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws SQLException {
		conn.close();
	}

}
