package client.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import client.gui.ClientPanel;
import client.gui.ClientWindow;

public class LoginPage extends ClientPanel{

	private static final long serialVersionUID = 8120115114670778158L;
	
	public LoginPage() {
		setLayout(new GridLayout(4, 1));
		add(new JLabel());
		// <>---- Login info ----<>
		JTextField username = new JTextField(24);
		JPasswordField pass = new JPasswordField(24);
		add(createField("Email: ", username));
		add(createField("Password: ", pass));
		
		
		// <>---- Check info ----<>
		JPanel enterPanel = new JPanel(new FlowLayout());
		JButton enter = new JButton("Enter");
		enter.addActionListener(
			new LoginActionListener(
				p->{
					if(true) //TODO Ask for approval
						ClientWindow.getInstance().setPage(HomePage.class);
				},
				username, 
				pass
			)
		);
		enterPanel.add(enter);
		enterPanel.setBackground(TRANSPARENT);
		add(enterPanel);
		
		
		// <>---- Other login options ----<>
		JLabel fbLogin = createImageLabel("https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/2048px-Facebook_f_logo_%282019%29.svg.png",
										  "Login with Facebook",
										  40,
										  40);
		fbLogin.addMouseListener(new MouseAdapter() {
			LoginActionListener listener = new LoginActionListener(
				p->{
					if(true) //TODO Ask for approval
						ClientWindow.getInstance().setPage(HomePage.class);
				},
				username, 
				pass
			);
			@Override
			public void mouseClicked(MouseEvent e) {
				listener.actionPerformed(null);
			}
		});
		enterPanel.add(fbLogin);
		JLabel gmailLogin = createImageLabel("https://rotulosmatesanz.com/wp-content/uploads/2017/09/2000px-Google_G_Logo.svg_.png",
											 "Login with Google",
											 40,
											 40);
		gmailLogin.addMouseListener(new MouseAdapter() {
			LoginActionListener listener = new LoginActionListener(
					p->{
						if(true) //TODO Ask for approval
							ClientWindow.getInstance().setPage(HomePage.class);
					},
					username, 
					pass
				);
				@Override
				public void mouseClicked(MouseEvent e) {
					listener.actionPerformed(null);
				}
			});
		enterPanel.add(gmailLogin);
	}
	protected static final Color TRANSPARENT = new Color(0, 0, 0, 0);
	protected static final Color STRAVA_COLOR = new Color(252, 106, 36);
	protected JPanel createField(String name, JTextComponent field) {
		JPanel end = new JPanel(new FlowLayout());
		end.setBackground(TRANSPARENT);
		JLabel temp = new JLabel(name);
		temp.setForeground(Color.WHITE);
		end.add(temp);
		end.add(field);
		return end;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
		    g.setColor(STRAVA_COLOR);
		    Dimension pSize = getPreferredSize();
		    g.fillRect(0, 0, pSize.width, pSize.height);
	        try {
	        	int size = Math.min(pSize.width, pSize.height);
				g.drawImage(
						ImageIO.read(
								new URL("https://play-lh.googleusercontent.com/j-ZV144PlVuTVsLuBzIKyEw9CbFnmWw9ku2NJ1ef0gZJh-iiIN1nrNPmAtvgAteyDqU")
									.openStream())
							.getScaledInstance(size, size, Image.SCALE_SMOOTH),
						(getPreferredSize().width - size)/2, 
						(getPreferredSize().height - size)/2, 
						null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	protected JLabel createImageLabel(String url, String alternativeText, int sizeX, int sizeY) {
		ImageIcon icon;
		try {
			icon = new ImageIcon(ImageIO.read(new URL(url).openStream()).getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			icon = null;
			e.printStackTrace();
		}
		return icon==null ? new JLabel(alternativeText):new JLabel(icon);
	}
	@Override
	public void showPanel() {
		
		
	}
	private static final Dimension PREFERED_SIZE = new Dimension(400, 250);
	@Override
	public Dimension getPreferredSize() {
		return PREFERED_SIZE;
	}

}
