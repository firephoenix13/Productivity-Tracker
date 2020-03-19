package productivity.tracker.presenters;

import productivity.tracker.database.SessionSQLRepository;
import productivity.tracker.database.models.Session;
import productivity.tracker.models.SessionTableModel;
import productivity.tracker.views.DatabaseView;

public class DatabasePresenter extends PresenterBase<DatabaseView, SessionTableModel> {

	private SessionSQLRepository repo;

	public DatabasePresenter(DatabaseView view) {
		super(view, new SessionTableModel());

		repo = new SessionSQLRepository();
		getModel().setSessions(repo.getAll());

		getView().setTableModel(getModel());
		getView().addEntryButtonActionListener(e -> onEntryButtonPressed());
	}

	private void onEntryButtonPressed() {
		repo.add(new Session(0, 1, 1, 1, 1, 1));
		getModel().setSessions(repo.getAll());
	}

}
