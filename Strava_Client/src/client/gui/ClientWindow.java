package client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.ServerHandler;

public class ClientWindow extends JFrame{
	private static final long serialVersionUID = -1115925128322368105L;
	private static ClientWindow instance;
	
	public static ClientWindow getInstance() {
		if(instance == null)
			return (instance = new ClientWindow());
		return instance;
	}
	
	ServerHandler handler;
	ClientPanel showingPanel;
	private ClientWindow() {
		
	}
	public void setPage(ClientPanel newPanel) {
		this.setContentPane(newPanel);
	}
}
