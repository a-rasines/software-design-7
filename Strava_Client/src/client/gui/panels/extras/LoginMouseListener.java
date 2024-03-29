package client.gui.panels.extras;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import client.gui.ClientWindow;

public class LoginMouseListener extends MouseAdapter{
	private static final TitledBorder EMPTY_FIELD_BORDER;
	static {
		TitledBorder temp = BorderFactory.createTitledBorder("This field needs to be filled");
		temp.setTitleColor(Color.white);
		EMPTY_FIELD_BORDER = temp;
	}
	JTextComponent[] fields;
	Consumer<String[]> success;
	public LoginMouseListener(Consumer<String[]> onSuccess, JTextComponent... components) {
		fields = components;
		success = onSuccess;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		String[] args = new String[fields.length];
		int i = 0;
		for(JTextComponent field : fields) {
			if(field.getText().trim().equals("")) {
				((JPanel)field.getParent()).setBorder(EMPTY_FIELD_BORDER);
				ClientWindow.getInstance().repaint();
				return;
			}
			if(field.getParent() != null)
				((JPanel)field.getParent()).setBorder(null);
			ClientWindow.getInstance().repaint();
			args[i++] = field.getText();
		}
		success.accept(args);
		for(MouseListener m : e.getComponent().getMouseListeners())//Reset button appearance
			m.mouseReleased(e);
	}

}
