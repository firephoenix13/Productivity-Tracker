package productivity.tracker;

import javax.swing.SwingUtilities;

import productivity.tracker.models.MainModel;
import productivity.tracker.presenters.MainPresenter;
import productivity.tracker.views.MainView;

public class Application {

	public Application() {
		new MainPresenter(new MainView(), new MainModel());
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