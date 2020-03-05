package productivity.tracker.database;

import productivity.tracker.database.tables.Session;

public class SessionSQLRepository implements Repository<Session> {

	@Override
	public void add(Session item) {
		SQLiteDatabase db = SQLiteDatabase.getDatabase();

		String statement = "INSERT INTO Sessions (SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate VALUES (?, ?, ?, ?);";

		db.add(statement, item);
	}

	@Override
	public void update(Session item) {

	}

	@Override
	public void remove(Session item) {

	}

}
