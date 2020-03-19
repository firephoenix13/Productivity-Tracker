package productivity.tracker.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class DatabaseView extends JPanel implements ViewBase {

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;

	public DatabaseView() {
		initGUI();
	}

	private void initGUI() {

		JSplitPane splitPane = new JSplitPane();

		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addGap(0))
		);

		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setFillsViewportHeight(true);
			scrollPane.setViewportView(table);
		}

		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		{
			btnNewButton = new JButton("Add Entry");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			panel_1.add(btnNewButton, BorderLayout.CENTER);
		}
		setLayout(groupLayout);
	}

	public void addEntryButtonActionListener(ActionListener l) {
		btnNewButton.addActionListener(l);
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
