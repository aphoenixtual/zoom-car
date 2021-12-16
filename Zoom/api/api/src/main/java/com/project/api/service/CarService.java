package com.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.entity.Car;
import com.project.api.repository.CarRepository;


/**
 * 
 * @author Aayush.C
 *
 */

@Service
public class CarService implements MySerivce<Car> {

	@Autowired
	private CarRepository repo;

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

	public List<Car> searchBy(String search){
		return repo.findByPincodeContainsOrCityContainsAllIgnoreCase(search, search);
	}
	
	public Car findByNumberPlate(String numberPlate) {
		return repo.findByNumberPlate(numberPlate);
	}
}
