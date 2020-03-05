package productivity.tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import productivity.tracker.database.tables.Session;

public class SessionSQLRepository implements Repository<Session> {

	private Connection connect() {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;

		try {

			// DB location
			String url = "jdbc:sqlite::resource:ProductivityDB.db";

			// Create a connection to the database
			connection = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	@Override
	public void add(Session item) {

		String sql = "INSERT INTO Sessions(SessionEfficiency, SessionStartTime, SessionDuration, SessionDate) VALUES(?, ?, ?, ?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, item.getSessionEfficiency());
			pstmt.setInt(2, item.getSessionStartTime());
			pstmt.setInt(3, item.getSessionDuration());
			pstmt.setInt(4, item.getSessionDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Session item) {

	}

	@Override
	public void remove(Session item) {

	}

	@Override
	public List<Session> query(String sql) {

		List<Session> sessions = new ArrayList<>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				// SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate
				Session session = new Session(rs.getInt("SessionID"), rs.getInt("SessionEfficiency"),
						rs.getInt("SessionStartTime"), rs.getInt("SessionDuration"), rs.getInt("SessionDate"));

				sessions.add(session);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return sessions;
	}

}
