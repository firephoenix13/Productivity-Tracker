package productivity.tracker.views;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

public class DatabaseView extends JSplitPane implements ViewBase {

	private static final long serialVersionUID = 1L;

	JTable table;
	private JButton btnAddRandomEntry;

	public DatabaseView() {
		initGUI();
	}

	private void initGUI() {
		table = new JTable();
		table.setGridColor(Color.WHITE);
		table.setAutoscrolls(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JScrollPane pane = new JScrollPane(table);
		pane.setBackground(new Color(192, 192, 192));
		pane.setAutoscrolls(true);
		pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Session Database",
				TitledBorder.CENTER, TitledBorder.TOP));

		setOrientation(JSplitPane.VERTICAL_SPLIT);

		setRightComponent(pane);

		btnAddRandomEntry = new JButton("Add Random Entry");
		setLeftComponent(btnAddRandomEntry);
	}

	public void addEntryButtonActionListener(ActionListener l) {
		btnAddRandomEntry.addActionListener(l);
	}

	@Override
	public void onPresenterAttached() {
		// TODO Auto-generated method stub
	}

	public void setTableModel(TableModel model) {
		table.setModel(model);
	}

	public void scrollTable() {
		table.scrollRectToVisible(table.getCellRect(table.getRowCount() - 1, 0, true));
	}
}
