package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		//Create socket conection
		try {
			ServerSocket ss = new ServerSocket(1101);
			System.out.println("created");
			Socket s = ss.accept(); //Se queda esperando
			System.out.println("accepted " + s);
			while(true) {
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String email = (String)dis.readUTF();
				String password = (String) dis.readUTF();
				
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeUTF(Facebook_AppService.authenticate(email, password) +  "");
				dos.flush();
				dos.close();
			}
			
		} catch(Exception e) {
			System.out.println(":(");
			System.out.println(e);
		}
	}
}
