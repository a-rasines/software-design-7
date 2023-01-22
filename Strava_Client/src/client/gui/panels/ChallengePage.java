package client.gui.panels;

import java.awt.Color;
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
import server.data.dto.ChallengeDTO;
import server.data.enums.Sport;

public class ChallengePage extends FieldPage {
	private static final long serialVersionUID = -5807112075284184359L;
	
	public ChallengePage() {
		setLayout(new GridLayout(0, 1));
		JComboBox<Sport> trainingType = new JComboBox<Sport>(Sport.values());
		add(createField("Session type:", trainingType, Color.BLACK));
		JTextField titleField = new JTextField(24);
		add(createField("Title: ", titleField));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField startDateField = new JFormattedTextField(df);
		startDateField.setColumns(24);
		startDateField.setText(df.format(new Date()));
		startDateField.addKeyListener(new DateKeyListener());
		add(createField("Start date:", startDateField));
		JFormattedTextField endDateField = new JFormattedTextField(df);
		endDateField.setColumns(24);
		endDateField.setText(df.format(new Date()));
		endDateField.addKeyListener(new DateKeyListener());
		add(createField("End date:", endDateField));
		JComboBox<String> objectiveCombo = new JComboBox<>(new String[] {"DISTANCE", "DURATION"});
		add(createField("Target: ", objectiveCombo, Color.BLACK));
		JTextField targetField = new JTextField(24);
		targetField.addKeyListener(new NumberFieldListener(true));
		add(createField("Target(km or s): ", targetField));
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new LoginMouseListener(
			p->{
				try {
					if(objectiveCombo.getSelectedItem().equals("DISTANCE"))
						ClientPanel
							.getInstanceOf(HomePage.class)
							.addChallenge(
								new ChallengeDTO(
									titleField.getText(),
									df.parse(startDateField.getText()).toInstant().getEpochSecond()*1000,
									df.parse(endDateField.getText()).toInstant().getEpochSecond()*1000,
									Float.parseFloat(targetField.getText()),
									0,
									(Sport)trainingType.getSelectedItem(),
									(byte)0
							)
						);
					else
						ClientPanel
						.getInstanceOf(HomePage.class)
						.addChallenge(
							new ChallengeDTO(
								titleField.getText(),
								df.parse(startDateField.getText()).toInstant().getEpochSecond()*1000,
								df.parse(endDateField.getText()).toInstant().getEpochSecond()*1000,
								0,
								(long)Float.parseFloat(targetField.getText()),
								(Sport)trainingType.getSelectedItem(),
								(byte)0
						)
					);
					
					ClientWindow.getInstance().setPage(HomePage.class);
				} catch (NumberFormatException | ParseException e1) {
					JOptionPane.showMessageDialog(null, "Date format may be wrong");
				}
				
			}, 
			titleField,
			startDateField,
			endDateField,
			targetField
		));
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientWindow.getInstance().setPage(HomePage.class);
			}
			
		});
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(TRANSPARENT);
		buttonPanel.add(registerButton);
		buttonPanel.add(backButton);
		add(buttonPanel);
	}
	
	void callSetupChallenge() {
		
	}
	void callDownloadChallenge() {
		
	}
	void callAcceptChallenge() {
		
	}
	private static final Dimension PREFERRED_SIZE = new Dimension(400, 320);
	@Override
	public Dimension getPreferredSize() {
		return PREFERRED_SIZE;
	}
}
