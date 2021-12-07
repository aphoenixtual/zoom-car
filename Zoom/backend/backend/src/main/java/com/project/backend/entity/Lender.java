package com.project.backend.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Aayush.C 
 *
 */
	
public class Lender {

	private int id;

	private String name;

	private String userName;

	private String password;

	private String roles;

	private boolean acitve;

	private Long number;

	private String email;

	private List<Car> carList;

	public Lender() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public void addCar(Car myCar) {
		if (this.carList == null) {
			this.carList = new ArrayList<>();
		}
		this.carList.add(myCar);
	}

	@Override
	public String toString() {
		return "Lender [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", carList="
				+ carList + "]";
	}

}
