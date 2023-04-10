package com.joan.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joan.spring.entity.Customer;
import com.joan.spring.service.CustomerService;
import com.joan.spring.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject Customer Service 
	@Autowired
	private CustomerService customerService;
	
	//add an initbinder... to convert trim input strings
	//remove leading and trailing whitespace - resolve issue for our validation
	@InitBinder
	public void intitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {

		// get the customers from the service
		List<Customer> theCustomers = null;
		
		//check for sort field
		if(sort!= null) {
			int theSortField=Integer.parseInt(sort);
			theCustomers=customerService.getCustomers(theSortField);
		}else {
			theCustomers=customerService.getCustomers(SortUtils.Last_Name);
		}

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
 
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		System.out.println("Binding result: "+theBindingResult);
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			//save the customer using our service
			customerService.saveCustomer(theCustomer);
			return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from our servcie
		Customer theCustomer=customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
	}
	
	 @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {
	        // search customers from the service
	        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
	                
	        // add the customers to the model
	        theModel.addAttribute("customers", theCustomers);
	        return "list-customers";        
	    }
}
 