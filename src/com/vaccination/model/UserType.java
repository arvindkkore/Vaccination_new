package com.vaccination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_type")
public class UserType {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int iduser_type;
	
	@Size(min=3, max=12)
	@Column(name = "user_type", nullable = false)
	String user_type;

	public int getIduser_type() {
		return iduser_type;
	}

	public void setIduser_type(int iduser_type) {
		this.iduser_type = iduser_type;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
		
	
	
}
