package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import server.data.domain.EmailProfile;

public class EmailProfileDAO extends DataAccessObjectBase implements IDataAccessObject<EmailProfile>{
	private static final EmailProfileDAO INSTANCE = new EmailProfileDAO();
	public static EmailProfileDAO getInstance() {
		return INSTANCE;
	}
	private EmailProfileDAO() {}
	public void save(EmailProfile object) {
		saveObject(object);
		
	}

	public void delete(EmailProfile object) {
		deleteObject(object);
		
	}

	public List<EmailProfile> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<EmailProfile> articles = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<EmailProfile> extent = pm.getExtent(EmailProfile.class, true);

			for (EmailProfile category : extent) {
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
	public EmailProfile find(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		EmailProfile result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + EmailProfile.class.getName() + " WHERE email == '" + email.replace("'", "''")+"'");
			query.setUnique(true);
			result = (EmailProfile) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("  $ Error querying a profile: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
}
