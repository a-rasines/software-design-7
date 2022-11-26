package server.factory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import server.data.temp.login.FacebookLoginDTO;
import server.data.temp.login.LoginDTO;

public class FacebookAssembler implements AuthInterface {
	private FacebookLoginDTO profile;
	private static Socket s = null;
	public static void setupSocket(String ip, int port) throws UnknownHostException, IOException {
		if(s != null)
			s.close();
		s = new Socket("localhost", 1101);
	}
	public FacebookAssembler(LoginDTO profile2) {
		if(!(profile2 instanceof FacebookLoginDTO))
			throw new IllegalArgumentException();
		this.profile = (FacebookLoginDTO) profile2;
	}
	public boolean authenticate() {
		try {
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF(profile.email + "\t" + profile.password);
			dout.flush();
			dout.close();
			DataInputStream din = new DataInputStream(s.getInputStream());
			return Boolean.parseBoolean(din.readUTF());
		} catch(Exception e) {
			System.out.println("No good");
			System.out.println(e);
			return false;
		}
		
	}
}
