package productivity.tracker.views;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import productivity.tracker.models.MainModel;
import productivity.tracker.presenters.MainPresenter;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class MainView extends ViewBase<MainPresenter> {

	private JFrame frame;

	public MainView(JFrame frame) {
		this.frame = frame;
	}

	public void setLabelText(final String text) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void buildUI() {

		// Create views swing UI components
		JTextField searchTermTextField = new JTextField(26);

		JButton filterButton = new JButton("Filter");
		filterButton.addActionListener(e -> getPresenter().onFilterButtonPressed());

		JTable table = new JTable();
		table.setGridColor(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.WHITE);
		table.setModel(getPresenter().getModel());

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.setBackground(new Color(0, 0, 255));
		ctrlPane.add(searchTermTextField);
		ctrlPane.add(filterButton);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBackground(new Color(30, 144, 255));
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Market Movers",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		frame.getContentPane().add(splitPane);
	}

}
