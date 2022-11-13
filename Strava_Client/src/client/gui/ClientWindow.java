package client.gui;

import javax.swing.JFrame;

import client.gui.panels.LoginPage;
import server.remote.IServer;
import server.remote.ServerHandler;

public class ClientWindow extends JFrame{
	private static final long serialVersionUID = -1115925128322368105L;
	private static ClientWindow instance;
	
	public static ClientWindow getInstance() {
		return instance;
	}

	public void setServerHandler(ServerHandler sv) {
		handler = sv;
	}
	ServerHandler handler;
	ClientPanel showingPanel;
	public ClientWindow(ServerHandler handler) {
		instance =  this;
		setPage(LoginPage.class);
		setResizable(false);
		setVisible(true);
		setServerHandler(handler);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public ServerHandler getServerHandler() {
		return handler;
	}
	public IServer getService() {
		return handler.getService();
	}
	public void setPage(Class<? extends ClientPanel> newPanel) {
		ClientPanel panel = ClientPanel.getInstanceOf(newPanel);
		setContentPane(panel);
		repaint();
		setPreferredSize(panel.getPreferredSize());
		pack();
		setLocationRelativeTo(null);
		repaint();
	}
}
