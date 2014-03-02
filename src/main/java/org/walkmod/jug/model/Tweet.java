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
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Tweet){
			return getId().equals(((Tweet) o).getId());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return getId().hashCode();
	}
}
