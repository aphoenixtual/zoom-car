package com.project.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.entity.Car;
import com.project.api.entity.Review;
import com.project.api.service.CarService;


/**
 * 
 * @author Aayush.C and Ankit
 *
 */

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;

	@GetMapping("/cars")
	public List<Car> getAll() {
		return service.getAll();
	}



	@GetMapping("/cars/{id}")
	public Car getById(@PathVariable int id) {
		return service.getById(id);
	}



	@PostMapping("/cars")
	public Car addNew(@RequestBody Car theCar) {
		return service.addNew(theCar);
	}



	@PutMapping("/cars")
	public Car update(@RequestBody Car theCar) {
		return service.update(theCar);
	}



	@DeleteMapping("/cars/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}



	@PostMapping("/cars/review/{id}")
	public Car User(@PathVariable int id, @RequestBody Review theReview) {
		Car currentCar = service.getById(id);
		currentCar.addReview(theReview);
		return service.update(currentCar);
	}


	//Filtering tables through pin,seat,company,city


	//Finding car through pincode
	@GetMapping("/carsByPin/{pincode}")
	public List<Car> getCarsFromPin(@PathVariable int pincode)
	{
		return service.getCarByPincode(pincode);
	}

	//Finding car by seats
	@GetMapping("/carsBySeat/{numberOfSeats}")
	public List<Car> getCarsFromSeats(@PathVariable int numberOfSeats)
	{
		return service.getCarByNumberOfSeat(numberOfSeats);
	}


	//finding car by city

	@GetMapping("/carsByCity/{city}")
	public List<Car> getCarsFromCity(@PathVariable String city)
	{
		return service.getCarByCity(city);
	}

	//finding car by company

	@GetMapping("/carsByCompany/{company}")
	public List<Car> getCarsFromCompany(@PathVariable String company)
	{
		return service.getCarByCompany(company);
	}




	//Getting car by pin code and seats
	@GetMapping("/cars/{pincode}/{numberOfSeats}")
	public List<Car> getCarsFromPinAndSeats(@PathVariable int pincode,@PathVariable int numberOfSeats)
	{
		return service.getByPinAndSeat(pincode,numberOfSeats);
	}




	//Getting car by pin code and seats and company
	@GetMapping("/cars/{pincode}/{numberOfSeats}/{company}")
	public List<Car> getCarsFromPinAndSeatsAndCompany(@PathVariable int pincode,@PathVariable int numberOfSeats,@PathVariable String company)
	{
		return service.getCarBypincodeCityPinSeats(pincode,numberOfSeats,company);
	}






}
