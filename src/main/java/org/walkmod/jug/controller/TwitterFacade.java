package org.walkmod.jug.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.walkmod.jug.hibernate.HibernateUtil;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;

public class TwitterFacade {

	public List<Tweet> getTimeLine(String screenName) {
		Session session = HibernateUtil.getInstance().getSessionFactory()
				.openSession();
		
		@SuppressWarnings("unchecked")
		List<Tweet> result = session.createCriteria(Tweet.class)
				.createCriteria(" ").setFirstResult(0).setMaxResults(10).list();

		return result;
	}
	
	public void createUser ( User user ){	
		Session s = HibernateUtil.getInstance().getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		try{
		
			s.save(user);
			tx.commit();
		}catch (Exception e){
			tx.rollback();
		}
		finally{
			s.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(int page, int rows){
		Session s = HibernateUtil.getInstance().getSessionFactory().openSession();
		List< User > result = null;
		try{
			result = s.createCriteria(User.class)
						.setFirstResult(page*rows)
						.setMaxResults(rows).list();
		}
		finally{
			s.close();
		}
		
		return result;	
	}

}
