package com.project.api.controller;


/**
 * @author: Aayush C  
 * Description:Car's Controller
 */

import java.util.List;
import java.util.Optional;

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
import com.project.api.service.CarService;

@RestController
@RequestMapping("/Zoom")



public class CarController {
	@Autowired
	CarService service;
	
	@GetMapping("/cars")
	public List<Car> getAllLenders() {
		return service.getAllCars();
	}
	
	@GetMapping("car/{id}")
	Optional<Car> getCar(@PathVariable int id) {
	return service.getLenderById(id);	
	}
	
	
	@PostMapping("/addcar")
	public void addCar(@RequestBody Car theCar) {
		service.addNewCar(theCar);
	}
	
	@PutMapping("carup/{id}")
	void updateCar(@PathVariable int id, @RequestBody Car theCar){
			service.updateCar(id, theCar);
		
	}
	@DeleteMapping("cardel/{id}")
	void deleteCar(@PathVariable int id) {
		service.deleteCar(id);
	}
}
