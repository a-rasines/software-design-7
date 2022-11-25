package client.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.gui.ClientPanel;
import client.gui.ClientWindow;
import client.gui.panels.extras.ChallengePanel;
import client.gui.panels.extras.SessionPanel.SessionType;

public class ChallengeWorkshopPage extends ClientPanel {
	private static final long serialVersionUID = 6597743772330564564L;
	public ChallengeWorkshopPage() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		JPanel upperPanel = new JPanel();
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientWindow.getInstance().setPage(HomePage.class);
			}
			
		});
		try {
			upperPanel.add(new JLabel(new ImageIcon(ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Strava_Logo.svg/2560px-Strava_Logo.svg.png")).getScaledInstance(150, 30, Image.SCALE_SMOOTH))), BorderLayout.WEST);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		upperPanel.add(new JLabel(" ".repeat(50) + "Challenge Workshop" + " ".repeat(50)), BorderLayout.CENTER);
		upperPanel.setBackground(Color.WHITE);
		upperPanel.add(backButton, BorderLayout.EAST);
		add(upperPanel, BorderLayout.NORTH);
		
		JPanel allPanel = new JPanel();
		BoxLayout bl = new BoxLayout(allPanel, BoxLayout.Y_AXIS);
		allPanel.setLayout(bl);
		//TODO Get available cycling challenges
		allPanel.add(createSection("Cycling", 
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true),
			new ChallengePanel(SessionType.CYCLING, "Test", new Date(), new Date(), 0, true)
			)
		);
		allPanel.add(new JLabel("\n"));
		//TODO Get available running challenges
		allPanel.add(createSection("Running", 
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.RUNNING, "Test", new Date(), new Date(), 0, true)
				)
			);
		allPanel.add(new JLabel("\n"));
		//TODO Get available running challenges
		allPanel.add(createSection("Cycling & Running", 
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true),
				new ChallengePanel(SessionType.BOTH, "Test", new Date(), new Date(), 0, true)
				)
			);
		add(allPanel, BorderLayout.CENTER);
		
	}
	private JPanel createSection(String name, JPanel... values) {
		JPanel end = new JPanel();
		BoxLayout bl = new BoxLayout(end, BoxLayout.Y_AXIS);
		end.setLayout(bl);
		JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		for(Component c : values) valuePanel.add(c);
		JScrollPane valueScroll= new JScrollPane(valuePanel);
		valueScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		valueScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		end.add(new JLabel(name));
		end.add(valueScroll);
		return end;
	}
	private static final Dimension PREFERRED_SIZE = new Dimension(700, 650);
	@Override
	public Dimension getPreferredSize() {
		return PREFERRED_SIZE;
	}

}
