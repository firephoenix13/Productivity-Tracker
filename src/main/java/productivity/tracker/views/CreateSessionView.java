package productivity.tracker.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import productivity.tracker.database.TemplateSQLRepository;
import productivity.tracker.database.models.SessionTemplate;
import javax.swing.JTextField;
import javax.swing.JSlider;

public class CreateSessionView extends JPanel implements ViewBase {

	private static final long serialVersionUID = 4975606041181359544L;

	private JLabel lblCreateANewSession;
	private JSeparator separator;
	private JTextPane txtpnEnterTheDetails;
	private JSeparator separator_1;
	private JPanel formPanel;
	private JComboBox<SessionTemplate> templateComboBox;
	private JLabel lblSelectATemplate;
	private JLabel lblSelectTheStartTIme;
	private DatePicker startDatePicker;
	private TimePicker startTimePicker;
	private JLabel lblSelectTheEndTime;
	private DatePicker endDatePicker;
	private TimePicker endTimePicker;

	public CreateSessionView() {
		initGUI();
	}

	private void initGUI() {
		setBackground(Color.DARK_GRAY);
		lblCreateANewSession = new JLabel("Create a new session");
		lblCreateANewSession.setForeground(Color.WHITE);
		lblCreateANewSession.setFont(new Font("Calibri", Font.BOLD, 16));
		separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		txtpnEnterTheDetails = new JTextPane();
		txtpnEnterTheDetails
				.setText("Enter the details of your work session to start identifying trends in your work.");
		txtpnEnterTheDetails.setOpaque(false);
		txtpnEnterTheDetails.setForeground(Color.WHITE);
		txtpnEnterTheDetails.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtpnEnterTheDetails.setEditable(false);
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		formPanel = new JPanel();
		formPanel.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(formPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCreateANewSession, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(txtpnEnterTheDetails, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(separator, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
						.addComponent(separator_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateANewSession, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnEnterTheDetails, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 182, Short.MAX_VALUE)
					.addContainerGap())
		);
		{
			templateComboBox = new JComboBox<SessionTemplate>();
			templateComboBox.setRenderer(new TemplateItemRenderer());
		}
		lblSelectATemplate = new JLabel("Select a template:");
		lblSelectATemplate.setForeground(Color.WHITE);
		lblSelectATemplate.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblSelectTheStartTIme = new JLabel("Select the start time:");
		lblSelectTheStartTIme.setForeground(Color.WHITE);
		lblSelectTheStartTIme.setFont(new Font("Calibri", Font.PLAIN, 13));

		URL dateImageURL = CreateSessionView.class.getResource("/images/datepickerbutton1.png");
		Image dateImage = Toolkit.getDefaultToolkit().getImage(dateImageURL);
		ImageIcon dateIcon = new ImageIcon(dateImage);

		DatePickerSettings startDateSettings = new DatePickerSettings();
		startDateSettings.setAllowEmptyDates(false);

		TimePickerSettings startTimeSettings = new TimePickerSettings();
		startTimeSettings.setAllowEmptyTimes(false);
		startTimeSettings.setDisplaySpinnerButtons(true);
		startTimeSettings.setFormatForDisplayTime("H:mm");
		startTimeSettings.setFormatForMenuTimes("H:mm");

		startDatePicker = new DatePicker(startDateSettings);
		startDatePicker.setDateToToday();
		startDatePicker.getComponentToggleCalendarButton().setText(null);
		startDatePicker.getComponentToggleCalendarButton().setIcon(dateIcon);
		startTimePicker = new TimePicker(startTimeSettings);
		startTimePicker.setTimeToNow();

		lblSelectTheEndTime = new JLabel("Select the end time:");
		lblSelectTheEndTime.setForeground(Color.WHITE);
		lblSelectTheEndTime.setFont(new Font("Calibri", Font.PLAIN, 13));

		DatePickerSettings endDateSettings = new DatePickerSettings();
		endDateSettings.setAllowEmptyDates(false);

		TimePickerSettings endTimeSettings = new TimePickerSettings();
		endTimeSettings.setAllowEmptyTimes(false);
		endTimeSettings.setDisplaySpinnerButtons(true);
		endTimeSettings.setFormatForDisplayTime("H:mm");
		endTimeSettings.setFormatForMenuTimes("H:mm");

		endDatePicker = new DatePicker(endDateSettings);
		endDatePicker.setDateToToday();
		endDatePicker.getComponentToggleCalendarButton().setText(null);
		endDatePicker.getComponentToggleCalendarButton().setIcon(dateIcon);
		endTimePicker = new TimePicker(endTimeSettings);
		endTimePicker.setTimeToNow();
		
		JLabel lblSelectMood = new JLabel("Select mood:");
		lblSelectMood.setForeground(Color.WHITE);
		lblSelectMood.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JSlider sldMood = new JSlider();
		
		JLabel lblSelectEfficiency = new JLabel("Select efficiency:");
		lblSelectEfficiency.setForeground(Color.WHITE);
		lblSelectEfficiency.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JSlider sldEfficiency = new JSlider();

		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel.setHorizontalGroup(
			gl_formPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_formPanel.createSequentialGroup()
							.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSelectATemplate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(lblSelectTheStartTIme, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(lblSelectTheEndTime, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_formPanel.createSequentialGroup()
							.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSelectMood, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(lblSelectEfficiency, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(sldEfficiency, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(sldMood, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(gl_formPanel.createSequentialGroup()
							.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(endDatePicker, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(startDatePicker, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(endTimePicker, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(startTimePicker, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
						.addComponent(templateComboBox, 0, 426, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_formPanel.setVerticalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(templateComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectATemplate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectTheStartTIme, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(startDatePicker, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(startTimePicker, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(endTimePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(endDatePicker, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addComponent(lblSelectTheEndTime, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(sldMood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectMood, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_formPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblSelectEfficiency, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_formPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sldEfficiency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(25))
		);
		formPanel.setLayout(gl_formPanel);
		setLayout(groupLayout);
	}

	public void addTemplateOption(SessionTemplate item) {
		templateComboBox.addItem(item);
	}

	@Override
	public void onPresenterAttached() {

	}

	class TemplateItemRenderer extends BasicComboBoxRenderer {
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			SessionTemplate template = (SessionTemplate) value;

			if (index != -1)
				setText(template.getTemplateName());
			
			return this;
		}
	}
}
