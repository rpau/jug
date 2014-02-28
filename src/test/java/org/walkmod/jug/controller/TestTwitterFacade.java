package org.walkmod.jug.controller;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Test;
import org.walkmod.jug.hibernate.HibernateUtil;
import org.walkmod.jug.model.User;

public class TestTwitterFacade extends TestCase{

	@Test
	public void testCreateUser(){
		User u = new User("@walkmod");
		TwitterFacade tf = new TwitterFacade();
		tf.createUser(u);
		
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
}
