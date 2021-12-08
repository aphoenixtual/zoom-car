package com.project.backend.controller;

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

import com.project.backend.entity.Car;
import com.project.backend.entity.Lender;
import com.project.backend.service.LenderService;

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
	public Lender getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/lenders")
	public Lender addNew(@RequestBody Lender theLender) {
		theLender.setRoles("ROLE_LENDER");
		theLender.setAcitve(true);
		return service.addNew(theLender);
	}

	@PutMapping("/lenders")
	public Lender update(@RequestBody Lender theLender) {
		return service.update(theLender);
	}

	@DeleteMapping("/lenders/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PostMapping("/lenders/car/{id}")
	public Lender addAddress(@PathVariable int id, @RequestBody Car myCar) {
		return service.addCar(id, myCar);
	}

}
