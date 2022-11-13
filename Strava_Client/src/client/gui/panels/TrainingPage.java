package client.gui.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.gui.ClientPanel;
import client.gui.ClientWindow;
import client.gui.panels.extras.DateKeyListener;
import client.gui.panels.extras.LoginMouseListener;
import client.gui.panels.extras.NumberFieldListener;
import client.gui.panels.extras.SessionPanel;
import client.gui.panels.extras.SessionPanel.SessionType;

public class TrainingPage extends FieldPage {

	private static final long serialVersionUID = 1885936956130822898L;
	
	public TrainingPage() {
		setLayout(new GridLayout(0, 1));
		JComboBox<SessionType> trainingType = new JComboBox<SessionType>(SessionType.values());
		add(createField("Session type:", trainingType));
		JTextField titleField = new JTextField(24);
		add(createField("Title: ", titleField));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField startDateField = new JFormattedTextField(df);
		startDateField.setColumns(24);
		startDateField.setText(df.format(new Date()));
		startDateField.addKeyListener(new DateKeyListener());
		add(createField("Start date:", startDateField));
		JTextField distanceField = new JTextField(24);
		distanceField.addKeyListener(new NumberFieldListener());
		add(createField("Distance(km): ", distanceField));
		JTextField durationField = new JTextField(24);
		durationField.addKeyListener(new NumberFieldListener());
		add(createField("Duration(s): ", durationField));
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new LoginMouseListener(
			p->{
				try {
					ClientPanel
						.getInstanceOf(HomePage.class)
						.addTrainingSession(
							new SessionPanel(
								(SessionType)trainingType.getSelectedItem(),
								titleField.getText(),
								df.parse(startDateField.getText()),
								Float.parseFloat(distanceField.getText()),
								Float.parseFloat(durationField.getText())
						)
					);
					//TODO Register in server the new training session
					ClientWindow.getInstance().setPage(HomePage.class);
				} catch (NumberFormatException | ParseException e1) {
					JOptionPane.showMessageDialog(null, "Date format may be wrong");
				}
				
			}, 
			titleField,
			startDateField,
			distanceField,
			durationField
		));
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientWindow.getInstance().setPage(HomePage.class);
			}
			
		});
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(STRAVA_COLOR);
		buttonPanel.add(registerButton);
		buttonPanel.add(backButton);
		add(buttonPanel);
	}

	private static final Dimension PREFERRED_SIZE = new Dimension(400, 250);
	@Override
	public Dimension getPreferredSize() {
		return PREFERRED_SIZE;
	}

}
