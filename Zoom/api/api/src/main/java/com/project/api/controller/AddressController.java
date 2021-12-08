package com.project.api.controller;


import java.util.List;

import com.project.api.entity.Address;
import com.project.api.service.AddressService;

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
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService service;

    @GetMapping("/address")
	public List<Address> getAll() {
		return service.getAll();
	}

	@GetMapping("/address/{id}")
	public Address getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/address")
	public Address addNew(@RequestBody Address theAddress) {
		return service.addNew(theAddress);
	}

	@PutMapping("/address")
	public Address update(@RequestBody Address theAddress) {
		return service.update(theAddress);
	}

	@DeleteMapping("/address/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

}
