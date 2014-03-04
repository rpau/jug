package org.walkmod.jug.model;

import java.util.Date;

public class Tweet {

	private User user;

	private String text;

	private Date date;

	public Tweet() {
	}

	public Tweet(User user, String text) {
		this.user = user;
		this.text = text;
		date = new Date();
	}


}
