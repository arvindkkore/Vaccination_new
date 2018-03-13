package com.vaccination.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vaccination.model.Admin;
import com.vaccination.model.Employee;
import com.vaccination.model.Login;
import com.vaccination.model.UserType;
import com.vaccination.model.Vaccination;
 
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
 
    public Employee findById(int id) {
        return getByKey(id);
    }
 
    public void saveEmployee(Employee employee) {
        persist(employee);
    }
 
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }
 
    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }

	@Override
	public List<UserType> userType() {
		List<UserType>  list =null;
		list = getSession().createCriteria(UserType.class).list();		 
		return list;
	}

	@Override
	public Admin login(Login login) {
		
		Admin admin=null;
		String SQL_QUERY =" from Admin as o where o.user_name=? and o.password=? and o.user_type=?";
		Query query = getSession().createQuery(SQL_QUERY);
		query.setParameter(0,login.getUsername());
		query.setParameter(1,login.getPassword());
		query.setParameter(2,login.getUser_type());
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			admin=(Admin)list.get(0);	
		}
		return admin;
	}

	@Override
	public List<Vaccination> getVaccinations() {
		List<Vaccination>  list =null;
		list = getSession().createCriteria(Vaccination.class).list();		 
		return list;
		
	}
}