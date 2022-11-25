package server.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import server.data.temp.register.RegisterDTO;
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
		HashMap<Class<? extends ProfileDTO>, UserSet> userMap = new HashMap<>();
		public boolean add(ProfileDTO profile) {
			userMap.putIfAbsent(profile.getClass(), new UserSet());
			return userMap.get(profile.getClass()).add(profile);
		}
		public boolean contains(ProfileDTO profile) {
			return userMap.get(profile.getClass()).contains(profile);
		}
		@SuppressWarnings("unlikely-arg-type")
		public boolean contains(Class<? extends ProfileDTO> type, String email) {
			return userMap.get(type).contains(email);
		}
		@SuppressWarnings("unchecked")
		public <T extends ProfileDTO> T get(Class<T> type, String email) {
			return (T)userMap.get(type).get(email);
		}
		
	}
	public static class UserSet extends HashSet<ProfileDTO>{
		private static final long serialVersionUID = 6812698332818013908L;
		public boolean contains(Object o) {
			if(o instanceof ProfileDTO)
				return super.contains(o);
			else if(o instanceof String)
				return get((String)o) != null;
			return false;
		}
		public ProfileDTO get(String email) {
			for(ProfileDTO profile : this) 
				if(profile.getEmail().equals(email))
					return profile;
			return null;
		}
	}
}
