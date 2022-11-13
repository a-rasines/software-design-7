package client.gui.panels.extras;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DateKeyListener extends KeyAdapter {
	public void keyTyped(KeyEvent e) {
	      char c = e.getKeyChar();
	      if (!((c >= '0') && (c <= '9')   ||
	         (c == KeyEvent.VK_BACK_SPACE) ||
	         (c == KeyEvent.VK_DELETE)     || 
	         (c == KeyEvent.VK_SLASH)))
	    	  e.consume();
	    }
}
