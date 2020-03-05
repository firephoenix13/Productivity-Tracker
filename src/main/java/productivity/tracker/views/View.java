package productivity.tracker.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import productivity.tracker.presenters.Presenter;

public class View extends ViewBase<Presenter> {

	private JPanel panel;
	private final JButton button;
	private final JLabel label;

	public View(final JFrame frame) {
		panel = new JPanel();

		button = new JButton("Hello, world!");
		button.addActionListener(e -> getPresenter().onButtonClicked());

		label = new JLabel();

		panel.add(button);
		panel.add(label);

		frame.add(panel);
	}

	public void setLabelText(final String text) {
		label.setText(text);
	}

	@Override
	public void show() {
		if (!panel.isVisible())
			panel.setVisible(true);
	}

	@Override
	public void hide() {
		if (panel.isVisible())
			panel.setVisible(false);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void buildUI() {
		// TODO Auto-generated method stub
		
	}
}