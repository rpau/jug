package org.walkmod.jug.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name= "Tweet")
public class Tweet implements Serializable {
	
	@Id
	@Column(name = "tweet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;

	@Column(name = "text")
	private String text;
	
	@Column(name = "date")
	private Date date;

	public Tweet(User user, String text) {
		this.user = user;
		this.text = text;
		date = new Date();		
	}
}
