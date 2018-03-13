package com.vaccination.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaccination.dao.ChildDao;
import com.vaccination.dao.EmployeeDao;
import com.vaccination.model.Child;
import com.vaccination.model.ChildVaccination;
import com.vaccination.model.Employee;
import com.vaccination.model.Search;
import com.vaccination.model.Vaccination;
 

 
@Service("childService")
@Transactional
public class ChildServiceImpl implements ChildService {
 
    @Autowired
    private ChildDao dao;
     
    public Child findById(int id) {
        return dao.findById(id);
    }
 
    public Child saveChild(Child child ,Vaccination vaccination) {
       return dao.saveChild(child,vaccination);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateChild(Child child) {
        Child entity = dao.findById(child.getIdchild());
        if(entity!=null){
            entity.setChild_name(child.getChild_name());
            entity.setFather_name(child.getFather_name());
            entity.setMother_name(child.getMother_name());
            entity.setParent_contact(child.getParent_contact());
            entity.setDate_of_birth(child.getDate_of_birth());
            entity.setParent_email(child.getParent_email());
            entity.setVaccination_id(child.getVaccination_id());
            
        }
    }
    
     
    public List<Child> findAllChild() {
        return dao.findAllChild();
    }
 
    public Child findChildById(int id) {
        return dao.findChildById(id);
    }

	@Override
	public void deleteChildById(int id) {
		dao.deleteChildById(id);		
	}
 
	@Override
	public void saveAdmin(Child child)
	{
		dao.saveAdmin(child);
	}

	@Override
	public Set<ChildVaccination> getVacHistoty(int child_id) 
	{
		return dao.getVacHistoty(child_id);
	}

	@Override
	public Vaccination getVaccination(String vaccination_id) {
		
		return dao.getVaccination(vaccination_id);
	}

	@Override
	public void updateVaccination(Child child, Vaccination vaccination) {
		dao.getVaccination(child,vaccination);
		
	}

	@Override
	public List<Child> findChildByDate(Search search,int doctor_id) {

		return dao.findChildByDate(search,doctor_id);
	}

	@Override
	public List<Vaccination> getRemainingVac(int child_id) {
		
		return dao.getRemainingVac(child_id);
	}

	@Override
	public void addChildByAdmin(Child child) {
		dao.addChildByAdmin(child);
	}
    
   
    
}