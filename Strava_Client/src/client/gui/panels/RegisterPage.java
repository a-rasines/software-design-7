package client.gui.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class RegisterPage extends LoginPage{
	private static final long serialVersionUID = -6176236894068641990L;
	public enum Field{
		EMAIL,
		NAME,
		BIRTHDATE,
		WEIGHT,
		HEIGHT,
		MAX_HEARTH_RATE,
		REST_HEARTH_RATE,
	}
	HashMap<Field, String> data = new HashMap<>();
	HashMap<Field, JTextComponent> componentMap;
	public RegisterPage() {
		setLayout(new GridLayout(8, 1));
		JTextField nameField = new JTextField();
		add(createField("Name", nameField));
		componentMap.put(Field.NAME, nameField);
		
		JTextField emailField = new JTextField();
		add(createField("Email:", emailField));
		componentMap.put(Field.EMAIL, emailField);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField birthdateField = new JFormattedTextField(df);
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
		
		JTextField weightField = new JTextField();
		weightField.addKeyListener(new NumberFieldListener());
		add(createField("Weight(kg)(opt.):", weightField));
		componentMap.put(Field.WEIGHT, weightField);

		JTextField heightField = new JTextField();
		heightField.addKeyListener(new NumberFieldListener());
		add(createField("Height(cm)(opt.):", heightField));
		componentMap.put(Field.HEIGHT, heightField);
		
		JTextField mhrField = new JTextField();
		heightField.addKeyListener(new NumberFieldListener());
		add(createField("Max. Hearth Rate(bpm)(opt.):", mhrField));
		componentMap.put(Field.MAX_HEARTH_RATE, mhrField);
		
		JTextField rhrField = new JTextField();
		heightField.addKeyListener(new NumberFieldListener());
		add(createField("Hearth Rate in rest(bpm)(opt.):", rhrField));
		componentMap.put(Field.REST_HEARTH_RATE, rhrField);
	}
	private static final Dimension PREFERED_SIZE = new Dimension(400, 400);
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
