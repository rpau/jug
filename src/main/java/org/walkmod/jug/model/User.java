package org.walkmod.jug.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {
	//https://community.jboss.org/wiki/EqualsAndHashCode
	
	@Id
	@Column(name = "screenName", unique=true)
	private String screenName;
	
	public User(){
		
	}

	public User(String screenName) {
		this.screenName = screenName;
	}
	

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof User){
			return getScreenName().equals(((User)o).getScreenName());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return getScreenName().hashCode();
	}
}
