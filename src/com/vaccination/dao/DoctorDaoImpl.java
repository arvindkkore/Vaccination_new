package com.vaccination.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vaccination.model.Admin;
import com.vaccination.model.Child;
import com.vaccination.model.Doctor;
import com.vaccination.model.Employee;
 
@Repository("doctorDao")
public class DoctorDaoImpl extends AbstractDao<Integer, Doctor> implements DoctorDao {
 
    public Doctor findById(int id) {
        return getByKey(id);
    }
 
    public Doctor saveDoctor(Doctor doctor) {
        return persist(doctor);
    }
 
    @SuppressWarnings("unchecked")
    public List<Doctor> findAllDoctors() {
        Criteria criteria = createEntityCriteria();
        return (List<Doctor>) criteria.list();
    }

	@Override
	public Doctor findDoctorById(int id) 
	{
		return getByKey(id);
	}

	@Override
	public void deleteDoctorById(int id) 
	{
		
	}

	@Override
	public void saveAdmin(Doctor doctor) 
	{
	 	Admin admin=new Admin(); 
		admin.setUser_name(doctor.getDoctor_name());
		admin.setPassword("qwerty");
		admin.setDoctor_id(doctor.getIddoctor());
		admin.setUser_type("2");
		getSession().persist(admin);
	}


 
   
}