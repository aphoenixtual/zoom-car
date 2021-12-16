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
 * 
 * @author Aayush.C
 *
 */

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String numberPlate;

	private String company;

	private String model;

	private int numberOfSeat;

	private String fuelType;

	private double rating;

	private int baseFairPrice;

	private String state;

	private String city;

	private String localArea;

	private int pincode;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "carId")
	private List<Review> reviewList;

	public Car() {
	}

	public Car(int id) {
		this.id = id;
	}
	public Car(String numberPlate, String company, String model, int numberOfSeat, String fuelType, double rating,
			int baseFairPrice) {
		this.numberPlate = numberPlate;
		this.company = company;
		this.model = model;
		this.numberOfSeat = numberOfSeat;
		this.fuelType = fuelType;
		this.rating = rating;
		this.baseFairPrice = baseFairPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getBaseFairPrice() {
		return baseFairPrice;
	}

	public void setBaseFairPrice(int baseFairPrice) {
		this.baseFairPrice = baseFairPrice;
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

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public void addReview(Review carReview) {
		if (this.reviewList == null) {
			this.reviewList = new ArrayList<>();
		}
		this.reviewList.add(carReview);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", numberPlate=" + numberPlate + ", company=" + company + ", model=" + model
				+ ", numberOfSeat=" + numberOfSeat + ", fuelType=" + fuelType + ", rating=" + rating
				+ ", baseFairPrice=" + baseFairPrice + ", state=" + state + ", city=" + city + ", localArea="
				+ localArea + ", pincode=" + pincode + ", reviewList=" + reviewList + "]";
	}

}
