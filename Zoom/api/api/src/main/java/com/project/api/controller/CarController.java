package com.project.api.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
 * @author Aayush.C
 *
 */

@RestController
@RequestMapping("/car")
public class CarController {

	private List<Car> filterCarList;
	
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

	@GetMapping("/cars/search/{item}")
	public List<Car> searchBy(@PathVariable String item){
		filterCarList = service.searchBy(item);
		return filterCarList;
	}
	
	@GetMapping("/cars/search/filter/{item}")
	public List<Car> filterCarList(@PathVariable String item){
		
		List<Car> filterCars = filterCarList.stream()
		.filter((car) -> car.getCompany().equals(item) || 
				car.getModel().equals(item) || 
				car.getNumberOfSeat() == Integer.parseInt(item))
		.collect(Collectors.toList());
		
		Collections.sort(filterCars, (c1, c2) -> (int)(c2.getRating() - c1.getRating()));
		return filterCarList;
		
	}
	
}
