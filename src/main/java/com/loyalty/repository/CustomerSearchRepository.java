package com.loyalty.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.loyalty.entity.Customer;

@Repository
public class CustomerSearchRepository {

	@Autowired
    MongoTemplate mongoTemplate;
	
	
	public List<Customer> searchCustomers(String countryOfResidence, String tier) {
		
        return mongoTemplate.find(Query.query(new Criteria()
                        .andOperator(Criteria.where("countryOfResidence").is(countryOfResidence),
                                    Criteria.where("tier").is(tier))
                        ), Customer.class);
    }
}
