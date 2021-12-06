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
import com.project.api.entity.Lender;
import com.project.api.service.LenderService;

/**
 * 
 * @author Aayush.C
 *
 */

@RestController
@RequestMapping("/lender")
public class LenderController {

	@Autowired
	private LenderService service;

	@GetMapping("/lenders")
	public List<Lender> getAll() {
		return service.getAll();
	}

	@GetMapping("/lenders/{id}")
	public Lender findByID(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/lenders")
	public Lender addNew(@RequestBody Lender theLender) {
		return service.addNew(theLender);
	}

	@PutMapping("/lenders")
	public Lender update(@RequestBody Lender theLender) {
		return service.update(theLender);
	}

	@DeleteMapping("/lenders/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "Deleted";
	}

	@PostMapping("/lenders/car/{id}")
	public Lender addCar(@PathVariable int id, @RequestBody Car theCar) {
		Lender currentLender = service.getById(id);
		currentLender.addCar(theCar);
		return service.update(currentLender);
	}

}
