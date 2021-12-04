package com.project.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author: Aayush C Note: Description:Lender's detail entity
 */

@Entity
public class LenderDetail {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lenderId;

	private String lenderEmail;
	private long lenderNumber;
	private String lenderFirstName, lenderLastName;
	 @OneToMany(targetEntity=Car.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JoinColumn(name="lenderId",referencedColumnName ="lenderId")
	private List<Car> car;

	public int getLenderId() {
		return lenderId;
	}

	public void setLenderId(int lenderId) {
		this.lenderId = lenderId;
	}

	public String getLenderEmail() {
		return lenderEmail;
	}

	public void setLenderEmail(String lenderEmail) {
		this.lenderEmail = lenderEmail;
	}

	public long getLenderNumber() {
		return lenderNumber;
	}

	public void setLenderNumber(long lenderNumber) {
		this.lenderNumber = lenderNumber;
	}

	public String getLenderFirstName() {
		return lenderFirstName;
	}

	public void setLenderFirstName(String lenderFirstName) {
		this.lenderFirstName = lenderFirstName;
	}

	public String getLenderLastName() {
		return lenderLastName;
	}

	public void setLenderLastName(String lenderLastName) {
		this.lenderLastName = lenderLastName;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public LenderDetail() {
	}

	@Override
	public String toString() {
		return "LenderDetail [lenderId=" + lenderId + ", lenderEmail=" + lenderEmail + ", lenderNumber=" + lenderNumber
				+ ", lenderFirstName=" + lenderFirstName + ", lenderLastName=" + lenderLastName + ", carList=" + car
				+ "]";
	}

	public LenderDetail(int lenderId,String lenderEmail, long lenderNumber, String lenderFirstName, String lenderLastName,List car) {
		this.lenderId=lenderId;
		this.lenderEmail = lenderEmail;
		this.lenderNumber = lenderNumber;
		this.lenderFirstName = lenderFirstName;
		this.lenderLastName = lenderLastName;
		this.car=car;

	}
}
