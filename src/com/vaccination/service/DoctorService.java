package com.vaccination.service;

import java.util.List;

import com.vaccination.model.Doctor;

public interface DoctorService 
{

	Doctor saveDoctor(Doctor doctor);

	void updateDoctor(Doctor doctor);

	List<Doctor> findAllDoctors();

	Doctor findDoctorById(int id);

	void deleteDoctorById(int id);

	void saveAdmin(Doctor doctor);

}
