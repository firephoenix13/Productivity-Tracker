package productivity.tracker.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import productivity.tracker.database.tables.Session;

public class SessionListModel implements ModelBase, ListModel<Session> {

	private List<Session> sessions;

	public SessionListModel() {
		this.sessions = new ArrayList<Session>();
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return sessions.size();
	}

	@Override
	public Session getElementAt(int index) {
		// TODO Auto-generated method stub
		return sessions.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	}

}
