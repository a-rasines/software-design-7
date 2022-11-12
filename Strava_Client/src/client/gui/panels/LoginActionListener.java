package client.gui.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

public class LoginActionListener implements ActionListener{
	private static final TitledBorder EMPTY_FIELD_BORDER;
	static {
		TitledBorder temp = BorderFactory.createTitledBorder("This field needs to be filled");
		temp.setTitleColor(Color.white);
		EMPTY_FIELD_BORDER = temp;
	}
	JTextComponent[] fields;
	Consumer<String[]> success;
	public LoginActionListener(Consumer<String[]> onSuccess, JTextComponent... components) {
		fields = components;
		success = onSuccess;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] args = new String[fields.length];
		int i = 0;
		for(JTextComponent field : fields) {
			if(field.getText().trim().equals("")) {
				((JPanel)field.getParent()).setBorder(EMPTY_FIELD_BORDER);
				field.getParent().getParent().repaint();
				return;
			}
			((JPanel)field.getParent()).setBorder(null);
			field.getParent().getParent().repaint();
			args[i++] = field.getText();
		}
		success.accept(args);
	}

}
