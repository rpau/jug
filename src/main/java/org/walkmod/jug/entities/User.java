package org.walkmod.jug.entities;

import javax.persistence.Entity;

@Entity
public class User {
	
	private String screenName;
	
	public User(String screenName){
		this.screenName = screenName;
	}
}
