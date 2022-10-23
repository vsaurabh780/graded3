package com.saurabh.project.controller;


import com.saurabh.project.entity.Customer;
import com.saurabh.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/list")
    public String listALl(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("Customers", customers);
        return "list-customers";
        
        
    }
    @RequestMapping("/add")
    public String add(Model model) {
        Customer customer = new Customer();
        model.addAttribute("Customer", customer);
        return "add-customer";
        
        
        
    }
    
    @PostMapping("/save")
	public String saveCustomer(@RequestParam(value="id",required=false) Integer id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {


		Customer theCustomer;
		if (id != null) {
			theCustomer=customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		} else
			theCustomer = new Customer(firstName,lastName,email);
		// save the Book
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}
    
    @RequestMapping("/delete")
   	public String deleteCustomer(@RequestParam(value="id",required=false) Integer id) {


   		
   		customerService.delete(id);

   		// use a redirect to prevent duplicate submissions
   		return "redirect:/customer/list";

   	}
    
    @RequestMapping("/update")
    public String update(@RequestParam("id") Integer id,Model model) {
        Customer customer = customerService.findById(id);
        
        
        model.addAttribute("Customer", customer);
        return "add-customer";
        
        
        
    }

}


