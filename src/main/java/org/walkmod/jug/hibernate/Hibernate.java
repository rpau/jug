/* 
  Copyright (C) 2013 Raquel Pau and Albert Coroleu.
 
 Walkmod is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 Walkmod is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.
 
 You should have received a copy of the GNU Lesser General Public License
 along with Walkmod.  If not, see <http://www.gnu.org/licenses/>.*/

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
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration
            .getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
   }

   public Session openSession() {
      return sessionFactory.openSession();
   }

   public void closeSession() {
      sessionFactory.getCurrentSession().close();
   }

   private static Hibernate instance = null;

   public static Hibernate getInstance() {
      if (instance == null) {
         instance = new Hibernate();
      }
      return instance;
   }
}
