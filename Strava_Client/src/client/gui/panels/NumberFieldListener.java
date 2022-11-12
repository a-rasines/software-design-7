package client.gui.panels;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberFieldListener extends KeyAdapter{
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if((!(c >= '0') || !(c <= '9')) && c != '.')
			e.consume();
	}
}
