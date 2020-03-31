package productivity.tracker.presenters;

import productivity.tracker.models.DashboardModel;
import productivity.tracker.views.DashboardView;

public class DashboardPresenter extends PresenterBase<DashboardView, DashboardModel> {

	public DashboardPresenter(DashboardView view, DashboardModel model) {
		super(view, model);
	}
}
