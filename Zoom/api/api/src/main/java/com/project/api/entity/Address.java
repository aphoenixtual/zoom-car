package com.project.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 * @author Prashant.V
 *
 */


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String state;

	private String city;

	private String localArea;

	private int pincode;

	public Address() {
	}

	public Address(String state, String city, String localArea, int pincode) {
		this.state = state;
		this.city = city;
		this.localArea = localArea;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocalArea() {
		return localArea;
	}

	public void setLocalArea(String localArea) {
		this.localArea = localArea;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", city=" + city + ", localArea=" + localArea + ", pincode="
				+ pincode + "]";
	}

}
