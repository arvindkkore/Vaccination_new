package com.vaccination.controller;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.log.Log;
import com.vaccination.model.Admin;
import com.vaccination.model.Child;
import com.vaccination.model.ChildVaccination;
import com.vaccination.model.Doctor;
import com.vaccination.model.Employee;
import com.vaccination.model.Login;
import com.vaccination.model.Search;
import com.vaccination.model.UserType;
import com.vaccination.model.Vaccination;
import com.vaccination.service.ChildService;
import com.vaccination.service.DoctorService;
import com.vaccination.service.EmployeeService;
 

@Controller
@RequestMapping("/")
@Scope("session")
@SessionAttributes({"user","doctor","child"})
public class AppController {
 
    @Autowired
    EmployeeService service;
 
    @Autowired
    ChildService childservice;
    
    @Autowired
    DoctorService docservice;
    
    @Autowired
    MessageSource messageSource;
    

  
    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) 
    {
        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        return "allemployees";
    }
 
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) 
        {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
         
        service.saveEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
 
        service.updateEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }
    
    
    /****** Services  **/
    
     @ModelAttribute("user")
    public Login setUpUserForm() {
       return new Login();
    }
    
    /*user Login  */
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(@ModelAttribute("user")  Login login,Model model) 
    {
    	
    	model.addAttribute("user", login);
    	if (login != null && login.getUser_type()!=null)
    	{
    	System.out.println("user "+login);	
    	 
		switch (login.getUser_type()) 
		{
		case "1":
			return "redirect:/doctors";			
		case "2":
			
			return "redirect:/childrenlist_filter";			
		case "3":
			return "redirect:/getUserProfile";			
		default:
			break;
			
		}
		
		}
    	
    	List<UserType> userTypes= service.userType();
    	model.addAttribute("userTypes", userTypes);    	 
        return "login";
    }
     
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String submit(@Valid Login login, 
      BindingResult result, ModelMap model) {
    	System.out.println("user type "+login.getUser_type());
    	
      if (result.hasErrors()) {
            return "login";
        }
        Admin login2=service.login(login);
       if (login2 == null) 
       {
    	   System.out.println("login2 null");
    	   return "login";
	   }
       
        model.addAttribute("user_name", login2.getUser_name());        
        model.addAttribute("user_type", login2.getUser_type());
        if (login2.getUser_type().equals("1"))
        {
          login.setUserid(login2.getIdadmin());
		}else if (login2.getUser_type().equals("2"))
        {
			login.setUserid(login2.getDoctor_id());
			
		}else if (login2.getUser_type().equals("3"))
        {
			login.setUserid(login2.getChild_id());
		}
        
        model.addAttribute("user", login);
        if (login2.getUser_type().equals("1"))
        {
        	 return "redirect:/doctors";        	 
		}
        if (login2.getUser_type().equals("2")) {
        		
        	 return "redirect:/childrenlist_filter";
    		}
        if (login2.getUser_type().equals("3")) {
        	 return "redirect:/getUserProfile";
    		}
        return "/home";
    }
    
    
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String userInfo(@ModelAttribute("user") Login user,Model model) {

       System.out.println("Email: " + user.getUsername());
       System.out.println("First Name: " + user.getPassword());

       return "login";
    }
    /* end of user login */
    
    /* Doctor operations */
    @RequestMapping(value = { "/doctors" }, method = RequestMethod.GET)
    public String doctorList(@ModelAttribute("user")Login login, Model model) {
    	List<Doctor> doctors = docservice.findAllDoctors();  
    	model.addAttribute("user", login);
        model.addAttribute("doctors", doctors);
        return "doctorlist";
    }
   
    @RequestMapping(value = { "/doctor" }, method = RequestMethod.GET)    
    public String doctor(@ModelAttribute("user") Login login,  Model model   )
    {
    	model.addAttribute("user", login);
    	model.addAttribute("doctor", new Doctor());
    	return "add_doctor";
    }
   
    @RequestMapping(value = { "/getDoctor" }, method = RequestMethod.GET)    
    public String getDoctor(@ModelAttribute("user") Login login,  Model model )
    {
    	
    	Doctor doctor=docservice.findDoctorById(login.getUserid());    	
    	model.addAttribute("doctor", doctor);
    	model.addAttribute("user", login);
    	return "doctor_profile";
    }
    
    @RequestMapping(value = { "/addDoctor" }, method = RequestMethod.POST)    
    public String addDoctor(@Valid Doctor doctor, 
    	      BindingResult result, ModelMap model) {  
    	
    	if (result.hasErrors()) 
        {	
            return "add_doctor";
        }
    	Doctor doctor2=docservice.saveDoctor(doctor);
    	
    	docservice.saveAdmin(doctor2);
        return "redirect:/doctors";
    }
    
    /*end of doctor operation */
    /* Child operations */
    
    @RequestMapping(value = { "/childrenlist" }, method = RequestMethod.GET)
    public String childernList(Model model) 
    {        
    	  List<Child> children = childservice.findAllChild();    	  
          model.addAttribute("children", children);
    	  return "childrenlist_doctor";
    }
    @RequestMapping(value = { "/childrenlist_filter" }, method = RequestMethod.GET)
    public String getChildByFilter(@ModelAttribute("user")Login login,Model model)
    {   
     Search search=new Search();	
     search.setSearch_date(new Date());
  	  List<Child> children = childservice.findChildByDate(search,login.getUserid()); 
  	  model.addAttribute("user", login);
      model.addAttribute("children", children);
	  return "childrenlist_doctor";      
    }
    
    @RequestMapping(value = { "/child" }, method = RequestMethod.GET)    
    public String child(@ModelAttribute("user") Login login,Model  model) 
    {
    	List<Vaccination> vaccinations=service.getVaccination();    	
    	model.addAttribute("vaccinations", vaccinations);
    	model.addAttribute("user", login);
    	model.addAttribute("child", new Child());
    	return "add_child";//new ModelAndView("add_child", "child", new Child());        
    }
    
    @RequestMapping(value = { "/addChild" }, method = RequestMethod.POST)    
    public String addChild(@Valid Child child, 
    	      BindingResult result, ModelMap model, @ModelAttribute("user") Login login ) {   
    	
    	
        if (result.hasErrors()) 
        {	
        	System.out.println(result);
            return "add_child";
        }
        Vaccination vaccination=childservice.getVaccination(child.getVaccination_id()); 
        child.setDoc_id(login.getUserid());
        Child child2=childservice.saveChild(child,vaccination);
        
        childservice.saveAdmin(child2);
        return "redirect:/childrenlist_filter";
    }
    
    
    
	@RequestMapping(value = { "/vaccination-{child_id}" }, method = RequestMethod.GET)
    public String getVaccination(@ModelAttribute("user")Login login,Model model,@PathVariable int child_id)
    {
    System.out.println("vaccination "+child_id);
    Set<ChildVaccination> childvac=childservice.getVacHistoty(child_id);
    if (childvac !=null) {
    	System.out.println("childvac "+childvac.size());
    	model.addAttribute("childvac", childvac);
	}
    return "vaccination_history";	
    }
    
    @RequestMapping(value = { "/add_vaccination-{child_id}" }, method = RequestMethod.GET)
    public String newVaccination(@ModelAttribute("user")Login admin,Model model,@PathVariable int child_id)
    {
    
    Child child=childservice.findChildById(child_id);    
    
    List<Vaccination> vaccinations=childservice.getRemainingVac(Integer.parseInt(child.getVaccination_id()));
    if (vaccinations !=null) 
    {
    	System.out.println("childvac "+vaccinations.size());
    	model.addAttribute("child", child);
    	model.addAttribute("user", admin);
    	model.addAttribute("vaccinations", vaccinations);
	}
    return "new_vaccination";	
    }
    
    @RequestMapping(value = { "/updateVaccination" }, method = RequestMethod.POST)
    public String newVaccination(Model model,@Valid Child child)
    {
    	
        Vaccination vaccination=childservice.getVaccination(child.getVaccination_id());        
        Child child_temp=childservice.findChildById(child.getIdchild());    	
        child_temp.setVaccination_id(child.getVaccination_id()); 
        childservice.updateVaccination(child_temp,vaccination);	
    return "redirect:/childrenlist_filter";	
    }
    
    
    @RequestMapping(value = { "/getUserProfile" }, method = RequestMethod.GET)
    public String getUserProfile(@ModelAttribute("user") Login login,Model model)
    {
    	     
        Child child=childservice.findChildById(login.getUserid());
        model.addAttribute("child", child);	
    return "user_profile";	
    }
    
    @RequestMapping(value = { "/child_admin" }, method = RequestMethod.GET)    
    public String child_admin(@ModelAttribute("user") Login login,  Model model ,@Valid Child child )
    {
    	
    	List<Doctor> doctors=docservice.findAllDoctors();
    	List<Vaccination> vaccinations=service.getVaccination();    	
    	model.addAttribute("user", login);
    	model.addAttribute("doctors", doctors);
    	model.addAttribute("vaccinations", vaccinations);
    	return "add_child_admin";
    }
    
    @RequestMapping(value = { "/addChildAdmin" }, method = RequestMethod.GET)    
    public String addChildAdmin(@ModelAttribute("user") Login login,  Model model ,@Valid Child child )
    {
    	
    	childservice.addChildByAdmin(child);
    	model.addAttribute("user", login);    	
    	return "redirect:/childrenlist";
    }
    
   
 
}