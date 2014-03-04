package org.walkmod.jug.controller;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Test;
import org.walkmod.jug.hibernate.Hibernate;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;
import org.walkmod.jug.service.Twitter;

public class TestTwitterFacade extends TestCase{
	
	
	private Twitter sut = Twitter.getInstance(); 
	private Hibernate hibernate = Hibernate.getInstance();

	@Test
	public void testCreateUser() throws Exception{
		User u = new User("@walkmod");
	
		sut.createUser(u);
		
		Session session = hibernate.openSession();
		List result = new LinkedList();
		try{
			result = session.createCriteria(User.class).list();
			
		}
		finally{
			session.close();
		}
		Assert.assertEquals(1, result.size());
	}
	
	@Test
	public void testCreateTweet() throws Exception{
		User u = new User("@acoroleu");
		
		sut.createUser(u);
		
		Tweet tweet = new Tweet(u, "Hello @walkmod!. Nice to meet you!");
		sut.createTweet(tweet);
		
		Session s = hibernate.openSession();
		List<Tweet> result = new LinkedList();
		try{
			result = s.createCriteria(Tweet.class).list();
			
		}
		finally{
			s.close();
		}
		Assert.assertEquals(1, result.size());
		
		result = sut.getTimeLine("@acoroleu");
		
		Assert.assertEquals(1, result.size());
		
	}
}
