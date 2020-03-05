package productivity.tracker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import productivity.tracker.models.MainModel;
import productivity.tracker.presenters.MainPresenter;
import productivity.tracker.views.MainView;

public class Application {
	private final JButton btnNewButton = new JButton("New button");

	public Application() {

		JFrame mainFrame = new JFrame();
		mainFrame.setSize(800, 600);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);

		final MainView view = new MainView(mainFrame);
		final MainModel model = new MainModel();
		final MainPresenter presenter = new MainPresenter(view, model);

		view.setPresenter(presenter);
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