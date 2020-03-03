package productivity.tracker;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import productivity.tracker.models.Model;
import productivity.tracker.presenters.Presenter;
import productivity.tracker.views.View;

public class Application {

	public Application() {

		JFrame mainFrame = new JFrame();
		mainFrame.setSize(200, 100);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout());
		mainFrame.setVisible(true);

		final View view = new View(mainFrame);
		final Model model = new Model();
		new Presenter(view, model);
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