package com.project.api.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.entity.Car;
import com.project.api.entity.CarBooked;
import com.project.api.entity.User;
import com.project.api.service.BookingService;
import com.project.api.service.CarService;
import com.project.api.service.UserService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService service;

	@Autowired
	private UserService userService;
	
	@Autowired CarService carService;
	
	@GetMapping("/bookings")
	public List<CarBooked> getAll() {
		return service.getAll();
	}

	@GetMapping("/bookings/{id}")
	public CarBooked getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/bookings/{userId}/{carId}/{hours}")
	public CarBooked addNew(@PathVariable int hours, @PathVariable int userId, @PathVariable int carId, @RequestBody CarBooked booked) {
		
		User user = userService.getById(userId);

		Car car = carService.getById(carId);
//		User user = new User(userId);
//		Car car = new Car(carId);

		
		booked.setCar(car);
		booked.setUser(user);

		if(hours <= 1) {
			booked.setBookingAmount(car.getBaseFairPrice());
		}else {
			double fair =  car.getBaseFairPrice() + (double) (car.getBaseFairPrice() * 3 * hours) / 10;
			booked.setBookingAmount(fair);
		}
		booked.setNumberOfHoursBooking(hours);
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new java.sql.Timestamp(time);
		booked.setStartDate(ts);
		
		return service.addNew(booked);
	}

	@DeleteMapping("/bookings/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

}
