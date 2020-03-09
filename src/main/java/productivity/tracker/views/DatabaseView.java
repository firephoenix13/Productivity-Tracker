package productivity.tracker.views;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

public class DatabaseView extends JSplitPane implements ViewBase {

	private static final long serialVersionUID = 1L;

	JTable table;
	private JLabel lblWank_1;
	private JButton btnAddRandomEntry;

	public DatabaseView() {
		initGUI();
	}

	private void initGUI() {
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setGridColor(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JScrollPane pane = new JScrollPane();
		pane.setBackground(new Color(192, 192, 192));
		pane.setAutoscrolls(true);
		pane.setViewportBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), null));
		pane.setViewportView(table);
		pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Session Database",
				TitledBorder.CENTER, TitledBorder.TOP));

		setOrientation(JSplitPane.VERTICAL_SPLIT);

		lblWank_1 = new JLabel("WANK");
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
}
