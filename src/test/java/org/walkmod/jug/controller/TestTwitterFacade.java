package org.walkmod.jug.controller;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Test;
import org.walkmod.jug.hibernate.HibernateUtil;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;

public class TestTwitterFacade extends TestCase{

	@Test
	public void testCreateUser() throws Exception{
		User u = new User("@walkmod");
	
		TwitterFacade.getInstance().createUser(u);
		
		Session s = HibernateUtil.getInstance().getSessionFactory().openSession();
		List result = new LinkedList();
		try{
			result = s.createCriteria(User.class).list();
			
		}
		finally{
			s.close();
		}
		Assert.assertEquals(1, result.size());
	}
	
	@Test
	public void testCreateTweet() throws Exception{
		User u = new User("@acoroleu");
		
		TwitterFacade.getInstance().createUser(u);
		
		Tweet tweet = new Tweet(u, "Hello @walkmod!. Nice to meet you!");
		TwitterFacade.getInstance().createTweet(tweet);
		
		Session s = HibernateUtil.getInstance().getSessionFactory().openSession();
		List result = new LinkedList();
		try{
			result = s.createCriteria(Tweet.class).list();
			
		}
		finally{
			s.close();
		}
		Assert.assertEquals(1, result.size());
		
		result = TwitterFacade.getInstance().getTimeLine("@acoroleu");
		
		Assert.assertEquals(1, result.size());
		
	}
}
