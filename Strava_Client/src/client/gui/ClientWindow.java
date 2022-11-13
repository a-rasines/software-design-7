package client.gui;

import javax.swing.JFrame;

import client.gui.panels.LoginPage;
import client.remote.IServer;
import client.remote.ServerHandler;
import testing.ServerHandlerSim;

public class ClientWindow extends JFrame{
	private static final long serialVersionUID = -1115925128322368105L;
	private static ClientWindow instance;
	
	public static ClientWindow getInstance() {
		if(instance == null)
			return (instance = new ClientWindow());
		return instance;
	}
	public static void main(String[] args) {
		if(args.length != 0)
			getInstance().setServerHandler(new ServerHandler(args[0], args[1], args[2]));
		else
			getInstance().setServerHandler(new ServerHandlerSim());;
	}
	public void setServerHandler(ServerHandler sv) {
		handler = sv;
	}
	ServerHandler handler;
	ClientPanel showingPanel;
	private ClientWindow() {
		setPage(LoginPage.class);
		setResizable(false);
		setVisible(true);
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
