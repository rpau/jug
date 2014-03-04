package org.walkmod.jug.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "User")
public class User implements Serializable {

	@Column(name = "screenName", unique = true)
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

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 1:09:17")
	public String getScreenName() {
		return screenName;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 1:09:17")
	public void setScreenName(String screenName) {
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

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 1:09:17")
	public void setId(Integer id) {
		this.id = id;
	}

	@javax.annotation.Generated(value = "org.walkmod", date = "04-mar-2014 1:09:17")
	public Integer getId() {
		return id;
	}
}
