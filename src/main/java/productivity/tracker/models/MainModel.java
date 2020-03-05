package productivity.tracker.models;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MainModel extends ModelBase implements TableModel {

	private String[][] data = { { "Max", "Bryars-Mansell", "24/12/2000" }, { "John", "Smith", "01/01/2003" },
			{ "Neo", "Matrix", "04/07/2001" } };

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return "Forename";
		case 1:
			return "Surname";
		case 2:
			return "Date of Birth";
		default:
			return "Unknown";
		}

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
