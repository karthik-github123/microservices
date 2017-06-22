package com.loyalty.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Customer Entity Class.
 * @author Karthik
 *
 */
@Document(collection = "customer")
public class Customer {

	/** First Name. */
	private String firstName;
	
	/** Last Name. */
	private String lastName;
	
	/** Email Address. */
	@Indexed(unique = true)
	private String email;
	
	/** Country of Residence. */
	private String countryOfResidence;
	
	/** DOB. */
	private String dateOfBirth;
	
	/** Title. */
	private String title;
	
	/** Tier. */
	private String tier;
	
	/** Preferred Language. */
	private String preferredLanguage;
	
	/** Identification for a Customer. */
	 @Id
	private String skywardsNo;

	
	/** Getters & Setters. */
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSkywardsNo() {
		return skywardsNo;
	}

	public void setSkywardsNo(String skywardsNo) {
		this.skywardsNo = skywardsNo;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	
}
