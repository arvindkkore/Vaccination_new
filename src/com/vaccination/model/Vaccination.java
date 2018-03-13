package com.vaccination.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vaccination")
public class Vaccination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvaccination;

	@Size(min = 3, max = 30)
	@Column(name = "vaccination_name", nullable = false)
	private String vaccination_name;

	@Size(min = 3, max = 12)
	@Column(name = "vaccination__duration", nullable = false) // datetime
	private int vaccination_duration;

	@OneToMany(mappedBy = "vaccination")
	private Set<ChildVaccination> vaccination_done = new HashSet<>();

	public int getIdvaccination() {
		return idvaccination;
	}

	public void setIdvaccination(int idvaccination) {
		this.idvaccination = idvaccination;
	}

	public String getVaccination_name() {
		return vaccination_name;
	}

	public void setVaccination_name(String vaccination_name) {
		this.vaccination_name = vaccination_name;
	}

	public int getVaccination_duration() {
		return vaccination_duration;
	}

	public void setVaccination_duration(int vaccination_duration) {
		this.vaccination_duration = vaccination_duration;
	}

	public Set<ChildVaccination> getVaccination_done() {
		return vaccination_done;
	}

	public void setVaccination_done(Set<ChildVaccination> vaccination_done) {
		this.vaccination_done = vaccination_done;
	}
}
