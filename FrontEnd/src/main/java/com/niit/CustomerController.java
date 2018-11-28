package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping(value="/all/Register")
	public String getRegistrationForm(Model model){
	Customer customer	=new Customer();
	model.addAttribute("customer",customer);	
	return "RegisterationForm";	
	}
	@RequestMapping(value="/all/register")
	public String registerCustomer(@ModelAttribute Customer customer,Model model){
		String email=customer.getUser().getEmailid();
		if(!customerDao.isEmailUnique(email))
		{
			model.addAttribute("errorMessage","Email already exists.. please choose different email id");
			return "RegisterationForm";
		}
		customerDao.registerCustomer(customer);
		
		 return "redirect:/login";
	}
}
