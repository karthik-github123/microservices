package com.loyalty.service;

import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalty.entity.Customer;
import com.loyalty.exception.ServiceException;
import com.loyalty.repository.CustomerRepository;
import com.loyalty.repository.CustomerSearchRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	/*private final Logger logger = LoggerFactory.getLogger(this.getClass());*/

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerSearchRepository customerSearchRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) throws ServiceException {
		validateCustomerDetails(customer);
		return customerRepository.save(customer);
		
	}

	private void validateCustomerDetails(Customer customer) throws ServiceException {
		if (customer != null) {
			if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
				/*logger.error("Error while persisting. Request did not contain valid Email address");*/
				throw new ServiceException(1001, 406, "Provide valid value for Email", null);
			} else if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
				/*logger.error("Error while persisting. Request did not contain First name");*/
				throw new ServiceException(1002, 406, "Provide valid value for First name ", null);
			}
			
		}
	}

	@Override
	public Customer getCustomerById(String id) {
		return customerRepository.findBySkywardsNo(id);
	}
	
	@Override
	public List<Customer> searchCustomer(String countryOfResidence, String tier) {
		if ((countryOfResidence == null || countryOfResidence.isEmpty()) 
				&& (tier == null || tier.isEmpty())) {
			return getAllCustomers();
		} else {
			return customerSearchRepository.searchCustomers(countryOfResidence, tier);
		}
	}
	
}
