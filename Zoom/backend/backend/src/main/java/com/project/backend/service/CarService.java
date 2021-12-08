package com.project.backend.service;


import java.util.Arrays;
import java.util.List;

import com.project.backend.entity.Car;
import com.project.backend.entity.Review;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class CarService {
    private RestTemplate template = new RestTemplate();

	private String url = "http://localhost:8080/car/cars";

	public List<Car> getAll() {
		return Arrays.asList(template.getForObject(url, Car[].class));
	}

	public Car getById(int id) {
		String url1 = url + "/" + id;
		return template.getForObject(url1, Car.class);
	}

	public Car addNew(Car theCar) {
		return template.postForObject(url, theCar, Car.class);
	}

	public Car update(Car theCar) {
		template.put(url, theCar, Car.class);
		return getById(theCar.getId());
	}

	public void delete(int id) {
		String deleteUrl = url + "/" + id;
		template.delete(deleteUrl);
	}
    public Car addReview(int id, Review review){
        String url1 = url + "/review/" + id;
        return template.postForObject(url1, review, Car.class);
    }

}
