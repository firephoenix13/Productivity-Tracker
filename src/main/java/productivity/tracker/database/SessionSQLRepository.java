package productivity.tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import productivity.tracker.database.models.Session;

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
			String url = "jdbc:sqlite:res/ProductivityDB.db";

			// Create a connection to the database
			connection = DriverManager.getConnection(url);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	@Override
	public void add(Session item) {

		String sql = "INSERT INTO Sessions(TemplateID, SessionStartTime, SessionEndTime, SessionEfficiency, SessionMood) VALUES(?, ?, ?, ?, ?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, item.getTemplateID());
			pstmt.setInt(2, item.getSessionStartTime());
			pstmt.setInt(3, item.getSessionEndTime());
			pstmt.setInt(4, item.getSessionEfficiency());
			pstmt.setInt(5, item.getSessionMood());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Session item) {
		String sql = "DELETE FROM Sessions WHERE SessionID = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, item.getSessionID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Session> query(String sql) {

		List<Session> sessions = new ArrayList<Session>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				// SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate
				Session session = new Session(rs.getInt("SessionID"), rs.getInt("TemplateID"),
						rs.getInt("SessionStartTime"), rs.getInt("SessionEndTime"), rs.getInt("SessionEfficiency"),
						rs.getInt("SessionMood"));

				sessions.add(session);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return sessions;
	}

	@Override
	public List<Session> getAll() {

		String sql = "SELECT SessionID, TemplateID, SessionStartTime, SessionEndTime, SessionEfficiency, SessionMood FROM Sessions";

		List<Session> sessions = new ArrayList<Session>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				// SessionID, TemplateID, SessionStartTime, SessionEndTime, SessionEffciency,
				// SessionMood
				Session session = new Session(rs.getInt("SessionID"), rs.getInt("TemplateID"),
						rs.getInt("SessionStartTime"), rs.getInt("SessionEndTime"), rs.getInt("SessionEfficiency"),
						rs.getInt("SessionMood"));

				sessions.add(session);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return sessions;
	}

	@Override
	public void update(Session item) {
		String sql = "UPDATE Sessions SET TemplateID = ?, SessionStartTime = ?, SessionEndTime = ?, SessionEfficiency = ?, SessionMood = ?"
				+ " WHERE SessionID = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, item.getTemplateID());
			pstmt.setInt(2, item.getSessionStartTime());
			pstmt.setInt(3, item.getSessionEndTime());
			pstmt.setInt(4, item.getSessionEfficiency());
			pstmt.setInt(5, item.getSessionMood());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
