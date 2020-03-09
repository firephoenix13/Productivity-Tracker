package productivity.tracker.presenters;

import productivity.tracker.database.SessionSQLRepository;
import productivity.tracker.database.tables.Session;
import productivity.tracker.models.SessionTableModel;
import productivity.tracker.views.DatabaseView;

public class DatabasePresenter extends PresenterBase<DatabaseView, SessionTableModel> {

	private SessionSQLRepository repo;

	String sqlSelect = "SELECT SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate FROM Sessions WHERE SessionID > 0";

	public DatabasePresenter(DatabaseView view) {
		super(view, new SessionTableModel());

		repo = new SessionSQLRepository();

		// Update the model.
		getModel().setSessions(repo.query(sqlSelect));

		// Update the view.
		getView().setTableModel(getModel());

		getView().addEntryButtonActionListener(e -> onEntryButtonPressed());
	}

	private void onEntryButtonPressed() {
		repo.add(new Session(0, 12, 34, 52, 23));

		getModel().setSessions(repo.query(sqlSelect));

		getModel().fireTableDataChanged();
	}

}
