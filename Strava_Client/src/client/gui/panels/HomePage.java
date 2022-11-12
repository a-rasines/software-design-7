package client.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.gui.ClientPanel;
import client.gui.ClientWindow;

public class HomePage extends ClientPanel{
	private static final long serialVersionUID = 3192046128464182145L;
	public HomePage() {
		setLayout(new BorderLayout());
		JPanel logoPanel = new JPanel(new BorderLayout());
		JLabel logoLabel = null;
		try {
			logoLabel = new JLabel(new ImageIcon(ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Strava_Logo.svg/2560px-Strava_Logo.svg.png")).getScaledInstance(300, 62, Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			logoLabel = new JLabel("STRAVA");
			e.printStackTrace();
		}
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
		totalPanel.add(new JLabel("\n"));//Little offset
			JPanel sessionPanel = new JPanel(new BorderLayout());
				JPanel topPanel = new JPanel(new BorderLayout());
					topPanel.add(new JLabel("Your Sessions"), BorderLayout.CENTER);
					JButton createSession = new JButton("New");
					topPanel.add(createSession, BorderLayout.EAST);
				sessionPanel.add(topPanel, BorderLayout.NORTH);
				
				JPanel sessionList = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JScrollPane sessionScroll = new JScrollPane(sessionList, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.RUNNING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.RUNNING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
					sessionList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				sessionPanel.add(sessionScroll, BorderLayout.CENTER);
		totalPanel.add(sessionPanel);
		totalPanel.add(new JLabel("\n"));//Little offset
			JPanel challengePanel = new JPanel(new BorderLayout());
				topPanel = new JPanel(new BorderLayout());
				topPanel.add(new JLabel("Your Challenges"), BorderLayout.CENTER);
				JButton createChallenge = new JButton("New");
				topPanel.add(createChallenge, BorderLayout.EAST);
			challengePanel.add(topPanel, BorderLayout.NORTH);
			
			JPanel challengeList = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JScrollPane challengeScroll = new JScrollPane(challengeList, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.RUNNING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.RUNNING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.BOTH, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
				challengeList.add(createSessionPanel(SessionType.CYCLING, new Date(), "Test"));
			challengePanel.add(challengeScroll, BorderLayout.CENTER);
		totalPanel.add(challengePanel);
		totalPanel.add(new JLabel("\n"));//Little offset
		add(totalPanel, BorderLayout.CENTER);
	}
	@Override
	public void showPanel() {
		// TODO Auto-generated method stub
		
	}
	public enum SessionType{
		CYCLING("https://imgur.com/Pfwx0nA.png"),
		RUNNING("https://imgur.com/4xlBRWY.png"),
		BOTH("https://assets.ifttt.com/images/channels/1055884022/icons/monochrome_large.png");
		public final BufferedImage image;
		SessionType(String url){
			image = javaIsSpecialSometimes(url);
		}
		private BufferedImage javaIsSpecialSometimes(String url) {
			try {
				return ImageIO.read(new URL(url));
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private static final Color BACKGROUND_COLOR = new Color(50, 50, 50);
	private JPanel createSessionPanel(SessionType type, Date date, String title) {
		JPanel end = new JPanel(new BorderLayout());
		end.setBackground(BACKGROUND_COLOR);
		end.add(new JLabel(new ImageIcon(type.image.getScaledInstance(100, 100, Image.SCALE_SMOOTH))), BorderLayout.CENTER);
		JLabel label = new JLabel(title + " // " + DATE_FORMAT.format(date));
		label.setForeground(Color.WHITE);
		end.add(label, BorderLayout.SOUTH);
		return end;
		
	}
	private static final Dimension PREFERRED_SIZE = new Dimension(700, 480);
	@Override
	public Dimension getPreferredSize() {
		return PREFERRED_SIZE;
	}
}
