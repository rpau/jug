package org.walkmod.jug.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.walkmod.jug.hibernate.Hibernate;
import org.walkmod.jug.model.${query.resolve("type.name")};
import org.hibernate.criterion.Restrictions;

public class Twitter {
	
	private Hibernate hibernate = Hibernate.getInstance();
	
	@SuppressWarnings("unchecked")
	public List< ${query.resolve("type.name")} >  findAll${query.resolve("type.name")}s(int page, int rows){
		Session s = hibernate.openSession();
		List< ${query.resolve("type.name")} > result = null;
		try{
			result = s.createCriteria(${query.resolve("type.name")}.class)
						.setFirstResult(page*rows)
						.setMaxResults(rows).list();
		}
		finally{
			hibernate.closeSession();
		}
		
		return result;	
	}
	
	public void create${query.resolve("type.name")}(
	${query.resolve("type.name")} ${query.resolve("type.name").toLowerCase()}
	){
		Session s = hibernate.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.save(${query.resolve("type.name").toLowerCase()});
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException("Error storing a ${query.resolve("type.name")}",  e);
		} finally {
			hibernate.closeSession();
		}
	}
}