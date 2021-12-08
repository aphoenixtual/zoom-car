package com.project.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.backend.entity.Car;
import com.project.backend.entity.Lender;

@Service
public class LenderService {

	private RestTemplate template = new RestTemplate();

	private String url = "http://localhost:8080/lender/lenders";

	public List<Lender> getAll() {
		return Arrays.asList(template.getForObject(url, Lender[].class));
	}

	public Lender getById(int id) {
		String url1 = url + "/" + id;
		return template.getForObject(url1, Lender.class);
	}

	public Lender addNew(Lender theLender) {
		return template.postForObject(url, theLender, Lender.class);
	}

	public Lender update(Lender theLender) {
		template.put(url, theLender, Lender.class);
		return getById(theLender.getId());
	}

	public void delete(int id) {
		String deleteUrl = url + "/" + id;
		template.delete(deleteUrl);
	}

	public Lender addCar(int id, Car myCar) {
//		User currentUser = getById(id);
//		currentUser.addAddress(address);
//		return update(currentUser);

		String url1 = url + "/car/" + id;
		return template.postForObject(url1, myCar, Lender.class);
	}
}
