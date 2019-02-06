package com.abhishek.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.app.dao.CustomerDaoImpl;
import com.abhishek.app.entities.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDaoImpl customerDAO;

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
		
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		System.out.println("customerId in customer service**"+customerId);
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}
	
	
	

}
