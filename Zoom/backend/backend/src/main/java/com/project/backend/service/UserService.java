package com.project.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.backend.entity.Address;
import com.project.backend.entity.Car;
import com.project.backend.entity.User;

@Service
public class UserService {

	private RestTemplate template = new RestTemplate();

	private String url = "http://localhost:8080/user/users";

	public List<User> getAll() {
		return Arrays.asList(template.getForObject(url, User[].class));
	}

	public User getById(int id) {
		String url1 = url + "/" + id;
		return template.getForObject(url1, User.class);
	}

	public User getByUserName(String username) {
		String url1 = url + "/name/" + username;
		return template.getForObject(url1, User.class);
	}

	public User addNew(User theUser) {
		return template.postForObject(url, theUser, User.class);
	}

	public User update(User theUser) {
		template.put(url, theUser, User.class);
		return getById(theUser.getId());
	}

	public void delete(int id) {
		String deleteUrl = url + "/" + id;
		template.delete(deleteUrl);
	}

	public User addAddress(int id, Address myAddress) {
//		User currentUser = getById(id);
//		currentUser.addAddress(address);
//		return update(currentUser);

		String url1 = url + "/address/" + id;
		return template.postForObject(url1, myAddress, User.class);
	}

	public List<Car> getCars(String item) {
		String carUrl = "http://localhost:8080/car/cars/search/" + item;
		return Arrays.asList(template.getForObject(url, Car[].class));
	}
}
