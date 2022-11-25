package server.factory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import server.data.temp.login.FacebookLoginDTO;
import server.data.temp.login.LoginDTO;

public class FacebookAssembler implements AuthInterface {
	private FacebookLoginDTO profile;
	public FacebookAssembler(LoginDTO profile2) {
		if(!(profile2 instanceof FacebookLoginDTO))
			throw new IllegalArgumentException();
		this.profile = (FacebookLoginDTO) profile2;
	}
	public boolean authenticate() {
		try {
			Socket s = new Socket("localhost", 1101);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF(profile.email + "\t" + profile.password);
			dout.flush();
			dout.close();
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			return true;
		} catch(Exception e) {
			System.out.println("No good");
			System.out.println(e);
			return false;
		}
		
	}
}
