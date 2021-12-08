package com.project.backend.controller;

import com.project.backend.entity.Address;
import com.project.backend.service.AddressService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
	private AddressService service;

    //Getting all Address details
	@GetMapping("/address")
	public List<Address> getAll() {
		return service.getAll();
	}



	//Getting all Address details with a particular id
	@GetMapping("/address/{id}")
	public Address getAddressById(@PathVariable int id)
	{
		return service.getById(id);

	}

	//Adding Address
	@PostMapping("/address")
	public Address addAddress(@RequestBody Address theAddress)
	{
		return service.addNewAddress(theAddress);
	}


	//Deleting Address
	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable int id) {
		service.deleteAddress(id);
	}

	//Update Address
	@PutMapping("/address")
	public String updateAddressAtId(@RequestBody Address theAddress)
	{
		service.updateAddressById(theAddress);
		return "Successfully Updated";
	}


}
