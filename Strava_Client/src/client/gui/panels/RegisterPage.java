package client.gui.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

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
