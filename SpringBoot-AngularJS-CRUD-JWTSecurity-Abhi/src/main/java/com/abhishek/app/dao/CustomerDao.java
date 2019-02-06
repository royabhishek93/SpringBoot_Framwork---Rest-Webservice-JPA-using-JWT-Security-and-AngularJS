package com.abhishek.app.dao;

import java.util.List;

import com.abhishek.app.entities.Customer;



public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
	boolean customerExists(String customerName,String email);

}
