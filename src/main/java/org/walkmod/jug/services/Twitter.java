package org.walkmod.jug.services;

import org.walkmod.jug.entities.User;

public class Twitter {

	public void createUser(String screenName){
		User user = new User(screenName);
	}
	
	
	
}
