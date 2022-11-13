package client.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.gui.ClientPanel;
import client.gui.ClientWindow;
import client.gui.panels.extras.ChallengePanel;
import client.gui.panels.extras.SessionPanel;
import client.gui.panels.extras.SessionPanel.SessionType;

public class HomePage extends ClientPanel{
	private static final long serialVersionUID = 3192046128464182145L;
	private JPanel sessionList;
	private JPanel challengeList;
	
	public HomePage() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JPanel logoPanel = new JPanel(new BorderLayout());
		JLabel logoLabel = null;
		try {
			logoLabel = new JLabel(new ImageIcon(ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Strava_Logo.svg/2560px-Strava_Logo.svg.png")).getScaledInstance(300, 62, Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			logoLabel = new JLabel("STRAVA");
			e.printStackTrace();
		}
		logoPanel.setBackground(TRANSPARENT);
		logoPanel.add(logoLabel, BorderLayout.CENTER);
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ClientWindow.getInstance().getService().logout(ClientWindow.getInstance().getServerHandler().getToken());
					ClientWindow.getInstance().setPage(LoginPage.class);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "Something went wrong: " + e1.getMessage());
				}
			}
			
		});
		logoPanel.add(logoutButton, BorderLayout.EAST);
		add(logoPanel, BorderLayout.NORTH);
		
		JPanel totalPanel = new JPanel();
		BoxLayout bl = new BoxLayout(totalPanel, BoxLayout.Y_AXIS);
		totalPanel.setLayout(bl);
		totalPanel.setBackground(TRANSPARENT);
		totalPanel.add(new JLabel("\n"));//Little offset
			JPanel sessionPanel = new JPanel(new BorderLayout());
			sessionPanel.setBackground(TRANSPARENT);
				JPanel topPanel = new JPanel(new BorderLayout());
				topPanel.setBackground(TRANSPARENT);
					topPanel.add(new JLabel(" Your Sessions"), BorderLayout.CENTER);
					JPanel buttonOffsetPanel = new JPanel(new FlowLayout());
					buttonOffsetPanel.setBackground(TRANSPARENT);
						JButton createSession = new JButton("New");
						createSession.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								ClientWindow.getInstance().setPage(TrainingPage.class);
								
							}
						});
						buttonOffsetPanel.add(createSession);
					topPanel.add(buttonOffsetPanel, BorderLayout.EAST);
				sessionPanel.add(topPanel, BorderLayout.NORTH);
				
				sessionList = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JScrollPane sessionScroll = new JScrollPane(sessionList, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					//TODO Turn this into a for loop with info
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.RUNNING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.RUNNING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
					sessionList.add(new SessionPanel(SessionType.CYCLING, "Test", new Date(), 0, 1));
				sessionPanel.add(sessionScroll, BorderLayout.CENTER);
		totalPanel.add(sessionPanel);
		totalPanel.add(new JLabel("\n"));//Little offset
			JPanel challengePanel = new JPanel(new BorderLayout());
			challengePanel.setBackground(TRANSPARENT);
				topPanel = new JPanel(new BorderLayout());
				topPanel.setBackground(TRANSPARENT);
				topPanel.add(new JLabel(" Your Challenges"), BorderLayout.CENTER);
				JPanel buttonPanel = new JPanel(new FlowLayout());
				buttonPanel.setBackground(TRANSPARENT);
					JButton createChallenge = new JButton("New");
					JButton browseChallenge = new JButton("Browse");
					buttonPanel.add(browseChallenge);
					buttonPanel.add(createChallenge);
				topPanel.add(buttonPanel, BorderLayout.EAST);
			challengePanel.add(topPanel, BorderLayout.NORTH);
			
			challengeList = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JScrollPane challengeScroll = new JScrollPane(challengeList, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				//TODO Turn this into a for loop with info
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.RUNNING, "Completed Challenge", new Date(), new Date(10000000000l), 1, true, true));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Completed Challenge", new Date(), new Date(10000000000l), 1, true, true));
				challengeList.add(new ChallengePanel(SessionType.BOTH, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.BOTH, "Challenge", new Date(), new Date(10000000000l), 1, true, true));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, false, false));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
				challengeList.add(new ChallengePanel(SessionType.CYCLING, "Challenge", new Date(), new Date(10000000000l), 1, true, false));
			challengePanel.add(challengeScroll, BorderLayout.CENTER);
		totalPanel.add(challengePanel);
		totalPanel.add(new JLabel("\n"));//Little offset
		add(totalPanel, BorderLayout.CENTER);
	}
	public void addTrainingSession(SessionPanel panel) {
		sessionList.add(panel);
	}
	private static final Dimension PREFERRED_SIZE = new Dimension(700, 530);
	@Override
	public Dimension getPreferredSize() {
		return PREFERRED_SIZE;
	}
}
