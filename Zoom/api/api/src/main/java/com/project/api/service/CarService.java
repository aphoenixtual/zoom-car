package com.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.entity.Car;
import com.project.api.repository.CarRepository;


/**
 * 
 * @author Aayush.C and Ankit
 *
 */

@Service
public class CarService implements MySerivce<Car> {

	@Autowired
	private CarRepository repo;



	//CRUD operations******************************
	@Override
	public List<Car> getAll() {
		return repo.findAll();
	}



	@Override
	public Car getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Car addNew(Car theCar) {
		return repo.save(theCar);
	}

	@Override
	public Car update(Car theCar) {
		return repo.save(theCar);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

//*************************************************


	//All Filters are here


	public List<Car> getByPinAndSeat(int pincode,int numberOfSeats)
	{
		return repo.findByPincodeAndNumberOfSeat(pincode,numberOfSeats);
	}

	public List<Car> getCarByPincode(int pincode){
		return repo.findByPincode(pincode);

	}

	public List<Car> getCarByCompany(String company){
		return repo.findByCompany(company);

	}

	public List<Car> getCarByNumberOfSeat(int numberOfSeat){

		return repo.findByNumberOfSeat(numberOfSeat);

	}

	public List<Car> getCarByCity(String city){
		return repo.findByCity(city);

	}

	public List<Car> getCarBypincodeCityPinSeats(int pincode,int numberOfSeat,String company)
	{
		return repo.findByPincodeAndNumberOfSeatAndCompany(pincode,numberOfSeat,company);
	}



}
