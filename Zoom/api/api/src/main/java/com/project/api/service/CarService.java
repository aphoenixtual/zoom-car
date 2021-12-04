package com.project.api.service;


/**
 * @author: Aayush C Description:Car Service 
 */


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.api.entity.Car;
import com.project.api.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository repo;

	public List<Car> getAllCars() {
		return (List<Car>) repo.findAll();
	}

	public Optional<Car> getLenderById(@PathVariable int id) {
		return repo.findById(id);
	}

	public void addNewCar(@RequestBody Car theCar) {
		repo.save(theCar);
	}

	public void updateCar(@PathVariable int id, @RequestBody Car theCar){
			repo.save(theCar);	
		}

	public void deleteCar(@PathVariable int id) {
		repo.deleteById(id);
	}
}
