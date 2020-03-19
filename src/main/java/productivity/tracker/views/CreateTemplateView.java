package productivity.tracker.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

public class CreateTemplateView extends JPanel implements ViewBase {

	private static final long serialVersionUID = 386384173602807828L;
	
	private JLabel lblCreateANew;
	private JTextPane txtTemplateExplaination;
	private JPanel dataFormPanel;
	private JLabel lblTemplateName;
	private JLabel lblTemplateDescription;
	private JScrollPane templateDescriptionTextAreaScrollPane;
	private JTextField templateNameTextField;
	private JTextArea templateDescriptionTextArea;
	private JPanel panel;
	private JButton btnCancel;
	private JButton btnCreate;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;

	public CreateTemplateView() {

		setBackground(Color.DARK_GRAY);

		lblCreateANew = new JLabel("Create a new session template");
		lblCreateANew.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCreateANew.setForeground(Color.WHITE);
		txtTemplateExplaination = new JTextPane();
		txtTemplateExplaination.setOpaque(false);
		txtTemplateExplaination.setEditable(false);
		txtTemplateExplaination.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtTemplateExplaination.setForeground(Color.WHITE);
		txtTemplateExplaination
				.setText("Session templates are used to define the name and description of work sessions that you will add.");
		dataFormPanel = new JPanel();
		dataFormPanel.setOpaque(false);

		panel = new JPanel();
		panel.setOpaque(false);

		separator = new JSeparator();
		separator.setForeground(Color.WHITE);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(dataFormPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(txtTemplateExplaination, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(lblCreateANew, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(separator_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(separator_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateANew, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTemplateExplaination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dataFormPanel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);

		btnCancel = new JButton("Cancel");
		btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnCreate = new JButton("Create");
		btnCreate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(143)
					.addComponent(btnCreate, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		{
			lblTemplateName = new JLabel("Template Name:");
			lblTemplateName.setForeground(Color.WHITE);
			lblTemplateName.setFont(new Font("Calibri", Font.PLAIN, 13));
		}
		{
			lblTemplateDescription = new JLabel("Template Description:");
			lblTemplateDescription.setForeground(Color.WHITE);
			lblTemplateDescription.setFont(new Font("Calibri", Font.PLAIN, 13));
		}
		{
			templateDescriptionTextAreaScrollPane = new JScrollPane();
			templateDescriptionTextAreaScrollPane
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
		{
			templateNameTextField = new JTextField();
			templateNameTextField.setToolTipText("The name of the session template (e.g. Write Maths Notes).");
			templateNameTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
			templateNameTextField.setColumns(10);
		}
		GroupLayout gl_dataFormPanel = new GroupLayout(dataFormPanel);
		gl_dataFormPanel.setHorizontalGroup(
			gl_dataFormPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataFormPanel.createSequentialGroup()
					.addGroup(gl_dataFormPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dataFormPanel.createSequentialGroup()
							.addComponent(lblTemplateName, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addGap(33))
						.addComponent(lblTemplateDescription, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_dataFormPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(templateDescriptionTextAreaScrollPane)
						.addComponent(templateNameTextField, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
		);
		gl_dataFormPanel.setVerticalGroup(
			gl_dataFormPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataFormPanel.createSequentialGroup()
					.addGroup(gl_dataFormPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_dataFormPanel.createSequentialGroup()
							.addComponent(lblTemplateName, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
						.addGroup(gl_dataFormPanel.createSequentialGroup()
							.addComponent(templateNameTextField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
					.addGroup(gl_dataFormPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dataFormPanel.createSequentialGroup()
							.addComponent(lblTemplateDescription, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(151, Short.MAX_VALUE))
						.addComponent(templateDescriptionTextAreaScrollPane, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
		);

		templateDescriptionTextArea = new JTextArea();
		templateDescriptionTextArea.setWrapStyleWord(true);
		templateDescriptionTextArea.setLineWrap(true);
		templateDescriptionTextArea.setFont(new Font("Calibri", Font.PLAIN, 13));
		templateDescriptionTextAreaScrollPane.setViewportView(templateDescriptionTextArea);
		dataFormPanel.setLayout(gl_dataFormPanel);
		setLayout(groupLayout);
	}

	@Override
	public void onPresenterAttached() {

	}
}
