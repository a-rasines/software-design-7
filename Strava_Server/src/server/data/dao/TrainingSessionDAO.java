package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.TrainingSession;

public class TrainingSessionDAO extends DataAccessObjectBase implements IDataAccessObject<TrainingSession>{
	private static final TrainingSessionDAO INSTANCE = new TrainingSessionDAO();
	public static TrainingSessionDAO getInstance() {
		return INSTANCE;
	}
	private TrainingSessionDAO() {}
	@Override
	public void save(TrainingSession object) {
		saveObject(object);
		
	}

	@Override
	public void delete(TrainingSession object) {
		deleteObject(object);
		
	}

	@Override
	public List<TrainingSession> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<TrainingSession> articles = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<TrainingSession> extent = pm.getExtent(TrainingSession.class, true);

			for (TrainingSession category : extent) {
				articles.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the TrainingSessions: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return articles;
	}

	@Override
	public TrainingSession find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		TrainingSession result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + TrainingSession.class.getName() + " WHERE email == " + param.replace("'", "''"));
			query.setUnique(true);
			result = (TrainingSession) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a TrainingSession: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
}
