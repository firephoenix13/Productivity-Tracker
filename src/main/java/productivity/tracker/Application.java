package productivity.tracker;

import javax.swing.SwingUtilities;

import productivity.tracker.models.DashboardModel;
import productivity.tracker.presenters.DashboardPresenter;
import productivity.tracker.views.DashboardView;

public class Application {

	public Application() {
		new DashboardPresenter(new DashboardView(), new DashboardModel());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Application();
			}
		});
	}
}