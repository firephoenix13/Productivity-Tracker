package productivity.tracker.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import productivity.tracker.presenters.DatabasePresenter;
import productivity.tracker.presenters.SessionListPresenter;

public class MainView extends JFrame implements ViewBase {

	private static final long serialVersionUID = 1L;

	private JComponent leftComponent;
	private JComponent centralComponent;

	public MainView() {
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		initGUI();
	}

	private void initGUI() {
		
		DatabaseView dbv = new DatabaseView();
		new DatabasePresenter(dbv);
		
		SessionListView slv = new SessionListView();
		new SessionListPresenter(slv);
		
		setCentralComponent(dbv);
		setLeftComponent(slv);
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
