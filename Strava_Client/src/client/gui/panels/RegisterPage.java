package client.gui.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import client.gui.ClientWindow;
import client.gui.panels.extras.LoginMouseListener;
import client.gui.panels.extras.NumberFieldListener;

public class RegisterPage extends FieldPage{
	private static final long serialVersionUID = -6176236894068641990L;
	public enum Field{
		EMAIL,
		NAME,
		PASSWORD,
		BIRTHDATE,
		WEIGHT,
		HEIGHT,
		MAX_HEARTH_RATE,
		REST_HEARTH_RATE,
	}
	HashMap<Field, String> data = new HashMap<>();
	HashMap<Field, JTextComponent> componentMap = new HashMap<>();
	public RegisterPage() {
		setLayout(new GridLayout(0, 1));
		
		add(new JLabel());//Offset
		JTextField nameField = new JTextField(24);
		add(createField("Name", nameField));
		componentMap.put(Field.NAME, nameField);
		
		JTextField emailField = new JTextField(24);
		add(createField("Email:", emailField));
		componentMap.put(Field.EMAIL, emailField);
		
		JPasswordField passwordField = new JPasswordField(24);
		add(createField("Password:", passwordField));
		componentMap.put(Field.EMAIL, passwordField);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField birthdateField = new JFormattedTextField(df);
		birthdateField.setColumns(24);
		birthdateField.setText(df.format(new Date()));
		birthdateField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9')   ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE)     || 
		         (c == KeyEvent.VK_SLASH)))
		    	  e.consume();
		    }
		});
		add(createField("Date of birth:", birthdateField));
		componentMap.put(Field.BIRTHDATE, birthdateField);
		
		JTextField weightField = new JTextField(24);
		weightField.addKeyListener(new NumberFieldListener());
		add(createField("Weight(kg)(opt.):", weightField));
		componentMap.put(Field.WEIGHT, weightField);

		JTextField heightField = new JTextField(24);
		heightField.addKeyListener(new NumberFieldListener());
		add(createField("Height(cm)(opt.):", heightField));
		componentMap.put(Field.HEIGHT, heightField);
		
		JTextField mhrField = new JTextField(16);
		heightField.addKeyListener(new NumberFieldListener());
		add(createField("Max. Hearth Rate(bpm)(opt.):", mhrField));
		componentMap.put(Field.MAX_HEARTH_RATE, mhrField);
		
		JTextField rhrField = new JTextField(16);
		heightField.addKeyListener(new NumberFieldListener());
		add(createField("Hearth Rate in rest(bpm)(opt.):", rhrField));
		componentMap.put(Field.REST_HEARTH_RATE, rhrField);
		
		JPanel enterPanel = new JPanel(new FlowLayout());
		JButton enter = new JButton("Register");
		enter.addMouseListener(
			new LoginMouseListener(
				p->{
					String token = ClientWindow.getInstance().getService().registerByEmail(p[0], p[1], p[2], p[3], weightField.getText().equals("")? 0 : Float.parseFloat(weightField.getText()), heightField.getText().equals("")? 0 : Float.parseFloat(heightField.getText()), mhrField.getText().equals("")? 0 : Float.parseFloat(mhrField.getText()), rhrField.getText().equals("")? 0 : Float.parseFloat(rhrField.getText()));
					if(!token.equals("UnU")) {
						ClientWindow.getInstance().getServerHandler().setToken(token);
						ClientWindow.getInstance().setPage(HomePage.class);
					}else {
						JOptionPane.showMessageDialog(null, "Something went wrong in registration");
					}
				},
				emailField, 
				passwordField,
				nameField,
				birthdateField
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
		fbLogin.addMouseListener(
				new LoginMouseListener(
						p->{
							String token = ClientWindow.getInstance().getService().registerByFacebook(p[0], p[1], p[2], p[3], weightField.getText().equals("")? 0 : Float.parseFloat(weightField.getText()), heightField.getText().equals("")? 0 : Float.parseFloat(heightField.getText()), mhrField.getText().equals("")? 0 : Float.parseFloat(mhrField.getText()), rhrField.getText().equals("")? 0 : Float.parseFloat(rhrField.getText()));
							if(!token.equals("UnU")) {
								ClientWindow.getInstance().getServerHandler().setToken(token);
								ClientWindow.getInstance().setPage(HomePage.class);
							}else {
								JOptionPane.showMessageDialog(null, "Something went wrong in registration");
							}
						},
						emailField, 
						passwordField,
						nameField,
						birthdateField
					)
				);
		enterPanel.add(fbLogin);
		JLabel gmailLogin = createImageLabel("https://rotulosmatesanz.com/wp-content/uploads/2017/09/2000px-Google_G_Logo.svg_.png",
											 "Login with Google",
											 40,
											 40);
		gmailLogin.addMouseListener(
				new LoginMouseListener(
						p->{
							String token = ClientWindow.getInstance().getService().registerByGoogle(p[0], p[1], p[2], p[3], weightField.getText().equals("")? 0 : Float.parseFloat(weightField.getText()), heightField.getText().equals("")? 0 : Float.parseFloat(heightField.getText()), mhrField.getText().equals("")? 0 : Float.parseFloat(mhrField.getText()), rhrField.getText().equals("")? 0 : Float.parseFloat(rhrField.getText()));
							if(!token.equals("UnU")) {
								ClientWindow.getInstance().getServerHandler().setToken(token);
								ClientWindow.getInstance().setPage(HomePage.class);
							} else {
								JOptionPane.showMessageDialog(null, "Something went wrong in registration");
							}
						},
						emailField, 
						passwordField,
						nameField,
						birthdateField
					)
				);
		enterPanel.add(gmailLogin);
	}
	private static final Dimension PREFERED_SIZE = new Dimension(400, 600);
	@Override
	public Dimension getPreferredSize() {
		return PREFERED_SIZE;
	}
	public void setField(Field field, String value) {
		data.put(field, value);
		componentMap.get(field).setText(value);
		componentMap.get(field).setEnabled(false);
	}
	@Override
	public void showPanel() {
		
	}

}
