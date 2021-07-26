package com.techtalentsouth.techtalentaddressbook.addressentry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressEntry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; 
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    
	public AddressEntry() {
		super();
	}

	public AddressEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AddressEntry [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + "]";
	}
	
	
    
    
}
