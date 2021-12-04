package com.project.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.entity.LenderDetail;
import com.project.api.repository.LenderRepository;

/**
 * @author: Aayush C Note: Description:Lender Service 
 */
@Service
public class LenderService {
	
	@Autowired
	LenderRepository repo;

	public List<LenderDetail> getAllLenders() {
		return (List<LenderDetail>) repo.findAll();
	}

	public Optional<LenderDetail> getLenderById(@PathVariable int id) {
		return repo.findById(id);
	}

	public void addNewLender(@RequestBody LenderDetail theLender) {
		repo.save(theLender);
	}

	public void updateLenderDetails(@PathVariable int id, @RequestBody LenderDetail theLender){
			repo.save(theLender);	
		}

	public void deleteLenderDetails(@PathVariable int id) {
		repo.deleteById(id);
	}
}
