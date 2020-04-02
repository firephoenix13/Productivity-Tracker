package productivity.tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import productivity.tracker.database.models.SessionTemplate;

public class TemplateSQLRepository implements Repository<SessionTemplate> {

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
	public List<SessionTemplate> query(String sql) {
		List<SessionTemplate> templates = new ArrayList<SessionTemplate>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				// TemplateID, TemplateName, TemplateDescription
				SessionTemplate template = new SessionTemplate(rs.getInt("TemplateID"), rs.getString("TemplateName"),
						rs.getString("TemplateDescription"));

				templates.add(template);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return templates;
	}

	@Override
	public List<SessionTemplate> getAll() {
		String sql = "SELECT TemplateID, TemplateName, TemplateDescription FROM Templates";

		List<SessionTemplate> templates = new ArrayList<SessionTemplate>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				// SessionID, TemplateID, SessionEfficiency, SessionStartTime, SessionDuration,
				// SessionDate
				SessionTemplate template = new SessionTemplate(rs.getInt("TemplateID"), rs.getString("TemplateName"),
						rs.getString("TemplateDescription"));

				templates.add(template);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return templates;
	}

	@Override
	public void add(SessionTemplate item) {
		String sql = "INSERT INTO Templates(TemplateName, TemplateDescription) VALUES(?, ?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, item.getTemplateName());
			pstmt.setString(2, item.getTemplateDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(SessionTemplate item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(SessionTemplate item) {
		// TODO Auto-generated method stub

	}

}
