package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.gui.panels.LoginPage;

public class ClientWindow extends JFrame{
	private static final long serialVersionUID = -1115925128322368105L;
	private static ClientWindow instance;
	public static ClientWindow getInstance() {
		return instance;
	}
	ClientPanel showingPanel;
	public ClientWindow() {
		instance =  this;
		setPage(LoginPage.class);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setPage(Class<? extends ClientPanel> newPanel) {
		try {
			ClientPanel panel = ClientPanel.getInstanceOf(newPanel);
			setContentPane(panel);
			repaint();
			setPreferredSize(panel.getPreferredSize());
			pack();
			setLocationRelativeTo(null);
			repaint();
		}catch(RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Error changing window", "Fatal error", JOptionPane.ERROR_MESSAGE);
			e.getCause().getCause().printStackTrace();
		}
	}
}
