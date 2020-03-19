package productivity.tracker.presenters;

import productivity.tracker.database.SessionSQLRepository;
import productivity.tracker.models.SessionListModel;
import productivity.tracker.views.SessionListView;

public class SessionListPresenter extends PresenterBase<SessionListView, SessionListModel> {

	String sqlSelect = "SELECT SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate FROM Sessions";

	public SessionListPresenter(SessionListView view) {
		super(view, new SessionListModel());

		SessionSQLRepository repo = new SessionSQLRepository();
		getModel().setSessions(repo.query(sqlSelect));

		getView().setListModel(getModel());
	}

}
