package com.vaccination.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "doctor")
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddoctor;
	@Size(min = 3, max = 12)
	@Column(name = "doctor_name", nullable = false)
	private String doctor_name;
	
	@Size(min = 3, max = 12)
	@Column(name = "contact", nullable = false)
	String contact;	
		   
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	Set<Child> children=new HashSet<>();
	
	public int getIddoctor() {
		return iddoctor;
	}

	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	    public Set<Child> getChildren()  
	    {  
	        return children;  
	    }
	  
	 public void setChildren(Set<Child> children) {
		this.children = children;
	}
	
}
