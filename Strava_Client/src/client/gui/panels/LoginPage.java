package client.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import client.gui.ClientWindow;
import client.gui.panels.extras.LoginMouseListener;
import server.remote.ClientController;

public class LoginPage extends FieldPage{

	private static final long serialVersionUID = 8120115114670778158L;
	private static final TitledBorder WRONG_CREDENTIALS;
	static {
		TitledBorder temp = BorderFactory.createTitledBorder("Username or password incorrect.");
		temp.setTitleColor(Color.white);
		WRONG_CREDENTIALS = temp;
	}
	@SuppressWarnings("deprecation")
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
		enter.addMouseListener(
			new LoginMouseListener(
				p->{
					try {
						ClientController.loginByEmail(username.getText(), pass.getText());
						ClientWindow.getInstance().setPage(HomePage.class);	
					} catch(RemoteException e){
						JOptionPane.showMessageDialog(null, "Something went wrong "+e.getCause().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}catch(Exception e) {
						
						username.setBorder(WRONG_CREDENTIALS);
						pass.setBorder(WRONG_CREDENTIALS);
					}
					
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
		fbLogin.addMouseListener(new LoginMouseListener(
				p->{
					try {
						ClientController.loginByFacebook(p[0], p[1]);
						ClientWindow.getInstance().setPage(HomePage.class);
					} catch(Exception e) {
						username.setBorder(WRONG_CREDENTIALS);
						pass.setBorder(WRONG_CREDENTIALS);
					}
					
				},
				username, 
				pass
			)
		);
		enterPanel.add(fbLogin);
		JLabel gmailLogin = createImageLabel("https://rotulosmatesanz.com/wp-content/uploads/2017/09/2000px-Google_G_Logo.svg_.png",
											 "Login with Google",
											 40,
											 40);
		gmailLogin.addMouseListener(new LoginMouseListener(
				p->{
					try {
						ClientController.loginByGoogle(p[0], p[1]);
						ClientWindow.getInstance().setPage(HomePage.class);
					} catch(RemoteException e) {
						username.setBorder(WRONG_CREDENTIALS);
						pass.setBorder(WRONG_CREDENTIALS);
					}
					
				},
				username, 
				pass
			)
		);
		enterPanel.add(gmailLogin);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientWindow.getInstance().setPage(RegisterPage.class);
			}
			
		});
		enterPanel.add(registerButton);
	}
	private static final Dimension PREFERED_SIZE = new Dimension(400, 250);
	@Override
	public Dimension getPreferredSize() {
		return PREFERED_SIZE;
	}

}
