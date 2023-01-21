package client.gui.panels.extras;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberFieldListener extends KeyAdapter{
	private boolean decimal;
	public NumberFieldListener(boolean decimal) {
		this.decimal = decimal;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if((!(c >= '0') || !(c <= '9')) && (c != '.' || !decimal))
			e.consume();
	}
}
