package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class FacebookServer {
	public static void main(String[] args) {
		System.out.println("Started");
		while(true) {
			try (ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]))) {
				System.out.println("Waiting for connections");
				Socket s = ss.accept(); //Se queda esperando
				System.out.println("accepted " + s);
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				while(true) {
					String[] params = null;
					try {
						params = dis.readUTF().split("\t");
					}catch(EOFException e) {continue;}
					dos.writeUTF(Facebook_AppService.authenticate(params[0], params[1])?"true":"false");
					dos.flush();
				}
				
			}catch(BindException e) {
				System.err.println("Unable to bind");
				e.printStackTrace();
				return;
			}catch(Exception e) {
				System.out.println("Disconnected");
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}
}
