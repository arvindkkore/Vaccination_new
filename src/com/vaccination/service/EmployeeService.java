package com.vaccination.service;


import java.util.List;

import com.vaccination.model.Admin;
import com.vaccination.model.Employee;
import com.vaccination.model.Login;
import com.vaccination.model.UserType;
import com.vaccination.model.Vaccination;

public interface EmployeeService {

   Employee findById(int id);
    
   void saveEmployee(Employee employee);
    
   void updateEmployee(Employee employee);
    
   void deleteEmployeeBySsn(String ssn);

   List<Employee> findAllEmployees(); 
    
   Employee findEmployeeBySsn(String ssn);

   boolean isEmployeeSsnUnique(Integer id, String ssn);

   List<UserType> userType();

   Admin login(Login login);

List<Vaccination> getVaccination();
    
}