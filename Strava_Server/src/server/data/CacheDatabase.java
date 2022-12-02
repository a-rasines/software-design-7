package server.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import server.data.domain.Profile;
import server.data.dto.ProfileDTO;
import server.data.enums.ProfileType;
/**
 * Temporal database
 * FIXME Delete when SQL or replace
 */
public class CacheDatabase {
	public static final UserMap userMap = new UserMap();
	static {
		//TODO Add hardcoded users
	}
	public static class UserMap implements Serializable{
		private static final long serialVersionUID = 5413245158457635047L;
		HashMap<ProfileType, UserSet> userMap = new HashMap<>();
		public boolean add(Profile profile) {
			userMap.putIfAbsent(profile.getType(), new UserSet());
			return userMap.get(profile.getType()).add(profile);
		}
		public boolean contains(Profile profile) {
			return userMap.get(profile.getType()).contains(profile);
		}
		@SuppressWarnings("unlikely-arg-type")
		public boolean contains(ProfileType type, String email) {
			return userMap.get(type).contains(email);
		}
		@SuppressWarnings("unchecked")
		public <T extends Profile> T get(ProfileType type, String email) {
			return (T)userMap.get(type).get(email);
		}
		
	}
	public static class UserSet extends HashSet<Profile>{
		private static final long serialVersionUID = 6812698332818013908L;
		public boolean contains(Object o) {
			if(o instanceof ProfileDTO)
				return super.contains(o);
			else if(o instanceof String)
				return get((String)o) != null;
			return false;
		}
		public Profile get(String email) {
			for(Profile profile : this) 
				if(profile.getEmail().equals(email))
					return profile;
			return null;
		}
	}
}
