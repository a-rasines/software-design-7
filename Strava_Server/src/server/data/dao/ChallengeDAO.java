package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Challenge;


public class ChallengeDAO extends DataAccessObjectBase implements IDataAccessObject<Challenge>{
	private static final ChallengeDAO INSTANCE = new ChallengeDAO();
	public static ChallengeDAO getInstance() {
		return INSTANCE;
	}
	private ChallengeDAO() {}
	@Override
	public void save(Challenge object) {
		saveObject(object);
		
	}

	@Override
	public void delete(Challenge object) {
		deleteObject(object);
		
	}

	@Override
	public List<Challenge> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Challenge> articles = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Challenge> extent = pm.getExtent(Challenge.class, true);

			for (Challenge category : extent) {
				articles.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Challenges: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return articles;
	}

	@Override
	public Challenge find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Challenge result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Challenge.class.getName() + " WHERE email == " + param.replace("'", "''"));
			query.setUnique(true);
			result = (Challenge) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Challenge: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Challenge> getSomeChallenges(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Challenge> result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Challenge.class.getName() + " limit 20");
			query.setUnique(true);
			result = (List<Challenge>) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Challenge: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return result;
	}
}
