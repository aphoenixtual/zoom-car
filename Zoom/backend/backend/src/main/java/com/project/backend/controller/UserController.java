package com.project.backend.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
import com.project.backend.entity.Car;
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

	private List<Car> cars;
	
	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> getAll() {
		return service.getAll();
	}

//	@GetMapping("/users/{id}")
//	public User getById(@PathVariable int id) {
//		return service.getById(id);
//	}
	
	@GetMapping("/users/{username}/{password}")
	public User getByUsername(@PathVariable String username, @PathVariable String password) {
		User user = service.getByUserName(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@PostMapping("/users")
	public User addNew(@RequestBody User theUser) {
		User user = service.getByUserName(theUser.getUserName());
		if(user != null) {
			return null;
		}
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
	
	// Call this from api
	@GetMapping("/users/searchcar/{item}")
	public List<Car> getCars(@PathVariable String item){
		cars = service.getCars(item);
		return cars;
	}

	
	// Problem here // Call this from api
	@GetMapping("/users/searchcar/item/{filterCar}")
	public List<Car> getByFilter(@PathVariable String filterCar){
//		return cars.stream()
//		.filter((car) -> car.getCompany().equals(filterCar) || 
//				car.getModel().equals(filterCar) ||
//				car.getNumberOfSeat() == (Integer.parseInt(filterCar))
//		.sorted(Comparator.comparing(Car::rating))
//		.collect((Collectors.toList()));
	
		List<Car> filterCars = cars.stream()
		.filter((car) -> car.getCompany().equals(filterCar) || 
				car.getModel().equals(filterCar) || 
				car.getNumberOfSeat() == Integer.parseInt(filterCar))
		.collect(Collectors.toList());
		
//		.sorted((c1, c2) -> c1.getRating().compareTo(c2.getRating()));
		
		Collections.sort(filterCars, (c1, c2) -> (int) (c2.getRating() - c1.getRating()));
		return filterCars;
	}
}
