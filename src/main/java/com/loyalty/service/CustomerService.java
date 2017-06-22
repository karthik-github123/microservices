package com.loyalty.service;

import java.util.List;

import com.loyalty.entity.Customer;
import com.loyalty.exception.ServiceException;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	Customer saveCustomer(Customer customer) throws ServiceException;
	
	Customer getCustomerById(String id);
	
	List<Customer> searchCustomer(String countryOfResidence, String tier);
}
