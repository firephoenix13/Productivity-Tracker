package productivity.tracker.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import productivity.tracker.presenters.MainPresenter;

public class MainView extends ViewBase<MainPresenter> {

	private JTable table;

	public MainView(JFrame frame) {
		JButton button = new JButton("Add Entry");
		button.addActionListener(e -> getPresenter().onFilterButtonPressed());

		table = new JTable();
		table.setGridColor(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.WHITE);

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.setBackground(new Color(0, 0, 255));
		ctrlPane.add(button);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBackground(new Color(30, 144, 255));
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Session Database", TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		frame.getContentPane().add(splitPane);
	}

	public void setTableModel(TableModel model) {
		table.setModel(model);
		
		table.repaint();
		table.invalidate();
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

}
