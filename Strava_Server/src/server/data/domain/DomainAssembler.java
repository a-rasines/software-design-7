package server.data.domain;

import java.util.ArrayList;

import server.data.dto.ProfileTypeDTO;
import server.data.dto.RegisterDTO;

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
		if(dto.getType() == ProfileTypeDTO.EMAIL)
			((EmailProfile)p).setPassword(dto.getPassword());
		return p;
		
	}
}
