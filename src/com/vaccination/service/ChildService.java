package com.vaccination.service;

import java.util.List;
import java.util.Set;

import com.vaccination.model.Child;
import com.vaccination.model.ChildVaccination;
import com.vaccination.model.Search;
import com.vaccination.model.Vaccination;

//http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
public interface ChildService {

	Child findById(int id);

	Child saveChild(Child child, Vaccination vaccination);

	void updateChild(Child child);

	List<Child> findAllChild();

	void deleteChildById(int id);

	Child findChildById(int id);

	void saveAdmin(Child child);

	Set<ChildVaccination> getVacHistoty(int child_id);

	Vaccination getVaccination(String vaccination_id);

	void updateVaccination(Child child, Vaccination vaccination);

	List<Child> findChildByDate(Search search,int doctor_id);

	List<Vaccination> getRemainingVac(int child_id);

	void addChildByAdmin(Child child);

	
}
