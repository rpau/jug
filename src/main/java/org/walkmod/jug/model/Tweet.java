package org.walkmod.jug.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Tweet")
public class Tweet {

	@Column(name = "user")
	private User user;

	@Column(name = "text")
	private String text;

	@Column(name = "date")
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;

	public Tweet() {
	}

	public Tweet(User user, String text) {
		this.user = user;
		this.text = text;
		date = new Date();
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

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public void setUser(User user) {
		this.user = user;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public User getUser() {
		return user;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public void setText(String text) {
		this.text = text;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public String getText() {
		return text;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public void setDate(Date date) {
		this.date = date;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public Date getDate() {
		return date;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public void setId(Integer id) {
		this.id = id;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public Integer getId() {
		return id;
	}
}
