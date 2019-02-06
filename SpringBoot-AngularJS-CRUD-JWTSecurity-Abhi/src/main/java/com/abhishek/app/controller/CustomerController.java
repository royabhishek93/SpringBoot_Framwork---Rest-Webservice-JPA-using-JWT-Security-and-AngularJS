/*package com.abhishek.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.entities.Customer;
import com.abhishek.app.service.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@RequestMapping(value="/getAllCustomers",method=RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomer(Model model){
		List<Customer> listOfCustomer= customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomer", listOfCustomer);
		return listOfCustomer;
	}
	
	
	@RequestMapping(value="/getCustomerById/{customerId}", method=RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable("customerId")  int customerId) {
		System.out.println("customerId in customer controller**"+customerId);
		 return customerService.getCustomerById(customerId);
		
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		System.out.println("customer in controller class**"+customer+"**"+customer.getCustomerName()+"**"+customer.getEmail());
		return customerService.addCustomer(customer);
		 
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.PUT,headers = "Accept=application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		System.out.println("customer in controller**"+customer.getCustomerId()+"**"+customer.getCustomerName()+"**"+customer.getEmail());

		return customerService.updateCustomer(customer);
		
		
	}
	@RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
	}
}
*/