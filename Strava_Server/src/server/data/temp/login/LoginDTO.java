package server.data.temp.login;

import server.data.ProfileDTO;
import server.data.temp.AuthDTO;

public interface LoginDTO extends AuthDTO{
	public String getID();
	public Class<? extends ProfileDTO> getReferredProfile();
}
