package org.walkmod.jug.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import javax.persistence.Column;

@Entity
@Table(name = "User")
public class User {

	@Column(name = "screenName")
	private String screenName;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;

	public User() {
	}

	public User(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof User) {
			return id.equals(((User) o).id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 21:48:09")
	public String getScreenName() {
		return screenName;
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
