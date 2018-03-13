package com.vaccination.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;


@Entity
@Table(name="admin")
public class Admin 
{
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idadmin;
 
    @Size(min=3, max=30)
    @Column(name = "user_name", nullable = false)
    private String user_name;
 
   
    @NotNull    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "user_type", nullable = false)
    private String user_type;

    @Column(name = "iddoctor")
    private int doctor_id;
    
    @Column(name = "idchild")
    private int child_id;
    
	public int getIdadmin() {
		return idadmin;
	}


	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
   
    public String getUser_type() {
		return user_type;
	}
    public void setUser_type(String user_type) {
		this.user_type = user_type;
	}


	public int getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}


	public int getChild_id() {
		return child_id;
	}


	
	public void setChild_id(int child_id) {
		this.child_id = child_id;
	}


	
    
}
