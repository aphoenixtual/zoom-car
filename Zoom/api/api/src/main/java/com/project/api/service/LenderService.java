package com.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.entity.Lender;
import com.project.api.repository.LenderRepository;


/**
 * 
 * @author Aayush.C
 *
 */

@Service
public class LenderService implements MySerivce<Lender> {

	@Autowired
	private LenderRepository repo;

	@Override
	public List<Lender> getAll() {
		return repo.findAll();
	}

	@Override
	public Lender getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Lender addNew(Lender theLender) {
		return repo.save(theLender);
	}

	@Override
	public Lender update(Lender theLender) {
		return repo.save(theLender);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
