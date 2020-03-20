package productivity.tracker.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import productivity.tracker.presenters.DatabasePresenter;

public class MainView extends JFrame implements ViewBase {

	private static final long serialVersionUID = 1L;

	private JComponent leftComponent;
	private JComponent centralComponent;

	public MainView() {
		setTitle("Productivity Tracker");
		setMinimumSize(new Dimension(400, 300));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);

		initGUI();
	}

	private void initGUI() {

		DatabaseView dbv = new DatabaseView();
		new DatabasePresenter(dbv);

		setCentralComponent(dbv);

		CreateTemplateView ctv = new CreateTemplateView();

		setLeftComponent(ctv);
	}

	@Override
	public void onPresenterAttached() {
		// TODO Auto-generated method stub
	}

	public void setCentralComponent(final JComponent component) {
		clearCentralComponent();
		centralComponent = component;
		getContentPane().add(component, BorderLayout.CENTER);
		pack();
	}

	public void clearCentralComponent() {
		if (centralComponent != null) {
			getContentPane().remove(centralComponent);
			centralComponent = null;
		}
	}

	public void setLeftComponent(final JComponent component) {
		clearLeftComponent();
		leftComponent = component;
		getContentPane().add(component, BorderLayout.LINE_START);
		pack();
	}

	public void clearLeftComponent() {
		if (leftComponent != null) {
			getContentPane().remove(leftComponent);
			leftComponent = null;
		}
	}
}
