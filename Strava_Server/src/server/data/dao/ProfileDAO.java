package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Profile;
import server.data.enums.ProfileType;

public class ProfileDAO extends DataAccessObjectBase implements IDataAccessObject<Profile>{
	private static final ProfileDAO INSTANCE = new ProfileDAO();
	public static ProfileDAO getInstance() {
		return INSTANCE;
	}
	private ProfileDAO() {}
	public void save(Profile object) {
		saveObject(object);
		
	}

	public void delete(Profile object) {
		deleteObject(object);
		
	}

	public List<Profile> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Profile> articles = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Profile> extent = pm.getExtent(Profile.class, true);

			for (Profile category : extent) {
				articles.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Profiles: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return articles;
	}
	public Profile find(String email, ProfileType type) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Profile result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Profile.class.getName() + " WHERE email == '" + email.replace("'", "''")+"' && profileType == '"+type.toString()+"'");
			query.setUnique(true);
			result = (Profile) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a profile: " + ex.getMessage()+"\nQuery: "+"SELECT FROM " + Profile.class.getName() + " WHERE email == '" + email.replace("'", "''")+"' && profileType == '"+type.toString()+"'");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	public Profile find(String param) {
		return find(param, ProfileType.EMAIL);
	}
}
