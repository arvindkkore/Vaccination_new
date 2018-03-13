package com.vaccination.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "child_vaccination")
public class ChildVaccination {
	
	private int id;
    private Child child;
    private Vaccination vaccination;
	private Date vaccinationDate;
    int vacin_status=0;
    
    @Id    
    @Column(name = "idchild_vaccination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
   
	
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idchild") 
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "idvaccination")
	public Vaccination getVaccination() {
		return vaccination;
	}
	public void setVaccination(Vaccination vaccination) {
		this.vaccination = vaccination;
	}
     
    /*// additional fields    
    
			  `` int(11) NOT NULL AUTO_INCREMENT,
			  `idchild` int(11) NOT NULL,
			  `idvaccination` int(11) NOT NULL,*/
			  
	@Column(name = "vaccination_date")   
	public Date getVaccinationDate() {
		return vaccinationDate;
	}
	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}
	public int getVacin_status() {
		return vacin_status;
	}
	public void setVacin_status(int vacin_status) {
		this.vacin_status = vacin_status;
	}
}
