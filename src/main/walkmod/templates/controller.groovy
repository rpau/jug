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
	
	public void create${query.resolve("type.name")}(
	${query.resolve("type.name")} ${query.resolve("type.name").toLowerCase()}
	){
		Session s = HibernateUtil.getInstance().getSessionFactory()
				.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.save(${query.resolve("type.name").toLowerCase()});
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException("Error storing a ${query.resolve("type.name")}",  e);
		} finally {
			s.close();
		}
	}
}