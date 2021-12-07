package com.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/home")
public class TestController {

	RestTemplate template = new RestTemplate();

	@GetMapping("/")
	public String check() {
		String url = "http://localhost:8080/test/";
		return template.getForObject(url, String.class);

	}
	@GetMapping("/users")
	public List<User> getAll() {
		return service.getAll();
	}

}
