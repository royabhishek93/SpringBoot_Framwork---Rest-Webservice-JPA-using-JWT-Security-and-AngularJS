package com.abhishek.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.abhishek.app.entities.Customer;


@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager  entityManager;
	
	@Override
	public List<Customer> getAllCustomers() {
		String hql="From Customer as customer Order by customer.customerId";
		
		
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
		
	}

	@Override
	public Customer getCustomerById(int customerId) {
		System.out.println("customerId in Dao"+customerId);
		return entityManager.find( Customer.class, customerId);
		
	}

	@Override
	public void addCustomer(Customer customer) {
		System.out.println("customer**"+customer);
		entityManager.persist(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("customer in dao Impl**"+customer.getCustomerId()+"**"+customer.getCustomerName()+"**"+customer.getEmail());
		Customer  cstmr=getCustomerById(customer.getCustomerId());
		cstmr.setCustomerName(customer.getCustomerName());
		cstmr.setEmail(customer.getEmail());
		entityManager.flush();
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
		
	}

	@Override
	public boolean customerExists(String customerName, String email) {
		
		String hql="FROM Customer as customer   WHERE customer.customerName = ?1 and customer.email = ?2";
		int count=  entityManager.createQuery(hql).setParameter(1, customerName).setParameter(2, email).getResultList().size();
		return count > 0 ?true:false;
	}



}
