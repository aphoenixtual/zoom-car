package com.project.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.backend.entity.User;

/**
 * @author Ankit
 */
@Service
public class UserService {

	//Rest template to get api from api folder
	private RestTemplate template = new RestTemplate();
	
	private String url = "http://localhost:8080/user/users";
	
	//All user from port 8080
	public List<User> getAll(){
		return Arrays.asList(template.getForObject(url, User[].class));
	}



	//Getting user by id by using api from host 8080

	public User getById(int id) {
		String url1=url+"/"+id;
		return template.getForObject(url1,User.class);
	}



   //Adding user from port 8085 to 8080
	public User addNewUser(User theUser)
	{
		return template.postForObject(url,theUser,User.class);
	}




	//Deleting user
	public void deleteUser(int id)
	{
		String deleteUrl=url+"/"+id;
		template.delete(deleteUrl);

	}



	//Updating user by id
	public void updateUserById(User theUser)
	{

		template.put(url,theUser,User.class);
	}



	
}
