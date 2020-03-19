package productivity.tracker.views;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

import productivity.tracker.database.tables.Session;

public class SessionListView extends JPanel implements ViewBase {

	private JList list;

	public SessionListView() {
		initGUI();
	}

	private void initGUI() {
		{
			list = new JList();
			list.setCellRenderer(new SessionListCellRenderer());
			add(list);
		}
	}

	@Override
	public void onPresenterAttached() {
		// TODO Auto-generated method stub

	}

	public void setListModel(ListModel model) {
		list.setModel(model);
	}

	class SessionListCellRenderer extends JLabel implements ListCellRenderer {

		private static final long serialVersionUID = -3260027197593664877L;

		public SessionListCellRenderer() {
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

			Session session = (Session) value;

			String text = "Date: " + session.getSessionDate() + ", Duration: " + session.getSessionDuration();

			setText(text);

			return this;
		}
	}

}
