package server.data.domain;

import java.util.ArrayList;
import java.util.HashMap;

import server.data.dto.ChallengeDTO;
import server.data.dto.LoginDTO;
import server.data.dto.RegisterDTO;
import server.data.dto.TrainingSessionDTO;
import server.data.enums.ProfileType;

public class DataAssembler {

	private static DataAssembler instance = new DataAssembler();
	
	public static DataAssembler getInstance() {
		return instance;
	}
	
	public Register registerFromRegisterDTO(RegisterDTO dto) {
		return new Register(dto.getPassword(), dto.getType(), dto.getName(), dto.getBirthdate(), dto.getWeight(), dto.getHeight(), dto.getMaxHeartRate(), dto.getRestHeartRate(), dto.getEmail());
	}
	
	public Profile profileFromRegisterDTO(RegisterDTO dto) {
		Profile p = Profile.of(
			dto.getName(), 
			dto.getBirthdate(), 
			dto.getWeight(), 
			dto.getHeight(), 
			dto.getMaxHeartRate(), 
			dto.getRestHeartRate(), 
			dto.getEmail(), 
			new ArrayList<>(), 
			new HashMap<Challenge, Byte>(), 
			dto.getType()
		);
		if(dto.getType() == ProfileType.EMAIL)
			((EmailProfile)p).setPassword(dto.getPassword());
		return p;
		
	}
	public Profile profileFromRegister(Register dto) {
		Profile p = Profile.of(
			dto.getName(), 
			dto.getBirthdate(), 
			dto.getWeight(), 
			dto.getHeight(), 
			dto.getMaxHeartRate(), 
			dto.getRestHeartRate(), 
			dto.getEmail(), 
			new ArrayList<>(), 
			new HashMap<Challenge, Byte>(), 
			dto.getType()
		);
		if(dto.getType() == ProfileType.EMAIL)
			((EmailProfile)p).setPassword(dto.getPassword());
		return p;
		
	}
	public Login loginFromLoginDTO(LoginDTO login) {
		return new Login(login.email, login.password, login.profileType);
	}
	
	public Login loginFromRegisterDTO(RegisterDTO login) {
		return new Login(login.getEmail(), login.getPassword(), login.getType());
	}
	public Login loginFromRegister(Register login) {
		return new Login(login.getEmail(), login.getPassword(), login.getType());
	}
	
	public TrainingSession trainingSessionFromTrainingSessionDTO(TrainingSessionDTO dto, Profile owner) {
		return new TrainingSession(dto.getName(), dto.getSport(), dto.getStartDate(), dto.getDistance(), dto.getDuration(), owner);
	}
	
	public TrainingSessionDTO trainingSessionDTOFromTrainingsession(TrainingSession ts) {
		return new TrainingSessionDTO(ts.getName(),ts.getSport(),ts.getStartDate(),ts.getDistance(),ts.getDuration());
	}
	
	public Challenge challengeFromChallengeDTO(ChallengeDTO cdto) {
		return new Challenge(cdto.getName(), cdto.getStartDate(), cdto.getEndDate(), cdto.getDistanceTarget(), cdto.getTimeTarget(), cdto.getSport());
	}
	public ChallengeDTO challengeDTOFromChallenge(Challenge cdto, byte progress) {
		return new ChallengeDTO(cdto.getId(), cdto.getName(), cdto.getStartDate(), cdto.getEndDate(), cdto.getDistanceTarget(), cdto.getTimeTarget(), cdto.getSport(), progress);
	}
}
