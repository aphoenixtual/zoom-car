package com.project.backend.controller;

import java.util.List;

import com.project.backend.entity.Car;
import com.project.backend.entity.Review;
import com.project.backend.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService service;

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
    @PutMapping("/cars/review{id}")
    public Car addReview(@PathVariable int id,@RequestBody Review review){
        return service.addReview(id, review);
    }
}
