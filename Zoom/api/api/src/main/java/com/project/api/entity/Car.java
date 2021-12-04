package com.project.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author: Aayush C  Description:Car entity
 */

@Entity
public class Car {

	@Id
	private int carId;
	private String carNumberPlate;
	private String carCompany, carModel;
	private String fuelType;
	private int carSeats;
	private int rating, carFarePrice;

	@OneToMany(targetEntity=ReviewDetails.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JoinColumn(name="carId",referencedColumnName ="carId")
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNumberPlate() {
		return carNumberPlate;
	}

	public void setCarNumberPlate(String carNumberPlate) {
		this.carNumberPlate = carNumberPlate;
	}

	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getCarSeats() {
		return carSeats;
	}

	public void setCarSeats(int carSeats) {
		this.carSeats = carSeats;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getCarFarePrice() {
		return carFarePrice;
	}

	public void setCarFarePrice(int carFarePrice) {
		this.carFarePrice = carFarePrice;
	}

	public Car() {
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNumberPlate=" + carNumberPlate + ", carCompany=" + carCompany
				+ ", carModel=" + carModel + ", fuelType=" + fuelType + ", carSeats=" + carSeats + ", rating=" + rating
				+ ", carFarePrice=" + carFarePrice + "]";
	}

	public Car(int carId, String carNumberPlate, String carCompany, String carModel, String fuelType, int carSeats,
			int rating, int carFarePrice) {

		this.carId = carId;
		this.carNumberPlate = carNumberPlate;
		this.carCompany = carCompany;
		this.carModel = carModel;
		this.fuelType = fuelType;
		this.carSeats = carSeats;
		this.rating = rating;
		this.carFarePrice = carFarePrice;
	}

}
