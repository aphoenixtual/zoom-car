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

import com.project.backend.entity.Address;
import com.project.backend.entity.User;
import com.project.backend.service.UserService;

/**
 * 
 * @author Ankit
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> getAll() {
		return service.getAll();
	}

	@GetMapping("/users/{id}")
	public User getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/users")
	public User addNew(@RequestBody User theUser) {
		theUser.setRoles("ROLE_USER");
		theUser.setAcitve(true);
		return service.addNew(theUser);
	}

	@PutMapping("/users")
	public User update(@RequestBody User theUser) {
		return service.update(theUser);
	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PostMapping("/users/address/{id}")
	public User addAddress(@PathVariable int id, @RequestBody Address address) {
		return service.addAddress(id, address);
	}
}
