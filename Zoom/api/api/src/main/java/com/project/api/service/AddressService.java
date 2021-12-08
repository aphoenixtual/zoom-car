package com.project.api.service;

import java.util.List;

import com.project.api.entity.Address;
import com.project.api.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Rahul.S
 *
 */


@Service
public class AddressService implements  MySerivce<Address> {
    @Autowired
    AddressRepository repo;

    @Override
	public List<Address> getAll() {
		return repo.findAll();
	}

	@Override
	public Address getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Address addNew(Address theAddress) {
		return repo.save(theAddress);
	}

	@Override
	public Address update(Address theAddress) {
		return repo.save(theAddress);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}
}
