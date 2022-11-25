package server.data.temp.register;

import server.data.temp.AuthDTO;
import server.data.temp.login.LoginDTO;

public interface RegisterDTO extends AuthDTO{
	public LoginDTO getLoginData();
}
