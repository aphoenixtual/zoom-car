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

import com.project.api.entity.Address;
import com.project.api.entity.User;
import com.project.api.service.MySerivce;
import com.project.api.service.UserService;

/**
 * 
 * @author Prashant.V
 * Note: Need to add Roles
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
	public User User(@PathVariable int id, @RequestBody Address theAddress) {
		User currentUser = service.getById(id);
		currentUser.addAddress(theAddress);
		return service.update(currentUser);
	}
	
	@GetMapping("/users/name/{username}")
	public User getByUserName(@PathVariable String username) {
		User user = null;
		user = service.findByUserName(username);
		return user; 
	}
}