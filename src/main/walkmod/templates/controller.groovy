package org.walkmod.jug.controller;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.walkmod.jug.hibernate.HibernateUtil;
import org.walkmod.jug.model.${query.resolve("type.name")};

public class TwitterFacade{
	
	
	@SuppressWarnings("unchecked")
	public List findAll${query.resolve("type.name")}s(int page, int rows){
		Session s = HibernateUtil.getInstance().getSessionFactory().openSession();
		List< ${query.resolve("type.name")} > result = null;
		try{
			result = s.createCriteria(${query.resolve("type.name")}.class)
						.setFirstResult(page*rows)
						.setMaxResults(rows).list();
		}
		finally{
			s.close();
		}
		
		return result;	
	}
}