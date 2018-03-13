package com.vaccination.dao;

import java.util.List;
import java.util.Set;

import com.vaccination.model.Child;
import com.vaccination.model.ChildVaccination;
import com.vaccination.model.Search;
import com.vaccination.model.Vaccination;
 
public interface ChildDao {
 
    Child findById(int id); 
    Child saveChild(Child employee, Vaccination vaccination);
    List<Child> findAllChild();
	Child findChildById(int id);
	void deleteChildById(int id);
	void saveAdmin(Child child);
	Set<ChildVaccination> getVacHistoty(int child_id);
	Vaccination getVaccination(String vaccination_id);
	void getVaccination(Child child, Vaccination vaccination);
	List<Child> findChildByDate(Search search,int doctor_id);
	List<Vaccination> getRemainingVac(int child_id);
	void addChildByAdmin(Child child); 
    
 
}