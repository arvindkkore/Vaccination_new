package com.vaccination.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "child")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idchild;

	@Size(min = 3, max = 30)
	@Column(name = "child_name", nullable = false)
	private String child_name;

	@Size(min = 3, max = 30)
	@Column(name = "father_name", nullable = false)
	private String father_name;

	@Size(min = 3, max = 12)
	@Column(name = "mother_name", nullable = false)
	private String mother_name;

	@Column(name = "date_of_birth", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_of_birth;

	@Column(name = "vac_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date vac_date;

	@Size(min = 3, max = 12)
	@Column(name = "parent_contact", nullable = false)
	private String parent_contact;

	@Size(min = 3, max = 30)
	@Column(name = "parent_email", nullable = false)
	private String parent_email;
	
	@Column(name = "vaccination_id", nullable = false)
	private String vaccination_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "iddoctor", nullable = true)
	private Doctor doctor;

	
	@OneToMany(mappedBy = "child",fetch = FetchType.EAGER)	
	private Set<ChildVaccination> vaccination_done = new HashSet<>();

	public int getIdchild() {
		return idchild;
	}

	public void setIdchild(int idchild) {
		this.idchild = idchild;
	}

	public String getChild_name() {
		return child_name;
	}

	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getParent_contact() {
		return parent_contact;
	}

	public void setParent_contact(String parent_contact) {
		this.parent_contact = parent_contact;
	}

	public String getParent_email() {
		return parent_email;
	}

	public void setParent_email(String parent_email) {
		this.parent_email = parent_email;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getVac_date() {
		return vac_date;
	}

	public void setVac_date(Date vac_date)
	{
		this.vac_date = vac_date;
	}
	
	public String getVaccination_id() {
		return vaccination_id;
	}
	public void setVaccination_id(String vaccination_id) {
		this.vaccination_id = vaccination_id;
	}
	public Set<ChildVaccination> getVaccination_done() {
		return vaccination_done;
	}
	public void setVaccination_done(Set<ChildVaccination> vaccination_done) {
		this.vaccination_done = vaccination_done;
	}
	private boolean status=false; //0/1

	private String vac_name;
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setVac_name(String vaccination_name) {
	  this.vac_name=vaccination_name;
		
	}	
	public String getVac_name()
	{
     return vac_name;		
	}
	
	
	public int doc_id;
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
}
