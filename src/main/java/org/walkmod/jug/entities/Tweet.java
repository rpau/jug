package org.walkmod.jug.entities;

import javax.persistence.Entity;

@Entity
public class Tweet {
	
	private User user;
	private String text;
	
	public Tweet(User user, String text){
		this.user = user;
		this.text = text;
	}

}
