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

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table (name= "Tweet")
public class Tweet implements Serializable {
	
	@Id
	@Column(name = "tweet_id")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private Long id;

	@ManyToOne
    @JoinColumn(name = "screenName")
	private User user;

	@Column(name = "text")
	private String text;
	
	@Column(name = "date")
	private Date date;

	public Tweet(){
		
	}
	
	public Tweet(User user, String text) {
		this.user = user;
		this.text = text;
		date = new Date();		
	}
}
