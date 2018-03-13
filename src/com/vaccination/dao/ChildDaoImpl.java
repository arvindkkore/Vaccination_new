package com.vaccination.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Expression;
import javax.print.Doc;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vaccination.model.Admin;
import com.vaccination.model.Child;
import com.vaccination.model.ChildVaccination;
import com.vaccination.model.Doctor;
import com.vaccination.model.Search;
import com.vaccination.model.UserType;
import com.vaccination.model.Vaccination;
 
@Repository("childDao")
public class ChildDaoImpl extends AbstractDao<Integer, Child> implements ChildDao {
 
    public Child findById(int id) {
        return getByKey(id);
    }
 
    public Child saveChild(Child child,Vaccination vaccination) {
    	
    	Doctor doctor=(Doctor)getSession().get(Doctor.class,child.getDoc_id());    	
    	child.setDoctor(doctor);
    	SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
		Calendar cal = Calendar.getInstance();   
    	if (child.getStatus()) //or vacdate=current date 
    	{
    		
    		// add into hidtory table
        	Vaccination vaccination1 = (Vaccination)getSession().get(Vaccination.class,Integer.parseInt(child.getVaccination_id()));      
            System.out.println("vaccination1 test "+vaccination1.getIdvaccination());
            ChildVaccination childVaccination=new ChildVaccination();
            childVaccination.setChild(child);
            childVaccination.setVaccination(vaccination1);
            childVaccination.setVaccinationDate(cal.getTime());      
            getSession().save(childVaccination);
    		
            //assing new value to child
    		String hql = "from Vaccination where idvaccination > :vaccination_id  ORDER BY idvaccination asc ";		
    		Query query = getSession().createQuery(hql);
    		query.setInteger("vaccination_id", vaccination.getIdvaccination());    		
    		List<Vaccination> listProducts = query.list();	
    		if (listProducts !=null && listProducts.size()>0) 
    		{

    			cal.add( Calendar.DATE,listProducts.get(0).getVaccination_duration()  );
    			child.setVac_name(listProducts.get(0).getVaccination_name());
    			child.setVac_date(cal.getTime());
    			child.setVaccination_id(String.valueOf(listProducts.get(0).getIdvaccination()));
			}
    		
			
		}else
		{
		child.setVac_name(vaccination.getVaccination_name());		
		}
    	
    	
        return persist(child);
    }
 
    @Override
	public void getVaccination(Child child, Vaccination vaccination) 
	{
		
      Session  session=getSession();      
      Child user = findById(child.getIdchild());
      SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
      Calendar cal = Calendar.getInstance();  
      Vaccination vaccination1 = (Vaccination)session.get(Vaccination.class,Integer.parseInt(user.getVaccination_id()));      
      System.out.println("vaccination1 test"+vaccination1.getIdvaccination());
      ChildVaccination childVaccination=new ChildVaccination();
      childVaccination.setChild(user);
      childVaccination.setVaccination(vaccination1);
      childVaccination.setVaccinationDate(cal.getTime());      
      session.save(childVaccination);      
      //assing new value to child
		String hql = "from Vaccination where idvaccination > :vaccination_id  ORDER BY idvaccination asc ";		
		Query query = getSession().createQuery(hql);
		query.setInteger("vaccination_id", vaccination.getIdvaccination());    		
		List<Vaccination> listProducts = query.list();	
		if (listProducts !=null && listProducts.size()>0) 
		{
			cal.add( Calendar.DATE,listProducts.get(0).getVaccination_duration()  );
			user.setVac_name(listProducts.get(0).getVaccination_name());
			user.setVac_date(cal.getTime());
			user.setVaccination_id(String.valueOf(listProducts.get(0).getIdvaccination()));
		}
      
	}
    
    @SuppressWarnings("unchecked")
    public List<Child> findAllChild() {
        Criteria criteria = createEntityCriteria();
        return (List<Child>) criteria.list();
    }

	@Override
	public Child findChildById(int id) 
	{
		Child child=(Child)getSession().get(Child.class,id);
		return  child;
	}

	@Override
	public void deleteChildById(int id) 
	{
		
	}
 
	@Override
	public void saveAdmin(Child child) 
	{
	 	Admin admin=new Admin(); 
		admin.setUser_name(child.getChild_name());
		admin.setPassword("qwerty");
		admin.setChild_id(child.getIdchild());
		admin.setUser_type("3");
		getSession().persist(admin);
	}

	@Override
	public Set<ChildVaccination> getVacHistoty(int child_id) 
	{
		Child child=(Child)getSession().get(Child.class,child_id);
		System.out.println("child is "+child.getIdchild());		
		return child.getVaccination_done();
	}

	@Override
	public Vaccination getVaccination(String vaccination_id) {
		Vaccination vaccination =  (Vaccination) getSession().get(Vaccination.class, Integer.parseInt(vaccination_id));
		return vaccination;
	}

	

	@Override
	public List<Child> findChildByDate(Search search,int doctor_id) {
		Date search_date=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String date=sdf.format(new Date());	     
		//{		
		 try {
			search_date=sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hql = "from Child where (vac_date=DATE(:vacdate) and status=0) or (date(vac_date)<DATE(:vacdate1) and status=0) and doctor.iddoctor=:doctorId";		
		Query query = getSession().createQuery(hql);
		query.setInteger("doctorId", 1);
		query.setString("vacdate", date);
		query.setString("vacdate1", date);
		List<Child> listProducts = query.list();
		 try {
			System.out.println("doctor :"+doctor_id);
			System.out.println("date :"+search_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return listProducts;
	}

	@Override
	public List<Vaccination> getRemainingVac(int child_id) {

		String hql = "from Vaccination where idvaccination > :vac_id";		
		Query query = getSession().createQuery(hql);
		query.setInteger("vac_id", child_id);		
		List<Vaccination> listProducts = query.list();		
		return listProducts;
	}

	@Override
	public void addChildByAdmin(Child child) 
	{
		Doctor doctor=(Doctor)getSession().get(Doctor.class,child.getDoc_id());
		Vaccination vaccination=(Vaccination)getSession().get(Vaccination.class,Integer.parseInt(child.getVaccination_id()));
		Child entity=new Child();
		entity.setChild_name(child.getChild_name());
		entity.setFather_name(child.getFather_name());
		entity.setMother_name(child.getMother_name());
		entity.setParent_contact(child.getParent_contact());		
		entity.setDate_of_birth(child.getDate_of_birth());
		entity.setParent_email(child.getParent_email());
		entity.setVac_name(child.getVac_name());
		entity.setVac_date(child.getVac_date());
		entity.setDoctor(doctor);		
		entity.setVaccination_id(child.getVaccination_id());
		getSession().persist(entity);
		Admin admin=new Admin(); 
		admin.setUser_name(child.getChild_name());
		admin.setPassword("qwerty");
		admin.setChild_id(entity.getIdchild());
		admin.setUser_type("3");
		getSession().persist(admin);
		
	}
   
}