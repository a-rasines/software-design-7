package client.gui;

import javax.swing.JFrame;
import client.ServerHandler;
import client.gui.panels.LoginPage;

public class ClientWindow extends JFrame{
	private static final long serialVersionUID = -1115925128322368105L;
	private static ClientWindow instance;
	
	public static ClientWindow getInstance() {
		if(instance == null)
			return (instance = new ClientWindow());
		return instance;
	}
	public static void main(String[] args) {
		getInstance();
	}
	ServerHandler handler;
	ClientPanel showingPanel;
	private ClientWindow() {
		setPage(LoginPage.class);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setPage(Class<? extends ClientPanel> newPanel) {
		ClientPanel panel = ClientPanel.getInstanceOf(newPanel);
		setContentPane(panel);
		panel.showPanel();
		setMinimumSize(panel.getPreferredSize());
		setMaximumSize(panel.getPreferredSize());
		repaint();
	}
}
