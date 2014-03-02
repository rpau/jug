package org.walkmod.jug.controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.walkmod.jug.hibernate.HibernateUtil;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;

public class TwitterFacade {

	public List<Tweet> getTimeLine(String screenName) throws Exception {
		Session session = HibernateUtil.getInstance().getSessionFactory()
				.openSession();
		@SuppressWarnings("unchecked")
		List<Tweet> result = session.createCriteria(Tweet.class)
				.createCriteria("user")
				.add(Restrictions.eq("screenName", screenName))
				.setFirstResult(0).setMaxResults(10).list();
		return result;
	}

	public void createTweet(Tweet tweet) throws Exception {
		Session s = HibernateUtil.getInstance().getSessionFactory()
				.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.save(tweet);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			s.close();
		}
	}

	public void createUser(User user) throws Exception {
		Session s = HibernateUtil.getInstance().getSessionFactory()
				.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			s.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(int page, int rows) throws Exception {
		Session s = HibernateUtil.getInstance().getSessionFactory()
				.openSession();
		List<User> result = null;
		try {
			result = s.createCriteria(User.class).setFirstResult((page-1) * rows)
					.setMaxResults(rows).list();
		} finally {
			s.close();
		}
		return result;
	}

	public static TwitterFacade getInstance() {
		if (instance == null) {
			instance = new TwitterFacade();
		}
		return instance;
	}

	private static TwitterFacade instance = null;

	private TwitterFacade() {
	}
}
