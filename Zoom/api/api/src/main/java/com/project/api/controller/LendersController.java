package com.project.api.controller;

/**
 * @author: Aayush C  
 * Description:Lender's Controller
 */


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.entity.LenderDetail;
import com.project.api.service.LenderService;

@RestController
@RequestMapping("/Zoom")
public class LendersController {
	
@Autowired
LenderService service;

	@GetMapping("/lenders")
	public List<LenderDetail> getAllLenders() {
		return service.getAllLenders();
	}
	
	@GetMapping("lender/{id}")
	Optional<LenderDetail> getLender(@PathVariable int id) {
	return service.getLenderById(id);	
	}
	
	
	@PostMapping("/addlender")
	public void addNewLender(@RequestBody LenderDetail theLender) {
		service.addNewLender(theLender);
	}
	
	@PutMapping("lenderup/{id}")
	void updateLenderDetails(@PathVariable int id, @RequestBody LenderDetail theLender){
			service.updateLenderDetails(id, theLender);
		
	}
	@DeleteMapping("lendersdel/{id}")
	void deleteLenderDetails(@PathVariable int id) {
		service.deleteLenderDetails(id);
	}
}
