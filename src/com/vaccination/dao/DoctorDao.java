package com.vaccination.dao;

import java.util.List;

import com.vaccination.model.Doctor;

public interface DoctorDao {

	Doctor findById(int id);

	Doctor saveDoctor(Doctor doctor);

	void deleteDoctorById(int id);

	List<Doctor> findAllDoctors();

	Doctor findDoctorById(int id);

	void saveAdmin(Doctor doctor);

}
