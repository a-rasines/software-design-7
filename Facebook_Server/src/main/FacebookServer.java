package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FacebookServer {
	public static void main(String[] args) {
		//Create socket conection
		while(true) {
			try (ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]))) {
				System.out.println("created");
				Socket s = ss.accept(); //Se queda esperando
				System.out.println("accepted " + s);
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				while(true) {
					String[] params = dis.readUTF().split("\t");
				
					dos.writeUTF(Facebook_AppService.authenticate(params[0], params[1]) +  "");
					dos.flush();
				}
				
			} catch(Exception e) {
				System.out.println(":(");
				System.out.println(e);
			}
		}
	}
}
