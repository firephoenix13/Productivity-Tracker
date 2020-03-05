package productivity.tracker.presenters;

import java.util.Random;

import productivity.tracker.database.SessionSQLRepository;
import productivity.tracker.database.tables.Session;
import productivity.tracker.models.MainModel;
import productivity.tracker.views.MainView;

public class MainPresenter extends PresenterBase<MainView, MainModel> {

	private SessionSQLRepository repo;

	String sqlSelect = "SELECT SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate FROM Sessions";

	public MainPresenter(MainView view, MainModel model) {
		super(view, model);

		repo = new SessionSQLRepository();

		// Update the model.
		getModel().setSessions(repo.query(sqlSelect));

		// Update the view.
		getView().setTableModel(getModel());
	}

	public void onFilterButtonPressed() {

		Random random = new Random();

		// Add a new random session.
		repo.add(new Session(random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()));

		// Update the model.
		getModel().setSessions(repo.query(sqlSelect));

		// Update the view.
		getView().setTableModel(getModel());
	}
}
