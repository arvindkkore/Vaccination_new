package com.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vaccination.dao.DoctorDao;
import com.vaccination.model.Doctor;

 
@Service("doctorService")
@Transactional
public class DocServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao dao;
     
    public Doctor findById(int id) {
        return dao.findById(id);
    }
 
    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return dao.saveDoctor(doctor);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    
    @Override
    public void updateDoctor(Doctor doctor) {
        Doctor entity = dao.findById(doctor.getIddoctor());
        if(entity!=null){
            entity.setDoctor_name(doctor.getDoctor_name());
            entity.setContact(doctor.getContact());
        }
    }
 
    @Override
    public void deleteDoctorById(int id) {
        dao.deleteDoctorById(id);
    }
    @Override
    public List<Doctor> findAllDoctors() {
        return dao.findAllDoctors();
    }
    @Override
    public Doctor findDoctorById(int id) {
        return dao.findDoctorById(id);
    }

	@Override
	public void saveAdmin(Doctor doctor) {
		dao.saveAdmin(doctor);
	}
 
    
   
    
}