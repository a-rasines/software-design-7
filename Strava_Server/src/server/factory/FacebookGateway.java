package server.factory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import server.data.dto.LoginDTO;
import server.data.dto.ProfileTypeDTO;

public class FacebookGateway implements AuthInterface {
	private LoginDTO profile;
	private static Socket s = null;
	public static void setupSocket(String ip, int port) throws UnknownHostException, IOException {
		if(s != null)
			s.close();
		s = new Socket("localhost", 1101);
	}
	public FacebookGateway(LoginDTO profile) {
		if(profile.profileType != ProfileTypeDTO.FACEBOOK)
			throw new IllegalArgumentException();
		this.profile = profile;
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
