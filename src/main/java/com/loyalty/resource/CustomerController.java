package com.loyalty.resource;

import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loyalty.entity.Customer;
import com.loyalty.exception.ServiceException;
import com.loyalty.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {
	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Customer> getAllCustomers(@RequestParam(value="countryOfResidence", defaultValue="") String countryOfResidence,
            @RequestParam(value="tier", defaultValue="") String tier) {
//		logger.debug("Values provided in request. Country of Residence: " + countryOfResidence + " Tier: " + tier);
        return customerService.searchCustomer(countryOfResidence, tier);
    }

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Customer getCustomer(@PathVariable(value="id") String customerId) {
//		logger.debug("Customer_Id:" + customerId);
        return customerService.getCustomerById(customerId);
    }
	
    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Customer saveCustomer(@RequestBody Customer customer) throws ServiceException{
//    	logger.debug("Save Customer");
    	Customer newCustomer = customerService.saveCustomer(customer);
    	return newCustomer;
    }
}