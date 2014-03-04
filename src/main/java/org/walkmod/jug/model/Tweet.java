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
@Table(name = "Tweet")
public class Tweet implements Serializable {

	@Id
	@Column(name = "tweet_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "screenName")
	@Column(name = "user")
	private User user;

	@Column(name = "text")
	private String text;

	@Column(name = "date")
	private Date date;

	public Tweet() {
	}

	public Tweet(User user, String text) {
		this.user = user;
		this.text = text;
		date = new Date();
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public Integer getId() {
		return id;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public void setId(Integer id) {
		this.id = id;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public User getUser() {
		return user;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public void setUser(User user) {
		this.user = user;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public String getText() {
		return text;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public void setText(String text) {
		this.text = text;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public Date getDate() {
		return date;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:37:25")
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Tweet) {
			return id.equals(((Tweet) o).id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
