package productivity.tracker.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import productivity.tracker.database.models.Session;

public class SessionTableModel extends AbstractTableModel implements ModelBase {

	private static final long serialVersionUID = 1L;

	private List<Session> sessions;

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
		fireTableDataChanged();
	}

	public void addSession(Session session) {
		this.sessions.add(session);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return sessions.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		// SessionID, SessionEfficiency, SessionStartTime, SessionDuration, SessionDate
		switch (columnIndex) {
		case 0:
			return "SessionID";
		case 1:
			return "TemplateID";
		case 2:
			return "SessionStartTime";
		case 3:
			return "SessionEndTime";
		case 4:
			return "SessionEfficiency";
		case 5:
			return "SessionMood";
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
			return session.getTemplateID();
		case 2:
			return session.getSessionStartTime();
		case 3:
			return session.getSessionEndTime();
		case 4:
			return session.getSessionEfficiency();
		case 5:
			return session.getSessionMood();
		default:
			return null;
		}
	}
}
