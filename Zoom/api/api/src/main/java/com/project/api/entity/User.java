package com.project.api.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Prashant.V
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String lastName;

	private Long number;

	private String email;

	/*
	 * Note: not tested this. Description: storing the current user address for car
	 * delivery
	 */
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="addressId", referencedColumnName = "id")
//	private Address currentAddress;

	private String userName;

	private String password;

	private String roles;

	private boolean acitve;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Address> addresses;

	public User() {
	}
	public User(int id) {
		this.id = id;
	}
	

	public User(String firstName, String lastName, Long number, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Address getCurrentAddress() {
//		return currentAddress;
//	}
//
//	public void setCurrentAddress(Address currentAddress) {
//		this.currentAddress = currentAddress;
//	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isAcitve() {
		return acitve;
	}

	public void setAcitve(boolean acitve) {
		this.acitve = acitve;
	}

	public void addAddress(Address address) {
		if (this.addresses == null) {
			this.addresses = new ArrayList<Address>();
		}
		this.addresses.add(address);
	}

}
