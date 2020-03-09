package productivity.tracker.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import productivity.tracker.presenters.DatabasePresenter;

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

		DatabasePresenter presenter = new DatabasePresenter(new DatabaseView());

		JPanel navigationPanel = new JPanel();
		FlowLayout fl_navigationPanel = new FlowLayout(FlowLayout.LEFT, 5, 5);
		fl_navigationPanel.setAlignOnBaseline(true);
		navigationPanel.setLayout(fl_navigationPanel);
		JLabel label = new JLabel("Left Component");
		navigationPanel.add(label);
		JButton button_1 = new JButton("Exit Button");
		navigationPanel.add(button_1);
		JButton button = new JButton("Left Button");
		navigationPanel.add(button);

		setLeftComponent(navigationPanel);
		setCentralComponent(presenter.getView());
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
