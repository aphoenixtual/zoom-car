package com.project.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.backend.entity.User;

@Service
public class UserService {
	
	private RestTemplate template = new RestTemplate();
	
	private String url = "http://localhost:8080/user/users";
	
	// One done baki ke 4 banao
	public List<User> getAll(){
		return Arrays.asList(template.getForObject(url, User[].class));
	}
	
}
