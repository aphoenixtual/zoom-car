package com.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.entity.User;
import com.project.api.repository.UserRepository;


/**
 * 
 * @author Prashant.V
 *
 */

@Service
public class UserService implements MySerivce<User> {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAll() {
		return repo.findAll();
	}

	@Override
	public User getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public User addNew(User theUser) {
		return repo.save(theUser);
	}

	@Override
	public User update(User theUser) {
		return repo.save(theUser);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
