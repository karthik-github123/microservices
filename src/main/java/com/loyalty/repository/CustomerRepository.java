package com.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.loyalty.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	Customer findBySkywardsNo(String skywardsNo);


}
