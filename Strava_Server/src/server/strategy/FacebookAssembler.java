package server.strategy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookAssembler {
	public static String authenticate(String email, String password) {
		try {
			Socket s = new Socket("localhost", 1101);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF(email);
			dout.flush();
			dout.writeUTF(password);
			dout.flush();
			dout.close();
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			return (String) din.readUTF();
		} catch(Exception e) {
			System.out.println("No good");
			System.out.println(e);
			return("no");
		}
		
	}
}
