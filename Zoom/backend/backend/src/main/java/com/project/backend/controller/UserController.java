package com.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.backend.entity.User;
import com.project.backend.service.UserService;


/**
 * 
 * @author Ankit
 * description:User controller all the endpoint to perform the operation for user
 *
 */


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;



	//Getting all user details
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getAll() {
		return service.getAll();
	}



	//Getting all user details with a particular id

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id)
	{
		return service.getById(id);

	}



	//Adding user
	@PostMapping("/users")
	public User addUSer(@RequestBody User theUser)
	{
		return service.addNewUser(theUser);
	}




	//Deleting user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}

	//Update user
	@PutMapping("/users")
	public String updateUserAtId(@RequestBody User theUser)
	{
		service.updateUserById(theUser);
		return "Successfully Updated";
	}


}
