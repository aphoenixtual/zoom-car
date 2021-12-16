package com.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.entity.CarBooked;
import com.project.api.repository.BookingRepository;

@Service
public class BookingService implements MySerivce<CarBooked>{

	@Autowired
	private BookingRepository repo;
	
	@Override
	public List<CarBooked> getAll() {
		return repo.findAll();
	}

	@Override
	public CarBooked getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public CarBooked addNew(CarBooked object) {
		return repo.save(object);
	}

	@Override
	public CarBooked update(CarBooked object) {
		return repo.save(object);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
