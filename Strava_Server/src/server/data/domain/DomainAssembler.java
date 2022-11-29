package server.data.domain;

import java.util.ArrayList;

import server.data.dto.RegisterDTO;

public class DomainAssembler {

	public static Profile profileFromRegisterDTO(RegisterDTO dto) {
		return new Profile(dto.getName(), dto.getBirthdate(), dto.getWeight(), dto.getHeight(), dto.getMaxHeartRate(), dto.getRestHeartRate(), dto.getEmail(), new ArrayList<>(), new ArrayList<>(), dto.getType());
	}
}
