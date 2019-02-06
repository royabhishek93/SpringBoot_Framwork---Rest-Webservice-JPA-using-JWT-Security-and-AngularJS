package com.abhishek.app.service;

import java.util.List;

import com.abhishek.app.entities.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
	
}
