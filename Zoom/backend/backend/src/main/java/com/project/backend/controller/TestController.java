package com.project.backend.controller;

import com.project.backend.entity.User;
import com.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//@RestController
//@RequestMapping("/user")
//public class TestController {
//
//
//	@Autowired
//	private UserService service;
//
//	@GetMapping("/users")
//	public List<User> getAll() {
//		return service.getAll();
//	}
//
//}
