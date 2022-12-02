package server.data.domain;

import java.util.ArrayList;

import server.data.dto.LoginDTO;
import server.data.dto.RegisterDTO;
import server.data.enums.ProfileType;

public class DomainAssembler {

	public static Profile profileFromRegisterDTO(RegisterDTO dto) {
		Profile p = Profile.of(
			dto.getName(), 
			dto.getBirthdate(), 
			dto.getWeight(), 
			dto.getHeight(), 
			dto.getMaxHeartRate(), 
			dto.getRestHeartRate(), 
			dto.getEmail(), 
			new ArrayList<>(), 
			new ArrayList<>(), 
			dto.getType()
		);
		if(dto.getType() == ProfileType.EMAIL)
			((EmailProfile)p).setPassword(dto.getPassword());
		return p;
		
	}
	public static Login loginFromLoginDTO(LoginDTO login) {
		return new Login(login.email, login.password, login.profileType);
	}
	public static Login loginFromRegisterDTO(RegisterDTO login) {
		return new Login(login.getEmail(), login.getPassword(), login.getType());
	}
}
