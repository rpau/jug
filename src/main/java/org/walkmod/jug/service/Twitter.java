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

package org.walkmod.jug.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.walkmod.jug.hibernate.Hibernate;
import org.walkmod.jug.model.Tweet;
import org.walkmod.jug.model.User;

public class Twitter {
   private Hibernate hibernate = Hibernate.getInstance();

   private static Twitter instance = null;

   @SuppressWarnings("unchecked")
   public List<Tweet> findAllTweets(int page, int rows) {
      Session s = hibernate.openSession();
      List<Tweet> result = null;
      try {
         result = s.createCriteria(Tweet.class).setFirstResult(page * rows).setMaxResults(rows).list();
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
         result = s.createCriteria(User.class).setFirstResult(page * rows).setMaxResults(rows).list();
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
}
