package com.abhishek.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="email")
	private String email;
	
	
	public Customer() {
		
	}
	/*
	public Customer( String customerName, String email) {
	
		this.customerName = customerName;
		this.email = email;
	}

	
	public Customer(int customerId, String customerName, String email) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
	}
   */
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	}
