package org.walkmod.jug.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Hibernate {

	private SessionFactory sessionFactory;

	
	
	private Hibernate() {
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	public void closeSession() {
		sessionFactory.getCurrentSession().close();
	}

	

	
	
}
