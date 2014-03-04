package org.walkmod.jug.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.walkmod.jug.hibernate.Hibernate;
import org.walkmod.jug.model.Tweet;
import org.hibernate.criterion.Restrictions;
import org.walkmod.jug.model.User;

public class Twitter {

	private Hibernate hibernate = Hibernate.getInstance();

	private static Twitter instance = null;

	@SuppressWarnings("unchecked")
	public List<Tweet> findAllTweets(int page, int rows) {
		Session s = hibernate.openSession();
		List<Tweet> result = null;
		try {
			result = s.createCriteria(Tweet.class).setFirstResult(page * rows)
					.setMaxResults(rows).list();
		} finally {
			hibernate.closeSession();
		}
		return result;
	}

	public void createTweet(Tweet tweet) {
		Session s = hibernate.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.save(tweet);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException("Error storing a Tweet", e);
		} finally {
			hibernate.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(int page, int rows) {
		Session s = hibernate.openSession();
		List<User> result = null;
		try {
			result = s.createCriteria(User.class).setFirstResult(page * rows)
					.setMaxResults(rows).list();
		} finally {
			hibernate.closeSession();
		}
		return result;
	}

	public void createUser(User user) {
		Session s = hibernate.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException("Error storing a User", e);
		} finally {
			hibernate.closeSession();
		}
	}

	public static Twitter getInstance() {
		if (instance == null) {
			instance = new Twitter();
		}
		return instance;
	}

	private Twitter() {
	}
	
	public List<Tweet> getTimeLine(String screenName) throws Exception {
		Session session = hibernate.openSession();
		@SuppressWarnings("unchecked")
		List<Tweet> result = session.createCriteria(Tweet.class)
				.createCriteria("user")
				.add(Restrictions.eq("screenName", screenName))
				.setFirstResult(0).setMaxResults(10).list();
		hibernate.closeSession();
		return result;
	}
}
