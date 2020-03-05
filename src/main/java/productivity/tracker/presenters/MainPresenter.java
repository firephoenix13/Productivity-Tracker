package productivity.tracker.presenters;

import productivity.tracker.database.SessionSQLRepository;
import productivity.tracker.database.tables.Session;
import productivity.tracker.models.MainModel;
import productivity.tracker.views.MainView;

public class MainPresenter extends PresenterBase<MainView, MainModel> {

	public MainPresenter(MainView view, MainModel model) {
		super(view, model);
	}

	public void onFilterButtonPressed() {
		SessionSQLRepository repo = new SessionSQLRepository();
		
		repo.add(new Session(0, 20, 30, 10, 20));
	}
}
