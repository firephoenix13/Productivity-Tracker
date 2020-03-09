package productivity.tracker.models;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import productivity.tracker.database.tables.Session;

public class SessionTableModel extends AbstractTableModel implements ModelBase {

	private static final long serialVersionUID = 1L;

	private List<Session> sessions;

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return sessions.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		// SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate
		switch (columnIndex) {
		case 0:
			return "SessionID";
		case 1:
			return "SessionEfficiency";
		case 2:
			return "SessionStartTime";
		case 3:
			return "SessionDuration";
		case 4:
			return "SessionDate";
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
		Session session = sessions.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return session.getSessionID();
		case 1:
			return session.getSessionEfficiency();
		case 2:
			return session.getSessionStartTime();
		case 3:
			return session.getSessionDuration();
		case 4:
			return session.getSessionDate();
		default:
			return null;
		}
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
